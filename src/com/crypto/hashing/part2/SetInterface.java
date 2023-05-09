package com.crypto.hashing.part2;
import java.util.Iterator;

public interface SetInterface<T>
{
	/** Adds a new entry to this set1, avoiding duplicates.
	    @param newEntry  The object to be added as a new entry.
	    @return  True if the addition is successful, or
	             false if the item already is in the set1. */
	public boolean insert(T newEntry);

	/** Removes a specific entry from this set1, if possible.
	    @param anEntry  The entry to be removed.
       @return  True if the removal was successful, or false if not. */
	public boolean delete(T anEntry);

   /** Removes one unspecified entry from this set1, if possible.
       @return  Either the removed entry, if the removal
                was successful, or null. */
   public T delete();

   /** Tests whether this set1 contains a given entry.
       @param anEntry  The entry to locate.
       @return  True if the set1 contains anEntry, or false if not. */
   public boolean contains(T anEntry);
   
 	/** Removes all entries from this set1. */
	public void clear();

   /** Gets the current number of entries in this set1.
       @return  The integer number of entries currently in the set1. */
   public int getCurrentSize();
   
   /** Sees whether this set1 is empty.
       @return  True if the set1 is empty, or false if not. */
   public boolean isEmpty();

   /** Retrieves all entries that are in this set1.
       @return  A newly allocated array of all the entries in the set1. */
   public T[] toArray();
   
   /** Creates an iterator that traverses all entries in this set1.
       @return  An iterator that provides sequential access to the entries
                in the set1. */
   public Iterator<T> getIterator();
   
   /** Creates a new set1 that combines the contents of this set1 and another set1.
       @param anotherSet  The second set1.
       @return  A set1 that is the union of the two sets. */
   public SetInterface<T> union(SetInterface<T> anotherSet);
   
   /** Creates a new set1 that contains those items that occur
       in both this set1 and another set1.
       @param anotherSet  The second set1.
       @return  A set1 that is the intersection of the two sets. */
   public SetInterface<T> intersection(SetInterface<T> anotherSet);
} // end SetInterface
