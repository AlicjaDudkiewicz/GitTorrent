package messages;

import java.io.Serializable;

import model.Host;

public class Request implements Serializable
{
    private Host host;

    public Host getHost()
    {
        return host;
    }
}
