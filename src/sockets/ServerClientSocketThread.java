package sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import controllers.RequestController;
import messages.Request;
import messages.Response;
import model.Host;

public class ServerClientSocketThread implements Runnable
{

    private Socket socket;
    private RequestController requestController = new RequestController();
    private ObjectOutputStream output;
    private ObjectInputStream  input;

    public ServerClientSocketThread(Socket clientSocket)
    {
        this.socket = clientSocket;
        try
        {
            this.input = new ObjectInputStream(socket.getInputStream());
            this.output = new ObjectOutputStream(socket.getOutputStream());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void run()
    {
        Request request;
        Response response;
        Host remoteHost=null;

        while (true)
        {
            try
            {
                request = (Request) input.readObject();

                if (request == null)
                {
                    disableHost(remoteHost);
                    tryCloseSocket();
                    return;
                }
                else
                {
                    request.getHost().setIp(socket.getInetAddress().getHostAddress());
                    remoteHost = request.getHost();
                    response = requestController.serveRequest(request);
                    output.writeObject(response);
                    output.flush();
                }
            }
            catch (IOException | ClassNotFoundException e)
            {
                disableHost(remoteHost);
                tryCloseSocket();
                return;
            }
        }
    }

    private void disableHost(Host remoteHost)
    {
        if(remoteHost!=null) //if is null then session was not initialized, no need to clean up
        {
            requestController.disableHost(remoteHost);
            System.out.println("Host disconected: "+ remoteHost);
        }
    }

    private void tryCloseSocket()
    {
        try
        {
            socket.close();
        }
        catch (IOException e)
        {

        }
    }

}
