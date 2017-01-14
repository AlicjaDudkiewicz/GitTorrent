package messages;

import model.FileInstance;

public class FilePartResponse extends Response
{
    private byte[]       filePartData;
    private FileInstance fileInstance;
    private long         startByte;

    public FilePartResponse(FileInstance fileInstance, long startByte)
    {
        this.fileInstance = fileInstance;
        this.startByte = startByte;
    }

    public long getStartByte()
    {
        return startByte;
    }
    public void setStartByte(long startByte)
    {
        this.startByte = startByte;
    }
    public FileInstance getFileInstance()
    {
        return fileInstance;
    }
    public void setFileInstance(FileInstance fileInstance)
    {
        this.fileInstance = fileInstance;
    }
    public byte[] getFilePartData()
    {
        return filePartData;
    }
    public void setFilePartData(byte[] filePartData)
    {
        this.filePartData = filePartData;
    }
    
}
