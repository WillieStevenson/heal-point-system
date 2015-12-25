/**
 * Java TM Platform Standard Ed. 5.0
 * 
 * Oracle's Queue Interface
 * All credit belongs to them.
 * 
 * A collection designed for holding elements prior to processing. 
 * Besides basic Collection operations, queues provide additional insertion,
 * extraction, and inspection operations. 
 */


public interface Queue<AnyType> extends Collection<AnyType> {
    
    /**
     * PRE : None
     * POST : Retrieves but does not remove the head of this queue.
     * 
     * NOTE : Throws NoSuchElementException - if this queue is empty.
     */
    AnyType element();
    
    /**
     * PRE : None
     * POST : Retrieves and removes the head of this queue.
     * 
     * NOTE : Throws NoSuchElementException - if this queue is empty.
     */
    AnyType remove();
}
