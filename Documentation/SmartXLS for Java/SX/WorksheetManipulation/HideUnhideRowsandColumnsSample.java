import com.smartxls.WorkBook;

public class HideUnhideRowsandColumnsSample
{

    public static void main(String args[])
    {
        try
        {
            HideUnhideRowsandColumnsSample hideUnhideRowsandColumnsSample = new HideUnhideRowsandColumnsSample();
            hideUnhideRowsandColumnsSample.run();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    HideUnhideRowsandColumnsSample()
    {
    }

    void run()
            throws Exception
    {
        WorkBook m_book = new WorkBook();
        m_book.read("..\\template\\book.xls");
        m_book.setRowHidden(1,true);
        m_book.setColHidden(1,true);
        m_book.write(".\\rowcolhide.xls");
    }
}