public class AdminController extends ManagerControl{
    public static void adminMenu() {
            Presenter.showInstruction("Hi! admin user, "+LocalUserManager.getCurrentUser().getUsername());
        while(true) {
            Presenter.showMenu(new String[]{"Edit pet template info", "Edit message template info", "Go back"},
                    "\nThis is the admin settings menu, you can:");
            int userChoice = GameController.getUserNum(3);
            if (userChoice == 1){
                Presenter.showInstruction("The current pet template information is:");
                Presenter.showInstruction("["+LocalPetManager.getTemplateInfo()+"]");
                Presenter.showInstruction("This information will be shown when people create a new pet");
                String newPetIntro = GameController.getUserString("Now enter a new one...");
                LocalPetManager.setTemplateInfo(newPetIntro);
                Presenter.showInstruction("You have changed the pet template information to ["+
                        LocalPetManager.getTemplateInfo()+"] successfully!");
            }
            else if (userChoice == 2){
                Presenter.showInstruction("The current message template information is:");
                Presenter.showInstruction("["+LocalMessageManager.getTemplateInfo()+"]");
                Presenter.showInstruction("This information will be shown when people create a new message");
                String newMessageIntro = GameController.getUserString("Now enter a new one...");
                LocalMessageManager.setTemplateInfo(newMessageIntro);
                Presenter.showInstruction("You have changed message template information to ["+
                        LocalMessageManager.getTemplateInfo()+"] successfully!");
            }
            else {
                return;
            }
        }
    }
}
