public class DixieCupMaker
{
    public static void main(String[] args)
    {
        DixieCup[] cups = new DixieCup[5];
        for(int i = 0; i < cups.length; ++i)
        {
            cups[i] = new DixieCup(5);
            for(int j = 0; j < cups[i].length(); ++j)
            {
                cups[i].addItem("test");
            }
        }
        System.out.println(cups[0].toString());
        cups[0].removeItem("test");
        System.out.println(cups[0].numItems());
        System.out.println(cups[0].toString());
        cups[0].removeItem("test");
        System.out.println(cups[0].toString());
        cups[0].addItem("new");
        System.out.println(cups[0].toString());
        cups[0].addItem("new2");
        System.out.println(cups[0].toString());
    }
}