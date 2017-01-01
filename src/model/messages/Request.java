package model.messages;

import java.io.Serializable;

import model.entities.Host;

public class Request implements Serializable
{
    private Host host;

    public Host getHost()
    {
        return host;
    }
}
