public class PetController {
    static public void petMenu() {
        while (true) {
            Presenter.showMenu(new String[] {"See Pet", "Let it send message", "Edit Pet", "Back"},
                    "You can do these with your pet:");
            int userChoice = GameController.getUserNum(4);
            if (userChoice == 1) {
                viewPet(UserManager.currentUser.getPetId());
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

    static public void viewPet(int petId) {
        User user = UserManager.currentUser;
        Pet pet = PetManager.findPet(petId);
        assert pet != null;
        Presenter.showInstruction("You see a "+pet.getPetColour()+", "+
                pet.getPetSex()+" pet called "+pet.getPetName()+" saying hi to you!\n");
        while (true) {
            boolean userInput = GameController.getUserYesOrNo("Enter 'y' to feed it or 'n' to go back");
            if (userInput) {
                Presenter.showInstruction(pet.getPetName()+": Yummy Yummy! Thank you," + user.getUsername()+"\n");
            }
            else {
                return;
            }
        }
    }

    static public void editPet() {
        User user = UserManager.currentUser;
        Pet pet = PetManager.findPet(user.getPetId());
        while (true) {
            Presenter.showMenu(new String[]{"Edit pet name", "Set pet public/private", "Back"},
                    "\nThis is edit pet menu, you can:");
            int userChoice = GameController.getUserNum(3);
            if (userChoice == 1) {
                assert pet != null;
                String newPetName = GameController.getUserString("Your previous pet name is "+
                        pet.getPetName()+". Please enter a new name...");
                PetManager.changePetName(user.getPetId(), newPetName);
                Presenter.showInstruction("You have change your pet name to "+pet.getPetName()+" successfully!");
            }
            else if (userChoice == 2) {
                boolean petPublic = GameController.getUserYesOrNo(
                        "Your pet is "+PetManager.checkPublicity(user.getPetId())+" to others now.\n" +
                                "Enter 'y' to make it public or 'n' to make it private");
                assert pet != null;
                pet.setPublicity(petPublic);
                Presenter.showInstruction("You have change your pet to "+
                        PetManager.checkPublicity(user.getPetId())+" successfully!");
            }
            else {
                return;
            }
        }
    }
}
