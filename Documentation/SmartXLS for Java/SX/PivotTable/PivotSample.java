import com.smartxls.*;

public class PivotSample
{

    public static void main(String args[])
    {
        WorkBook bookModel = new WorkBook();
        int rowIndex = 0;
        try
        {
            bookModel.read("..\\template\\pivotTemplate.xls");

            BookPivotRangeModel model = bookModel.getPivotModel();
			model.setList("A1:D27");
			model.setLocation(0, 7, 5);

            BookPivotRange pivotRange = model.getActivePivotRange();
            BookPivotArea rowArea = pivotRange.getArea(BookPivotRange.row);
            BookPivotArea columnArea = pivotRange.getArea(BookPivotRange.column);
            BookPivotArea dataArea = pivotRange.getArea(BookPivotRange.data);
            BookPivotArea pageArea = pivotRange.getArea(BookPivotRange.page);

            BookPivotField rowField = pivotRange.getField("Who");
            rowArea.addField(rowField);
            BookPivotField dataField = pivotRange.getField("Amount");
            dataArea.addField(dataField);
            BookPivotField columnField = pivotRange.getField("What");
            columnArea.addField(columnField);
            BookPivotField pageField = pivotRange.getField("Week");
            pageArea.addField(pageField);


            bookModel.write(".\\PivotTable.xls");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}