package main_server;

import model.messages.Request;
import model.messages.Response;

import java.io.*;
import java.net.Socket;

public class ClientSocketThread extends Thread
{

        private Socket socket;
        private DispatcherServer dispatcherServer= new DispatcherServer();

        public ClientSocketThread(Socket clientSocket)
        {
            this.socket = clientSocket;
        }

        public void run()
        {

            ObjectInputStream ois =null;
            ObjectOutputStream ous=null;
            Request request = null;
            Response response=null;

            try {
                ois= new ObjectInputStream(socket.getInputStream());
                request=(Request)ois.readObject();
                ous = new ObjectOutputStream(socket.getOutputStream());
            } catch (IOException | ClassNotFoundException e)
            {
                e.printStackTrace();
            }

            while (true)
            {
                try
                {

                    if (request == null)
                    {
                        socket.close();
                        return;
                    } else
                    {
                        response=dispatcherServer.serveRequest(request);
                        ous.writeObject(response);
                        ous.flush();
                    }
                } catch (IOException e)
                {
                    try
                    {
                        socket.close();
                    }
                    catch (IOException e1)
                    {
                        e1.printStackTrace();
                    }
                    return;
                }
            }
        }

}
