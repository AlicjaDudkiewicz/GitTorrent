package host;

import model.messages.FileListUploadRequest;
import model.messages.Request;


public class TestHost2
{
    public static void main(String[] args)
    {

        DispatcherHost dispatcherHost= new DispatcherHost();
        dispatcherHost.connectToServer("localhost",21370);
        Request request= new FileListUploadRequest();
        dispatcherHost.sendRequest(request);
    }
}
