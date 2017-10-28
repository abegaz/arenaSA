--->> arenaBase_1.zip 
This is the new Arena Base / Prototype. Intended for Developers.
Before running the Prototype you will need to set up the
associated Database. [ Find the arenabase.sql file in the arenaBase_1.zip ] 

You will also need to set up an "Operator" Role. I also advise setting up multiple users.
This can be done through the GUI Sign Up Feature. 

All users by default start as Spectators.
Operators must Approve: New League Owners & New Operators.
(( This is why you have to have at least One Operator )).
All Applications to be : Player or Advertiser, are automatically approved

User Role ID  & Corresponding Type are kept in arenadatabase.userroleType
1 - Spectator
2 - Operator
3 - League Owner
4 - Player
5 - Advertiser

--Ideas for Future Sprints--

- Allow user to change their own User Name 

- Create Logged In Table. TableView to show on Spectator Page
((siging in adds. closing programs deletes from ))/{refresh page often to make seem live? }

(( one for the Operator to 'Kick' ? ))

- Display Local Time. Date ? 

- make <enter> on Login press SignUp button

- Make Windows Draggable 

-----------------------older\/\/\/----------newer^^^^^----------------------------------
arenaPrototype
 
Meant to serve as refrence for Developers.

Delete any previous Prototype version & any previous 'arena' databases before
implementing this version.

* Requires User To : 
 --  Create Database 'arena' . 
 --  In XAMP LocalHost 'root' password must be set to 'zilbot46'
 --  Default database is NOT populated. You must Add Users. (( Use the program itself or enter the data into the table ))

* Uses additional libraries:
These must be downloaded and manually added to library in order to run the program properly in Eclipse.
 
 -- Jfoenix  [ https://github.com/jfoenixadmin/JFoenix ]
 -- mysqlConnecter (Connecter/J)   [  https://dev.mysql.com/downloads/connector/j/5.1.html  ] 

To Be Done.
-------------------
- Remove Console Error Reporting.
- Resolve inconsistency of Application Icon.
- Add convince features:  • Pressing 'Enter' on loginPage presses 'Sign In' button.
                          • Make Application Draggable.
- May contain Image Path Errors that reference earlier prototype.

 
