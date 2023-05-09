package com.crypto.hashing.part1;

public class Profile {
	
	Name fullName;
	String emailAddress;
	String cryptoCoinAddress;
	String idNumber;
	
	
	Profile(){	}
	
	Profile(String first, String last, String email, String coin, String id){
		
	    fullName = new Name(first, last);
	    setFullName(fullName);
		setEmailAddress(email);
		setCryptoCoinAddress(coin);
		setIdNumber(id);
	}
	
	
	public Name getFullName() {
		return fullName;
	}
	public void setFullName(Name fullName) {
		this.fullName = fullName;
		
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getCryptoCoinAddress() {
		return cryptoCoinAddress;
	}
	public void setCryptoCoinAddress(String cryptoCoinAddress) {
		this.cryptoCoinAddress = cryptoCoinAddress;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	
	public String toString() {
	    return "Key: "+getFullName()+
	    		"\nValue\n"
	    		+"\n\tName: " + fullName 
	    		+ "\n\tID Number: " + idNumber 
	    		+ "\n\tEmail: " + emailAddress 
	    		+"\nCryptoCoin: " + cryptoCoinAddress;
	}

}
