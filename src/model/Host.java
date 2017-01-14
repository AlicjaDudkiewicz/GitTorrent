package model;

import java.io.Serializable;


public class Host implements Serializable
{
    private String ip;
    private int port;

    public Host(String ip, int port)
    {
        this.ip = ip;
        this.port = port;
    }

    public String getIp()
    {
        return ip;
    }

    public void setIp(String ip)
    {
        this.ip = ip;
    }

    public int getPort()
    {
        return port;
    }

    public void setPort(int port)
    {
        this.port = port;
    }

    @Override
    public String toString()
    {
        return this.getIp() + ":" + this.getPort();
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        Host host = (Host) o;

        if (port != host.port)
        {
            return false;
        }
        return ip.equals(host.ip);

    }

    @Override
    public int hashCode()
    {
        int result = ip.hashCode();
        result = 31 * result + port;
        return result;
    }
}
