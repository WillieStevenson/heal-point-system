# heal-point-system

THE HEAL POINT SYSTEM

by Willie Stevenson and Sylvia Allain

University of Maine
COS 226 - Final Project README
DATE : 12/13/2012


This program simulates the Heal Point system used in the state of Maine for many high school sports.
The method calculating a school's Heal Points is a two step process.

First, a team's preliminary index (PI) must be calculated.
To do this, assign 40 points for a victory over a class a Division A school,
35 for a Division B school, 30 for a division C, and 25 for division D.
For example, if Bangor were to beat Hampden once, Bucksport twice, and Central once,
the sum would be 140 points (40 points for beating div.
A Hampden, 35 points times 2 for defeating div. 
B Bucksport, and 30 points for defeating div. C Central).  
That sum is then divided by the number of games in a regular season. 
The resulting number is a team's PI. 
A school in any division with no victories automatically obtains a PI of 1.

In the instance of a tie match, each team is awarded half of the points that they would normally receive.
For tieing with a division 'A' team, 20 points are awarded. 
Tieing with a division 'B' team awards 17 points (rounded down). 
Lastly, 15 points are awarded for tieing with a division 'C' team. 
The following example will be used to illustrate this occurrence. 
	
Bangor (division A) faces Central (division C). 
In the very unlikely instance that Central has a tie game with Bangor, 
Central receives 20 points, while Bangor only receives 15 as a result form   	
beating central. If central where to have beaten Bangor, Central is awarded 40 points,
while Bangor is awarded none.


Second, the tournament index (TI) is calculated. 
To do this, add up all of the PI's of the teams that a school has defeated (if a team defeats another team twice, add the PI's twice). 
Then divide the resulting sum by the number of games in the season and multiply by 10. 
This number is the tournament index or TI of a school. 
It is the TI that ranks a team in the Heal Point system, not the PI.

We will use schools from the surrounding area.

Division A Teams : Bangor, Brewer, Hampden, Nokomis, Old Town,  John Bapst
Division B Teams : Orono, Bucksport, Ellsworth
Division C Teams : Central
