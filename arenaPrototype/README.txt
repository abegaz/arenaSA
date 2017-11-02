--->> arenaBase_1.zip 
This is the new Arena Base / Prototype. Intended for Developers.
Before running the Prototype you will need to set up the
associated Database. [ Find the arenabase.sql file in the arenaBase_1a.zip ]
*Note: The Database itself should be named "arenadatabase"

Because of File Size Limitations associated with GitHub's Online Interface. This Prototype is broken into 3 zip files:
- arenaBase_1A = Contains arenabase.sql, .classpath, .project, & build.fxbuild Files
- arenaBase_1B = contains bin folder.
- arenaBase_1C = contains src folder. 

You can also find this Build as a single .zip. Including the database .sql file. Here: 
https://drive.google.com/file/d/0B-Ti4kvfw2z8WUdBdHBzRktMd2c/view?usp=sharing

Put contents of all 3 .Zip files into file "arenaBase" in your Eclipse Workfolder before attempting to run. 

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

THEY NEED TO BE NUMBERED THIS WAY IN USERROLETYPE FOR THE BUILD TO WORK

Also. I recommend building out seperate controllers for your own view functionality
for the features you choose to implement.  
  
Another Note. Modifications from the previous Database Build I started with: 
This Database still needs to have Auto Increment Added to the ID columns that
are NOT in the "user" table.
This Database's FK's have been ripped out. & a "pending" table added. 

This Build uses JFoenix & JDBC. You can get them here if you don't have them already
https://drive.google.com/open?id=0B-Ti4kvfw2z8Z2t3bzZrbDVUMVU

--Ideas for Future Sprints--

- Allow user to change their own User Name 

- Create Logged In Table. TableView to show on Spectator Page
((signing in adds. closing programs deletes from ))/{refresh page often to make seem live? }

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

 
