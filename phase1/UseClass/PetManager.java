import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

/**
 * This is the class that stores and manages entity.Pet objects
 *
 * @author Zhi Heng(Justin) Zheng
 */
public class PetManager extends TemplateInfo{

  public Integer petID = 0;

  private List<Pet> petList = new ArrayList<>();

  public List<Pet> getPetList() {
    return petList;
  }

  public void setPetList(List<Pet> newPetList) {
    petList = newPetList;
  }

  public void noPetFound(){
    System.out.println("This pet cannot be found.");
  }

  public void addPet(Pet newPet) {
    petList.add(newPet);
  }

  public PetManager(){
    this.setTemplateInfo("Now create your pet!");
  }

  /**
   * This method searches petList for a entity.Pet object with petID and returns the object If it fails to
   * find such entity.Pet object, it will return null
   *
   * @param petID this is the ID of the pet we are looking for
   */
  public Pet findPet(int petID) {
    for (Pet pet : this.petList) {
      if (pet.getId() == petID) {
        return pet;
      }
    }
    noPetFound();
    return null;
  }

  /** This method creates a new entity.Pet object, adds it to petList, and returns it */
  public int createPet(
      String petName, String petColour, String petSex, boolean publicity, String status) {

    int createPetId = petID;
    Pet newPet = new Pet(petName, petID, petColour, petSex, publicity, status);
    addPet(newPet);

    petID += 1;

    return createPetId;
  }

  /**
   * Given a petID, return a public/private or a missing warning.
   * @param petID The id of the pet to check publicity of
   * @return a string representing public or private
   */
  public String checkPublicity(int petID) {
    Pet petToCheck = findPet(petID);
    if (petToCheck != null) {
      if (petToCheck.getPublicity()) {
        return "public";
      } else {
        return "private";
      }
      }
    return "This pet cannot be found.";
  }

  /**
   * This method feeds the entity.Pet object by the amount provided
   *
   * @param petID This is the entity.Pet object to feed
   * @param amount This is the amount we want to feed
   */
  public void feedPet(int petID, int amount) {
    Pet petToFeed = findPet(petID);
    if (petToFeed != null) {
      petToFeed.increaseHungerLevel(amount);
    } else {
      noPetFound();
    }
  }

  /**
   * Change the name of the pet defined by petID to the newPetName
   * @param petID A petID
   * @param newPetName The new name the pet should have.
   */
  public void changePetName(int petID, String newPetName){
    Pet petToName = findPet(petID);
    if (petToName != null){
      petToName.setPetName(newPetName);
    } else {
      noPetFound();
    }
  }

  /**
   * Return the status of the pet.
   * @param petID The id of the pet
   * @return The status of the pet
   */
  public String updatePetStatus(int petID){
    Pet petToUpdate = findPet(petID);
    if (petToUpdate != null){
      if (petToUpdate.getHungerLevel() >= 6){
        return "This pet is healthy.";
      } else if (petToUpdate.getHungerLevel() == 0){
        return "This pet has fainted.";
      } else if (petToUpdate.getHungerLevel() <= 5){
        return "This pet is hungry.";
      }
    }
    return "This pet cannot be found.";
  }
//
//  public String getPetTemplateInfo() {
//    return petTemplateInfo;
//  }
//
//  public void setPetTemplateInfo(String newInfo) {
//    this.petTemplateInfo = newInfo;
//  }
}
