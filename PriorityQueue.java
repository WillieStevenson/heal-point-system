/**
 * The binary heap is implemented by using a modified version of the 
 * PriorityQueue class in Weiss' book, “Data Structures and Problem Solving Using Java” (Weiss).   
 * 
 * via Java TM Platform Standard Ed. 5.0
 * 
 * Oracle's PriorityQueue Class
 * All credit belongs to them.
 * 
 * An unbounded priority queue based on a priority heap. 
 * This queue orders elements according to an order specified at construction time, 
 * which is specified according to a Comparator, depending on which constructor is used.
 */

import java.util.ArrayList;
import java.util.NoSuchElementException;


public class PriorityQueue<AnyType> extends AbstractCollection<AnyType> implements Queue<AnyType> 
{
	
	
	private static final int DEFAULT_CAPACITY = 100;
	
	//added fields
	private int currentSize;
	private Comparator<? super AnyType> cmp;
	private AnyType[] array;
	private ArrayList<AnyType> rankList;
	
	/**
     * Construct an empty PriorityQueue with capacity of DEFAULT_CAPACITY + 1.
     */
	public PriorityQueue()
	{
		currentSize = 0;
		cmp = null;
		array = (AnyType[]) new Object[ DEFAULT_CAPACITY + 1];
		rankList = new ArrayList<AnyType>();
	}
	
	/**
     * Construct an empty PriorityQueue with a specified comparator.
     */
	public PriorityQueue(Comparator<? super AnyType> c)
	{
		currentSize = 0;
		cmp = c;
		array = (AnyType[]) new Object[ DEFAULT_CAPACITY + 1 ];
	}
	
	/**
     * Construct a PriorityQueue from another Collection.
     */
	public PriorityQueue(Collection<? extends AnyType> coll)
	{
		cmp = null;
		currentSize = coll.size();
		array = (AnyType[]) new Object[ (currentSize + 2) * 11 / 10 ];
		
		int i = 1;
		for( AnyType item : coll)
			array[ i++ ] = item;
		buildHeap();
	}
	
	/**
     * POST : Returns the number of items in this PriorityQueue.
     */
	public int size()
	{
		return currentSize;
	}
	
	/**
     * POST : Make this PriorityQueue empty.
     */
	public void clear()
	{
		currentSize = 0;
	}
	
	/**
     * POST : Returns an iterator over the elements in this PriorityQueue. 
     * The iterator does not view the elements in any particular order.
     */
	public Iterator<AnyType> iterator()
	{
		
	    return new Iterator<AnyType>( )
        {
            int current = 0;
            
            public boolean hasNext( )
            {
                return current != size( );
            }
            
            public AnyType next( )
            {
                if( hasNext( ) )
                    return array[ ++current ];
                else
                    throw new NoSuchElementException( );
            }
            
            public void remove( )
            {
                throw new UnsupportedOperationException( );
            }
        };
	}
	
	/**
     * PRE : None
     * POST : Returns the smallest item in the priority queue.
     * Specified by : element in interface Queue<AnyType>
     */
	public AnyType element()
	{
		if( isEmpty() )
			throw new NoSuchElementException();
		return array[ 1 ];
	}
	
	/**
     * PRE : Takes an element x
     * POST : Ensures an item can be added to this PriorityQueue, returns true if so.
     */
	public boolean add(AnyType x)
	{

		int hole = ++currentSize;
		array[ 0 ] = x;
		
		
		for( ; compare( x, array[ hole / 2 ] ) < 0; hole /= 2)
			array[ hole ] = array[ hole / 2 ];
		array[ hole ] = x;
		
		return true;
	}
	
	/**
     * PRE : None
     * POST : Removes and returns the smallest item in the priority queue.
     */
	public AnyType remove()
	{
		AnyType minItem = element();
		array[ 1 ] = array[ currentSize-- ];
		percolateDown( 1 );
		
		return minItem;
	}
	
	
	/**
     * PRE : Takes an index to start the percolate
     * POST : Percolate down in the heap.
     *        Where hole is the index at which the percolate begins.
     */
	private void percolateDown(int hole)
	{
		int child;
		AnyType tmp = array[ hole ];
		
		for( ; hole * 2 <= currentSize; hole = child)
		{
			child = hole * 2;
			if( child != currentSize && compare( array[ child + 1 ], array[ child ] ) < 0 )
				child++;
			if( compare( array[ child ], tmp ) < 0 )
				array[ hole ] = array[ child ];
			else
				break;
		}
		array[ hole ] = tmp;
		
		
	}
	
	/*
     * Establish heap order property from an 
     * arrangement of items. Runs in linear time.
     */
	private void buildHeap()
	{
		for( int i = currentSize / 2; i > 0; i-- )
			percolateDown( i );
	}
	
	/**
     * PRE : None
     * POST : Returns rankList
     */
	public ArrayList<AnyType> returnRankList()
	{
		rankList.clear();
		for (int i = 0; i < 10; i++)
			rankList.add(remove());
		
		return rankList;
	}
	
	/**
     * PRE : Takes two opposing teams
     * POST : Specifies how to compare team specific data,
     *        In this case, their TI's.
     *        
     *        Returns -1 if left hand team's TI is greater than right hand team's
     *        Returns 1 if left hand team's TI is less than right hand team's
     *        Returns 0 if equal
     * 
     */
	private int compare( AnyType lhs, AnyType rhs )
	{
		Team x = (Team) lhs;
		Team y = (Team) rhs;
		if (x.getTI() > y.getTI())
			return -1;
		if (x.getTI() < y.getTI())
			return 1;
		else
			return 0;

		
	}	
}
