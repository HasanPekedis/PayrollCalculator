//Hasan Pekedis 150120068
//This class's object represents a storage area for the factory.
//addItem method adds items to items lists.
//resizeArray method resizes methods for item list.
//Again we need to use java.util.Arrays for Arrays.copyOf().
//There are set and get methods for each data field.
import java.util.Arrays;

public class Storage {

    private int capacity;
    private Item[] items;

    public Storage(int capacity){
        this.capacity = capacity;
    }    

    public void addItem(Item Item){
    	if (this.items == null) {
    		Item[] baseList= new Item[1];
    		baseList[0] = Item;
    		this.items = baseList;
    	} 
    	else {
        	resizeArray(this.items);
        	this.items[items.length - 1] = Item;
    	}
    }
    
    public void resizeArray(Item[] items) {
    	this.items = Arrays.copyOf(items, items.length + 1);
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public Item[] getItems() {
        return items;
    }
    public void setItems(Item[] items) {
        this.items = items;
    }

}