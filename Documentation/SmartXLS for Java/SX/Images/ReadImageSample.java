import com.smartxls.WorkBook;

import java.io.FileOutputStream;

public class ReadImageSample
{

    public static void main(String args[])
    {
        try
        {
            WorkBook m_book = new WorkBook();

            //open the workbook
            m_book.read("..\\template\\book.xls");

            String filename = "img";
            int type = m_book.getPictureType(0);
            if(type == -1)
                filename += ".gif";
            else if(type == 5)
                filename += ".jpg";
            else if(type == 6)
                filename += ".png";
            else if(type == 7)
                filename += ".bmp";

            byte[] imagedata = m_book.getPictureData(0);
            
            FileOutputStream fos = new FileOutputStream(filename);
            fos.write(imagedata);
            fos.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}