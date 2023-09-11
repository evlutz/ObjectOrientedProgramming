import java.util.LinkedList;

class MovieManager1 {
	
	MovieManager1() {}

	/*
	Makes a programme given a list of movies
	@Param list of movies
	@Return Programme of all the ordered movies
	 */
	public Programme organizeMovies(LinkedList<Movie> movies)
	{
		Programme orgProgramme = new Programme();
		for(int i = 0; i<movies.size(); i++){

			if((moviesToList(700, 1200, movies.get(i))) == true) {
				orgProgramme.matinee.add(movies.get(i));
			}
			if((moviesToList(1200, 2000, movies.get(i))) == true) {
				orgProgramme.primetime.add(movies.get(i));
			}
			if (moviesToList(2000, 2400, movies.get(i)) == true){
					orgProgramme.soiree.add(movies.get(i));
				}
			if(moviesToList(0, 200, movies.get(i)) == true){
				orgProgramme.soiree.add(movies.get(i));
			}

		}

		return orgProgramme;
	}

	/*
	@Param Takes in a lower bound, upper bound and a movies
	determines if the movie is within the bounds of the runtime
	@return true if the movie is and false if it is not
	 */
	public Boolean moviesToList(double lowBound, double upBound, Movie movie){
			if(movie.showtime <= upBound && lowBound <= movie.showtime && movie.simulcast==false){
				return true;
			}
			else return false;
	}

	/*
	Matinees 7am-12
	Primetime 12-20
	Soiree 20-2

	Make new Programme
	Cycle through list
	Weed out when simulcast = false
	cycle through again
	Make helper function that has upper bounds and lower bound and takes in a movie
	when showtime is 7<showtime<12
	add to Matinees
	when showtime is 12<showtime<20
	add to Primetime
	when showtime is greater than 2000 but less than 2400
	or the showtime is greater than 0 or less than 200
	if true add to Soiree
	 */

	
}
