package messages;

import java.util.ArrayList;

import model.Host;

/**
 * Created by Alicja on 2016-12-29.
 */
public class HostListResponse extends Response
{
    private ArrayList<Host> hostList = new ArrayList<>();

    public ArrayList<Host> getHostList()
    {
        return hostList;
    }

    public void setHostList(ArrayList<Host> hostList)
    {
        this.hostList = hostList;
    }
}
