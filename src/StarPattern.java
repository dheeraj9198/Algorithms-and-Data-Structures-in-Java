/**
 * Created by dheeraj on 13/1/15.
 */
public class StarPattern {

    public static void main(String[] args){
        int total =7;
        int middle = total/2+1;

        for(int x = 1 ;x  <= middle ;x++)
        {
            for(int y = 1;y<=total;y++){
                if(middle-x< y && y<middle+x){
                    System.out.print("*");
                }else{
                   System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

}
