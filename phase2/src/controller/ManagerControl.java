package controller;

import manager.*;

/**
 * Storage for all the managers.
 */
public class ManagerControl {

    public static UserManager LocalUserManager = new UserManager();
    public static TemplateManager LocalTemplateManager = new TemplateManager();
    public static ReminderManager LocalReminderManager = new ReminderManager();
    public static PetManager LocalPetManager = new PetManager();
    public static MessageManager LocalMessageManager = new MessageManager();
    public static ActionCreator LocalActionCreator = new ActionCreator();

}
