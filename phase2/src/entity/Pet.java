package entity;

import java.io.Serializable;

/**
 * Class that represents a pet.
 */
public class Pet implements Serializable {
  private String petName;
  private final int id;
  private final String petColour;
  private final String petSex;
  private boolean publicity;
  private int hungerLevel;
  private int growthLevel;
  private String status;
  private String greeting;

  /**
   * Constructor for pet
   * @param petName Name of the pet
   * @param id ID of the pet
   * @param petColour color of the pet
   * @param petSex sex of the pet
   * @param publicity public/private
   * @param status current status of the pet
   */
  public Pet(
      String petName, int id, String petColour, String petSex, boolean publicity, String status, String greeting) {
    this.petName = petName;
    this.petColour = petColour;
    this.petSex = petSex;
    this.publicity = publicity;
    this.hungerLevel = 10;
    this.growthLevel = 0;
    this.id = id;
    this.status = status;
    this.greeting = greeting;
  }

  /**
   * @return the name of the pet
   */
  public String getPetName() {
    return this.petName;
  }

  /**
   * @param newName the new name to set the pets name to
   * set a new name for the pet
   */
  public void setPetName(String newName) {
    this.petName = newName;
  }

  /**
   * @return pets id
   */
  public int getId() {
    return this.id;
  }

  /**
   * @return the colour of the pet
   */
  public String getPetColour() {
    return this.petColour;
  }

  /**
   * @return return the sex of the pet
   */
  public String getPetSex() {
    return this.petSex;
  }

  /**
   * @return return the publicity status of this pet
   */
  public boolean getPublicity() {
    return this.publicity;
  }

  /**
   * @param newPublicity the value to set the publicity to
   * set the publicity of this pet
   */
  public void setPublicity(boolean newPublicity) {
    this.publicity = newPublicity;
  }

  /**
   * @return the hunger level of this pet
   */
  public int getHungerLevel() {
    return this.hungerLevel;
  }

  /**
   * @param level amount to increase by
   * add level amount to the pets hunger level
   */
  public void increaseHungerLevel(int level) {
    this.hungerLevel = Math.min(10, this.hungerLevel + level);
  }

  /**
   * @param level amount to decrease by
   * remove level amount to the pets hunger level
   */
  public void decreaseHungerLevel(int level) {
    this.hungerLevel = Math.max(0, this.hungerLevel - level);
  }

  /**
   * @return growth status of pet
   */
  public int getGrowthLevel() {
    return this.growthLevel;
  }

  /**
   * add 1 growth status to pet
   */
  public void increaseGrowthLevel() {
    this.growthLevel += 1;
  }

  /**
   * @return status of this pet
   */
  public String getStatus() {
    return this.status;
  }

  /**
   * @param newStatus new status of this pet
   * set the status of the pet
   */
  public void setStatus(String newStatus) {
    this.status = newStatus;
  }

  /**
   * @return the greeting of this pet
   */
  public String getGreeting(){
    return this.greeting;
  }

  /**
   * @param greeting new greeting
   * set the greeting of this pet
   */
  public void setGreeting(String greeting) {
    this.greeting = greeting;
  }
}
