public class DixieCup
{
    private String[] items;
    private int itemNumber = 0;

    public DixieCup(int numItems)
    {
        itmes = new String[numItems];
    }
    public void addItem(String itemName)
    {
        if(itemNumber < items.length)
        {
            items[itemNumber] = itemName;
            while(itemNumber <= items.length)
            {
                ++itemNumber;
                if(items[itemNumber] != null)
                {
                    break;
                }
            }

        }
    }
    public String getItem(int index)
    {
        return items[index];
    }
    public void removeItem(String itemName)
    {
        for(int i = 0; i < items.length; ++i)
        {
            if(items[i].equals(itemName))
            {
                items[i] = null;
                itemNumber = i;
            }
        }
    }
    @Override
    public String toString()
    {

    }
}