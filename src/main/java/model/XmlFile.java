package model;

import java.util.List;

public class XmlFile {

    // Identificação
    private String cUF;
    private String cNF;
    private String natOp;
    private String mod;
    private String serie;
    private int nNF;
    private String dhEmi;
    private int tpNF;
    private int idDest;
    private String cMunFG;
    private int tpImp;
    private int tpEmis;
    private int cDV;
    private int tpAmb;
    private int finNFe;
    private int indFinal;
    private int indPres;
    private int indIntermed;
    private int procEmi;
    private String verProc;

    // Emitente
    private String emitCNPJ;
    private String emitNome;
    private String emitLogradouro;
    private String emitNumero;
    private String emitBairro;
    private String emitMunicipio;
    private String emitUF;
    private String emitCEP;
    private String emitIE;
    private int emitCRT;

    // Destinatário
    private String destCPF;
    private String destNome;
    private int destIndIEDest;

    // Produtos
    private List<Produto> itens;

    // Totais
    private double vProd;
    private double vNF;
    private double vTotTrib;

    // Transporte
    private int modFrete;

    // Pagamento
    private List<Pagamento> pagamentos;

    // Intermediador
    private String intermedCNPJ;
    private String intermedIdTransacao;

    // Informações adicionais
    private String infoComplementar;

    // QRCode e URL
    private String qrCode;
    private String urlChave;

    // Dados de autorização
    private String protocoloAutorizacao;
    private String dataRecebimento;
    private String status;
    private String motivo;

    public String getcUF() {
        return cUF;
    }

    public void setcUF(String cUF) {
        this.cUF = cUF;
    }

    public String getcNF() {
        return cNF;
    }

    public void setcNF(String cNF) {
        this.cNF = cNF;
    }

    public String getNatOp() {
        return natOp;
    }

    public void setNatOp(String natOp) {
        this.natOp = natOp;
    }

    public String getMod() {
        return mod;
    }

    public void setMod(String mod) {
        this.mod = mod;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public int getnNF() {
        return nNF;
    }

    public void setnNF(int nNF) {
        this.nNF = nNF;
    }

    public String getDhEmi() {
        return dhEmi;
    }

    public void setDhEmi(String dhEmi) {
        this.dhEmi = dhEmi;
    }

    public int getTpNF() {
        return tpNF;
    }

    public void setTpNF(int tpNF) {
        this.tpNF = tpNF;
    }

    public int getIdDest() {
        return idDest;
    }

    public void setIdDest(int idDest) {
        this.idDest = idDest;
    }

    public String getcMunFG() {
        return cMunFG;
    }

    public void setcMunFG(String cMunFG) {
        this.cMunFG = cMunFG;
    }

    public int getTpImp() {
        return tpImp;
    }

    public void setTpImp(int tpImp) {
        this.tpImp = tpImp;
    }

    public int getTpEmis() {
        return tpEmis;
    }

    public void setTpEmis(int tpEmis) {
        this.tpEmis = tpEmis;
    }

    public int getcDV() {
        return cDV;
    }

    public void setcDV(int cDV) {
        this.cDV = cDV;
    }

    public int getTpAmb() {
        return tpAmb;
    }

    public void setTpAmb(int tpAmb) {
        this.tpAmb = tpAmb;
    }

    public int getFinNFe() {
        return finNFe;
    }

    public void setFinNFe(int finNFe) {
        this.finNFe = finNFe;
    }

    public int getIndFinal() {
        return indFinal;
    }

    public void setIndFinal(int indFinal) {
        this.indFinal = indFinal;
    }

    public int getIndPres() {
        return indPres;
    }

    public void setIndPres(int indPres) {
        this.indPres = indPres;
    }

    public int getIndIntermed() {
        return indIntermed;
    }

    public void setIndIntermed(int indIntermed) {
        this.indIntermed = indIntermed;
    }

    public int getProcEmi() {
        return procEmi;
    }

    public void setProcEmi(int procEmi) {
        this.procEmi = procEmi;
    }

    public String getVerProc() {
        return verProc;
    }

    public void setVerProc(String verProc) {
        this.verProc = verProc;
    }

    public String getEmitCNPJ() {
        return emitCNPJ;
    }

    public void setEmitCNPJ(String emitCNPJ) {
        this.emitCNPJ = emitCNPJ;
    }

    public String getEmitNome() {
        return emitNome;
    }

    public void setEmitNome(String emitNome) {
        this.emitNome = emitNome;
    }

    public String getEmitLogradouro() {
        return emitLogradouro;
    }

    public void setEmitLogradouro(String emitLogradouro) {
        this.emitLogradouro = emitLogradouro;
    }

    public String getEmitNumero() {
        return emitNumero;
    }

    public void setEmitNumero(String emitNumero) {
        this.emitNumero = emitNumero;
    }

    public String getEmitBairro() {
        return emitBairro;
    }

    public void setEmitBairro(String emitBairro) {
        this.emitBairro = emitBairro;
    }

    public String getEmitMunicipio() {
        return emitMunicipio;
    }

    public void setEmitMunicipio(String emitMunicipio) {
        this.emitMunicipio = emitMunicipio;
    }

    public String getEmitUF() {
        return emitUF;
    }

    public void setEmitUF(String emitUF) {
        this.emitUF = emitUF;
    }

    public String getEmitCEP() {
        return emitCEP;
    }

    public void setEmitCEP(String emitCEP) {
        this.emitCEP = emitCEP;
    }

    public String getEmitIE() {
        return emitIE;
    }

    public void setEmitIE(String emitIE) {
        this.emitIE = emitIE;
    }

    public int getEmitCRT() {
        return emitCRT;
    }

    public void setEmitCRT(int emitCRT) {
        this.emitCRT = emitCRT;
    }

    public String getDestCPF() {
        return destCPF;
    }

    public void setDestCPF(String destCPF) {
        this.destCPF = destCPF;
    }

    public String getDestNome() {
        return destNome;
    }

    public void setDestNome(String destNome) {
        this.destNome = destNome;
    }

    public int getDestIndIEDest() {
        return destIndIEDest;
    }

    public void setDestIndIEDest(int destIndIEDest) {
        this.destIndIEDest = destIndIEDest;
    }

    public List<Produto> getItens() {
        return itens;
    }

    public void setItens(List<Produto> itens) {
        this.itens = itens;
    }

    public double getvProd() {
        return vProd;
    }

    public void setvProd(double vProd) {
        this.vProd = vProd;
    }

    public double getvNF() {
        return vNF;
    }

    public void setvNF(double vNF) {
        this.vNF = vNF;
    }

    public double getvTotTrib() {
        return vTotTrib;
    }

    public void setvTotTrib(double vTotTrib) {
        this.vTotTrib = vTotTrib;
    }

    public int getModFrete() {
        return modFrete;
    }

    public void setModFrete(int modFrete) {
        this.modFrete = modFrete;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public String getIntermedCNPJ() {
        return intermedCNPJ;
    }

    public void setIntermedCNPJ(String intermedCNPJ) {
        this.intermedCNPJ = intermedCNPJ;
    }

    public String getIntermedIdTransacao() {
        return intermedIdTransacao;
    }

    public void setIntermedIdTransacao(String intermedIdTransacao) {
        this.intermedIdTransacao = intermedIdTransacao;
    }

    public String getInfoComplementar() {
        return infoComplementar;
    }

    public void setInfoComplementar(String infoComplementar) {
        this.infoComplementar = infoComplementar;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getUrlChave() {
        return urlChave;
    }

    public void setUrlChave(String urlChave) {
        this.urlChave = urlChave;
    }

    public String getProtocoloAutorizacao() {
        return protocoloAutorizacao;
    }

    public void setProtocoloAutorizacao(String protocoloAutorizacao) {
        this.protocoloAutorizacao = protocoloAutorizacao;
    }

    public String getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(String dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
