The ENSF409 Final Project by Adeshpal Virk, Hannah Oluyemisi Asaolu, Tyler Galea and Cole Barraclough

When downloading the program please download to the directory edu/ucalgary/ensf409


Instructions to use the program.

1. Open the User.java file and fill in the URL, USERNAME and PASSWORD fields with your information

2. Compile the program using javac edu/ucalgary/ensf409/User.java if it is running on windows

3. Run the program using java -cp .;mysql-connector-java-8.0.23.jar edu.ucalgary.ensf409.User if it is running on windows

4. The program will prompt you to enter the category of the furniture. Here enter Chair, Desk, Lamp or filing (Capitilization not important)

5. The program will prompt you to enter the type of the furniture. Here enter the type of furniture desired (Capitilization not important)

6. The program will prompt you to enter the amount of the furniture. The input must be greater then 0

7. After all of this is inputed the program will find the cheapest way to build that furniture. If it is successful an order file will be created in the Orders directory and it will display the items used and the price. If it is not successful it will suggest a list of
manufactuerers if the type of furniture exits. The used furniture will be removed from the database as well.

Instructions to run the unit tests.

1. Update the database back to the origonal using source [path-to-file]\inventory.sql

2. Compile the unit test using javac -cp .;hamcrest-core-1.3.jar;junit-4.13.2.jar edu/ucalgary/ensf409/[Desired-unit-test].java

3. Run the unit test using java -cp .;hamcrest-core-1.3.jar;junit-4.13.2.jar;mysql-connector-java-8.0.23.jar org.junit.runner.JUnitCore edu.ucalgary.ensf409.[Desired-unit-test]


