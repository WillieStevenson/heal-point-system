
public abstract class AbstractCollection<AnyType> implements Collection<AnyType> {
	/*
     * AbstractCollection provides default implementations for some of the easy methods in the Collection interface.
     */    


    /*
     * Tests if this collection is empty.
     */
	public boolean isEmpty()
	{
		return size() == 0;
	}
	
	/*
     * Changes the size of this collection to zero.
     */
	public void clear()
	{
		Iterator<AnyType> itr = iterator();
		while( itr.hasNext() )
		{
			itr.next();
			itr.remove();
		}
	}
	
	/*
     * Adds x to this collections. This default implementation always throws an exception.
     */
	public boolean add( AnyType x )
	{
		throw new UnsupportedOperationException();
	}
	
	/*
     * Returns true if this collection contains x. If x is null, returns false. 
     * (This behavior may not always be appropriate.)
     */
	public boolean contains( Object x )
	{
		if( x == null )
			return false;
		
		for( AnyType val : this )
			if( x.equals( val ) )
				return true;
		
		return false;
	}
	
	/*
     * Removes non-null x from this collection. (This behavior may not always be appropriate.)
     */
	public boolean remove( Object x )
	{
		if( x == null )
			return false;
		
		Iterator<AnyType> itr = iterator();
		while( itr.hasNext() )
			if( x.equals( itr.next() ))
			{
				itr.remove();
				return true;
			}
		
		return false;
	}
	/*
     * Obtains a primitive array view of the collection.
     */
	public Object [ ] toArray()
	{
		Object [ ] copy = new Object[ size() ];
		int i = 0;
		
		for( AnyType val : this)
			copy[i++] = val;
		
		return copy;
	}
	
	/*
     * Obtains a primitive array view of the collection.
     */
	public <OtherType> OtherType [] toArray( OtherType [] arr)
	{
		int theSize = size();
		if (arr.length < theSize)
			arr = (OtherType []) java.lang.reflect.Array.newInstance(arr.getClass().getComponentType(), theSize);
		
		else if(theSize < arr.length)
			arr[theSize] = null;
		
		Object [] copy = arr;
		int i = 0;
		
		for( AnyType val : this )
			copy[ i++ ] = val;
		
		//added type cast
		return (OtherType[]) copy;
	}
	
	/*
     * Returns a representation of this collection as a string.
     */
	public String toString()
	{
		StringBuilder result = new StringBuilder( "[" );
		
		for( AnyType obj : this )
			result.append( obj + " " );
		
		result.append( "]" );
		
		return result.toString();
	}
}
