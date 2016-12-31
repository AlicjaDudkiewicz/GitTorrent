package model.host;

import model.FileInstance;

import java.util.ArrayList;


public class Host
{
    private String name;
    private ArrayList<FileInstance> filesList= new ArrayList<>();

    public String getName()
    {
        return name;
    }

    public ArrayList<FileInstance> getFilesList()
    {
        return filesList;
    }
}
