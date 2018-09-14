package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Put_Values_In_MAP_While_Iteration {
	
	
	

	public static void main(String[] args) {
		
		Map<String,Integer> map = new HashMap<String,Integer>();
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		map.put("one",1);
		map.put("two", 2);
		map.put("three", 3);
		
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
		
			map.put("four", 4);  // ConcurrentModificationException as we CANNOT UPDATE map while iterating
			System.out.println(entry.getValue());
			al.add(entry.getValue());
			al.add(entry.getValue());
			al.remove(1);
			
		}
		
		

	}

}
