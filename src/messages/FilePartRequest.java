package messages;

import model.FileInstance;

public class FilePartRequest extends Request
{
    private FileInstance fileInstance;
    private long         partStartByte;
    private long         partFileSize;

    public FilePartRequest(FileInstance fileInstance, long partStartByte, long filePartSize)
    {
        this.fileInstance = fileInstance;
        this.partStartByte = partStartByte;
        this.partFileSize = filePartSize;
    }

    public FileInstance getFileInstance()
    {
        return fileInstance;
    }

    public void setFileInstance(FileInstance fileInstance)
    {
        this.fileInstance = fileInstance;
    }

    public long getPartStartByte()
    {
        return partStartByte;
    }

    public void setPartStartByte(long partStartByte)
    {
        this.partStartByte = partStartByte;
    }

    public long getPartFileSize()
    {
        return partFileSize;
    }

    public void setPartFileSize(long partFileSize)
    {
        this.partFileSize = partFileSize;
    }

}
