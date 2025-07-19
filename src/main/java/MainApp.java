import controller.MainSceneController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class MainApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("READER XML SYSTEM");

        // Carrega o arquivo FXML
        // O FXMLLoader é responsável por carregar um arquivo FXML e retornar o grafo de objetos resultante [34].
        // O método getResource() resolve o caminho do FXML em relação à classe [34].
        URL fxmlLocation = getClass().getResource("fxml/MainScreen.fxml");
        if (fxmlLocation == null) {
            System.err.println("Erro: MainScreen.fxml não encontrado. Verifique o caminho.");
            return;
        }

        FXMLLoader loader = new FXMLLoader(fxmlLocation);
        Parent root = loader.load();

        // Cria uma nova Scene com o nó raiz carregado do FXML
        // Você pode definir a largura e altura iniciais da Scene aqui
        Scene scene = new Scene(root, 800, 600);
       // Opcional: Adiciona uma folha de estilo CSS (se tiver)
        scene.getStylesheets().add(getClass().getResource("css/styles.css").toExternalForm());


        stage.setScene(scene);
        stage.show();

    }
}
