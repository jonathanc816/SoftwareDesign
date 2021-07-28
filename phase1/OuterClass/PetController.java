public class PetController extends ManagerControl{
    /**
     * Shows the menu for interaction with pets, and allows for interaction with pets.
     */
    static public void petMenu() {
        while (true) {
            Presenter.showMenu(new String[] {"See Pet", "Send message", "Edit Pet", "Back"},
                    "You can do these with your pet:");
            int userChoice = GameController.getUserNum(4);
            if (userChoice == 1) {
                viewPet(LocalUserManager.getCurrentUser().getPetId());
            }
            else if (userChoice ==2) {
                MessageController.createMessage();
            }
            else if (userChoice == 3) {
                editPet();
            }
            else {
                return;
            }
        }
    }

    /**
     * View a pets information and perform some actions with the pet.
     * @param petId The ID of the pet to view.
     */
    static public void viewPet(int petId) {
        User user = LocalUserManager.getCurrentUser();
        Pet pet = LocalPetManager.findPet(petId);
        assert pet != null;
        Presenter.showInstruction("You see a "+pet.getPetColour()+", "+
                pet.getPetSex()+" pet named "+pet.getPetName()+" saying hi to you!\n");
        while (true) {
            boolean userInput = GameController.getUserYesOrNo("Enter 'y' to feed it or 'n' to go back");
            if (userInput) {
                Presenter.showInstruction(pet.getPetName()+": Yummy Yummy! Thank you, " + user.getUsername()+"\n");
            }
            else {
                return;
            }
        }
    }

    /**
     * Make basic changes to a pets variables.
     */
    static public void editPet() {
        User user = LocalUserManager.getCurrentUser();
        Pet pet = LocalPetManager.findPet(user.getPetId());
        while (true) {
            Presenter.showMenu(new String[]{"Edit pet name", "Set pet public/private", "Back"},
                    "\nThis is the pet editor menu, you can:");
            int userChoice = GameController.getUserNum(3);
            if (userChoice == 1) {
                assert pet != null;
                String newPetName = GameController.getUserString("Your previous pet name is "+
                        pet.getPetName()+". Please enter a new name...");
                LocalPetManager.changePetName(user.getPetId(), newPetName);
                Presenter.showInstruction("You have changed your pet name to "+pet.getPetName()+" successfully!");
            }
            else if (userChoice == 2) {
                boolean petPublic = GameController.getUserYesOrNo(
                        "Your pet is "+LocalPetManager.checkPublicity(user.getPetId())+" to others now.\n" +
                                "Enter 'y' to make it public or 'n' to make it private");
                assert pet != null;
                pet.setPublicity(petPublic);
                Presenter.showInstruction("You have change your pet to "+
                        LocalPetManager.checkPublicity(user.getPetId())+" successfully!");
            }
            else {
                return;
            }
        }
    }
}
