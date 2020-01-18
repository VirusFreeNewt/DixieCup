public class DixieCup
{
    private String[] items;
    private int itemNumber = 0;

    private int numItems;

    private StringBuilder contents = new StringBuilder();

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
    public boolean addItem(String itemName)
    {
        setIndex();
        if(itemNumber < items.length)
        {
            items[itemNumber] = itemName;
            return true;
        }
        return false;
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
                    break;
                }
            }
        }
    }
    public void setItem(int index, String newItem)
    {
        items[index] = newItem;
    }

    public String getItem(int index)
    {
        return items[index];
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
}