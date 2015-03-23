package CoreJava;

import java.util.ArrayList;

/**
 * Created by dheeraj on 22/3/15.
 */
public class ALT {
    private static final class A{

        public int getK() {
            return 1;
        }

        public String getString() {
            return "kkk";
        }
    }

    private static final class B{

        public int getKaaa() {
            return 10;
        }

        public String getStringaaaa() {
            return "kfxnkfjxkkk";
        }
    }

    public static void main(String[] args){
        ArrayList<Object> objects = new ArrayList<Object>();
        objects.add(new A());
        objects.add(new B());


        for(Object o: objects){
            if(o instanceof  A){
                System.out.println(((A)o).getK());
            }
            if(o instanceof B){
                System.out.println(((B)o).getKaaa());
            }
        }











    }

}
