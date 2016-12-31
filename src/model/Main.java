package model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args)
    {

        FilesListUploader filesListUploader= new FilesListUploader();
        ArrayList<FileInstance> availableFilesList = filesListUploader.getAvailableFilesList("C:\\Users\\Alicja\\Downloads");
        for(FileInstance fileInstance: availableFilesList)
        {
            System.out.println(fileInstance.getName()+"  ----" +fileInstance.getMd5());
        }

    }
}
