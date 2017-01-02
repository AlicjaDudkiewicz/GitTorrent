package model;

import model.FileInstance;
import model.Host;

import java.util.HashMap;

/**
 * Created by Alicja on 2016-12-30.
 */
public class MainServer
{
    private static HashMap<Host, FileInstance> filesList = new HashMap<>();

    public HashMap<Host, FileInstance> getFilesList()
    {
        return filesList;
    }
}
