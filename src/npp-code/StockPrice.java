class StockPrice {

    public static void main(String[] args) {
/*
        int[] data = new int[]{5, 10, 4, 6, 7};
*/
        int[] data = new int[]{5, 10, 4, 6, 12};
        int min = data[0];
        int profit = 0;
        int max = data[0];

        for (int k = 1; k < data.length; k++) {
            if (data[k] < min) {
                min = data[k];
            } else if (data[k] - min > profit) {
                profit = data[k] - min;
                max = data[k];
            }
        }
        System.out.println("profit="+profit+",min = "+min+",max="+max);

    }


}