package service;

import model.Produto;
import model.XmlFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class XmlFileService {

    private static XmlFileService instance;
    private List<XmlFile> cacheXmlFiles = null;



    private XmlFileService() {
        // Construtor privado para evitar instâncias externas
    }

    public static XmlFileService getInstance() {
        if (instance == null) {
            instance = new XmlFileService();
        }
        return instance;
    }

    public List<XmlFile> loadXmlFilesFromDirectory(List<Path> xmlPaths) {

        if(cacheXmlFiles != null) {
            return cacheXmlFiles;
        }

        List<XmlFile> xmlFiles = new ArrayList<>();
        for (Path path : xmlPaths) {
            try {
                Document doc = DocumentBuilderFactory.newInstance()
                        .newDocumentBuilder()
                        .parse(path.toFile());
                doc.getDocumentElement().normalize();

                // Navega até infNFe
                Node infNFeNode = doc.getElementsByTagName("infNFe").item(0);
                if (infNFeNode == null) continue;
                Element infNFe = (Element) infNFeNode;

                XmlFile xmlFile = new XmlFile();

                // Mapeia campos de identificação
                Element ide = (Element) infNFe.getElementsByTagName("ide").item(0);
                if (ide != null) {
                    xmlFile.setcUF(getTagValue(ide, "cUF"));
                    xmlFile.setcNF(getTagValue(ide, "cNF"));
                    xmlFile.setNatOp(getTagValue(ide, "natOp"));
                    xmlFile.setMod(getTagValue(ide, "mod"));
                    xmlFile.setSerie(getTagValue(ide, "serie"));
                    xmlFile.setnNF(parseInt(getTagValue(ide, "nNF")));
                    xmlFile.setDhEmi(getTagValue(ide, "dhEmi"));
                    xmlFile.setTpNF(parseInt(getTagValue(ide, "tpNF")));
                    xmlFile.setIdDest(parseInt(getTagValue(ide, "idDest")));
                    xmlFile.setcMunFG(getTagValue(ide, "cMunFG"));
                    xmlFile.setTpImp(parseInt(getTagValue(ide, "tpImp")));
                    xmlFile.setTpEmis(parseInt(getTagValue(ide, "tpEmis")));
                    xmlFile.setcDV(parseInt(getTagValue(ide, "cDV")));
                    xmlFile.setTpAmb(parseInt(getTagValue(ide, "tpAmb")));
                    xmlFile.setFinNFe(parseInt(getTagValue(ide, "finNFe")));
                    xmlFile.setIndFinal(parseInt(getTagValue(ide, "indFinal")));
                    xmlFile.setIndPres(parseInt(getTagValue(ide, "indPres")));
                    xmlFile.setIndIntermed(parseInt(getTagValue(ide, "indIntermed")));
                    xmlFile.setProcEmi(parseInt(getTagValue(ide, "procEmi")));
                    xmlFile.setVerProc(getTagValue(ide, "verProc"));
                }

                // Mapeia emitente
                Element emit = (Element) infNFe.getElementsByTagName("emit").item(0);
                if (emit != null) {
                    xmlFile.setEmitCNPJ(getTagValue(emit, "CNPJ"));
                    xmlFile.setEmitNome(getTagValue(emit, "xNome"));
                    Element enderEmit = (Element) emit.getElementsByTagName("enderEmit").item(0);
                    if (enderEmit != null) {
                        xmlFile.setEmitLogradouro(getTagValue(enderEmit, "xLgr"));
                        xmlFile.setEmitNumero(getTagValue(enderEmit, "nro"));
                        xmlFile.setEmitBairro(getTagValue(enderEmit, "xBairro"));
                        xmlFile.setEmitMunicipio(getTagValue(enderEmit, "xMun"));
                        xmlFile.setEmitUF(getTagValue(enderEmit, "UF"));
                        xmlFile.setEmitCEP(getTagValue(enderEmit, "CEP"));
                    }
                    xmlFile.setEmitIE(getTagValue(emit, "IE"));
                    xmlFile.setEmitCRT(parseInt(getTagValue(emit, "CRT")));
                }

                // Mapeia destinatário
                Element dest = (Element) infNFe.getElementsByTagName("dest").item(0);
                if (dest != null) {
                    xmlFile.setDestCPF(getTagValue(dest, "CPF"));
                    xmlFile.setDestNome(getTagValue(dest, "xNome"));
                    xmlFile.setDestIndIEDest(parseInt(getTagValue(dest, "indIEDest")));
                }

                // Mapeia produtos
                NodeList detList = infNFe.getElementsByTagName("det");
                List<Produto> produtos = new ArrayList<>();
                for (int i = 0; i < detList.getLength(); i++) {
                    Element det = (Element) detList.item(i);
                    Produto prod = new Produto();
                    prod.setNumeroItem(parseInt(det.getAttribute("nItem")));
                    Element prodElem = (Element) det.getElementsByTagName("prod").item(0);
                    if (prodElem != null) {
                        prod.setCodigo(getTagValue(prodElem, "cProd"));
                        prod.setDescricao(getTagValue(prodElem, "xProd"));
                        prod.setNcm(getTagValue(prodElem, "NCM"));
                        prod.setCfop(getTagValue(prodElem, "CFOP"));
                        prod.setUnidade(getTagValue(prodElem, "uCom"));
                        prod.setQuantidade(parseDouble(getTagValue(prodElem, "qCom")));
                        prod.setValorUnitario(parseDouble(getTagValue(prodElem, "vUnCom")));
                        prod.setValorTotal(parseDouble(getTagValue(prodElem, "vProd")));
                    }
                    Element impostoElem = (Element) det.getElementsByTagName("imposto").item(0);
                    if (impostoElem != null) {
                        prod.setTotalTributos(parseDouble(getTagValue(impostoElem, "vTotTrib")));
                    }
                    prod.setObservacao(getTagValue(det, "infAdProd"));
                    produtos.add(prod);
                }
                xmlFile.setItens(produtos);

                // Mapeia totais
                Element total = (Element) infNFe.getElementsByTagName("total").item(0);
                if (total != null) {
                    Element icmsTot = (Element) total.getElementsByTagName("ICMSTot").item(0);
                    if (icmsTot != null) {
                        xmlFile.setvProd(parseDouble(getTagValue(icmsTot, "vProd")));
                        xmlFile.setvNF(parseDouble(getTagValue(icmsTot, "vNF")));
                        xmlFile.setvTotTrib(parseDouble(getTagValue(icmsTot, "vTotTrib")));
                    }
                }

                // Mapeia transporte
                Element transp = (Element) infNFe.getElementsByTagName("transp").item(0);
                if (transp != null) {
                    xmlFile.setModFrete(parseInt(getTagValue(transp, "modFrete")));
                }

                // Mapeia informações adicionais
                Element infAdic = (Element) infNFe.getElementsByTagName("infAdic").item(0);
                if (infAdic != null) {
                    xmlFile.setInfoComplementar(getTagValue(infAdic, "infCpl"));
                }

                // Mapeia QRCode e URL
                Node infNFeSuplNode = doc.getElementsByTagName("infNFeSupl").item(0);
                if (infNFeSuplNode != null) {
                    Element infNFeSupl = (Element) infNFeSuplNode;
                    xmlFile.setQrCode(getTagValue(infNFeSupl, "qrCode"));
                    xmlFile.setUrlChave(getTagValue(infNFeSupl, "urlChave"));
                }

                // Mapeia dados de autorização
                Node protNFeNode = doc.getElementsByTagName("protNFe").item(0);
                if (protNFeNode != null) {
                    Element protNFe = (Element) protNFeNode;
                    Element infProt = (Element) protNFe.getElementsByTagName("infProt").item(0);
                    if (infProt != null) {
                        xmlFile.setProtocoloAutorizacao(getTagValue(infProt, "nProt"));
                        xmlFile.setDataRecebimento(getTagValue(infProt, "dhRecbto"));
                        xmlFile.setStatus(getTagValue(infProt, "cStat"));
                        xmlFile.setMotivo(getTagValue(infProt, "xMotivo"));
                    }
                }

                xmlFiles.add(xmlFile);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return xmlFiles;
    }

    // Métodos utilitários
    private String getTagValue(Element elem, String tag) {
        NodeList nl = elem.getElementsByTagName(tag);
        if (nl.getLength() > 0 && nl.item(0) != null) {
            return nl.item(0).getTextContent();
        }
        return null;
    }
    private int parseInt(String value) {
        try { return value == null ? 0 : Integer.parseInt(value); } catch (Exception e) { return 0; }
    }
    private double parseDouble(String value) {
        try { return value == null ? 0.0 : Double.parseDouble(value); } catch (Exception e) { return 0.0; }
    }

}
