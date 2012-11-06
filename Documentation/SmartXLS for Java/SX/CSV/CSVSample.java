import com.smartxls.WorkBook;

public class CSVSample
{

    public static void main(String args[])
    {

        WorkBook workBook = new WorkBook();
        try
        {
            workBook.read("..\\template\\book.csv");

            workBook.write(".\\out.xls");
            
            workBook.setText(0,0,"aa");
            workBook.setText(1,0,"bb");
            workBook.setText(2,0,"cc");

            workBook.writeCSV("./out.csv");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}