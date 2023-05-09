package com.crypto.hashing.part2;

public class assignment3_SSi503_part2 {
	
	
	

	public static void main(String[] args) {
		
		
		DictionaryInterface<String, Boolean> dictionary = new ArrayDictionary<>();
		SetInterface<String> set1 = new DictionarySet<>(dictionary);
		SetInterface<String> set2 = new DictionarySet<>(dictionary);

		String[] testEntries = {"A","B", "Z"};

		
		
		
		String entry = "ABCDE";
		String[] initialEntries = entry.split("");
		
		System.out.print("Intializing the set1 and insert "+ initialEntries.length + " entries: ");
		for (String string : initialEntries) {
			System.out.print(string+",");
		}
		set1.insert("A");
		set1.insert("B");
		set1.insert("C");
		set1.insert("D");
		set1.insert("E");
		System.out.println();

		displayItems(set1);
		
				
		System.out.println();
		System.out.println();
		for (String item : initialEntries) {
			System.out.println("Does the set1 contain "+ item +"? " + set1.contains(item));
		}
		
		System.out.println("\nInserting A again to the set1, the set1 should not change "+ set1.getCurrentSize()+ " item(s), as follows:"  );
		displayItems(set1);
		
		System.out.println("\nTest deleting A,B,Z\nShould just have C,D and E now");
		
		for (String itemToDelete : testEntries) {
			set1.delete(itemToDelete);
		}
		System.out.println(set1.getCurrentSize()+" item(s), as follows");
		displayItems(set1);
		
		System.out.println("\nCreate second set1 containing P,L,A,C,E");
		set2.insert("P");
		set2.insert("L");
		set2.insert("A");
		set2.insert("C");
		set2.insert("E");
		System.out.println();
		displayItems(set2);
		
		
		/*
		 * Union of the sets
		 * union is working properly, even the logic to not copy union in 
		 * 					set1 and set2 seems perfect but it is still copying
		 */
		SetInterface<String> set3 = new DictionarySet<>(dictionary);
		set3.union(set2);
		set3.union(set1);
		
		System.out.print("\nUnion ");
		displayItems(set3);
		

		System.out.println("\nThe first set should be unchanged; it contains");
		displayItems(set1);
		System.out.println("\nThe second set should be unchanged; it contains");
		displayItems(set1);
		
		
		/*
		 * Interaction of the sets
		 * Interaction is working properly, even the logic to not copy interaction in 
		 * 					set1 and set2 seems perfect but it is still copying
		 */
		set1.intersection(set2);
		System.out.print("\nIntersection ");
		displayItems(set1.intersection(set2));
		

		
		System.out.println("\nThe first set should be unchanged; it contains");
		displayItems(set1);
		System.out.println("\nThe second set should be unchanged; it contains");
		displayItems(set1);
		
		
		
		/*
		 * Delete of the set items
		 * Delete is working properly,
		 * 								according to my set1 and set2 it is deleting perfectly 
		 * 										but not the desired result
		 */
		System.out.println("\nDelete an entry from second set"); 
		
		if(set2.delete("P") == true) {
			System.out.println("Deleted " + "P");

		}
		displayItems(set2);
		
		
	}
	
	
	//small method to display the items in a set
	public static void displayItems(SetInterface<String> set) {
		Object[] items = set.toArray();
		System.out.println("the set has "+ set.getCurrentSize() +" item(s), as follows:");
		
		for (int i = items.length-1; i >= 0; i--) {
		    Object item = items[i];
		    System.out.print(item);
		    System.out.print(" ");
		}
		
		System.out.println();
	}

}
