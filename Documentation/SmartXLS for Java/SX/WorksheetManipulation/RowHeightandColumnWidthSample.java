import com.smartxls.WorkBook;

public class RowHeightandColumnWidthSample
{

    public static void main(String args[])
    {
        try
        {
            RowHeightandColumnWidthSample rowHeightandColumnWidthSample = new RowHeightandColumnWidthSample();
            rowHeightandColumnWidthSample.run();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    RowHeightandColumnWidthSample()
    {
    }

    void run()
            throws Exception
    {
        WorkBook m_book = new WorkBook();
        m_book.read("..\\template\\book.xls");

        m_book.setRowHeight(1, 25 * 1440/256);
        m_book.setColWidth(1, 25 * 256);

        m_book.write(".\\rowheightcolwidth.xls");
    }
}