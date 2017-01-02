package main_server;

import java.io.File;

import model.entities.FileInstance;

/**
 * Created by Alicja on 2016-12-30.
 */
public class TestServer
{
    public static void main(String[] args)
    {
        MainFilesList mainFilesList= MainFilesList.getInstance();
        mainFilesList.getAllFilesList().add(new FileInstance(new File("‪C:\\Users\\alicja.dudkiewicz\\JAJCO.txt")));
        mainFilesList.getAllFilesList().add(new FileInstance(new File("‪C:\\Users\\alicja.dudkiewicz\\llooldd.txt")));
        DispatcherServer dispatcherServer = new DispatcherServer();
        dispatcherServer.activateServer(21370);
    }
}
