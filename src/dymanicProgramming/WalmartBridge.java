package dymanicProgramming;

/**
 * Created by dheeraj on 12/21/14.
 * O(n^3)
 * O(NlogN) for longest increasing subsequence
 */
public class WalmartBridge {
    private String string1;
    private String string2;

    public WalmartBridge(String s1,String s2){
        this.string1 = s1;
        this.string2 = s2;
    }

    public int getNumBridges(){
        int answer = 0;
        int currentIndex = -1;
        int length = 0;
        int tempIndex;
        for(int x =0;x<string1.length();x++){
            currentIndex = -1;
            length = 0;
            for(int y=x;y<string1.length();y++){
               tempIndex = findIndex(string1.charAt(y));
                if(tempIndex == -1){
                    continue;
                }
                if(tempIndex > currentIndex){
                    length++;
                    currentIndex = tempIndex;
                }
            }
            answer=Math.max(answer,length);
        }
        return   answer;
    }

    private int findIndex(char c){
        for(int k =0;k<string2.length();k++){
            if(string2.charAt(k) == c){
                return k;
            }
        }
        return -1;
    }


    public static void main(String[] args){
        WalmartBridge walmartBridge =  new WalmartBridge("ACB","ABC");
        System.out.println(walmartBridge.getNumBridges());
    }
}
