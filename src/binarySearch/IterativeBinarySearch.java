public class IterativeBinarySearch {
    public static void main(String[] strings){
            int[] arr = {1,2,3,4,5,6,7,8,9};
	            int find = 9;
		            int start  = 0;
			            int end = arr.length-1;
				            while(start<=end){
					                int mid = (start+end)/2;
							            if(find == arr[mid]){
								                    System.out.println(mid);
										                    return;
												                }else if(find < arr[mid]){
														                end = mid-1;
																            }else{
																	                    start = mid+1;
																			                }
																					        }
																						        System.out.println("-1");
																							    }
																							    }

