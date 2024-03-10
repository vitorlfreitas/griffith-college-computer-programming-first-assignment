// Package of our code
package Griffith;

// Imports to make our code work properly
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class Controls {
    
    public static void main(String[] args) {
        
        // Initializing the Scanner to read inputs on the console
        Scanner scan = new Scanner(System.in);
        
        // I split the code into methods, so it is easier to understand.
        System.out.println("Task 01 - Calculator Program");
        // Calling the method
        task01(scan);
        
        System.out.println("\nTask 02 - Caesar Cipher");
        // Calling the method
        task02(scan);
        
        System.out.println("\nTask 04 - Guessing Game");
        // Calling the method
        task04(scan);
        
        System.out.println("\nTask 05 - Pyramid Maker");
        // Calling the method
        task05(scan);
        
        
        System.out.println("\nEnd of the Program...");
        scan.close();
        
    }
    
    /* Task 01: It is a simple calculator which asks the user to enter one of the four basic commands and two numbers. The code will verify if the user has inserted the right input and then, it will make the mathmatic operation and finish by displaying for the user */
    private static void task01(Scanner scan) {
        
        // This while loop is to guarantee the task is executed even though any error was thrown. If the code gets at the end of the scope, it will be broken by the 'break' keyword
        while (true) {
            // Ask user to enter the command and two numbers
            System.out.println("Commands: Add, Sub, Mult, Div");
            System.out.println("Enter Command and Two Numbers e.g.(Add 1 4)");
            System.out.print("> ");

            // Check if any error will be thrown
            try {

                // Gets the first element until the white space and convert to lower case, because the Java is case sensitive
                String commander = scan.next().toLowerCase();

                // Gets the number until the white space
                double num1 = scan.nextDouble();

                // Gets the next number until the white space
                double num2 = scan.nextDouble();

                // Declares a variable
                double result;

                // Verifies if the commander is equal to 'add'
                if (commander.equals("add")) 
                    result = num1 + num2;

                // Verifies if the commander is equal to 'sub'
                else if (commander.equals("sub"))
                    result = num1 - num2;

                // Verifies if the commander is equal to 'mult'
                else if (commander.equals("mult"))
                    result = num1 * num2;

                // Verifies if the commander is equal to 'div' and the second number is not equal to 0
                else if (commander.equals("div") && num2 != 0)
                    result = num1 / num2;

                // Verifies if the commander is equal to 'div', if this statement returns true, it means the user entered 0 in the second number
                else if (commander.equals("div"))
                    // As it is not possible to divide a number by zero, it throws an error
                    throw new IllegalArgumentException("Cannot divide a number by 0");
                else
                    // // If any of the conditions above were true, it means the command is invalid, as a result it throws an error
                    throw new IllegalArgumentException("Invalid Commander"); 

                // Print the Result if any error was thrown
                System.out.println("Result: " + result);
                break; // Breaks the while loop
            }        
            // Catches the exception 
            catch (InputMismatchException ime) {
                // Display the message of the errors declared above
                System.out.println("Error: Invalid Input. Please enter a number");
                // Empties invalid input
                scan.nextLine();
            }
            catch (IllegalArgumentException iae) {
                // Or, display if any of the written error in code was triggered
                System.out.println("Error: " + iae.getMessage());
                // Empties invalid input
                scan.nextLine();
            }
            
        } // End of the While Loop
        
    } // End of the Task 01
    
    /* Task 02: Encodes a word given as an input then print it out*/
    private static void task02(Scanner scan) {
        // This while loop is to guarantee the task is executed even though any error was thrown. If the code gets at the end of the scope, it will be broken by the 'break' keyword
        while(true) {
            // Using the try keyword to catch any possible exception 
            try {
                System.out.print("Enter the amount of positions to shift: ");
                // Stores the input in a variable
                int position = scan.nextInt();

                System.out.print("Enter a word to shift: ");
                // Stores the input in a variable
                String word = scan.next();

                /* In this piece of code, we are calling 2 functions and storing the return in a String variable.
                The first function to be called is the encodeChar(), which receives as a parameter a String and a int varible.
                The it returns an array of characteres which all the characteres changed.
                After that, we pass the return of this function as a parameter for our another function, convertArrayToString(), which will receive this array of function and returns a unique String varible. Then we assign this return to the wordEncoded variable */
                String wordEncoded = convertArrayCharToString(encodeChar(word, position));

                // We print the output
                System.out.println(word + " encoded is " + wordEncoded);
                break; // Breaks the while loop

            } catch (InputMismatchException ime) {
                System.out.println("Invalid input. Please enter an integer for the position.");
                scan.nextLine(); // Consuming the input
            }
        }

    } // Ends  Task 2

    /* Task 03: Guessing Game
        In this task the user has to guess the random character generated by our code. The user has 10 attempts which is controlled by our while loop, so then if the variable attempts get 10 as a value, it turns the condition of the while loop in false breaking the while loop. 
        How does it work?
        Every char has a code in ASCII, so when we are manipulating char we can use mathmatics operations, so we could say that the user is trying to find a number between two numbers. For example, A and Z are numbers between 65 and 90. As a conclusion, the user is vizualizing the letter, but the computer is receiving numbers. It is good because we can use not only math operarions such as addition and subtraction, but also comparations and conditions with numbers. */
    private static void task04(Scanner scan) {
        // Declaring a variable
        int option;
        
        System.out.println("------  Guess the Letter Game!  ------");
        
        System.out.println("Try to guess the Random Char");
        System.out.println("You Have 10 Attempts to guess");
        
        // A condition to guarantee that the user will pick one of the two options correctly
        while (true) {
            
            System.out.println("Choose the level: ");
            System.out.println("1) Easy     |    2) Hard");
            System.out.print("> ");
            try {
                // Checks if any error will be thrown
                option = scan.nextInt();
                break; // If any erro is thrown, this line will be executed and will break the while loop
                
            } catch (InputMismatchException ime) {
                System.out.println("Error: Invalid Option");
                scan.next(); // Empties the scanner, returning to the beggining of the loop
            }
        }
        // It will check if the number is equal to 1, if so, the method will be called
        if (option == 1)
            easyGuessGame(scan); // Initialize the Easy Level Game
        else
            hardGuessGame(scan); // Initialize the Hard Level Game
        
    } // End of the Task 04
    
    /* Task 05 - Pyramid Maker
    This code will display a pyrimid of character or characteres that the user wanted.
    It is a chain of 1 loops with 2 loops inside.
    The outer loop is responsible to print the lines
    The first inner loop is responsible to print the white spaces before the character is printed out.
    The last inner loop will print the characteres, making a pyramid
    The user can choose the pattern, which line it will starts and how many lines must be printed */
    private static void task05(Scanner scan) {
        // This while loop is to guarantee the task is executed even though any error was thrown. If the code gets at the end of the scope, it will be broken by the 'break' keyword
        while (true) {
            try {
                // Asks the user to enter a patter, e.g."*"
                System.out.print("Enter a pattern: ");
                String pattern = scan.nextLine().trim();

                // Asks the user which line will be the start
                System.out.print("Enter a start amount: ");
                int start = scan.nextInt();

                // Asks the user which line will finish the code
                System.out.print("Enter an end amount: ");
                int end = scan.nextInt(); 
                // Number of rows in the pyramid

                // Loop for each row of the pyramid
                for (int row = start; row <= end; row++) { 

                    // Prints white spaces according to the start
                    for (int whiteSpace = 0; whiteSpace < end - (row - 1); whiteSpace++) {
                        System.out.print(" ");
                    }
                    // Print the patterns chosen by the user
                    for (int patternPrinter = 0; patternPrinter < row; patternPrinter++) {
                        // If to check if the user has inserted one element
                        if (pattern.length() == 1)
                            System.out.print(pattern + " ");
                        // Checks if the user has entered a String with more than 1 character.
                        else
                            System.out.print(pattern);
                    }

                    // Move to the next line after printing each row
                    System.out.println();
                }
                break; // Breaks the while loop
            }
            catch (InputMismatchException ime) {
                System.out.println("Error: Input is not expected by the program");
                scan.nextLine(); // Empties the scanner
            }
        }
    } // Ends Task 05
    
    
    
    
    
    // ** Useful Methods ** 

    // Used in the task 2 to encode a String. This method receives two parameters, A String to be encoded and an integer to shift the characteres 
    private static char[] encodeChar(String word, int position) {
        
        // Creates an array of char form a String by the toCharArray method
        char[] character = word.trim().toCharArray();
        
        // For loop to iterate all elements of the array
        for (int i = 0; i < character.length; i++) {
            
            // Checks if the character code is between 'a' and 'z' ( [97 and 122]
            if (character[i] > 96 && character[i] < 123) {
                // A variable to store the new charCode
                int temp = character[i] + position;
                
                // Check if the new position is greater than the limit
                if (temp > 122){
                    // if so, it will calculate the difference and then subtract to make a go back effect
                    int diff = temp - 122;
                    temp = 122 - diff;
                    // Assign the new value to the array
                    character[i] = (char) temp;
                    
                }
                else if (temp < 97) {
                    // Check if the new position is less than the limit
                    int diff = 97 - temp;
                    temp = 97 + diff;
                    // Assign the new value to the array
                    character[i] = (char) temp;
                }
                else 
                    // Assign the new value to the array
                    character[i] = (char) temp;
                
            }
            else if (character[i] > 64 && character[i] < 91) {
                
                int temp = character[i] + position; // Stores the new char code
                
                if (temp > 90){
                    // Check if the new position is greater than the limit
                    int diff = temp - 90; 
                    temp = 90 - diff;
                    // Assign the new value to the array
                    character[i] = (char) temp;
                    
                }
                else if (temp < 65) {
                    // Check if the new position is less than the limit
                    int diff = 65 - temp;
                    temp = 65 + diff;
                    // Assign the new value to the array
                    character[i] = (char) temp;
                }
                else 
                    // If it has not broken the limit, it assigns the new value directly
                    character[i] = (char) temp;
            }
            else {
                // Throws an error if it is not a proper word.
                throw new Error("It is not a proper word");
            }
        } // Ends of the For Loop
        
        return character; // Return the array
        
    } // End of the Method

    // Used in the task 2 to convert an array of char into a String
    private static String convertArrayCharToString(char[] arr) {
        return new String(arr); // It is a simple method, I split it in a method to make the code more readable 
    } // End of the Method
    
    // Return a random char, it is used in the task 04.  
    private static char getRandomLetter() {
        // A method that returns a random character
        int randomNumber = 0;
        
        // While the variable is not a proper character, it will keep going.
        while (!isLetter(randomNumber)) {
            // Generates a random number between 0 and 100, then I add 22, that is the highest number that is a code of a character.
            int number = (int) Math.round(Math.random() * 100);
            randomNumber = 22 + number;
            
        }
        
        
        return (char) randomNumber; // Returns the variable casted to char
    } // End of the Method
    
    // Returns true if the value is a letter
    private static boolean isLetter(int number) {
        // Char is useful when we are using math operations. It allows us to use either the charcode (int) or the char itself ('a', 'B')
        return ((number > 64 && number < 91) || (number >= 'a' && number <= 'z')); // Returns a boolean
    } // End of the Method
    
    // Method used in the Task 4, it is a easy version of the guess game. This easy game accepts either the char in capital letter or in lowercase.
    private static void easyGuessGame(Scanner scan) {
        // Explaining the difference
        System.out.println("Easy level:  There is no difference between lowercase letters and Uppercase letters");
        
        // Using the class Random
        Random random = new Random();
        
        // It will generate a random number between 65 and 90;
        int randomChar = random.nextInt(27) + 64;

        // Assigning a randomNumber variable for the Capital Letter
        int randomChar2 = randomChar - 32;
        // Our game has a limited attempts
        int attempts = 1;
        // Boolean value to veirify if the User guessed the number
        boolean guessed = false;
        // It will keep going until the condition turns into false
        while (attempts <= 10) {
            // Requesting the user to insert a guess
            System.out.print("Enter guess: ");
            char guessChar = scan.next().charAt(0);
            // It checks if the number entered by the user is equal the random number
            if (randomChar == guessChar || randomChar2 == guessChar) {
                
                System.out.println("You Win!");
                System.out.println("You guessed the letter in " + attempts + " attempts");
                guessed = true; // assign true to the boolean guessed, used in the end of this code
                break; // If he guess, it breaks the while loop 
                
            }
            // It launches some hints
            
            // If it is almost close to the random number, it says 'Hot'
            else if ( // The condition checks if the difference between both numbers is less than 10
                    Math.abs(randomChar - guessChar) <= 5|| // It does not take into consideration if it is positive or negative
                    Math.abs(randomChar2 - guessChar) <= 5) { // It may be 5 greater or less
                
                System.out.println("Hot!");
                attempts++;
            }
            // If it is close but not too close to the random number, it says 'Warm'
            else if ( // The condition checks if the difference between both numbers is less than 10
                    Math.abs(randomChar - guessChar) <= 10|| // It does not take into consideration if it is positive or negative
                    Math.abs(randomChar2 - guessChar) <= 10) { // It may be 10 greater or less
                
                System.out.println("Warm!");
                attempts++; // Increments the attempts variable by 1
            }
            else {
                System.out.println("Cold!");
                attempts++; // Increments the attempts variable by 1
            }
            
        } // End of For Loop 
        
        if (!guessed) { // If the boolean variable has not been changed, then:
            System.out.println("Game Over!");
            System.out.println("The Letter was " + randomChar);
        }
        
        
    } // End of the easyGuessGame
    
    // Method used in the Task 4, it is a hard version of the guess game. This hard game accepts treats the characteres as differents. In other words, there are 52 possible characteres to guess.
    private static void hardGuessGame(Scanner scan) {
        
        System.out.println("Hard level:  There is difference between lowercase letters and Uppercase letters");
        System.out.println(); // Prints a line
        
        char randomChar = getRandomLetter(); // Generates a random character
        int attempts = 1; // Assign a variable by 1
        boolean guessed = false; // Assign a boolean by false as a default
        
        while (attempts <= 10) { // Loop will keep going until the condition becomes false or if it is broken by the keyword break
            
            System.out.print("Enter guess: ");
            char guessChar = scan.next().charAt(0); // It will get the first character of the String the user entered
            
            // If the user entered the same character
            if (randomChar == guessChar) {
                System.out.println("You Win!");
                System.out.println("You guessed the letter in " + attempts + " attempts");
                guessed = true; // Assign 'true' to the boolean used at the end of this code
                break; // Breaks the loop
            }
            // If it is wrong, it will give some hints for the user
            else if (Math.abs(randomChar - guessChar) <= 5) { // If the difference is until 5 of distance, it will display 'hot'
                System.out.println("Hot!");
                attempts++; // Increments 1 to the attempts variable
            }
            else if (Math.abs(randomChar - guessChar) <= 10) { // If the difference is until 5 of distance, it will display 'warm'
                System.out.println("Warm!");
                attempts++; // Increments 1 to the attempts variable
            }
            else {
                System.out.println("Cold!"); // If it is not close at all, it will display 'cold'
                attempts++; // Increments 1 to the attempts variable
            }
            
        } 
        // If the guessed boolean variable has not been changed, this code will display the message below
        if (!guessed) {
            System.out.println("Game Over!");
            System.out.println("The Letter was \"" + randomChar + "\"");
        }
        
        
        
    } // End of the hardGuessGame

} // End of the main Class
