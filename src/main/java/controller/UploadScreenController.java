package controller;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import model.XmlFile;
import service.XmlFileService;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class UploadScreenController {

    @FXML
    private Button homeButton;
    @FXML
    private Button invoicesButton;
    @FXML
    private Button settingsButton;
    @FXML
    private Button supportButton;
    @FXML
    private Button gitHubButton;
    @FXML
    private Button SelectFilesButton;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private Label progressLabel;

    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @FXML
    private void onClickHomeButton(ActionEvent event) {
        try {
            Node sourceNode = (Node) event.getSource();
            Scene currentScene = sourceNode.getScene();

            URL fxmlLocation = getClass().getResource("/fxml/MainScreen.fxml");
            if (fxmlLocation != null) {
                Parent root = FXMLLoader.load(fxmlLocation);
                currentScene.setRoot(root);
            }

            Stage currentStage = (Stage) currentScene.getWindow();
            currentStage.setTitle("Upload Files");

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao carregar upload files: " + e.getMessage());
        }
    }

    @FXML
    private void onClickSelectFilesButton(ActionEvent event) {

        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Select Directory");
        File selectedDirectory = directoryChooser.showDialog(primaryStage);
        if (selectedDirectory != null) {
            processXmlFiles(selectedDirectory);
        }
    }

    private void processXmlFiles(File directory) {
        Task<Integer> task = new Task<Integer>() {
            @Override
            protected Integer call() throws Exception {
                List<Path> xmlFiles = Files.walk(directory.toPath())
                        .filter(path -> path.toString().endsWith(".xml"))
                        .collect(Collectors.toList());

                List<XmlFile> xmlFileList = XmlFileService.getInstance().loadXmlFilesFromDirectory(xmlFiles);

                int totalFiles = xmlFiles.size();
                for (int i = 0; i < totalFiles; i++) {
                    Thread.sleep(100);
                    updateProgress(i + 1, totalFiles);
                    updateMessage("Processing file " + (i + 1) + " of " + totalFiles);
                }
                return totalFiles;
            }

            @Override
            protected void succeeded() {
                // Este método é chamado na JavaFX Application Thread (Thread da UI) [7, 8]
                super.succeeded();
                int processedCount = getValue();
                progressLabel.textProperty().unbind();
                progressLabel.setText("Processed " + processedCount + " XML files successfully!");
            }

//            @Override
//            protected void failed() {
//                // Este método é chamado na JavaFX Application Thread (Thread da UI) [7, 8]
//                super.failed();
//                getException().printStackTrace(); // Imprime a exceção no console
//                progressLabel.setText("Erro durante o carregamento: " + getException().getMessage());
//                progressLabel.setText("Erro!");
//                progressBar.setProgress(0.0);
//            }

//            @Override
//            protected void cancelled() {
//                super.cancelled();
//                progressLabel.setText("Carregamento cancelado.");
//                progressLabel.setText("Cancelado.");
//                progressBar.setProgress(0.0);
//            }

        };

        progressBar.progressProperty().bind(task.progressProperty());
        progressLabel.textProperty().bind(task.messageProperty());
        new Thread(task).start();
    }
}
