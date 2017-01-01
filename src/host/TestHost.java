package host;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestHost extends Application
{
    public static void main(String[] args)
    {
        launch(args);



//        DispatcherHost dispatcherHost= new DispatcherHost();
//        dispatcherHost.connectToServer("localhost",21370);
//        Request request= new FileListUploadRequest();
//        dispatcherHost.sendRequest(request);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("GitTorrent");
        primaryStage.setScene(new Scene(root, 900, 550));
        primaryStage.show();
    }
}
