import java.util.*;

/**
 * use balanced bst for storing data
 */
class TestUber {

    private static HashMap<String, NavigableMap<Long,String>> idDataListMap = new HashMap<String, NavigableMap<Long, String>>();

    private static void insertData(String id, Long timestamp, String location) {
        NavigableMap<Long,String> datas = null;
        if (!idDataListMap.containsKey(id)) {
            datas = new TreeMap<Long,String>();
            idDataListMap.put(id, datas);
        } else {
            datas = idDataListMap.get(id);
        }
        datas.put(timestamp, location);
    }

    private static String getLocation(String id, Long timeStamp) {
        NavigableMap<Long,String> datas = idDataListMap.get(id);
        if (datas == null) {
            return null;
        } else {
           return datas.floorEntry(timeStamp).getValue();
        }
    }

    public static void main(String[] args) {
        TestUber test = new TestUber();
        /*
        test.insertData("1", 5L, "5");
        test.insertData("1", 2L, "2");
        test.insertData("1", 8L, "8");
        test.insertData("1", 7L, "7");
        test.insertData("1", 9L, "9");
        test.insertData("1", 1L, "1");
        test.insertData("1", 3L, "3");
        */
        test.insertData("1", 1L, "1");
        test.insertData("1", 2L, "2");
        test.insertData("1", 3L, "3");
        test.insertData("1", 5L, "5");
        test.insertData("1",10L,"10");
        test.insertData("1", 7L, "7");
        test.insertData("1", 8L, "8");
        test.insertData("1", 9L, "9");


        System.out.println(test.getLocation("1", 8L)); // 8
        System.out.println(test.getLocation("1", 10L)); // 5
    }
}
