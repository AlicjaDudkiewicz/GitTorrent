package model;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

/**
 * Created by Alicja on 2016-12-28.
 */
public class FilesListUploader
{
    private ArrayList<FileInstance> availableFilesList= new ArrayList<>();
    public void uploadFiles(String pathToDirectory)
    {
        File[] files = new File(pathToDirectory).listFiles();
        for(File file: files)
        {
            FileInstance fileInstance = new FileInstance(file);
            availableFilesList.add(fileInstance);
        }
    }

    public ArrayList<FileInstance> getAvailableFilesList(String path)
    {
        uploadFiles(path);
        return availableFilesList;
    }
}
