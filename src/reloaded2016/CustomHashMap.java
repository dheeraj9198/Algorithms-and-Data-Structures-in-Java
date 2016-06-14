package reloaded2016;

/**
 * Created by dheeraj on 9/6/16.
 */
class HashMap {

    private static final int prime = 1001;
    private static final int a = 379;
    private static final int b = 497;

    private int[] objects = new int[prime];

    private static int getHash(int data) {
        return (a * data + b) % prime;
    }

    public void put(int k){
        int hash = getHash(k);
        objects[hash] = k;
    }

    public int get(int k){
        int hash = getHash(k);
        return objects[hash];
    }


    public static void main(String[] strings){
        HashMap customHashMap = new HashMap();
        customHashMap.put(9000);
        System.out.println(customHashMap.get(9000));
    }

}
