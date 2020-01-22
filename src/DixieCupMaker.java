import java.util.Scanner;

public class DixieCupMaker
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int index = 0;

        String input = "";
        int intInput, intInput2, intInput3;

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
            System.out.println(DixieCup.toString(cups));
            System.out.println("Functions: enter an index to get to a cup, 'swapItem', 'leastItems', 'mostItems'");
            input = scanner.next();
            switch(input)
            {
                case "swapItem":
                    try
                    {
                        System.out.println("What cup would you like to change the first item at? (Please type an integer)  ");
                        input = scanner.next();

                        System.out.println("What cup would you like to change the second item at? (Please type an integer)  ");
                        intInput = Integer.parseInt(scanner.next());

                        System.out.println("What index would you like to change the item in cup " + Integer.parseInt(input) + " at? (Please type an integer)  ");
                        intInput2 = Integer.parseInt(scanner.next());

                        System.out.println("What index would you like to change the item in cup " + intInput + " at? (Please type an integer)  ");
                        intInput3 = Integer.parseInt(scanner.next());

                        cups[index].swapItem(cups[Integer.parseInt(input)], cups[intInput], intInput2, intInput3);
                    }
                    catch (NumberFormatException | ArrayIndexOutOfBoundsException e)
                    {
                        System.out.println("Inputs must be positive integers less then " + cups[index].length());
                    }
                    break;
                case "leastItems":
                    System.out.println("Cup " + DixieCup.leastItems(cups) + " has the least items");
                    break;
                case "mostItems":
                    System.out.println("Cup " + DixieCup.mostItems(cups) + " has the most items");
                    break;
                default:
                    try
                    {
                        index = Integer.parseInt(input);
                    }
                    catch (ArrayIndexOutOfBoundsException e)
                    {
                        System.out.println("Index must be a positive integer less then " + cups[index].length());
                        continue;
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("Invalid input, make sure there are no spaces.");
                        continue;
                    }

                    System.out.println(cups[index].toString());
                    System.out.println("Functions: 'add' 'remove' 'setItem' 'swapItem' 'getItem' 'numItems' 'length'");
                    input = scanner.next();
                    switch (input)
                    {
                        case "add":
                            System.out.println("What would you like to add?  ");
                            input = scanner.next();
                            if (!cups[index].addItem(input)) //Attempts to add item and announces if failure
                            {
                                System.out.println("Cannot add more items");
                            }
                            break;
                        case "remove":
                            System.out.println("What would you like to remove?  ");
                            input = scanner.next();
                            cups[index].removeItem(input);
                            break;
                        case "setItem":
                            try
                            {
                                System.out.println("What index would you like to change the item at? (Please type an integer)  ");
                                intInput = Integer.parseInt(scanner.next());

                                System.out.println("What would you like to add?  ");
                                input = scanner.next();

                                cups[index].setItem(intInput, input);
                            }
                            catch (NumberFormatException | ArrayIndexOutOfBoundsException e)
                            {
                                System.out.println("Index must be a positive integer less then " + cups[index].length());
                            }
                            break;
                        case "swapItem":
                            try
                            {
                                System.out.println("What index would you like to change the first item at? (Please type an integer)  ");
                                intInput = Integer.parseInt(scanner.next());

                                System.out.println("What index would you like to change the second item at? (Please type an integer)  ");
                                input = scanner.next();

                                cups[index].swapItem(intInput, Integer.parseInt(input));
                            }
                            catch (NumberFormatException | ArrayIndexOutOfBoundsException e)
                            {
                                System.out.println("Index must be a positive integer less then " + cups[index].length());
                            }
                            break;
                        case "getItem":
                            System.out.println("What index would you like to get the item at? (Please type an integer)  ");
                            input = scanner.next();
                            try
                            {
                                intInput = Integer.parseInt(input);
                                cups[index].getItem(intInput);
                            }
                            catch (NumberFormatException | ArrayIndexOutOfBoundsException e)
                            {
                                System.out.println("Index must be a positive integer less then " + cups[index].length());
                            }
                            break;
                        case "numItems":
                            System.out.println("Number of items: " + cups[index].numItems());
                            break;
                        case "length":
                            System.out.println("Length: " + cups[index].length());
                            break;
                        case "quit":
                            break;
                        default:
                            System.out.println("Invalid input, make sure there are no spaces.");
                            break;
                    }
                    break;
            }
        }
    }
}