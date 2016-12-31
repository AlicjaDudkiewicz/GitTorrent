package model.main_server;

import model.FileInstance;
import model.host.Host;
import model.messages.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

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
            new ClientSocketThread(socket).start();
        }
    }

    public Response serveRequest(Request request)
    {
        Host host = request.getHost();
        Response response = null;
        MainFilesList mainFilesList = MainFilesList.getInstance();
        if (request instanceof FileListUploadRequest)
        {
            response = new FileListUploadResponse();

            if (!(host == null || host.getFilesList() == null))
            {
                mainFilesList.updateList(host);

                response.setStatus("OK");
            }
            else
            {
                response.setStatus("FAILED");
            }


        }
        if (request instanceof FilesListRequest)
        {
            response = new FilesListResponse();
            ArrayList<FileInstance> allFilesList = mainFilesList.getAllFilesList();
            ((FilesListResponse) response).setFilesList(allFilesList);
            response.setStatus("OK");
        }
        if (request instanceof HostListRequest)
        {
            response = new HostListResponse();
            FileInstance requiredFile = ((HostListRequest) request).getRequiredFile();
            if (requiredFile != null)
            {
                ArrayList<Host> hostList = mainFilesList.getHostNames(requiredFile);
                ((HostListResponse) response).setHostList(hostList);
                response.setStatus("OK");
            }
            response.setStatus("FAILED");
        }
        return response;
    }

}