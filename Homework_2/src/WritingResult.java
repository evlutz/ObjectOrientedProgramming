//ewlutz
//Evan Lutz

//brmarsh
//Ben Marsh
import java.util.LinkedList;

public class WritingResult implements IChallenge{
	
	//Linkedlist each element in the list represents a chapter and the double of how many words were written
	LinkedList<Double> wordsWrittenList = new LinkedList<Double>();
	
	//A number 1-30 based on the day in November
	int lastUpdated;

	
	
	public WritingResult(LinkedList<Double> wordsWrittenList, int lastUpdated) {
		this.wordsWrittenList = wordsWrittenList;
		this.lastUpdated = lastUpdated;
	}
	/*
	 * Adds a chapter of words written to the List of chapters
	 * @param Takes in a doubles and adds it to the end of the list
	 * @return The writtingResult
	 */
	
	public WritingResult nextChapter(double newChap) {
		this.wordsWrittenList.addLast(newChap);
		return this;
	}
	
	
	public double averagePerDay() {
		double wordsWritten = 0;
		if(this.wordsWrittenList.size() == 0) {
			return 0;
		}
		else {
			for (int i = 0; i < wordsWrittenList.size(); i++) {
				wordsWritten = wordsWritten + wordsWrittenList.get(i);
			}
		}
		return wordsWritten / lastUpdated;
	}
	
	public double differenceFromGoal() {
		int wordsWritten = 0;
		for (int i = 0; i < wordsWrittenList.size(); i++) {
			wordsWritten = wordsWritten + wordsWrittenList.get(i);
		}
		return (50000 - this.averagePerDay()) / (30 - this.lastUpdated + 1);
	}
}
