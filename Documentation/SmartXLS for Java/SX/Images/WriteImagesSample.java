import com.smartxls.PictureShape;
import com.smartxls.ShapeFormat;
import com.smartxls.WorkBook;

public class WriteImagesSample
{

    public static void main(String args[])
    {
        try
        {
            WorkBook m_book = new WorkBook();

            //Inserting image
            PictureShape pictureShape = m_book.addPicture(1, 0, 3, 8, "..\\template\\MS.GIF");
            ShapeFormat shapeFormat = pictureShape.getFormat();
            shapeFormat.setPlacementStyle(ShapeFormat.PlacementFreeFloating);
            pictureShape.setFormat();

            m_book.write(".\\pic.xls");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}