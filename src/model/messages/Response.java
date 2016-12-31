package model.messages;

import java.io.Serializable;

import sun.plugin2.message.Serializer;

/**
 * Created by Alicja on 2016-12-28.
 */
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
