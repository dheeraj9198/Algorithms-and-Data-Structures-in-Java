package LeetCode;

/**
 * Created by dheeraj on 20/1/15.
 */
public class ExcelSheet {


    public String convertToTitle(int n) {
        StringBuilder stringBuilder = new StringBuilder("");
        int rem;
        while(n>0){
          rem = n % 26;
            n= n/26;

            if(rem == 0 && n >0){
                rem = 26;
                n = n-1;
            }

            if (rem > 0){
                stringBuilder.append((char)('A'+rem-1));
            }
        }

        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args){
        ExcelSheet excelSheet = new ExcelSheet();
     System.out.print(excelSheet.convertToTitle(26));
    }
}
