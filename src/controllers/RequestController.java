package controllers;

import java.util.ArrayList;

import messages.FileListUploadRequest;
import messages.FileListUploadResponse;
import messages.FilesListRequest;
import messages.FilesListResponse;
import messages.HostListRequest;
import messages.HostListResponse;
import messages.Request;
import messages.Response;
import model.FileInstance;
import model.Host;
import model.MainFilesList;

public class RequestController
{

    private MainFilesList mainFilesList;

    public Response serveRequest(Request request)
    {
        Host host = request.getHost();
        Response response = null;
        mainFilesList = MainFilesList.getInstance();

        if (request instanceof FileListUploadRequest)
        {
            response = new FileListUploadResponse();
            if (!(host == null))
            {
                mainFilesList.updateList((FileListUploadRequest) request);
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
            response.setStatus("OKd");
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
            else
                response.setStatus("FAILED");
        }
        return response;
    }

    public void disableHost(Host host)
    {
        mainFilesList.removeHost(host);
    }

}
