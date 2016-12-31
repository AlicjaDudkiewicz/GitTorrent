package model.messages;

import java.io.Serializable;

import model.host.Host;

public class Request implements Serializable
{
    private Host host;

    public Host getHost()
    {
        return host;
    }
}
