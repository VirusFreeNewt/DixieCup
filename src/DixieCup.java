public class DixieCup
{
    private String[] items;
    private int itemNumber = 0;

    private int numItems;

    private StringBuilder contents = new StringBuilder();

    public DixieCup(int numItems)
    {
        items = new String[numItems];
    }
    public void addItem(String itemName)
    {
        if(itemNumber < items.length)
        {
            items[itemNumber] = itemName;
            while(itemNumber < items.length)
            {

                if(items[itemNumber] == null)
                {
                    break;
                }
                ++itemNumber;
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
            if(items[i] != null)
            {
                if(items[i].equals(itemName))
                {
                    items[i] = null;
                    itemNumber = i;
                    break;
                }
            }
        }
    }
    public int numItems()
    {
        numItems = 0;
        for(String item : items)
        {
            if(item != null)
            {
                ++numItems;
            }
        }
        return numItems;
    }
    public int length()
    {
        return items.length;
    }
    //TODO: add goto next null index
    @Override
    public String toString()
    {
        contents.setLength(0); //clear the contents string
        contents.append("Contents: ");
        for(String item : items)
        {
            contents.append(item).append(" ");
        }
        return contents.toString();
    }
}