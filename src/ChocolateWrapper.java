/**
 * Created by dheeraj on 6/18/2016.
 * A chocolate costs 1 rupee each. You can also exchange 3 wrappers for a chocolate. If you have x rs, how many chocolates can you get??
 */
public class ChocolateWrapper {

    public static void main(String[] strings){
        int rs = 17;
        int chocolate = rs;
        int wrapper = rs;
        while(wrapper > 2){
            int newC = wrapper / 3;
            wrapper = wrapper % 3;
            wrapper = wrapper + newC;
            chocolate = chocolate + newC;
        }
        System.out.println(chocolate);
    }

}
