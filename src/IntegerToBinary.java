/**
 * Created by dheeraj on 7/1/2016.
 */
public class IntegerToBinary {


    private static String intToBin(int ans) {
        String s = "";
        while (ans > 0) {
            s = ans % 2 + s;
            ans = ans / 2;
        }
        return s;
    }

    private static int binToInt(String s) {
        int k =0;
        for(int x = s.length()-1;x>=0;x--){
            if(s.charAt(x) == '1'){
                k = k + (int)Math.pow(2,s.length() - (x+1));
            }
        }
        return k;
    }

    public static void main(String[] strings) {
        String s = intToBin(10);
        System.out.print(s+"*"+binToInt(new StringBuilder(s).reverse().toString()));


    }
}
