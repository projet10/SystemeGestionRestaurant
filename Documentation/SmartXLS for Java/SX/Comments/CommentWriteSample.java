import com.smartxls.WorkBook;

public class CommentWriteSample
{

    public static void main(String args[])
    {
        WorkBook workBook = new WorkBook();
        try
        {
            //add a comment to B2
            workBook.addComment(1, 1, "comment text here!", "author name here!");

            workBook.write(".\\comment.xls");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}