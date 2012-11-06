
import com.smartxls.WorkBook;

public class OpenXML
{
    public static void main(String args[])
    {
        WorkBook bookModel = new WorkBook();
        try
        {
            bookModel.readXLSX("..\\template\\format.xlsx");
            bookModel.writeXLSX(".\\out.xlsx");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
