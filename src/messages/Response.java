package messages;

import java.io.Serializable;

public class Response implements Serializable
{
    private String status;

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }
}
