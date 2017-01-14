package messages;

import java.util.ArrayList;

import model.FileInstance;

/**
 * Created by Alicja on 2016-12-29.
 */
public class FileListUploadRequest extends Request
{
    private ArrayList<FileInstance> fileList;

    public FileListUploadRequest(ArrayList<FileInstance> fileList)
    {
        this.fileList = fileList;
    }

    public ArrayList<FileInstance> getFileList()
    {
        return fileList;
    }

    public void setFileList(ArrayList<FileInstance> fileList)
    {
        this.fileList = fileList;
    }
}
