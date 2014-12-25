import java.util.HashMap;
import java.util.Map;


/**
 * @author dheeraj
 *
 */
public class FindCharsInStringInAanyOrderMinimalWindow_IGNORE_REPETITION {

	
	public static void main(String[] args) {
		String mainString = "this is a test string";
		String subString = "tist";
		
		int length = -1;
		int start = -1;
		int end = -1;
		
		int tempLength = -1;
		int tempStart = -1;
		int tempEnd = -1;
		
		boolean allFound = true;
		
		Map<Character,Integer> map = new HashMap<Character,Integer>(subString.length());
		for(int y =0;y<subString.length();y++)
		{
			map.put(subString.charAt(y), -1);
		}
		
		for(int x =0;x<mainString.length();x++)
		{
			for(int y =0;y<subString.length();y++)
			{
				if(subString.charAt(y) == mainString.charAt(x))
				{
					map.put(subString.charAt(y), x);
				}
			}
			
			allFound = true;
			for(int y =0;y<subString.length();y++)
			{
				if(map.get(subString.charAt(y)) == -1)
				{
					allFound = false;
					break;
				}
			}
			
			if(allFound)
			{
				//find min max and length
				for(int y =0;y<subString.length();y++)
				{
					if(y ==0)
					{
						tempStart = map.get(subString.charAt(y));
						tempEnd = map.get(subString.charAt(y));
					}else{
						tempStart = Math.min(tempStart,map.get(subString.charAt(y)));
						tempEnd = Math.max(tempEnd,map.get(subString.charAt(y)));
					}
				}
				
				tempLength = (tempEnd - tempStart) +1;
				//System.out.println("temp length = "+tempLength);
				if(length == -1)
				{
					length = tempLength;
					start = tempStart;
					end = tempEnd;
				}else{
					if(length <= tempLength){
						//do nothing
					}else{
						length = tempLength;
						start = tempStart;
						end = tempEnd;
					}
				}
			}
		}
		
		System.out.println("start = "+start+ " end = "+end+" length = "+length);
		System.out.println(mainString.substring(start, end+1));
	}
	
	
}
