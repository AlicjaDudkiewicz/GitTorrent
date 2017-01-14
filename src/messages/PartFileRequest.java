package messages;

import model.FileInstance;

public class PartFileRequest extends Request
{
    private FileInstance fileInstance;
    private long         partStartByte;
    private long         partEndByte;
}
