package gateway;

import controller.ManagerControl;
import manager.*;

import java.io.*;

/**
 * Manager for all the states of the managers.
 */
public class StateManager extends ManagerControl {
    /**
     * Save the state of the manager to file.
     */
    public static void saveState() {
        try {
            FileOutputStream fileOut = new FileOutputStream("Files/ObjectManager.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(LocalUserManager);
            out.writeObject(LocalTemplateManager);
            out.writeObject(LocalReminderManager);
            out.writeObject(LocalPetManager);
            out.writeObject(LocalMessageManager);
            out.writeObject(LocalActionCreator);
            out.close();
            fileOut.close();
        }
        catch (IOException i){
            i.printStackTrace();
        }
    }

    /**
     * Restore the state of the managers from file.
     */
    public static void restoreState() {
        try {
            FileInputStream fileIn = new FileInputStream("Files/ObjectManager.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            LocalUserManager = (UserManager) in.readObject();
            LocalTemplateManager = (TemplateManager) in.readObject();
            LocalReminderManager = (ReminderManager) in.readObject();
            LocalPetManager = (PetManager) in.readObject();
            LocalMessageManager = (MessageManager) in.readObject();
            LocalActionCreator = (ActionCreator) in.readObject();
            in.close();
            fileIn.close();
        }
        catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
    }

}
