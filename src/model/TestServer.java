package model;

import java.io.File;

import sockets.ServerDispatcher;

/**
 * Created by Alicja on 2016-12-30.
 */
public class TestServer
{
    public static void main(String[] args)
    {
        MainFilesList mainFilesList= MainFilesList.getInstance();
        mainFilesList.getAllFilesList().add(new FileInstance(new File("C:\\JAJCO.txt")));
        mainFilesList.getAllFilesList().add(new FileInstance(new File("C:\\llooldd.txt")));
        ServerDispatcher serverDispatcher = new ServerDispatcher();
        serverDispatcher.activateServer(21370);
    }
}
