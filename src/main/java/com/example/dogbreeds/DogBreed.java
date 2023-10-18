package com.example.dogbreeds;

public class DogBreed {

    private int id;
    private String breedName;
    private String origin;
    private String size;
    private int numberOfOwners;

    // Constructor
    public DogBreed(int id, String breedName, String origin, String size, int numberOfOwners) {
        this.id = id;
        this.breedName = breedName;
        this.origin = origin;
        this.size = size;
        this.numberOfOwners = numberOfOwners;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBreedName() {
        return breedName;
    }

    public void setBreedName(String breedName) {
        this.breedName = breedName;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getNumberOfOwners() {
        return numberOfOwners;
    }

    public void setNumberOfOwners(int numberOfOwners) {
        this.numberOfOwners = numberOfOwners;
    }
}
