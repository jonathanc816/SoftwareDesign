This is a Tamagochi text base game.

0) Program Instructions
    - To play the game, run Main.main() method.
    - TO AVOID LOSING DATA, PLEASE NOT TERMINATE PROGRAM OUTSIDE THE GAME. (Important!)
    - To exit the game, choose 'Exit' option in menu.
    - To clean all game data to reset the game, delete Files/ObjectManager.ser in the project file.


1) You need to create a user followed by the template instructions if you are new to the game.


2) There are three types of users
2.1) A regular user would:
    - Have a customized pet
    - Edit pet
    - Let it send massage to other users
    - View mailbox
    - Add friends
    - See and interact with yours abd friends' pets
2.1) An admin user would:
    - Do everything regular user could do
    - Admin settings below:
    - Edit pet template information, which will be shown when users create their pets.
    - Edit message template information, which will be shown when users create messages.
2.2) Guest user
    - Guest user has fixed username 'guest'
    - Guest user can create their own customized pet
    - Guest user can do everything regular user could do
    - Except adding friends, this is because all information of a guest user will be deleted when guest user logout.


3) Mailbox
    - User can view messages delivered by other user's lovely pet in Mailbox.


4) Friends
    - You can send friend request to other existed users, but need for their acceptance
    - When a user receive friend request in their mailbox, they can choose 'accept' it or 'ignore'
    - If 'accept' two users will be friends with each other immediately.
    - If 'ignore', nothing happened. Friend request will be saved in user's mailbox that can be accept later.


5) Pet
    - Users can edit their own pet (change name/color/public or private)
    - Pet can send messages to other existed users no matter you are friends or not
    - Pet is default public to friends.
    - You can visit and interact with your friend's pet iff it's public.


6) Have fun :)