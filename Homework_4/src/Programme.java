import sun.awt.image.ImageWatched;

import java.util.LinkedList;

/*
Programme class
@Param contain 3 lists, matinee 700-1200, primetime 1200-2000, soiree 2000-200
 */
class Programme {

	LinkedList<Movie> matinee;
	LinkedList<Movie> primetime;
	LinkedList<Movie> soiree;

	Programme()
	{
		this.matinee = new LinkedList<Movie>();
		this.primetime = new LinkedList<Movie>();
		this.soiree = new LinkedList<Movie>();
	}

	Programme(LinkedList<Movie> matinee, LinkedList<Movie> primetime, LinkedList<Movie> soiree)
	{
		this.matinee = matinee;
		this.primetime = primetime;
		this.soiree = soiree;
	}

	/*
	Equals function compares to see if every value in each of the lists are equal
	@Param obj list of movies
	@Return boolean true if they are equal
	 */
	@Override
	public boolean equals(Object listOfMoviesPre) {
		int i = 0;
		Programme listOfMovies = (Programme) listOfMoviesPre;

		if(sameMovies(listOfMovies.soiree, this.soiree) && sameMovies(listOfMovies.matinee, this.matinee) && sameMovies(listOfMovies.primetime, this.primetime) && this.matinee.size() == listOfMovies.matinee.size()
		&& this.soiree.size() == listOfMovies.soiree.size() && this.primetime.size() == listOfMovies.primetime.size()){
			return true;
		}
		else{return false;}

	}

	/*
	Checks to see if 2 lists of movies are equal
	@Param 2 linkedlist of Movies
	@return boolean if the two lists are indentical
	 */
	public boolean sameMovies(LinkedList<Movie> list1, LinkedList<Movie> list2){
		int same = 0;
		for(int i = 0; i < list1.size(); i++) {
			if (list1.get(i).title.equals(list2.get(i).title)) {
				if (list1.get(i).simulcast == list2.get(i).simulcast && list1.get(i).showtime == list2.get(i).showtime
						&& list1.get(i).runtime == list2.get(i).runtime) {
					same++;
				}

			}
			else{return false;}
		}

		return(same == list1.size());

	}





}
