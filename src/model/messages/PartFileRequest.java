package model.messages;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

import model.entities.FileInstance;

public class PartFileRequest extends Request 
{
    private FileInstance fileInstance;
    private long partStartByte;
    private long partEndByte;
}