package model;

import sockets.ServerDispatcher;

/**
 * Created by Alicja on 2016-12-30.
 */
public class TestServer
{
    public static void main(String[] args)
    {
        ServerDispatcher serverDispatcher = new ServerDispatcher();
        serverDispatcher.activateServer(21370);
    }
}
