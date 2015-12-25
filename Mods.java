/**
 * The Moderator class.
 * 
 * Created by Sylvia Allain and Willie Stevenson
 * University of Maine
 * COS 226 - Final Project
 * DATE : 12/13/2012
 * 
 * 
 * This class moderates the program, handing calls to and from other class, sending finalized information to
 * the GUI when needed.
 * 
 * Methods :
 * 
 * public Mods()
 * public void distributeTeamScores(ArrayList<Integer> sl)
 * public ArrayList<Team> getBinaryRanking()
 * public ArrayList<Team> getPairingRanking()
 * public ArrayList<Team> getSkewRanking()
 * public long getBinaryTime()
 * public long getPairingTime()
 * public long getSkewTime()
 * public ArrayList<Team> getNextPrelimList()
 * public String defeatedTeamsToString(String team)
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.*;


public class Mods<AnyType> {

	
	public PriorityQueue binaryHeap;
	public PairingHeap pairingHeap;
	public BinarySkewHeap skewHeap;
	
	public long binaryTime;
	public long pairingTime;
	public long skewTime;
	
	private ArrayList<Team> Prelim1;
	private ArrayList<Team> Prelim2;
	private ArrayList<Team> Prelim3;
	private ArrayList<Team> Prelim4;
	private ArrayList<Team> Prelim5;
	private ArrayList<Team> Prelim6;
	private ArrayList<Team> Prelim7;
	private ArrayList<Team> Prelim8;
	private ArrayList<Team> Prelim9;
	private ArrayList<Team> Prelim10;
	private ArrayList<Team> Prelim11;
	private ArrayList<Team> Prelim12;
	
	private ArrayList<Team> CurrentPrelimList;
	
	private int PrelimNumber;
	
	 /**
     * Creates a moderator object. At instantiation, each data structure to be implemented,
     * team (of which are predefined with a name and division), and all prelims to be played are defined.
     */
	public Mods()
	{
		// data structures to be used 
        binaryHeap = new PriorityQueue();
        pairingHeap = new PairingHeap();
        skewHeap = new BinarySkewHeap();
        
        // Intial prelim to display, in other words start at the first prelim.
        PrelimNumber = 1;
		
        // Predefines all teams that may play in a given prelim
		Team bangor = new Team("Bangor", 'A');
		Team brewer = new Team("Brewer", 'A');
		Team hampden = new Team("Hampden", 'A');
		Team oldTown = new Team("Old Town", 'A');
		Team nokomis = new Team("Nokomis", 'A');
		Team johnBapst = new Team("John Bapst", 'A');
		Team orono = new Team("Orono", 'B');
		Team bucksport = new Team("Bucksport", 'B');
		Team ellsworth = new Team("Ellsworth", 'B');
		Team central = new Team("Central", 'C');
		
		// Creates all prelims. 
		
		Prelim1 = new ArrayList<Team>();
		Prelim1.add(nokomis);
		Prelim1.add(johnBapst);
		Prelim1.add(orono);
		Prelim1.add(bucksport);
		Prelim1.add(ellsworth);
		Prelim1.add(central);
		Prelim1.add(bangor);
		Prelim1.add(brewer);
		Prelim1.add(hampden);
		Prelim1.add(oldTown);		
		
		Prelim2 = new ArrayList<Team>();
		Prelim2.add(orono);
		Prelim2.add(johnBapst);
		Prelim2.add(ellsworth);
		Prelim2.add(bucksport);
		Prelim2.add(bangor);
		Prelim2.add(central);
		Prelim2.add(hampden);
		Prelim2.add(brewer);
		Prelim2.add(nokomis);
		Prelim2.add(oldTown);
		
		Prelim3 = new ArrayList<Team>();
		Prelim3.add(hampden);
		Prelim3.add(central);
		Prelim3.add(nokomis);
		Prelim3.add(brewer);
		Prelim3.add(orono);
		Prelim3.add(bangor);
		Prelim3.add(bucksport);
		Prelim3.add(oldTown);
		Prelim3.add(ellsworth);
		Prelim3.add(johnBapst);
		
		Prelim4 = new ArrayList<Team>();
		Prelim4.add(orono);
		Prelim4.add(brewer);
		Prelim4.add(ellsworth);
		Prelim4.add(oldTown);
		Prelim4.add(bangor);
		Prelim4.add(johnBapst);
		Prelim4.add(hampden);
		Prelim4.add(bucksport);
		Prelim4.add(nokomis);
		Prelim4.add(central);
		
		Prelim5 = new ArrayList<Team>();
		Prelim5.add(hampden);
		Prelim5.add(johnBapst);
		Prelim5.add(nokomis);
		Prelim5.add(bucksport);
		Prelim5.add(bangor);
		Prelim5.add(oldTown);
		Prelim5.add(orono);
		Prelim5.add(central);
		Prelim5.add(ellsworth);
		Prelim5.add(brewer);
		
		Prelim6 = new ArrayList<Team>();
		Prelim6.add(brewer);
		Prelim6.add(oldTown);
		Prelim6.add(johnBapst);
		Prelim6.add(bucksport);
		Prelim6.add(bangor);
		Prelim6.add(hampden);
		Prelim6.add(nokomis);
		Prelim6.add(orono);
		Prelim6.add(ellsworth);
		Prelim6.add(central);
		
		Prelim7 = new ArrayList<Team>();
		Prelim7.add(nokomis);
		Prelim7.add(central);
		Prelim7.add(oldTown);
		Prelim7.add(brewer);
		Prelim7.add(ellsworth);
		Prelim7.add(hampden);
		Prelim7.add(bangor);
		Prelim7.add(orono);
		Prelim7.add(bucksport);
		Prelim7.add(johnBapst);
		
		Prelim8 = new ArrayList<Team>();
		Prelim8.add(oldTown);
		Prelim8.add(central);
		Prelim8.add(nokomis);
		Prelim8.add(hampden);
		Prelim8.add(bangor);
		Prelim8.add(johnBapst);
		Prelim8.add(ellsworth);
		Prelim8.add(orono);
		Prelim8.add(bucksport);
		Prelim8.add(brewer);
		
		Prelim9 = new ArrayList<Team>();
		Prelim9.add(bucksport);
		Prelim9.add(oldTown);
		Prelim9.add(ellsworth);
		Prelim9.add(central);
		Prelim9.add(bangor);
		Prelim9.add(nokomis);
		Prelim9.add(hampden);
		Prelim9.add(orono);
		Prelim9.add(brewer);
		Prelim9.add(johnBapst);
		
		Prelim10 = new ArrayList<Team>();
		Prelim10.add(hampden);
		Prelim10.add(johnBapst);
		Prelim10.add(nokomis);
		Prelim10.add(orono);
		Prelim10.add(bangor);
		Prelim10.add(ellsworth);
		Prelim10.add(brewer);
		Prelim10.add(central);
		Prelim10.add(bucksport);
		Prelim10.add(oldTown);
		
		Prelim11 = new ArrayList<Team>();
		Prelim11.add(johnBapst);
		Prelim11.add(central);
		Prelim11.add(oldTown);
		Prelim11.add(bucksport);
		Prelim11.add(brewer);
		Prelim11.add(orono);
		Prelim11.add(nokomis);
		Prelim11.add(ellsworth);
		Prelim11.add(bangor);
		Prelim11.add(hampden);
		
		Prelim12 = new ArrayList<Team>();
		Prelim12.add(oldTown);
		Prelim12.add(ellsworth);
		Prelim12.add(hampden);
		Prelim12.add(nokomis);
		Prelim12.add(bangor);
		Prelim12.add(bucksport);
		Prelim12.add(brewer);
		Prelim12.add(johnBapst);
		Prelim12.add(orono);
		Prelim12.add(central);
		
		// Sets the current displayable prelim list to the first prelim list
		
		CurrentPrelimList = new ArrayList<Team>();
		CurrentPrelimList = Prelim1;
	}

	
	/**
     * PRE : is passed a score list containg integers
     * POST : iterates through the current prelim list and gives each team their score as well as the team they faced (PI and TI)
     */
	public void distributeTeamScores(ArrayList<Integer> sl)
	{
		//current score list for current prelim list
		ArrayList<Integer> scoreList = sl;
		int teamScore;
		int opponentTeamScore;
		Team opponentTeam;
		Team currentTeam;
		
		//Iterates through team list in order to set each team's PI
		for (int i = 0; i < 10; i++)
		{
			currentTeam = CurrentPrelimList.get(i);
			teamScore = scoreList.get(i);
			if (i % 2 == 0) // will always account for a team's opponent team whether one ahead or one behind in the list
			{
				opponentTeamScore = scoreList.get(i+1);
				opponentTeam = CurrentPrelimList.get(i+1);
			}
			else
			{
				opponentTeamScore = scoreList.get(i-1);
				opponentTeam = CurrentPrelimList.get(i-1);
			}
			
			currentTeam.setPI(teamScore, opponentTeamScore, opponentTeam);
			
		}
		
		//Iterates through team list in order to calculate each team's TI
		for(int i = 0; i < 10; i++)
		{
			currentTeam = CurrentPrelimList.get(i);
			currentTeam.calculateTI();
		}
		

	}
	
	/**
     * FOR EACH get Ranking method
     * 
     * Each get ranking method (binary, pairing, skew) is meant to calculate -
     * the time each data structure takes to add each team to the heap after their TI has been calculated. 
     * An array list containing the rank of each team is then returned to the GUI.
     */
	public ArrayList<Team> getBinaryRanking()
	{
		long startTimer = System.nanoTime();
		
		for (Team i : CurrentPrelimList)
		{
			binaryHeap.add(i);
		}
		
		ArrayList<Team> rankList = binaryHeap.returnRankList();
		
		long endTimer = System.nanoTime();

		binaryTime = endTimer - startTimer;
		
		return rankList;
		
	}
	
	/*
     * See note above
     */
	public ArrayList<Team> getPairingRanking()
	{
		long startTimer = System.nanoTime();
		
		for (Team i : CurrentPrelimList)
		{
			pairingHeap.insert(i);
		}
		
		ArrayList<Team> rankList = pairingHeap.returnRankList();
		
		long endTimer = System.nanoTime();
		
		pairingTime = endTimer - startTimer;
		
		return rankList;
		
	}
	
	/*
     * See note above
     */
	public ArrayList<Team> getSkewRanking()
	{
		long startTimer = System.nanoTime();
		
		for (Team i : CurrentPrelimList)
		{
			skewHeap.add(i);
		}
		
		ArrayList<Team> rankList = skewHeap.returnRankList();
		
		long endTimer = System.nanoTime();
		
		skewTime = endTimer - startTimer;
		
		return rankList;
		
	}
	

	
	 /*
     * Returns a long that contains the runtime of the getBinaryRanking method in nano seconds
     */
	public long getBinaryTime()
	{
		return binaryTime;
	}
	
	/*
     * Returns a long that contains the runtime of the getPairingRanking method in nano seconds
     */
	public long getPairingTime()
	{
		return pairingTime;
	}
	
	/*
     * Returns a long that contains the runtime of the getSkewRanking method in nano seconds
     */
	public long getSkewTime()
	{
		return skewTime;
	}
	

	
	/**
     * PRE : None
     * POST : Returns next prelim list to the GUI and changes current prelim for the moderator
     */
	public ArrayList<Team> getNextPrelimList()
	{
		if (PrelimNumber == 1)
		{
			PrelimNumber += 1;
			return Prelim1;
		}
		
		if (PrelimNumber == 2)
		{
			CurrentPrelimList = Prelim2;
			PrelimNumber += 1;
			return Prelim2;
		}
		
		if (PrelimNumber == 3)
		{
			PrelimNumber += 1;
			CurrentPrelimList = Prelim3;
			return Prelim3;
		}
		
		if (PrelimNumber == 4)
		{
			PrelimNumber += 1;
			CurrentPrelimList = Prelim4;
			return Prelim4;
		}
		
		if (PrelimNumber == 5)
		{
			PrelimNumber += 1;
			CurrentPrelimList = Prelim5;
			return Prelim5;
		}
		
		if (PrelimNumber == 6)
		{
			PrelimNumber += 1;
			CurrentPrelimList = Prelim6;
			return Prelim6;
		}
		
		if (PrelimNumber == 7)
		{
			PrelimNumber += 1;
			CurrentPrelimList = Prelim7;
			return Prelim7;
		}
		
		if (PrelimNumber == 8)
		{
			PrelimNumber += 1;
			CurrentPrelimList = Prelim8;
			return Prelim8;
		}
		
		if (PrelimNumber == 9)
		{
			PrelimNumber += 1;
			CurrentPrelimList = Prelim9;
			return Prelim9;
		}
		
		if (PrelimNumber == 10)
		{
			PrelimNumber += 1;
			CurrentPrelimList = Prelim10;
			return Prelim10;
		}
		
		if (PrelimNumber == 11)
		{
			PrelimNumber += 1;
			CurrentPrelimList = Prelim11;
			return Prelim11;
		}
		
		if (PrelimNumber == 12)
		{
			PrelimNumber += 1;
			CurrentPrelimList = Prelim12;
			return Prelim12;
		}
		
		else
			return null;
	}
	
	/**
     * PRE : takes a team name
     * POST : correctly formats a string containg a team's information/season history
     *      : division, defeated teams, and TI are printed
     */
	public String defeatedTeamsToString(String team)
	{
		Team t = null;
		Team teamIter = null;
		
		String info;
		String defeatedTeams = "";
		for (Team iter : CurrentPrelimList)
		{
			if (iter.getName().equals(team))
			{
				t = iter;
			}
		}
		for (Object iter : t.returnDefeatedTeamsList())
		{
			teamIter = (Team) iter;
			defeatedTeams = defeatedTeams + teamIter.getName() + "\n";
		}
		
		info = "Division: " + t.getDivision() + "\n\n" + "Defeated Teams: " + "\n" + defeatedTeams + "\n\n" + "TI: " + t.getTI();
		return info;
	}
	
}

	
	



