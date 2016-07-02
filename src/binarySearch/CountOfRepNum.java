package binarySearch;

class CountOfRepNum {

    private static int getFirst(int[] array, int num, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (mid - 1 < start) {
            if (array[mid] == num) {
                return mid;
            } else if (array[mid] >= num) {
                //left
                return getFirst(array, num, start, mid - 1);
            } else {
                return getFirst(array, num, mid - 1, end);
            }
        } else {
            if (array[mid - 1] < num && array[mid] == num) {
                return mid;
            } else if (array[mid] >= num) {
                //left
                return getFirst(array, num, start, mid - 1);
            } else {
                return getFirst(array, num, mid - 1, end);
            }
        }

    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 4, 4, 4, 5, 6, 7, 7, 7, 7, 8};
        System.out.println(getFirst(array, 1, 0, array.length));

    }


}