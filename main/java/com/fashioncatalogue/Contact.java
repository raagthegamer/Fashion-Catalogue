package com.fashioncatalogue;

public class Contact {
	
	//private variables
	int _id;
	String name;
	String pass;
	String email;
	
	// Empty constructor
	public Contact(){

	}

	// constructor
	public Contact(int id, String name, String pass, String email){
		this._id = id;
		this.name = name;
		this.pass = pass;
		this.email = email;
	}
	
	// constructor
	public Contact(String name, String pass, String email){
		this.name = name;
		this.pass = pass;
		this.email = email;
	}
	// getting ID
	public int getID(){
		return this._id;
	}
	
	// setting id
	public void setID(int id){
		this._id = id;
	}
	
	// getting name
	public String getName(){
		return this.name;
	}
	
	// setting name
	public void setName(String name){
		this.name = name;
	}
	
	// getting phone number
	public String getPass(){
		return this.pass;
	}
	
	// setting phone number
	public void setPass(String pass){
		this.pass = pass;
	}

	public String getEmail() { return this.email; }

	public void setEmail(String email) { this.email = email; }
}