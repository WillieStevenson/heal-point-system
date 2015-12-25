/**
 * /**
 * Java TM Platform Standard Ed. 5.0
 * 
 * Oracle's Iterator Interface
 * All credit belongs to them.
 * 
 * 
 * An iterator interface for Collections.
 *
 * An iterator for lists that allows us traverse the list in either direction,
 * modify the list during iteration,
 * and obtain the iterator's current position in the list.
 */


public interface Iterator<AnyType> extends java.util.Iterator<AnyType> {
	/*
     * Tests if there are more items in the collection.
     */
	boolean hasNext();
	
	/*
     * Obtains the next item in the collection.
     */
	AnyType next();
	
	/*
     * Remove the last item returned by next. Can only be called once after next.
     * NOTE : This is an overloaded method.
     */
	void remove();
	
}