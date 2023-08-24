package org.iitwforce.automation.uclidmmpBabita;

import java.util.HashMap;
import java.util.Set;

public class HashMapEx {

	public static void main(String[] args) {
		HashMap<Integer,String> mapEx= new HashMap<Integer,String>();
		mapEx.put(1, "James");
		mapEx.put(2, "John");
		mapEx.put(3, "Eric");
		mapEx.put(4, "Williams");

		System.out.println("Number of elements in the Map :: " + mapEx.size());
		System.out.println(mapEx.get(1));

		
		Set<Integer> empSet= mapEx.keySet();
		for(Integer i: empSet)
		{
			System.out.print(i);
			System.out.println("::"+ mapEx.get(i));
		}


	}

}
