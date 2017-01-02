package host;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import model.entities.FileInstance;
import model.entities.Host;
import model.messages.FilesListResponse;
import model.messages.HostListResponse;
import model.messages.PullFileRequest;
import model.messages.PushFileRequest;
import model.messages.Request;
import model.messages.Response;


public class DispatcherHost
{
    private ServerSocket         serverSocket;
    private Socket               socketForClient;
    private Socket               clientSocket;
    private MainWindowController controller;

    public DispatcherHost()
    {
        FXMLLoader fxmlLoader = new FXMLLoader();
        try
        {
            Pane p = fxmlLoader.load(getClass().getResource("mainWindow.fxml").openStream());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        controller = fxmlLoader.getController();
        controller.setDispatcher(this);
    }

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
            new main_server.ClientSocketThread(socket).start();
        }
    }


    public void connectToServer(String host, int port)
    {
        try
        {
            clientSocket = new Socket(host, port);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void sendRequest(Request request)

    {

        try
        {
            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());

            oos.writeObject(request);
            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
            try
            {

                Response response = (Response) ois.readObject();
                System.out.println(response.getStatus());

            }
            catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }
            oos.close();
            ois.close();
            clientSocket.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public Response serveRequest(Request request)
    {
        if (request != null)
        {
            if (request instanceof PullFileRequest)
            {

            }
            if (request instanceof PushFileRequest)
            {

            }

        }
        return null;
    }

    public void serveResponse(Response response)
    {
        MainWindowController controller = null;
        if (response instanceof FilesListResponse)
        {
            ArrayList<FileInstance> filesList = ((FilesListResponse) response).getFilesList();
            controller.refreshFilesList(filesList);
        }
        if (response instanceof HostListResponse)
        {
            ArrayList<Host> hostList = ((HostListResponse) response).getHostList();
            controller.setHostList();
        }


    }
}
