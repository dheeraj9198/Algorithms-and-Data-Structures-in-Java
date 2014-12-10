import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: windows 7
 * Date: 12/5/14
 * Time: 7:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyStack {

    public static void main(String[] args)
    {

        Stack stack = new Stack();
        Map map = new Hashtable();
        Hashtable<String,String>  stringStringHashtable = new Hashtable<String, String>();
        stringStringHashtable.put("1","2");
        while(!stringStringHashtable.isEmpty())
        {
            System.out.println(stringStringHashtable.get("1"));
            stringStringHashtable.remove("1");

        }
    }
}
