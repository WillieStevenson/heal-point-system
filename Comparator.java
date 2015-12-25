/**
 * Java TM Platform Standard Ed. 6.0
 * 
 * Oracle's Comparator Interface
 * All credit belongs to them.
 * 
 * 
 * Compares its two arguments for order. Returns a negative integer, zero,
 * or a positive integer as the first argument is less than, equal to, or greater than the second.
 */

public interface Comparator<AnyType> {
    /*
     * Overloads default compare.
     */
    int compare( AnyType lhs, AnyType rhs ) throws ClassCastException;
}
