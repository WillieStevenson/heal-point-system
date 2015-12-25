import java.util.ArrayList;

public class BinarySkewHeap<AnyType>
{
	public interface Position<AnyType>
	{
		Double getValue();
	}
	/*
	 * Node used in the Binary Skew Heap
	 */
	private static class SkewNode<AnyType> implements Position<AnyType>
	{
		public Double				element;
		public SkewNode<AnyType>	leftChild;
		public SkewNode<AnyType>	rightChild;
		public Team					team;
		
		public SkewNode(Team a)
		{
			team = (Team) a;
			element = team.getTI();
			leftChild = null;
			rightChild = null;
		}
		
		
		
		public Double getValue()
		{
			return element;
		}
	}
	
	private SkewNode<AnyType> root;
	private int theSize;
	private ArrayList<Team> rankList;
    /**
     * An empty skew heap
     */
    public BinarySkewHeap()
    {
    	root = null;
    	theSize = 0;
    	rankList = new ArrayList<Team>();
    }
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
    
    /*
     * PRE : pass team to add to heap.
     * POST : returns node with largest TI.
     */
    public Position<AnyType> add(Team x)
    {
    	SkewNode<AnyType> newNode = new SkewNode<AnyType>(x);
    	
    	if(root == null)
    		root = newNode;
    	else
    		root = merge(root, newNode);
    	
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
        if (isEmpty()) 
        	throw new UnderflowException("UnderflowException");
        
        Team x = findMax();
        root.element = null;
        if(root.leftChild == null && root.rightChild == null)
        	root = null;
        else
        	root = merge(root.leftChild, root.rightChild);
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
     * Merge the two trees 
     * 
     * PRE :
     * a is the first tree 
     * b is the second tree to be merged with the first
     * 
     * POST : returns a skew node, merging the tree.
     */
    public SkewNode merge(SkewNode a, SkewNode b)
    {
        if (a == null) 
        {
            return b;
        }
        else if (b == null) 
        {
            return a;
        }
        else
        {
            /**
             * Defined by type of data in node
             */
            SkewNode big, small;

            if (compare(a.element, b.element) > 0)
            {
                big = a;
                small = b;
            }
            else
            {
                big = b;
                small = a;
            }
            SkewNode rightChild = big.rightChild;
            SkewNode leftChild = big.leftChild;
            
            //switches big's right child to its left child
            big.rightChild = leftChild;
            
            //if has no right child, when left and right are switched, small becomes left child
            if (rightChild == null)
            	big.leftChild = small;
            //if there is a right child, small is merged with right child, then the root of these becomes the left child
            else
            	big.leftChild = merge(rightChild, small);

            return big;
        }
    }
    
    
}
