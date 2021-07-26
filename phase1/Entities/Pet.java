import java.io.Serializable;

public class Pet implements Serializable {
  private String petName;
  private final int id;
  private final String petColour;
  private final String petSex;
  private boolean publicity;
  private int hungerLevel;
  private int growthLevel;
  private String status;

  public Pet(
      String petName, int id, String petColour, String petSex, boolean publicity, String status) {
    this.petName = petName;
    this.petColour = petColour;
    this.petSex = petSex;
    this.publicity = publicity;
    this.hungerLevel = 10;
    this.growthLevel = 0;
    this.id = id;
    this.status = status;
  }

  public String getPetName() {
    return this.petName;
  }

  public void setPetName(String newName) {
    this.petName = newName;
  }

  public int getId() {
    return this.id;
  }

  public String getPetColour() {
    return this.petColour;
  }

  public String getPetSex() {
    return this.petSex;
  }

  public boolean getPublicity() {
    return this.publicity;
  }

  public void setPublicity(boolean newPublicity) {
    this.publicity = newPublicity;
  }

  public int getHungerLevel() {
    return this.hungerLevel;
  }

  public void increaseHungerLevel(int level) {
    this.hungerLevel = Math.min(10, this.hungerLevel + level);
  }

  public void decreaseHungerLevel(int level) {
    this.hungerLevel = Math.max(0, this.hungerLevel - level);
  }

  public int getGrowthLevel() {
    return this.growthLevel;
  }

  public void increaseGrowthLevel() {
    this.growthLevel += 1;
  }

  public String getStatus() {
    return this.status;
  }

  public void setStatus(String newStatus) {
    this.status = newStatus;
  }
}
