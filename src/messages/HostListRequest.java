package messages;

import model.FileInstance;

/**
 * Created by Alicja on 2016-12-29.
 */
public class HostListRequest extends Request
{
    private FileInstance requiredFile;

    public FileInstance getRequiredFile()
    {
        return requiredFile;
    }

    public void setRequiredFile(FileInstance requiredFile)
    {
        this.requiredFile = requiredFile;
    }
}
