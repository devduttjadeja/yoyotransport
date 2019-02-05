package practice.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ComplexCollectionExample {

	public static void main(String[] args) {

		Map<Integer,Set<String>> map = new HashMap<Integer,Set<String>>();
		
		Set<String> s1 = new HashSet<String>();
		Set<String> s2 = new HashSet<String>();
		
		s1.add("abc");
		s1.add("def");
		
		s2.add("bcd");
		s2.add("xyz");
		
		map.put(1, s1);
		map.put(2, s2);
		
		Collection<Set<String>> values = map.values();
		Set<Integer> keySet = map.keySet();
		Set<Entry<Integer,Set<String>>> entrySet = map.entrySet();
		
		for (Set<String> vs : map.values()) {
			
			System.out.println(vs);
			
			for (String s : vs) {
				
				System.out.println(s);
				
			}
		}
	}
}
