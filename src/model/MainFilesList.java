package model;

import java.util.ArrayList;
import java.util.HashMap;

import messages.FileListUploadRequest;

/**
 * Created by Alicja on 2016-12-30.
 */
public class MainFilesList
{
    private static MainFilesList                          instance      = null;
    private        HashMap<Host, ArrayList<FileInstance>> mainFilesList = new HashMap<>();

    private MainFilesList()
    {
    }

    public static MainFilesList getInstance()
    {
        if (instance == null)
        {
            instance = new MainFilesList();
        }
        return instance;
    }

    public void updateList(FileListUploadRequest fileList)
    {
        mainFilesList.remove(fileList.getHost());
        mainFilesList.put(fileList.getHost(), fileList.getFileList());
    }

    public ArrayList<Host> getHostNames(FileInstance fileInstance)
    {
        ArrayList<Host> requiredHostsList = new ArrayList<>();
        for (HashMap.Entry<Host, ArrayList<FileInstance>> entry : mainFilesList.entrySet())
        {
            if (entry.getValue().contains(fileInstance))
            {
                requiredHostsList.add(entry.getKey());
            }
        }
        return requiredHostsList;
    }

    public ArrayList<FileInstance> getAllFilesList()
    {
        ArrayList<FileInstance> allFilesList = new ArrayList<>();
        for (HashMap.Entry<Host, ArrayList<FileInstance>> entry : mainFilesList.entrySet())
        {
            for (FileInstance file : entry.getValue())
            {
                if (!(allFilesList.contains(file)))
                {
                    allFilesList.add(file);
                }
            }
        }
        return allFilesList;
    }

    public void removeHost(Host host)
    {
        mainFilesList.remove(host);
    }
}
