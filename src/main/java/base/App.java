/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Douglas Glover
 */
package base;

import java.util.Scanner;

/*
You don’t always need a complex control structure to solve simple problems. Sometimes a program requires an extra step in one case,
but in all other cases there’s nothing to do.

Write a simple program to compute the tax on an order amount. The program should prompt for the order amount and the state.
the state is “WI,” then the order must be charged 5.5% tax. The program should display the subtotal, tax,
and total for Wisconsin residents but display just the total for non-residents.

Example Output

What is the order amount? 10
What is the state? WI
The subtotal is $10.00.
The tax is $0.55.
The total is $10.55.

Or

What is the order amount? 10
What is the state? MN
The total is $10.00

Constraints

Implement this program using only a simple if statement—don’t use an else clause.
Ensure that all money is rounded up to the nearest cent.
Use a single output statement at the end of the program to display the program results.

Challenges

Allow the user to enter a state abbreviation in upper, lower, or mixed case.
Also allow the user to enter the state’s full name in upper, lower, or mixed case.
 */
public class App {
    Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        App myApp = new App();
        double order = myApp.getOrder();
        String state = myApp.getState();
        myApp.findTotal(order, state);
    }
    double getOrder()
    {
        System.out.print("What is the order amount? ");
        return in.nextDouble();
    }
    String getState()
    {
        System.out.print("What is the state? ");
        return in.next();
    }
    void findTotal(double order, String state)
    {
        String message;
        message = String.format("The total is $%.2f", order);
        if(state.equals("WI"))
        {
            double tax = order * 0.055;
            double total = order + tax;
            message = String.format("""
            The subtotal is $%.2f.
            The tax is $%.2f.
            The total is $%.2f.
            """, order, tax, total);
        }
        System.out.print(message);
    }
}
