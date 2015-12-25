/**
 * Java TM Platform Standard Ed. 6.0
 * 
 * Oracle's Collection Interface
 * All credit belongs to them.
 * 
 * 
 * Thrown to indicate that a method has been passed an illegal or inappropriate argument. 
 */
public interface Collection<AnyType> extends Iterable<AnyType>, java.io.Serializable {
    
    /*
     * Returns the number of elements in this collection. 
     * If this collection contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
     */
    int size();
    
    /*
     * Returns true if this collection contains no elements. 
     */
    boolean isEmpty();
    
    /*
     * PRE : is passed o, whose presence in this collection is to be tested 
     * 
     * Returns true if this collection contains the specified element. 
     * More formally, returns true if and only if this collection contains at 
     * least one element e such that (o==null ? e==null : o.equals(e)). 
     */
    boolean contains( Object o);
    
    /*
     * PRE : is passed x, whose presence in this collection is to be ensured 
     * 
     * Ensures that this collection contains the specified element (optional operation). 
     * Returns true if this collection changed as a result of the call. 
     * (Returns false if this collection does not permit duplicates and already 
     * contains the specified element.)
     */
    boolean add( AnyType x );
    
    /*
     * PRE : element to be removed from this collection, if present 
     * 
     * Removes a single instance of the specified element from this collection, 
     * if it is present (optional operation).
     * More formally, removes an element e such that (o==null ? e==null : o.equals(e)),
     * if this collection contains one or more such elements. 
     * Returns true if this collection contained the specified element (or equivalently,
     * if this collection changed as a result of the call). 
     */
    boolean remove( Object o);
    
    /*
     * Removes all of the elements from this collection (optional operation). 
     * The collection will be empty after this method returns.
     * 
     * NOTE : Throws UnsupportedOperationException - if the clear operation 
     *        is not supported by this collection
     */
    void clear();
    
    /*
     * Returns an iterator over the elements in this collection.
     */
    Iterator<AnyType> iterator();
    
    /*
     * POST : an array containing all of the elements in this collection
     */
    Object [] toArray();
    
    /*
     * PRE : Takes an array into which the elements of this collection are to be stored.
     * POST : Returns an array containing all of the elements in this collection.
     * 
     * NOTE :     Throws : ArrayStoreException - if the runtime type of the specified
     *                     array is not a supertype of the runtime type of every 
                           element in this collection 
                           
                           NullPointerException - if the specified array is null
     */
    <OtherType> OtherType [] toArray( OtherType [ ] arr );
}
