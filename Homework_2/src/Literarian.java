//ewlutz
//Evan Lutz

//brmarsh
//Ben Marsh
public class Literarian {
	
	ChallengeResult cr;
	
	
	public Literarian (ChallengeResult cr) {
		this.cr = cr;
	}
	
	//return true if the literarian 1 is better
	//return false if lit2 is better by comparing the difference from goal
	public boolean betterBookworm(Literarian lit2) {
		if(this.cr.rr.differenceFromGoal() < lit2.cr.rr.differenceFromGoal()) {
			return true; //this.dif is lower than lit2
		}
		else {
			return false;
		}
		
	}
	
	
	
	//return true if this.lit has a high reading average
	public boolean wittierWordsmith (Literarian lit2) {
		if(this.cr.wr.averagePerDay() > lit2.cr.wr.averagePerDay()) {
			return true;
		}
		else {
			return false;
		}
	}
	/*
	 * returns a boolean indicating whether the literarian has a 
	 * higher average number of written words per day or a 
	 * lower average difference needed to meet their reading goals 
	 * than the other (input) Literarian. 
	 * You must use calls to betterBookworm and wittierWordsmith in this method.
	 */
	public boolean successfulScholar(Literarian lit2) {
		if(this.betterBookworm(lit2)) {
			return true;
			
		}
		else {
			if (this.wittierWordsmith(lit2)) {
				return true;
			}
			else {
				return false;
			}
		}

	}

}
