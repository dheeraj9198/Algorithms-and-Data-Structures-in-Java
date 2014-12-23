/**
 * Created by dheeraj on 12/23/14.
 */
public class LongestIncreasingSubsequenceChars {


    private char[] array;
    private int length;

    public LongestIncreasingSubsequenceChars(char[] arr) {
        array = arr;
        length = array.length;
    }


    public int getLongestIncreasingsubsequenceLength() {
        char[] maxElementArray = new char[length];
        int[] lengthArray = new int[length];

        int currentLength;

        for (int x = 0; x < length; x++) {
            maxElementArray[x] = 0;
            lengthArray[x] = 0;
        }

        maxElementArray[0] = array[0];
        lengthArray[0] = 1;
        currentLength = 0;

        for (int x = 1; x < length; x++) {
            int maxIndex = binarySearchMaxSmallest(maxElementArray, array[x], 0, currentLength);
            if (maxIndex == -1) {
                //not found
                currentLength++;
                maxElementArray[currentLength] = array[x];
                lengthArray[currentLength] = 1;
            } else {
                int lengthTemp = lengthArray[maxIndex] + 1;
                int lengthCountIndex = binarySearch(lengthArray, lengthTemp, 0, currentLength);
                if (lengthCountIndex == -1) {
                    currentLength++;
                    maxElementArray[currentLength] = array[x];
                    lengthArray[currentLength] = lengthTemp;
                } else {
                    maxElementArray[lengthCountIndex] = array[x];
                }
            }
        }
        return lengthArray[currentLength];
    }

    private int binarySearchMaxSmallest(char[] array, char data, int start, int end) {
        if(data > array[end]){
            return end;
        }
        if (start == end) {
            return -1;
        }
        int mid = start + end;
        mid = mid  /2;
        if(array[mid] < data && array[mid+1] > data){
            return mid;
        }else{
            if(array[mid] < data){
                return binarySearchMaxSmallest(array,data,mid+1,end);
            }else{
                return binarySearchMaxSmallest(array,data,start,mid);
            }
        }
    }

    private int binarySearch(int[] array, int data, int start, int end) {
        if (start == end) {
            if (array[start] == data) {
                return start;
            } else {
                return -1;
            }
        }

        int mid = start + end;
        mid = mid/2;
        if(array[mid] == data){
            return mid;
        }

        if(array[mid] < data){
            return binarySearch(array,data,mid+1,end);
        }else{
            return binarySearch(array,data,start,mid);
        }
    }

    public static void main(String[] args){
       // char test = 'A';
       // int x = test;
       // System.out.println((int)test);

        char[] arr = {'A','B','E','C','D'};//{2,3,5,6,7,8,10,11,13};
        LongestIncreasingSubsequenceChars longestIncreasingSubsequenceChars = new LongestIncreasingSubsequenceChars(arr);
        System.out.println(longestIncreasingSubsequenceChars.getLongestIncreasingsubsequenceLength());
    }

}
