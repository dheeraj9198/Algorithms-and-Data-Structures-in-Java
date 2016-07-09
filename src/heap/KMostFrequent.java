package heap;

import java.util.HashMap;

/**
 * Created by dheeraj on 7/8/2016.
 */
public class KMostFrequent {
    private static HashMap<String, Data> wordCountMap = new HashMap<String, Data>();
    private static Data[] datas = new Data[4];
    private static int size;

    private static void addToHeap(Data data) {
        if (size < datas.length) {
            datas[size] = data;
            data.heapIndex = size;
            size++;
            if (size == datas.length) {
                buildHeap();
            }
        } else if (datas[0].count < data.count) {
            datas[0].heapIndex = -1;
            datas[0] = data;
            datas[0].heapIndex = 0;
            heapify(0);
        }
    }

    private static void buildHeap() {
        int p = getParent(datas.length - 1);
        for (int k = p; p >= 0; p--) {
            heapify(k);
        }
    }

    private static void heapify(int k) {
        int min = k;
        int l = getLeft(k);
        int r = getRight(k);

        if (l <= datas.length - 1 && datas[l].count < datas[k].count) {
            min = l;
        }

        if (r <= datas.length - 1 && datas[r].count < datas[min].count) {
            min = r;
        }

        if (min != k) {
            Data data = datas[min];
            datas[min] = datas[k];
            datas[min].heapIndex = min;
            datas[k] = data;
            datas[k].heapIndex = k;
            heapify(min);
        }
    }


    private static int getParent(int child) {
        return (child - 1) / 2;
    }

    private static int getRight(int p) {
        return 2 * p + 2;
    }

    private static int getLeft(int p) {
        return 2 * p + 1;
    }


    static class Data {
        int count;
        String word;
        int heapIndex;

        public Data(String word, int count, int heapIndex) {
            this.count = count;
            this.word = word;
            this.heapIndex = -1;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "count=" + count +
                    ", word='" + word + '\'' +
                    ", heapIndex=" + heapIndex +
                    '}';
        }
    }

    private static void addWord(String word) {
        Data data = wordCountMap.get(word);
        if (data == null) {
            data = new Data(word, 1, -1);
            wordCountMap.put(word, data);
            addToHeap(data);
        } else {
            data.count++;
            if (data.heapIndex == -1) {
                addToHeap(data);
            } else {
                heapify(data.heapIndex);
            }
        }
    }

    public static void main(String[] strings) {
        String s = "A B C D A B A E E E E F F F";
        String[] strings1 = s.split(" ");
        for (String s1 : strings1) {
            addWord(s1);
        }
        System.out.println();
    }

}
