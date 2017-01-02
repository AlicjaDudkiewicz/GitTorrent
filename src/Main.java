import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.entities.FileInstance;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainWindow.fxml"));
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
