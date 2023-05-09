package com.crypto.hashing.part2;

import java.util.Iterator;

public class DictionarySet<K extends Comparable<? super K>>
		 implements SetInterface<K>, Iterable<K>
{
	private DictionaryInterface<K, Boolean> items;

	public DictionarySet(DictionaryInterface<K, Boolean> dictionary) {
	        items = dictionary;
	    }
	public boolean insert(K newEntry)
	{
		if (items.contains(newEntry)) {
            return false;
        }
		else {
	        items.add(newEntry, false);
	        return true;	
		}
	} // end add
   
   public SetInterface<K> union(SetInterface<K> otherSet)
	{
		//temp dictionary to store other list elements

	   DictionaryInterface<K, Boolean> tempDictionary = new ArrayDictionary<>();
	   SetInterface<K> unionSet = new DictionarySet<>(tempDictionary);
	   Iterator<K> iter1 = getIterator();
	   Iterator<K> iter2 = otherSet.getIterator();
	   while (iter1.hasNext()) {
	       K entry = iter1.next();
	       unionSet.insert(entry);
	   }
	   while (iter2.hasNext()) {
	       K entry = iter2.next();
	       unionSet.insert(entry);
	   }
	   return unionSet;
	} // end union

	public SetInterface<K> intersection(SetInterface<K> otherSet)
	{
		//temp dictionary to store other list elements
		DictionaryInterface<K, Boolean> tempDictionary = new ArrayDictionary<>();
		   SetInterface<K> intersectionSet = new DictionarySet<>(tempDictionary);
		   Iterator<K> iter = getIterator();
		   while (iter.hasNext()) {
		       K entry = iter.next();
		       if (otherSet.contains(entry)) {
		           intersectionSet.insert(entry);
		       }
		   }
		   return intersectionSet;
	} // end intersection
   
	public void clear()
	{
		items.clear();
	} // end clear

	public boolean contains(K anEntry)
	{
		return items.contains(anEntry);
	} // end contains

	public int getCurrentSize()
	{
		return items.getSize();
	} // end getCurrentSize

	public boolean isEmpty()
	{
		return items.isEmpty();
	} // end isEmpty

	public Iterator<K> getIterator()
	{
		return items.getKeyIterator();
	} // end getIterator

	public Iterator<K> iterator()
	{
		return getIterator();
	} // end iterator

	public K[] toArray()
	{
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		K[] result = (K[])new Comparable[getCurrentSize()]; // Unchecked cast
		Iterator<K> iter = items.getKeyIterator();
		int index = 0;
		while (iter.hasNext())
		{
			result[index] = iter.next();
			index++;
		} // end while

		return result;
	} // end toArray

	@Override
	public boolean delete(K anEntry) {
		return items.remove(anEntry) != null;
	}

	@Override
	public K delete() {
		K result = null;
        Iterator<K> iter = items.getKeyIterator();
        if (iter.hasNext()) {
            result = iter.next();
            items.remove(result);
        }
        return result;
	}

} // end DictionarySet
