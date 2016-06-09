/**
 * Created by dheeraj on 9/2/15.
 */
public class Hanoi {

    private static int steps =0;

    private static void hanoi(int n,String src,String dest,String temp){
        if(n == 1){
            steps++;
            System.out.format("Moving %d from %s to %s\n", n, src, dest);
        }else{
            hanoi(n-1,src,temp,dest);
            steps++;
            System.out.format("Moving %d from %s to %s\n",n,src,dest);
            hanoi(n - 1, temp, dest, src);
        }
    }

    public static void main(String[] args){
        hanoi(3,"source","destination","temp");
        System.out.println("Steps = "+steps);
    }
}
