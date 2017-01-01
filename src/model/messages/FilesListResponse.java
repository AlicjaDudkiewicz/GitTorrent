package model.messages;

import model.entities.FileInstance;

import java.util.ArrayList;

/**
 * Created by Alicja on 2016-12-29.
 */
public class FilesListResponse extends Response
{
    private ArrayList<FileInstance> filesList = new ArrayList<>();

    public ArrayList<FileInstance> getFilesList()
    {
        return filesList;
    }

    public void setFilesList(ArrayList<FileInstance> filesList)
    {
        this.filesList = filesList;
    }
}
