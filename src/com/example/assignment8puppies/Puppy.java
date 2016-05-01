package com.example.assignment8puppies;

public class Puppy {
	private int id;
	private String breed;
	private String description;
	private int imageID;
	private int soundID;
	
	public Puppy(int id, String breed, String description, int imageID, int soundID) {
		this.id = id;
		this.breed = breed;
		this.description = description;
		this.imageID = imageID;
		this.soundID = soundID;
	}

	@Override
	public String toString() {
		return breed;
	}

	public int getId() {
		return id;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getImageID() {
		return imageID;
	}

	public void setImageID(int imageID) {
		this.imageID = imageID;
	}

	public int getSoundID() {
		return soundID;
	}

	public void setSoundID(int soundID) {
		this.soundID = soundID;
	}

}
