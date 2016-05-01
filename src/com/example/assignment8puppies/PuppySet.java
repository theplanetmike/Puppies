package com.example.assignment8puppies;

import java.util.ArrayList;
import java.util.UUID;

public class PuppySet {
	

	private ArrayList<Puppy> puppyArray;
	
	private static PuppySet myPuppySet;
	
	private PuppySet() { //this constructor is private to keep it inaccessible
		puppyArray = new ArrayList<Puppy>();
		
		puppyArray.add(new Puppy(0, "Basenji", "Called a barless dog but not, from Africa", R.drawable.basenji, R.raw.basenjibark));
		puppyArray.add(new Puppy(1, "English Bulldog", "Ugly and adorable still", R.drawable.bulldog, R.raw.bulldogbark));
		puppyArray.add(new Puppy(2, "Dalmation", "1001 would be a few too many", R.drawable.dalmation, R.raw.dalmationbark));
		puppyArray.add(new Puppy(3, "Great Dane", "Big, distinguished dog", R.drawable.dane, R.raw.danebark));
		puppyArray.add(new Puppy(4, "Labradoodle", "Muppet-like cuteness, my fav", R.drawable.doodle, R.raw.doodlebark));
		puppyArray.add(new Puppy(5, "Greyhound", "Not a bus, but just as fast", R.drawable.greyhound, R.raw.greyhoundbark));
		puppyArray.add(new Puppy(6, "Hound", "Floppy ears, good nose", R.drawable.hound, R.raw.houndbark));
		puppyArray.add(new Puppy(7, "Husky", "UW's maskot, very cuddly warm", R.drawable.husky, R.raw.huskybark));
		puppyArray.add(new Puppy(8, "Labrador", "A tried and true companion", R.drawable.lab, R.raw.labbark));
		
	}
	
	public static PuppySet makeList()
	{ //use this to create a list instead of the constructor
		if(myPuppySet == null)
		{
			myPuppySet = new PuppySet();
		}
		return myPuppySet;
	}
	
	public ArrayList<Puppy> getPuppies()
	{ //returns the already created list
		return puppyArray;
	}
	
	public Puppy getPuppy(int id)
	{ //returns a Puppy by id
		for (Puppy dog: puppyArray)
		{
			if (dog.getId() == id)
			{
				return dog;
			}
		}
		return null;
	}
} //end PuppySet
