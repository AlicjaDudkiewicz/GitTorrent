package sockets;

import model.FileInstance;
import model.Host;
import model.MainFilesList;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import messages.*;

public class DispatcherServer
{
    public void activateServer(int port)
    {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try
        {
            serverSocket = new ServerSocket(port);
        }
        catch (IOException e)
        {
            e.printStackTrace();

        }
        while (true)
        {
            try
            {
                socket = serverSocket.accept();
            }
            catch (IOException e)
            {
                System.out.println("I/O error: " + e);
            }
            // new thread for a client
            new Thread(new ServerClientSocketThread(socket)).start();
        }
    }

   
}