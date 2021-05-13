package Lecture41;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class HashMapDemo {

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
		
		//put : O(1)
		map.put("Ram", 10);
		map.put("Mohan", 30);
		map.put("Sham", 15);
		map.put("Rohit", 15);
		map.put("Anvi", 5);
		
		System.out.println(map);//NEVER PRINTED IN SAME ORDER
		//THIS IS DONE TO ENSURE O(1)
		
		map.put("Ram", 40);// old value updated 
		//SAME KEY CANNOT BE ADDED

		//get : O(1)
		System.out.println(map.get("Mohan"));
		System.out.println(map.get("Ram"));
		System.out.println(map.get("Amit"));//null
		
		// containsKey : O(1)
		System.out.println(map.containsKey("Mohan"));//true
		System.out.println(map.containsKey("Amit"));//false
		
		//remove : O(1)
		System.out.println(map.remove("Mohan"));
		System.out.println(map);
		System.out.println(map.remove("Amit"));//null
		System.out.println(map);
		
		//keys obtain
		// map.keySet
		//Set<String> keys = map.keySet();// returns a set(like an arraylist) of keys with no duplicates
		for(String key: map.keySet()) {
			System.out.print(key+"->"+map.get(key)+"  ");
		}
		
		//way3
		ArrayList<String> list= new ArrayList<String>(map.keySet());
		for(String val : list) {
			System.out.print(val +" : " + map.get(val));
		}
		// changes in this arraylist will not reflect in the Set at al
		
		
	}

}
