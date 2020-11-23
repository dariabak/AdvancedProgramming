package uk.ac.mmu;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringRosterer {

	//problem definition
	private int _numberOfEmployees = 100;
	private int _daysToRoster = 365;	
	private char[] _shiftLetters = {'E','M','D','L'};
	
	//used in various places to get random numbers
	private Random _random = new Random();
	
	//each element in the array represents one employee, and each character in their string = 1 day
	private String[] _roster;
	
	/**
	 * Tries a hill clibming approach to a simple rostering problem
	 */
	public StringRosterer() {
    	_roster = new String[_numberOfEmployees];
		createInitialRoster();
		
		System.out.println("Objective Score of Intitial Roster: " + objectiveFunction());
		
		for(int i=0;i<100000;i++) {
			tryToImprove(objectiveFunction(), _random.nextInt(_daysToRoster),_random.nextInt(_roster.length),_random.nextInt(_roster.length));
			if ( i % 1000 == 0) {
				if ( objectiveFunction() == 0) {
					System.out.println("Got a perfect solution! Score: 0");
					System.exit(0);
				}
				else {
					System.out.println(i + ": " + objectiveFunction());
				}
			}
		}
		
		System.out.println("Final Objective Score: " + objectiveFunction());
	}
	
	/**
	 * Swaps two random employees shifts on the same day to see if its any better
	 * If not, it swaps them back
	 */
	public void tryToImprove(int oldScore,int day, int e_1, int e_2) {
		
		//swap their shifts		
		char[] c_1 = _roster[e_1].toCharArray();
		char[] c_2 = _roster[e_2].toCharArray();
		
		char c = c_1[day];
		c_1[day] = c_2[day];
		c_2[day] = c;
		
		_roster[e_1] = new String(c_1);
		_roster[e_2] = new String(c_2);
		
		//find out if it worked
		if (!(objectiveFunction() <= oldScore)) {
			//oh dear, we made things worse. Change it back
			c = c_1[day];
			c_1[day] = c_2[day];
			c_2[day] = c;
			_roster[e_1] = new String(c_1);
			_roster[e_2] = new String(c_2);			
		}
	}
	
	/**
	 * Creates a completely random roster
	 * Assigns a random shift to each employee, each day
	 */
	public void createInitialRoster() {
		for(int i=0;i<_roster.length;i++) {
			for(int j=0;j<_daysToRoster;j++) {
				_roster[i] = _roster[i] + _shiftLetters[_random.nextInt(_shiftLetters.length)];
			}
		}
	}
	
	/**
	 * Comes up with a "badness" score for the current roster
	 * 
	 * Two Rules: 	1	no L-E shift pattern = 10pts of badness
	 * 				2	no L-L-L shift patterns = 5pts of badness
	 * @return the badness score
	 */
	public int objectiveFunction() {
		int score = 0;
		Pattern lll = Pattern.compile("LLL");
		Pattern le = Pattern.compile("LE");
		for(String x: _roster) {
     			Matcher a = lll.matcher(x);
     			Matcher b = le.matcher(x);
     			while(a.find()) {
     				score += 5;
			    } 
     			while(b.find()) {
     				score += 10;
     			}
		}
		return score;
	}
	
	/**
	 * The main entry point of the program
	 * @param args - not used
	 */
	public static void main(String[] args) {	
		long starttime = System.currentTimeMillis();
		StringRosterer s = new StringRosterer();
		long endtime = System.currentTimeMillis();
		System.out.println("Rostering Took: " + (endtime-starttime) + "ms");
	}
}
