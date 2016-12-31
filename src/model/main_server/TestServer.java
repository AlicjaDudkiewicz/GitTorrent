package model.main_server;

/**
 * Created by Alicja on 2016-12-30.
 */
public class TestServer
{
    public static void main(String[] args)
    {
        DispatcherServer dispatcherServer = new DispatcherServer();
        dispatcherServer.activateServer(21370);
    }
}
