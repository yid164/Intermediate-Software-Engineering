8.1 Running Prototype

Prototype name: F.O.S.jar and Food-Ordering-System


F.O.S.jar can run on any machine that has Java VM.  It is opened when a user double clicks it.  There is also a F.O.S.exe that can be run on Windows machines.

Food-Ordering-System files need to be opened in a text editor or IDE.
If anyone wants to run the code in InteliJ (An IDE), they need to install jdbc postgresql driver first.  Then run the file and the main interface will comes out. 
Part of the registration function and Search function is completed.
The project uses Postgresql Database. However, users do not need to install the Postgresql driver because the prototype jar already contains the driver.  Users only need to open the jar file.

8.2 Implementation of two Primary Success Scenarios:


The first success scenario is the Sign-in and Sign-up use case (Use case 1). 

Step 1: A user can open our application and press the “Sign up” button to sign up.

Step 2: The user enters a username (E.g. “abc123”) and password (E.g. “qwerty”). The user then checks	 “Sign up as customer” and clicks “Sign Up right Now!”.  Now the user is successfully registered, and the OptionPanel “You have been successfully Signed in” will be displayed. Note, that the password and the username will be uploaded to our postgresql.  Registering with a previously existing username is not allowed.

Step 3: Now the user needs to enter their information. Since the registration system is not totally complete, we only need their name, phone number and e-mail address.  The use can also chose to save their preferred food. Now press save button and quit.

Step 4: Use the “Log in” feature, and enter the username and password the user previously registered and press submit. After a short wait the OptionPanel “Okay, Login” will show up to let the customer know they’re successfully logged in.  All the information is saved in our database, so if the customer inputs the wrong username or password, they will not be able to log in. Instead, an OptionPanel “Wrong username or password” will be displayed



The second scenario is the “Search Restaurant” use case (use case 2). Since the search function is not totally complete, only the “search restaurant” function is implemented.

Step 1: The user opens the application and inputs the name of the restaurant they want to order from.  They then press “Go”.

Step 2: If the restaurant searched exists, the result will show up in the middle of the main interface. However, if there is no matched result, ErrorOptionPanel “Sorry we can’t find that in our system” will be displayed. 

Step 3: Users can click the restaurant name showed in the middle of the interface to generate more information about the restaurant.





8.3 Skeleton Implementation:

We are using java so the skeleton should be in the “java class” and “package” form.

Package database: 
(This package contains the classes necessary for connecting to the database postgresql)
 —- AddCustomers.java		// Adding customer information into database
 —- AddRestaurants.java		// Adding restaurant information into database
 —- AddUser.java		// Adding User (customer or restaurant) info into database
 —- DisplayRestaurant.java		// Display the restaurant information (for developer use)
 —- GoConnection.java		// Main function connecting to database
 —- Login.java			// Check if the user input the correct username or not
 —- AddFeedback.java		// Adding feedback to the restaurant
 -- SearchRestaurants.java // Search restaurant name in the database

Package Interface:
(This package contains the main interface)
 —- Main.java			// The main interface (Panel). Combines Left, Centre and Right
 —- Centre.java			// The centre panel (part) of the main interface. 
 —- Left.java			// The left part of the main interface
 —- Right.java			// The right part of the main interface
 -- Registration.java    // The user registration and login part of the interface

Package postgresql:
(This package contains the postgresql.jar so user can user our file directly)
 -- postgresql-42.1.4.jar  // the driver of postgresql


Package Map:
(This package contains the classes necessary for connecting to the Google map if we decide to use Google map later, so nothing in the package for now)

Package Order:
(This package contains the classes necessary for placing orders. We are not sure how to do it now so nothing in the package for now)
