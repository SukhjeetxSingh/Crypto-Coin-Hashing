package com.crypto.hashing.part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class MainHashByType {
	
	private static int[] size = {1000, 900, 800, 700, 600}; //defining Initial sizes for dictionary 
	private static int[] typeOfProbing = {0,1};		  //type of probing 0: linear probing 1:quadratic
    static HashedDictionary<Name, Profile> hashedDictionary;    //dictionary initiation

	
	public static void readFromFile(String fileName, int size, int typeOfProbing) {
		
    	String firstName, lastName, profileEmail, coin, id;

		// pass the path to the file as a parameter
	    File file = new File(fileName);
	    Scanner sc = null;
    	String[] arrOfProfileInfo = null;

        /*
         * choosing dictionary using typeofProbing
         */
        if (typeOfProbing == 0) {
            hashedDictionary = new HashedDictionary<Name, Profile>(size, 0);
        } else {
            hashedDictionary = new HashedDictionary<Name, Profile>(size, 1);
        }
		try {
			sc = new Scanner(file);
		    while (sc.hasNextLine()) {
		    	/*
		    	 * first name, last name, email, crypto coin, userId
		    	 */
		    	
		    	arrOfProfileInfo = sc.nextLine().split(",");
		    	firstName = arrOfProfileInfo[0]; 	//first name of the user profile
		    	lastName = arrOfProfileInfo[1];		//last name of the user profile
		    	profileEmail = arrOfProfileInfo[2];	//email of the user profile
		    	coin = arrOfProfileInfo[3];			
		    	id = arrOfProfileInfo[4];
		    	
	            Name fullName = new Name(firstName, lastName);
	            
	            Profile userProfile =  new Profile(fullName.getFirst(), fullName.getLast(), profileEmail, coin, id);
	            
	            /*
	             * adding in dictionary with 
	             * 					Key : full name of the user
	             * 					Value: full profile of the user
	             * 								(fullName, userProfile)
	             */
	            hashedDictionary.add(fullName, userProfile);
		    }
		    if(typeOfProbing == 0) {
			    System.out.println("==========================================================");
	            System.out.println("Two hashed dictionaries of size "+ size + " were created");
	            System.out.println("The linear probed dictionary encountered\n\t"
						+ hashedDictionary.totalConflicts()
						+ " after adding "
						+ hashedDictionary.getSize()
						+ " names");
		    }
		    else {
	            System.out.println("The quadratic probed dictionary encountered\n\t"
						+ hashedDictionary.totalConflicts()
						+ " after adding "
						+ hashedDictionary.getSize()
						+ " names");
			    System.out.println("\n\n");
		    }
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//read from file
		

		for (int sizeOfDictionary : size) {
		    for (int typeOfDictionary : typeOfProbing) {
		        readFromFile("500_profile_SSi503.csv", sizeOfDictionary, typeOfDictionary);
				}
	        System.out.println("*******************************************************\n\t");
	        
	        
	        Iterator<Profile> valuesIterator = hashedDictionary.getValueIterator();
	        int count = 0;
	        while (valuesIterator.hasNext() && count < 5) {
	            Profile key = valuesIterator.next();
	            System.out.println(key);
	            System.out.println();
	            count++;
	        }
		}
		
	}

}
