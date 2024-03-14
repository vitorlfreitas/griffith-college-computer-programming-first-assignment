package Griffith;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab {
    
    public static void main(String[] args) {
        
        // Initializing the Scanner to read inputs on the console
        Scanner scan = new Scanner(System.in);
        
        // I split the code into methods, so it is easier to understand.
        System.out.println("Task 01 - Diameter and Volume Calculator");
        // Calling the method
        task01(scan);
        
        System.out.println("\nTask 02 - Caesar Cipher");
        // Calling the method
        task02(scan);
        
        System.out.println("\nTask 03 - Paint Tins Calculator");
        // Calling the method
        task03(scan);
        
        System.out.println("\nTask 04 - Bill Splitter");
        // Calling the method
        task04(scan);
        
        System.out.println("\nTask 05 - Difference in Years Calculator");
        // Calling the method
        task05(scan);
        
        
        System.out.println("\nEnd of the Program...");
        scan.close();
        
    }
    
    /* Task 01:
    It will calculate the diameter and the volume of a ball which the User entered the diameter
    */
    private static void task01(Scanner scan) {
        
        while (true) { // This will ensure that if an error occurs, it will execute again.
            
            // Ask user to enter the input
            System.out.print("Enter the diameter of the ball in cm: ");

            // Check if it is a valid number
            try {
                double diameter = scan.nextDouble();
                // Checks if the diameter is equal to zero or a negative number
                if (diameter <= 0) {
                    // Throw an error if the number is negative or equal to 0
                    throw new IllegalArgumentException("You Entered a Negative Number or Zero ");
                }
                // Calculates the Radius
                double radius = getRadius(diameter);
                // calculates the Volume
                double volume = getVolume(radius);
                // Calcualtes the Surface
                double surfaceArea = calculatesSurfaceArea(radius);

                // Display the outcome
                System.out.println("Volume of the ball: " + stringFormatter(volume) + "cm³");
                System.out.println("Surface area of the ball: " + stringFormatter(surfaceArea) + "cm²");
                break; // Breaks the while loop
            }
            // If an exception is thrown
            catch (InputMismatchException | IllegalArgumentException e) {
                System.out.println("Error: Input is not a valid number");
                scan.nextLine(); // Empties the scanner
            }
        }
    } // End of the task 01
    
    // Task 02: It will encode a character provided by the User. The user will enter a number that will be used to sum to the current the position of the character and then shift to a new position
    private static void task02(Scanner scan) {
        // This will ensure that if an error occurs, it will execute again.
        while (true) {
            try { // Used to handle errors
                System.out.print("Enter the amount of positions to shift: ");
                int position = scan.nextInt(); // Set the input into the position variable

                System.out.print("Enter a character to encode: ");
                char charToEncode = scan.next().charAt(0); // Will get the first character entered by the user

                // Call a method that receives a string and the position as a parameter and returns the character encoded
                char charEncoded = encodeChar(charToEncode, position);

                System.out.println(charToEncode + " encoded is " + charEncoded);
                break; // Breaks the while loop
                
            } catch (InputMismatchException ime) { // If the input insert a input that is not expected by our program, an error will be thrown
                System.out.println("Error: Invalid Input");
                scan.nextLine(); // Empties the scanner
            }
        } 
    }
    /* Task 03: It will inform the user how many tins of paint is necessary to paint a wall. The user enters the width and the height of the wall and the our program calculates the amount necessary, and returns for the user */
    private static void task03 (Scanner scan) {
        
        // Declaring Constantes
        final double LITRES_PER_TIN = 2.50;
        final double METERS_COVERED_PER_LITRE = 13.0;
        final double METERS_PER_TIN = Math.floor((LITRES_PER_TIN * METERS_COVERED_PER_LITRE));
        // This will ensure that if an error occurs, it will execute again.
        while (true) {
            try { // It will handle possible problems 
                System.out.print("Enter your walls width in meters: ");
                double width = scan.nextDouble(); // Setting the variable width
                
                if (width <= 0) throw new InputMismatchException("Width Cannot be less or equal to 0");

                System.out.print("Enter your walls height in meters: ");
                double height = scan.nextDouble(); // Setting the variable height 
                
                if (height <= 0) throw new InputMismatchException("Width Cannot be less or equal to 0");

                double areaOfWall = width * height; // Calculating the area of the wall

                // Displaying the output for the user
                System.out.println("\nThe area of the wall is " + stringFormatter(areaOfWall) + "m²");

                // Rounding up the amount of tins needed
                int tinsNeeded = (int) Math.ceil((areaOfWall / METERS_PER_TIN));

                System.out.println("You will need " + tinsNeeded + " tins of paint");
                break; // Breaks the while loop
            }
            catch (InputMismatchException ime) {
                // If the input insert a input that is not expected by our program, an error will be thrown
                System.out.println("Error: Invalid Input");
                scan.nextLine(); // Empties the Scanner
            }
        }
    } // End of the Task 03
    
    // Task 04: It calculates how much each person should pay
    private static void task04(Scanner scan) {
        // This will ensure that if an error occurs, it will execute again.
        while (true) {
            try { // Handle problem
                System.out.print("Enter the bill amount: €");
                double bill = scan.nextDouble(); // Setting the input into a variable 

                if (bill <= 0) // It will check if the input is a valid number
                    throw new Error("The bill cannot be negative or equal to zero"); // Throws an error

                System.out.print("Enter the number of people: ");
                int numberOfPeople = scan.nextInt(); // Setting the input into a variable 

                if (numberOfPeople <= 0) // Checks if it is a valid number
                    throw new Error("It must be at least 1 person to pay the bill");

                System.out.print("Enter the service fee (e.g., 15 for 15%): ");
                double serviceCharge = scan.nextDouble();

                if (serviceCharge < 0 || serviceCharge > 20) // Checks if the value is an acceptable number, according to the restrictions of the program, which defined that the service fee cannot be larger than 20.
                    throw new Error("Invalid Value for Service Charge: Service Charge is [0% - 20%] "); // Throws an error

                // Calculares the service fee value according to the values passed by the user
                double serviceFee = bill * (serviceCharge / 100);
                // Calculates the total
                double totalBill = bill + serviceFee;
                // Divides the total by the number os people entered by the user
                double valuePerPerson = totalBill / numberOfPeople;

                // Calling the function to formate the number into a readable and standard way to money, with 2 decimals
                System.out.println("\nTotal bill including the service: €" + stringFormatter(totalBill));
                System.out.println("Each Person Should Pay: €" + stringFormatter(valuePerPerson));
                break; // Breaks the while loop

            }
            catch (Error e) { // Display the error message caught in the code
                System.out.println("Error: " + e.getMessage());
                scan.nextLine(); // Empties the Scanner
            }
            catch (InputMismatchException ime) {
                System.out.println("Erro: Invalid Input");
                scan.nextLine(); // Empty the Scanner
            }
        }
    } // End of the task 04
    
    // Task 05: Program will calculate the difference between two dates provided by the user
    private static void task05(Scanner scan) {
        
        final int DAYS_IN_A_YEAR = 365;
        final int DAYS_IN_A_MONTH = 30;
        final int LEAP_YEAR = 4;
        
        while (true) {
            try {
                System.out.println("Enter the year of birth and month (e.g. 1990 7)");
                System.out.print("> ");
                // Storing all the dates provided by the user into variables
                int year1 = scan.nextInt();
                int month1 = scan.nextInt();
                int leapYear1 = Math.round(year1 / LEAP_YEAR); // Setting the leap years

                // Calculating the amount of days of the first date
                int totalDays1 = (year1 * DAYS_IN_A_YEAR) + (month1 * DAYS_IN_A_MONTH) + leapYear1; 

                // Asking another date for the user
                System.out.println("Enter the second birth year and month ");
                System.out.print("> ");
                int year2 = scan.nextInt();
                int month2 = scan.nextInt();
                int leapYear2 = Math.round(year2 / LEAP_YEAR);

                // Calculating the amount of days of the second date
                int totalDays2 = (year2 * DAYS_IN_A_YEAR) + (month2 * DAYS_IN_A_MONTH) + leapYear2; 
                
                // Calculating the difference in days of each date
                int differenceInDays = totalDays1 - totalDays2; 
                
                // Calculating the difference in years, dividing by the amount of days in a year 
                int differenceInYears = Math.abs(differenceInDays / DAYS_IN_A_YEAR);
                
                // Calculating the difference in months, dividing by the amount of days in a month 
                int differenceInMonths = Math.abs((differenceInDays % DAYS_IN_A_YEAR) / DAYS_IN_A_MONTH);
                
                // * Math.abs will handle negative numbers.

                // Displaying the output
                System.out.println("The difference is " + differenceInYears + " years and " + differenceInMonths + " months");
                break;

            } catch (InputMismatchException ime) { // Display the message to the user informing the reason for the error 
                System.out.println("Error: You Have Not Enter a Number");
                scan.nextLine(); // Empties the Scanner
            }
        }
    } // End of the while loop
    
    // ** Methods ** 
    
    // Encodes the char
    private static char encodeChar(char character, int position) {
        return (char) (character + position); // Casting the int to char and returning
    }
    // Formates the Number to a String with 2 decimals
    private static <T extends Number> String stringFormatter(T value) {
        return String.format("%.2f", value.doubleValue()); // Formating a number into a String with 2 decimals
    }
    
    // Calculates the Radius
    private static double getRadius(double diameter) {
        return diameter / 2.0; // Returns the radius calculated by the formula R = D / 2
    }
    
    // Calculates the Volume
    private static double getVolume(double radius) {
        return (4.0/3.0) * Math.PI * Math.pow(radius, 3); // Returns the volume calculated by the formula V = (4/3) * PI * R³
    }
    
    // Calculates the Surface Area
    private static double calculatesSurfaceArea(double radius) {
        return 4 * Math.PI * Math.pow(radius, 2); // Returns the surface area calculated by the formula S = 4 * PI * R²
    }

}
