import java.util.List;

/**
 * This is the class that stores and manages Pet objects
 *
 * @author Zhi Heng(Justin) Zheng
 */
public class PetManager {

  private List<Pet> petList;

  /** This method returns the list of Pet objects stored */
  public List<Pet> getPetList() {
    return petList;
  }

  /**
   * This method changes petList based on the list given
   *
   * @param newPetList this is the new list that will replace the existing petList
   */
  public void setPetList(List<Pet> newPetList) {
    this.petList = newPetList;
  }

  /**
   * This method adds one Pet object to petList
   *
   * @param newPet this is the new Pet object
   */
  public void addPet(Pet newPet) {
    this.petList.add(newPet);
  }

  /**
   * This method searches petList for a Pet object with petID and returns the object If it fails to
   * find such Pet object, it will return null
   *
   * @param petID this is the ID of the pet we are looking for
   */
  public Pet findPet(int petID) {
    for (Pet pet : petList) {
      if (pet.getId() == petID) {
        return pet;
      }
    }
    return null;
  }

  /** This method creates a new Pet object, adds it to petList, and returns it */
  public Pet createPet(
      String petName, int id, String petColour, String petSex, boolean publicity, String status) {
    Pet newPet = new Pet(petName, id, petColour, petSex, publicity, status);
    addPet(newPet);
    return newPet;
  }

  /**
   * This method checks if the Pet object is public or private
   *
   * @param pet This is the Pet object to check
   */
  public String checkPublicity(Pet pet) {
    if (pet.getPublicity()) {
      return "This pet is public.";
    } else {
      return "This pet is private.";
    }
  }

  /**
   * This method feeds the Pet object by the amount provided
   *
   * @param petID This is the Pet object to feed
   * @param amount This is the amount we want to feed
   */
  public void feedPet(int petID, int amount) {
    var petToFeed = findPet(petID);
    if (petToFeed != null) {
      petToFeed.increaseHungerLevel(amount);
    }
  }
}
