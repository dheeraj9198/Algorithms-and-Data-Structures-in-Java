import java.util.HashMap;
import java.util.Map;

public class FindCharsInAnyOrderInMinimumWindowInString {

	
	public static void main(String[] args)
	{
		String mainString = "this is a test string";
		String subString = "tist";	
		
		String answerString = "*";
		String tempString = "";
		//System.out.println(tempString.length());
		
		boolean firstTimeDone = false;
		
		Map<Character,Integer> map = new HashMap<Character, Integer>();
		
		// populate count hashmap
		for(int x =0;x<subString.length();x++)
		{
			if(map.containsKey(subString.charAt(x)))
			{
				map.put(subString.charAt(x),map.get(subString.charAt(x))+1);
			}else{
				map.put(subString.charAt(x),1);
			}
		}
		System.out.println(map);
		
		// find substring
		for(int x = 0;x<mainString.length();x++)
		{
			tempString = tempString + mainString.charAt(x); 
			if(!firstTimeDone)
			{
				if(checkIfAllAreFound(tempString,map))
				{
						firstTimeDone = true;
						answerString = tempString;
				}	
			}else{
				if(mainString.charAt(x) == tempString.charAt(0))
				{
					tempString = removeUseLessChars(tempString,map);
					if(checkIfAllAreFound(tempString,map) && tempString.length() < answerString.length()){
						answerString  = tempString;
					}
				}
			}
		}
		System.out.println("--------------------------------------");
		System.out.println(answerString);
		System.out.println("--------------------------------------");

	}
	
	static String removeUseLessChars(String mainString,Map<Character,Integer> countMap){
		
		// check if count of chars belonging to countMap is less than in mainString
		
		int start = 1;
		for(int x =1;x<mainString.length();x++)
		{
			if(countMap.containsKey(mainString.charAt(x)))
			{
				start = x;
				break;
			}
		}
		
		return mainString.substring(start,mainString.length());
		
	}
	
	static boolean checkIfAllAreFound(String mainString,Map<Character,Integer> countMap)
	{
		System.out.println("checkinf for "+countMap+" in : "+mainString);
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		boolean found = true;
		for(int x =0;x<mainString.length();x++)
		{
			if(map.containsKey(mainString.charAt(x)))
			{
				map.put(mainString.charAt(x),map.get(mainString.charAt(x))+1);
			}else{
				map.put(mainString.charAt(x),1);
			}		
		}
		
		for(Map.Entry<Character, Integer> entry : countMap.entrySet())
		{
			if(!map.containsKey(entry.getKey()))
			{
				//System.out.println("not contains : "+entry.getKey());
				found = false;
				break;
			}else{
				if(map.get(entry.getKey()) < entry.getValue())
				{
					//System.out.println("count not matched : "+entry.getKey());
					found = false;
					break;
				}
			}
		}
		//System.out.println("result : "+(found ? "found" : "not found"));  
		return found;
	}
	
	
	
}























