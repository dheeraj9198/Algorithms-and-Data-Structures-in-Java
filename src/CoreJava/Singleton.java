package CoreJava;

/**
 * Created by dheeraj on 28/7/15.
 */
public class Singleton {
    private static volatile Object object = null;

    public static Object getObjectInstance() {
        System.out.println("entered : "+Thread.currentThread().getName());
        if (object == null) {
            System.out.println("waiting : "+Thread.currentThread().getName());
            synchronized (Singleton.class) {
                if (object == null) {
                    System.out.println("init : "+Thread.currentThread().getName());
                    object = new Object();
                }
            }
        }
        System.out.println("returning : "+Thread.currentThread().getName());
        return object;
    }

    public static void main(String[] ksdnml) {
        for (int k = 0; k < 100; k++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    getObjectInstance();
                }
            });
            thread.setName("Thread : " + k);
            thread.start();
        }
    }
}
