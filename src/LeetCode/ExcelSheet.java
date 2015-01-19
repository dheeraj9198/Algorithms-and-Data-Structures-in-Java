package LeetCode;

/**
 * Created by dheeraj on 20/1/15.
 */
public class ExcelSheet {


    public String convertToTitle(int n) {
        StringBuilder stringBuilder = new StringBuilder("");
        int k;
        while(n>0){
            k = 64+n%26;
            if(k == 64)
            {

                stringBuilder.append('Z');
                n = n/26;
            }else{
                stringBuilder.append((char)(k));
            }
            n = n /26;
        }

        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args){
        ExcelSheet excelSheet = new ExcelSheet();
     System.out.print(excelSheet.convertToTitle(52));
    }
}
