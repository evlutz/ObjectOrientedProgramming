//ewlutz
//Evan Lutz

//brmarsh
//Ben Marsh
public class ChallengeResult {
	
	ReadingResult rr;
	WritingResult wr;
	
	public ChallengeResult(ReadingResult rr, WritingResult wr) {
		this.rr = rr;
		this.wr = wr;
	}
	
	
	public double howClose() {
		return (rr.differenceFromGoal() * 10000) + wr.differenceFromGoal();
	}
	
}
