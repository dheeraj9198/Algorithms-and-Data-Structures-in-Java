public class SmallestCommonSubsequenceFinder {

    String strDna;
    String strPat;

    char[] patternArray;
    char[] dnaArray;


    int bestLength;
    int bestStart;
    int bestEnd;

    public int getBestEnd() {
        return bestEnd;
    }

    public void setBestEnd(int bestEnd) {
        this.bestEnd = bestEnd;
    }

    public int getBestStart() {
        return bestStart;
    }

    public void setBestStart(int bestStart) {
        this.bestStart = bestStart;
    }

    public int getBestLength() {
        return bestLength;
    }

    public void setBestLength(int bestLength) {
        this.bestLength = bestLength;
    }


    public SmallestCommonSubsequenceFinder(String strDna, String strPat){
        this.strDna = strDna;
        this.strPat = strPat;
        this.patternArray = strPat.toCharArray();
        this.dnaArray = strDna.toCharArray();
    }

    public int getStartIndex(int start){
        for(int i=start;i<dnaArray.length;i++){
            if(dnaArray[i] == patternArray[0]){
                return i;
            }
        }
        return -1;
    }

    public void findMinSubSeqDNAWindow(int start,int currIndex, int comparingIndex, boolean isStart){

        if(start >= dnaArray.length || currIndex >= dnaArray.length){
            return;
        }

        while(currIndex < dnaArray.length && dnaArray[currIndex] != patternArray[comparingIndex]){
            currIndex++;
        }

        //check if currIndex has exceeded the array length

        if(currIndex >= dnaArray.length){
            //element not found
            return;
        }

        if(isStart){
            start = currIndex;
            isStart = false;
        }

        if(comparingIndex == patternArray.length-1){
            int lengthOfSubSeq = currIndex - start + 1;
            if(bestLength == 0 || lengthOfSubSeq < bestLength){
                bestLength = lengthOfSubSeq;
                bestStart = start;
                bestEnd = currIndex;
            }
            //start finding new sub sequence
            findMinSubSeqDNAWindow(start + 1, start + 1, 0, true);
        }
        else {
            //go for next character
            findMinSubSeqDNAWindow(start, currIndex+1, comparingIndex+1, isStart);
        }
    }

    public static void main(String args[]){
        String strPat = "anna";
        String strDna = "annabancxna";

        SmallestCommonSubsequenceFinder finder = new SmallestCommonSubsequenceFinder(strDna,strPat);
        finder.findMinSubSeqDNAWindow(0,0,0,true);
        System.out.println("Best Length : " + finder.getBestLength());
        System.out.println("BestStart : " + finder.getBestStart());
        System.out.println("Best End : " + finder.getBestEnd());
    }
}