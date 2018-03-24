
import java.util.Arrays;

/** DOCUMENTATION
 * Programmer: Laura Perez 
 * Assignment Start: 3/21/18 10:30pm (3/21 10:15pm-10:40pm, 3/22 10pm-11pm, 3/23 4:40pm-5:50pm)
 * Assignment Completion: 3/23/18 5:50pm
 * Total Hours for Assignment: 2.5 hours
 * Comments: I did not have a good handle on what was going on in this code. I had to do
 * a lot of research to understand everything that kept going wrong. Some were small mistakes,
 * but it was good practice in analyzing someone else's code and making adjustments. I'm
 * pretty sure what I ended up doing is on the clumsy side, so it would be good to see
 * examples of what would have worked better (after turning in the assignment of course).
 * @author rosy1064
 * @param <T> 
 */


public final class Bag<T extends Object & Comparable> implements BagInterface<T> {
    private T[] bag_items;
    private int num_items;
    
    public Bag() {
        bag_items = (T[])new Object[10]; // default 10 item bag
        this.num_items=0;
    }
    
    public Bag(int startSize)
    {
        bag_items = (T[])new Object[startSize];
        this.num_items=0;
    }
    
    // return the current size of the bag, or the number of elements in the bag
    public int getSize(){
        return this.num_items;
    }
    
    // returns true if bag is empty or false if bag is not empty
    public boolean isEmpty() {
        return this.num_items == 0;
    }
    
    // returns true if bag is empty or false if bag is not empty
    public boolean isFull() {
        return this.num_items == this.bag_items.length;
    }
    
    // add item to bag, returns true if successful, false if not
    public boolean add(T item) {
        if ( this.isFull() ) 
        {
            if ( resize() == false )
                return false;
        }
        bag_items[num_items++] = item;
        /* print what's in bag_items to check if copied
        for(int i=0; i<num_items; i++)
        {
            System.out.printf("%s: ",i);
            System.out.println(this.bag_items[i]);
        }
        */
        return true;
    }
    
    // returns true if item is removed from bag
    public boolean remove(T item) {
        if ( this.isEmpty() ) return false;
        for(int i=0;i<this.num_items;i++)
        {
            if ( this.bag_items[i]==item )
            {
                for(int j=i+1;j<this.num_items;j++)
                    this.bag_items[j-1]=this.bag_items[j];
                this.num_items--;
                return true;
            }
        }
        return false;
    }
    
    // clear the bag of all items
    public void clear()
    {
        this.num_items=0; // just reset numberOfEntries to zero and overwrite old data when we add new data
    }
    
    // returns true if item found in bag
    public boolean contains(T item) {
        for(int i=0;i<this.num_items;i++) if ( bag_items[i]==item ) return true;
        return false;
    }
    
    public T[] toArray() {
        T[] arr = (T[])new Object[this.num_items];
        for(int i=0;i<this.num_items;i++) arr[i]=this.bag_items[i];
        return arr;
    }            
    
    @Override 
    public String toString()
    {
        String out="{";
        for(int i=0;i<this.num_items-1;i++)
        {
            out = out + "{"+bag_items[i].toString()+"}, ";
        }
        out = out + "{"+bag_items[num_items-1]+"}}";
        return out;
    }
    
    public boolean resize()
    {
        // variable for new size of new array
        int newSize = num_items + 1;
        // declare new array
        T[] newArray = (T[])new Object[newSize];
        // for loop copies bag_items into new array
        for(int i=0; i<num_items; i++)
            newArray[i] = bag_items[i];
        // reassign bag_items pointer to new array
        this.bag_items = newArray;
        // return true if there is a null element (i.e. new element means resize successful)
        for(int j=0;j<num_items+1; j++)
            if (bag_items[j] == null) return true;
        return false;
    }
    
    private void helper(T a[], int k, int n)
    {
        while ( k*2 + 1 < n ) { 
                    int child = 2*k + 1;    

                    if ((child + 1 < n) && (a[child].compareTo(a[child+1]))< 0) child++;        

                    if (a[k].compareTo(a[child]) < 0) {
                            T temp = a[child];
                            a[child] = a[k];
                            a[k] = temp;
                            k = child;  
                    }        
                    else            
                            return;    
            }
    }

    public void sort()
    {
            int N = this.num_items;

            for (int i = N/2; i >= 0; i--) { 
                    helper( bag_items, i, this.num_items);    
            }     

            while (N-1 > 0) {  
                    T temp = bag_items[N-1];
                    bag_items[N-1] = bag_items[0];
                    bag_items[0] = temp;
                    helper(bag_items, 0, N-1);
                    N--;
            }

    }
}
