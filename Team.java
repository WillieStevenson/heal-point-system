import java.util.ArrayList;



public class Team<AnyType> {
	/*
     * For a definition of these variables, please look at the constructor.
     */
    private String teamName;
    private int points;
    private char division;
    private double TI;
    private double PI;
    // prelimCount contains the number of prelims that have elapsed so far. 
    private int prelimCount = 0;
    private int winCount;
    private ArrayList<AnyType> teamHistory;
    private ArrayList<Team> defeatedTeams;
    
    /*
     * A team is instantiated with the following information :
     * PRE : A team must be created with (passed) a team name and a division (class or rank) 
     *  as one of the following chars: 'A' , 'B' , or 'C'
     * POST : A team is constructed with : 
     *  * a team name
     *  * a division
     *  * points, which is the running sum of points received from beating other teams
     *  * a tournament index (TI) which is calculated after each prelim
     *  * a preliminary index (PI) which is calculated after each prelim. This is used to calculate TI.
     *  * a counter variable, that contains the number of wins a team has at a given moment. 
     *  * ...If this number is 0, PI = 1.
     *  * a team history list, which contains the list of all teams that a team has played
     *  * a defeated team list, which contains a list of teams that a team has defeated
     *  * if this is empty, winCount would be 0, and PI would be 1 at any given time.
     */
	public Team(String name, char div)
	{
		teamName = name;
		division = div;
		points = 0; // accumulated
		TI = 0;
		PI = 1; // Initial no win season 
		winCount = 0;
		defeatedTeams = new ArrayList<Team>();
	}
	
	/*
     * POST : Returns 'this' team's division.
     * NOTE : division is a rank or class of a school team such as A or B
     *        ... A - C are only of relevance in this program.
     * NOTE : This is preset data in the Mods class; division cannot be edited by the user.
     */
    public char getDivision()
    {
        return this.division;
    }
    
    /*
     * POST : Returns 'this' team's name.
     * NOTE : This is preset data in the Mods class; division cannot be edited by the user.
     */
    public String getName()
    {
        return this.teamName;
    }
    
    /*
     * POST : Returns 'this' team's PI.
     */
    public double getPI()
    {
        return this.PI;
    }
    
    /*
     * POST : Returns 'this' team's TI.
     */
    public double getTI()
    {
        return this.TI;
    }	
	
    /*
     * POST : Returns 'this' team's defeated team list.
     */
	public ArrayList<Team> returnDefeatedTeamsList()
	{
		return this.defeatedTeams;
	}
	
	/*
     * The setPI method tests the heap.
     * PRE : i is this team's score (input from GUI)
     *       j is other team's score (input from GUI)
     *       other is the opposing team
     * POST : PI is calculated by the formula in the README file
     * 
     * NOTE : PI = 1 if a team has no wins.
     */
	public void setPI(int i, int j, Team other)
	{
		this.prelimCount += 1;
		
		if (i > j)
		{	
			if (winCount == 0)
				this.PI = 0;
			if (other.getDivision() == 'A')
			{
				this.points += 40;
			}
			if (other.getDivision() == 'B')
			{
				this.points += 35;
			}
			if (other.getDivision() == 'C')
			{
				this.points += 30;
			}
			this.defeatedTeams.add(other);
			winCount += 1;
		}
		
		this.PI = points/(double)this.prelimCount;
		if(winCount == 0)
			this.PI = 1;
	}
	
	/*
     * TI is calculated by the formula in the README file
     */
	public void calculateTI()
	{
		int defeatedPIsum = 0;
		for (Team i : defeatedTeams)
		{
			defeatedPIsum += i.getPI();
		}
		
		this.TI = (defeatedPIsum/(double)this.prelimCount)*10.0;
	}
}
