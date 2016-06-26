package reloaded2016;

/**
 * Created by dheeraj on 9/6/16.
 */
class CustomHashMap {

    private static int size =100;
    private static final int prime = 1001;
    private static final int a = 379;
    private static final int b = 497;

    private Object[] objects = new Object[size];

    private static int getHash(int data) {
        return ((a * data + b) % prime)%size;
    }

    public void put(int k,Object o){
        int hash = getHash(k);
        objects[hash] = k;
    }

    public Object get(int k){
        int hash = getHash(k);
        return objects[hash];
    }


    public static void main(String[] strings){
        CustomHashMap customHashMap = new CustomHashMap();
        customHashMap.put(9000,"Test9000");
        customHashMap.put(9001,"Test9001");
        customHashMap.put(9002,"Test9002");
        customHashMap.put(9003,"Test9003");
        customHashMap.put(9004,"Test9004");

        System.out.println(customHashMap.get(9000));
        System.out.println(customHashMap.get(9004));

    }

}
