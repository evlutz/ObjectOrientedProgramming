//ewlutz
//Evan Lutz

//brmarsh
//Ben Marsh
public class WritingResult implements IChallenge{
	
	
	double wordsWritten;
	
	//A number 1-30 based on the day in November
	int lastUpdated;
	
	
	public WritingResult(double wordsWritten, int lastUpdated) {
		this.wordsWritten = wordsWritten;
		this.lastUpdated = lastUpdated;
	}
	
	public double averagePerDay() {
		return this.wordsWritten / lastUpdated;
	}
	
	public double differenceFromGoal() {
		return (50000 - this.wordsWritten) / (30 - this.lastUpdated + 1);
	}
}
