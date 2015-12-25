/**
 * The pairing heap is implemented by using a modified version of the 
 * PriorityQueue class in Weiss' book, “Data Structures and Problem Solving Using Java” (Weiss).   
 * 
 * Some credit belongs to Weiss implentation of pairing heap.
 * 
 * 
 * Modified by Sylvia Allain
 * University of Maine
 * COS 226 - Final Project
 * DATE : 12/13/2012
 * 
 * A data structure to implement.
 */

import java.util.ArrayList;
import java.util.NoSuchElementException;


public class PairingHeap<AnyType extends Comparable<? super AnyType>>
{
	

	public interface Position<AnyType>
	{
		Double getValue();
	}
	
	private static class PairNode<AnyType> implements Position<AnyType>
	{
		public Double				element;
		public PairNode<AnyType>	leftChild;
		public PairNode<AnyType>	nextSibling;
		public PairNode<AnyType>	prev;
		public Team					team;
		
		public PairNode(Team a)
		{
			team = (Team) a;
			element = team.getTI();
			leftChild = null;
			nextSibling = null;
			prev = null;
		}
		
		public Double getValue()
		{
			return element;
		}
	}
	
	private PairNode<AnyType> root;
	private int theSize;
	private ArrayList<Team> rankList;
	
	/*
	 * Constructs a pairing heap with size of 0 and a root with null. A new rankList is created.
	 */
	public PairingHeap()
		{root = null; theSize = 0; rankList = new ArrayList<Team>();}
	
	/*
     * POST : Returns size of skewHeap
     */
	public int size()
	{	return theSize;}
	/**
     * Return true if and only if the priority queue is empty
     */
	public boolean isEmpty()
	{	return root == null;}
	/*
     * POST : Makes the heap empty, sets size to 0 and removes reference to root (= null)
     */
	public void makeEmpty()
	{	root = null; theSize = 0;}
	
	public Position<AnyType> insert(Team a)
	{
		PairNode<AnyType> newNode = new PairNode<AnyType>(a);
		
		if(root == null)
			root = newNode;
		else
			root = compareAndLink(root, newNode);
		
		theSize++;
		return newNode;
	}
	
	/*
     * PRE : None
     * POST : return the team at root
     * 
     * NOTE : If heap is empty, throw UnderFlowException
     */
	public Team findMax()
	{
		if(isEmpty())
			throw new UnderflowException("UnderflowException");
		Team rootTeam = (Team) root.team;
		return rootTeam;
	}
	
	/*
     * PRE : None
     * POST : return the team at root and replace the removed node with the new largest node.
     * 
     * NOTE : If heap is empty, throw UnderFlowException
     */
	public Team deleteMax()
	{
		if(isEmpty())
			throw new UnderflowException("UnderflowException");
		
		Team x = findMax();
		root.element = null;
		if(root.leftChild == null)
			root = null;
		else
			root = combineSiblings(root.leftChild);
		
		theSize--;
		return x;
	}
	
	/*
     * POST : Returns array list containing each largest value contained in the node removed and added in order
     *        of largest to smallest
     */
	public ArrayList<Team> returnRankList()
	{
		rankList.clear();
		for (int i = 0; i < 10; i++)
			rankList.add(deleteMax());
		
		return rankList;
	}
	
	/**
     * Change the value of the item stored in the pairing heap.
     * @param pos any Position returned by insert.
     * @param newVal the new value, which must be smaller
     *    than the currently stored value.
     * @throws IllegalArgumentException if pos is null.
     * @throws IllegalArgumentException if new value is larger than old.
     */
	public void decreaseKey(Position<AnyType> pos, Double newVal)
	{
		if(pos == null)
			throw new IllegalArgumentException();
		
		PairNode<AnyType> p = (PairNode<AnyType>) pos;
		
		if(p.element == (Double) null || compare(p.element, newVal) < 0)
			throw new IllegalValueException();
		p.element = (Double) newVal;
		if(p != root)
		{
			if( p.nextSibling != null )
				p.nextSibling.prev = p.prev;
			if( p.prev.leftChild == p)
				p.prev.leftChild = p.nextSibling;
			
			p.nextSibling = null;
			root = compareAndLink(root,p);
		}
	}
	
	/*
     * PRE : Passes two nodes TI
     * POST : 1 is returned if p is bigger
     */
	private int compare(Double p, Double nv)
	{
		if(p > nv)
			return 1;
		else
			return -1;
	}
	
	/**
     * Internal method that is the basic operation to maintain order.
     * Links first and second together to satisfy heap order.
     * @param first root of tree 1, which may not be null.
     *    first.nextSibling MUST be null on entry.
     * @param second root of tree 2, which may be null.
     * @return result of the tree merge.
     */
	private PairNode<AnyType> compareAndLink(PairNode<AnyType> first, PairNode<AnyType> second)
	{
		if(compare(second.element,first.element) > 0)
		{
			second.prev = first.prev;
			first.prev = second;
			first.nextSibling = second.leftChild;
			if(first.nextSibling != null)
				first.nextSibling.prev = first;
			second.leftChild = first;
			return second;
		}
		else
		{
			second.prev = first;
			first.nextSibling = second.nextSibling;
			if(first.nextSibling != null)
				first.nextSibling.prev = first;
			second.nextSibling = first.leftChild;
			if(second.nextSibling != null)
				second.nextSibling.prev = second;
			first.leftChild = second;
			return first;
		}
	}
	
	// The tree array for combineSiblings
	private PairNode[] treeArray = new PairNode[11];
	
	/**
     * Internal method that implements two-pass merging.
     * @param firstSibling the root of the conglomerate;
     *     assumed not null.
     */
	private PairNode<AnyType> combineSiblings(PairNode<AnyType> firstSibling)
	{
		if (firstSibling.nextSibling == null)
			return firstSibling;
		// Store the subtrees in an array
		int numSiblings = 0;
		for( ; firstSibling != null; numSiblings++)
		{
			treeArray[numSiblings] = firstSibling;
			firstSibling.prev.nextSibling = null;
			firstSibling = firstSibling.nextSibling;
		}
		treeArray[numSiblings] = null;
		// Combine subtrees two at a time, going left to right
		int i = 0;
		for( ; i + 1 < numSiblings; i += 2)
			treeArray[i] = compareAndLink(treeArray[i], treeArray[i+1]);
		// j has the result of last compareAndLink.
        // If an odd number of trees, get the last one.
		int j = i - 2;
		
		if( j == numSiblings - 3 )
			treeArray[j] = compareAndLink(treeArray[j], treeArray[j+2]);
		// Now go right to left, merging last tree with
        // next to last. The result becomes the new last
		for( ; j >= 2; j -= 2)
			treeArray[j-2] = compareAndLink(treeArray[j - 2], treeArray[j]);
		
		return (PairNode<AnyType>) treeArray[0];
	}
	
	
}