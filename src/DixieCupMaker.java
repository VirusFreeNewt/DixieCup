import java.util.Scanner;

public class DixieCupMaker
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        int intInput;
        DixieCup[] cups = new DixieCup[5];
        for(int i = 0; i < cups.length; ++i)
        {
            cups[i] = new DixieCup(5);
            for(int j = 0; j < cups[i].length(); ++j)
            {
                cups[i].addItem(null);
            }
        }

        while(!input.equals("quit"))
        {
            System.out.println(cups[0].toString());
            System.out.println("Functions: 'add' 'remove' 'setItem' 'getItem' 'numItems' 'length'");
            input = scanner.next();
            switch(input)
            {
                case "add":
                    System.out.println("What would you like to add?  ");
                    input = scanner.next();
                    if(!cups[0].addItem(input)) //Attempts to add item and announces if failure
                    {
                        System.out.println("Cannot add more items");
                    }
                    break;
                case "remove":
                    System.out.println("What would you like to remove?  ");
                    input = scanner.next();
                    cups[0].removeItem(input);
                    break;
                case "setItem":
                    System.out.println("What index would you like to change the item at? (Please type an integer)  ");
                    try
                    {
                        intInput = Integer.parseInt(scanner.next());
                        System.out.println("What would you like to add?  ");
                        input = scanner.next();
                        cups[0].setItem(intInput, input);
                    }
                    catch (NumberFormatException | ArrayIndexOutOfBoundsException e)
                    {
                        System.out.println("Index must be a positive integer less then " + cups[0].length());
                    }
                    break;
                case "getItem":
                    System.out.println("What index would you like to get the item at? (Please type an integer)  ");
                    input = scanner.next();
                    try
                    {
                        intInput = Integer.parseInt(input);
                        cups[0].getItem(intInput);
                    }
                    catch (NumberFormatException | ArrayIndexOutOfBoundsException e)
                    {
                        System.out.println("Index must be a positive integer less then " + cups[0].length());
                    }
                case "numItems":
                    System.out.println("Number of items: " + cups[0].numItems());
                    break;
                case "length":
                    System.out.println("Length: " + cups[0].length());
                    break;
                case "quit":
                    break;
                default:
                    System.out.println("Invalid input, make sure there are no spaces.");
                    break;
            }
        }
    }
}