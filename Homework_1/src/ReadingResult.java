//ewlutz
//Evan Lutz

//brmarsh
//Ben Marsh
public class ReadingResult implements IChallenge{
	
	int averageBooksPerDayGoal;
	BooksRead fiction;
	BooksRead nonFiction;

	
	public ReadingResult (int averageBooksPerDayGoal, BooksRead fiction, BooksRead nonFiction) {
		this.averageBooksPerDayGoal = averageBooksPerDayGoal;
		this.fiction = fiction;
		this.nonFiction = nonFiction;
	}
	
	public double averagePerDay() {
		return (fiction.booksRead + nonFiction.booksRead) / 31;
	}
	
	public double differenceFromGoal() {
		if(this.averageBooksPerDayGoal - this.averagePerDay() > 0) {
			return this.averageBooksPerDayGoal - this.averagePerDay();
		}
		else {
			return 0;
		}
	}
	
}
