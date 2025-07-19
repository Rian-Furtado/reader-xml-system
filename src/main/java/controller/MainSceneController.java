package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;


public class MainSceneController {

    @FXML
    private Button homeButton;
    @FXML
    private Button invoicesButton;
    @FXML
    private Button settingsButton;
    @FXML
    private Button uploadFilesButton;
    @FXML
    private Button supportButton;
    @FXML
    private Button gitHubButton;

    @FXML
    private void onClickUploadFilesButton(ActionEvent event){
      try {
          Node sourceNode = (Node) event.getSource();
          Scene currentScene = sourceNode.getScene();

          URL fxmlLocation = getClass().getResource("/fxml/UploadScreen.fxml");
          if(fxmlLocation != null){
              Parent root = FXMLLoader.load(fxmlLocation);
              currentScene.setRoot(root);
          }

          Stage currentStage = (Stage) currentScene.getWindow();
          currentStage.setTitle("Upload Files");

      }catch (IOException e){
          e.printStackTrace();
          System.err.println("Erro ao carregar upload files: " + e.getMessage());
      }
    }

    @FXML
    private void onClickInvoicesButton(ActionEvent event) throws IOException {
            Node sourceNode = (Node) event.getSource();
            Scene currentScene = sourceNode.getScene();

            URL fxmlLocation = getClass().getResource("/fxml/InvoiceScreen.fxml");
            if(fxmlLocation != null){
                Parent root = FXMLLoader.load(fxmlLocation);
                currentScene.setRoot(root);
            }

    }




}
