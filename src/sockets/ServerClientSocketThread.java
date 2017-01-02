package sockets;

import java.io.*;
import java.net.Socket;

import controllers.RequestController;
import messages.Request;
import messages.Response;

public class ServerClientSocketThread implements Runnable
{

        private Socket socket;
        private RequestController requestController= new RequestController();

        public ServerClientSocketThread(Socket clientSocket)
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
                        response=requestController.serveRequest(request);
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
