/**
 * Created by dheeraj on 11/1/15.
 */
public class MyHeap {
    private int heapSize;
    private int[] array;

    public MyHeap(int[] arr){
        array = arr;
        heapSize = arr.length;
    }

    private void print(){
        for(int x =0;x<array.length;x++){
            System.out.print(array[x]+" ");
        }
        System.out.println();
    }

    private void maxHeapify(int index){
        int max = index;

        if(getLeftChild(index) < heapSize && array[max] < array[getLeftChild(index)]){
            max = getLeftChild(index);
        }

        if(getRightChild(index) < heapSize && array[max] < array[getRightChild(index)]){
            max= getRightChild(index);
        }

        if(max != index){
            swap(max,index);
            maxHeapify(max);
        }
    }

    private void buildMaxHeap(){
        int start = heapSize/2 -1;
        for(int x = start;x>=0;x--){
            maxHeapify(x);
        }
    }


    private void heapSort(){
        buildMaxHeap();
        for(int x = heapSize-1;x>0;x--){
            swap(0,heapSize-1);
            heapSize = heapSize -1;
            maxHeapify(0);
        }
        heapSize = array.length;
    }

    private void swap(int z,int y){
        int x = array[z];
        array[z] = array[y];
        array[y] = x;
    }

    private int getParent(int child){
        return (child-1)/2;
    }

    private int getLeftChild(int parent){
        return parent*2+1;
    }

    private int getRightChild(int parent){
        return parent*2+2;
    }

    private void increaseKeyValue(int index,int value){
        if(index >= heapSize || value < array[index]){
            System.out.println("error");
            return;
        }

        array[index] = value;
        while(index >= 0 && array[index] > array[getParent(index)]){
            swap(index,getParent(index));
            index = getParent(index);
        }
    }

    private void increaseHeapSize(){
        heapSize = heapSize +1;
        int[] newArr = new int[heapSize];
        for(int x =0;x<heapSize;x++){
            try {
                newArr[x] = array[x];
            }catch (Exception e){
                newArr[x] =0;
            }
        }
        array = newArr;
    }

    public static void main(String[] args){
        int[] arr = {1,4,3,6,5,8,7,9,2};
        MyHeap myHeap =new MyHeap(arr);
        //myHeap.heapSort();
        myHeap.print();

        myHeap.increaseKeyValue(8,10);

        myHeap.print();

        myHeap.increaseHeapSize();
        myHeap.increaseKeyValue(9,100);
        myHeap.print();


    }





}
