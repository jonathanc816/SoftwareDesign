package manager;

import entity.Message;
import entity.Reminder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * This the class of creator for entities
 *
 * @author  Yupeng Chang
 * @version 1.0
 * @since   2020-07-19
 */
public class ActionCreator implements Serializable {

    /**
     * Create and return a reminder object according to user input
     * @param args This is arraylist of user input arguments for a reminder
     */
    public Reminder createReminder(ArrayList<String> args) {
        String title = args.get(0);
        String description = args.get(1);

        String dueDateInput = args.get(2);
        Date dueDate = new Date();

        int reminderId = 0;

        return new Reminder(title, false, reminderId);
    }

    /**
     * Create and return a reminder object according to user input
     * @param args This is arraylist of user input arguments for a reminder
     */
    public Message createMessage(ArrayList<String> args) {
        String fromId = args.get(0);
        String toID = args.get(1);
        String content = args.get(2);
        return new Message(fromId, toID, content);
    }
}
