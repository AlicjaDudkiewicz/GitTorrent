package sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDispatcher
{
    ServerSocket serverSocket = null;

    public void activateServer(int port)
    {
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

    public void deactivateServer()
    {
        try
        {
            serverSocket.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
   
}