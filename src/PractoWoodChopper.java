/**
 * Created by dheeraj on 12/1/15.
 */
public class PractoWoodChopper {

    private int[] array;

    private PractoWoodChopper(int[] arr){
        this.array = arr;
    }

    private int getLargest(){
        int largest = array[0];

        for(int x =1;x<array.length;x++){
            largest = Math.max(largest,array[x]);
        }

        return largest;
    }

    private void solve(){
        int largest = getLargest()+1;
        int[] hashArray = new int[largest];

        for(int k =0;k<largest;k++){
            hashArray[k] =0;
        }

        for(int k =0;k<array.length;k++){
            hashArray[array[k]] = hashArray[array[k]]+1;
        }

        for(int k =hashArray.length-2;k>=0;k--){
            hashArray[k] = hashArray[k+1] + hashArray[k];
        }

        System.out.print(hashArray[0]+" ");
        int x = hashArray[0];
        for(int k =1;k<hashArray.length;k++){
            if(x != hashArray[k]){
                System.out.print(hashArray[k]+" ");
                x = hashArray[k];
            }
        }
    }

    public  static void main(String[] args){
        int[] k = {9,1,2,3,4,7,3,3};
        PractoWoodChopper practoWoodChopper = new PractoWoodChopper(k);
        practoWoodChopper.solve();
    }



}
