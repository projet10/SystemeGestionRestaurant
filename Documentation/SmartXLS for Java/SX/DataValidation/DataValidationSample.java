import com.smartxls.DataValidation;
import com.smartxls.WorkBook;

public class DataValidationSample
{

    public static void main(String args[])
    {
        WorkBook workBook = new WorkBook();
        try
        {
            workBook.setText(0, 1, "Apple");
            workBook.setText(0, 2, "Orange");
            workBook.setText(0, 3, "Banana");

            DataValidation dataValidation = workBook.CreateDataValidation();
            dataValidation.setType(DataValidation.eUser);
            dataValidation.setFormula1("\"dddd\0gggg\0hhh\"");
            workBook.setSelection("A1:A5");
            workBook.setDataValidation(dataValidation);

            dataValidation = workBook.CreateDataValidation();
            dataValidation.setType(DataValidation.eUser);
            dataValidation.setFormula1("$B$1:$D$1");
            workBook.setSelection("B1:D5");
            workBook.setDataValidation(dataValidation);

            workBook.write(".\\datavalidation.xls");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}