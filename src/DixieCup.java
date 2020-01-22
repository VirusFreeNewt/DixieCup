public class DixieCup
{
    private String[] items;
    private int itemNumber = 0;

    private static DixieCup cup;

    private static StringBuilder contents = new StringBuilder();

    static int mostItems(DixieCup[] cups)
    {
        cup = cups[0];
        int i;
        for(i = 1; i < cups.length - 1; ++i)
        {
            if(cups[i].numItems() > cup.numItems())
            {
                cup = cups[i];
            }
        }
        return cup.itemNumber;
    }
    static int leastItems(DixieCup[] cups)
    {
        cup = cups[0];
        int i;
        for(i = 1; i < cups.length - 1; ++i)
        {
            if(cups[i].numItems() < cup.numItems())
            {
                cup = cups[i];
            }
        }
        return cup.itemNumber;
    }
    private void setIndex()
    {
        itemNumber = 0;
        while(itemNumber < items.length)
        {
            if(items[itemNumber] == null)
            {
                break;
            }
            ++itemNumber;
        }
    }

    public DixieCup(int numItems)
    {
        items = new String[numItems];
    }
    boolean addItem(String itemName)
    {
        setIndex();
        if(itemNumber < items.length)
        {
            items[itemNumber] = itemName;
            return true;
        }
        return false;
    }

    void removeItem(String itemName)
    {
        for(int i = 0; i < items.length; ++i)
        {
            if(items[i] != null)
            {
                if(items[i].equals(itemName))
                {
                    items[i] = null;
                    break;
                }
            }
        }
    }
    void setItem(int index, String newItem)
    {
        items[index] = newItem;
    }
    void swapItem(DixieCup cup1, DixieCup cup2, int index1, int index2)
    {
        String temp = cup1.getItem(index1);
        cup1.setItem(index1, cup2.getItem(index2));
        cup2.setItem(index2, temp);
    }
    void swapItem(int index1, int index2)
    {
        String temp = getItem(index1);
        setItem(index1, getItem(index2));
        setItem(index2, temp);
    }



    String getItem(int index)
    {
        return items[index];
    }
    int numItems()
    {
        int numItems = 0;
        for(String item : items)
        {
            if(item != null)
            {
                ++numItems;
            }
        }
        return numItems;
    }
    int length()
    {
        return items.length;
    }
    @Override
    public String toString()
    {
        contents.setLength(0); //clear the contents string
        contents.append("Contents: ");
        for(String item : items)
        {
            if(item != null)
            {
                contents.append(item).append(" ");
                continue;
            }
            contents.append("Empty ");
        }
        return contents.toString();
    }
    static String toString(DixieCup[] cups)
    {
        contents.setLength(0); //clear the contents string
        for(int i = 0; i < cups.length; ++i)
        {
            contents.append("Contents of Cup ").append(i).append(": ");
            for(int j = 0; j < cups[i].length(); ++j)
            {
                String item = cups[i].getItem(j);
                if(item != null)
                {
                    contents.append(item).append(" ");
                    continue;
                }
                contents.append("Empty ");
            }
            contents.append("\n");
        }
        return contents.toString();
    }
}