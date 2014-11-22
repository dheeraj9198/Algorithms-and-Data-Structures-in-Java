/**
 * Created with IntelliJ IDEA.
 * User: windows 7
 * Date: 11/22/14
 * Time: 5:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class SecondMajority {
    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 4, 7, 2};

        int count = 0;
        int num = 0;

        for (int x = 0; x < array.length; x++) {
            if (count == 0) {
                num = array[x];
                count++;
            } else {
                if (array[x] == num) {
                    count++;
                } else {
                    count--;

                }
            }
        }
        int occ = 0;

        for(int y = 0 ;y<array.length;y++)
        {
            if(array[y] == num)
                occ++;
        }

        if(occ > array.length/2)
        {
            System.out.println("2 majority element is "+num);
        }else{
            System.out.println("no 2 majority element");
        }

    }


}
