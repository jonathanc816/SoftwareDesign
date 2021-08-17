This is a Tamagochi text base game.

0) Program Instructions
    - To play the game, run src.main.Main.main() method.
    - TO AVOID LOSING DATA, PLEASE NOT TERMINATE PROGRAM OUTSIDE THE GAME. (Important!)
    - To exit the game, choose 'Exit' option in menu.
    - To clean all game data to reset the game, delete Files/ObjectManager.ser in the project file.


1) You need to create a user followed by the template instructions if you are new to the game.


2) There are four types of users
2.1) A regular user would:
    - Have a customized pet
    - Edit pet
    - Let it send massage to other users
    - Let it create reminder
    - View mailbox
    - Add friends
    - See and interact with yours abd friends' pets
2.2) An admin user would:
    - Do everything regular user could do
    - Admin settings below:
    - Edit pet template information, which will be shown when users create their pets.
    - Edit message template information, which will be shown when users create messages.
    - View and Interact with all user's creations.
    - Change users creations to private/public or delete them.
    - Suspend a user, the target user can't login in [set time] minutes.
    - View user's report issue in common admin mailbox.
2.3) Guest user
    - You could find it Start Menu -> Other Users
    - Guest user has fixed username 'guest'
    - Guest user can create their own customized pet
    - Guest user can do everything regular user could do
    - Except adding friends, this is because all information of a guest user will be deleted when guest user logout.
2.4) Temporary user
    - You could find it Start Menu -> Other Users
    - You need to set the time for temporary user
    - Temporary user can do everything regular user could do
    - Temporary user can't login after time is up
    - All information of temporary user maintains after time is up

3) Mailbox
    - User can view messages delivered by other user's lovely pet in Mailbox.
    - User is able to delete messages.


4) Friends
    - You can send friend request to other existed users, but need for their acceptance
    - When a user receive friend request in their mailbox, they can choose 'accept' it or 'ignore'
    - If 'accept' two users will be friends with each other immediately.
    - If 'ignore', nothing happened. Friend request will be saved in user's mailbox that can be accept later.
    - Allow user to unfriend with each other in view friend menu.


5) Pet
    - Users can edit their own pet (change name/color/public or private)
    - entity.Pet can send messages to other existed users no matter you are friends or not
    - entity.Pet is default public to friends.
    - You can visit and interact with your friend's pet iff it's public.

6) Reminder
    - User can add/delete reminders by their pets
    - User can view reminders by their pets
    - User can mark their reminders as complete or incomplete
    - User can like their or friends' reminders just like Tik Toc
    - User can set the reminder public/private

7) Setting
    - Start Menu -> Login -> Setting
    - User can change their password.
    - User can report issue to common mailbox so that all admin can see the issue
    - Admin users can enter Admin Setting (See more in 2.2 Admin user)

8) Have fun :)