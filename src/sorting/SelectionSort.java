package sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: windows 7
 * Date: 11/19/14
 * Time: 10:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class SelectionSort {
    public static void main(String[] args) throws Exception
    {
        String numbersString = new BufferedReader(new InputStreamReader(System.in)).readLine();
        String[] numbers =  numbersString.split(" ");
        int[] numArray = new int[numbers.length];
        for(int x=0;x<numbers.length;x++)
        {
            numArray[x] = Integer.parseInt(numbers[x]);
        }

        numArray = selectionSort(numArray);

        for(int x = 0 ;x<numArray.length;x++)
        {
            System.out.print(numArray[x]);
        }
    }

    public static int[] selectionSort(int[] numArray)
    {
        for(int x = 0; x<numArray.length;x++)
        {
            //find smallest between x and numArray.length-1
            int smallestIndex =  findSmallestIndex(numArray,x);
            int temp = numArray[x];
            numArray[x] = numArray[smallestIndex];
            numArray[smallestIndex] = temp;
        }
        return numArray;
    }

    public static int findSmallestIndex(int[] numArray,int index)
    {
        int smallest = index;
        for(int x = index;x<numArray.length;x++)
        {
            if(numArray[smallest] > numArray[x])
            {
                smallest = x;
            }
        }
        return smallest;
    }
}
