import java.util.LinkedList;

class MovieManager2 {

	MovieManager2() {
	}

	/*
	Makes a programme given a list of movies
	@Param list of movies
	@Return Programme of all the ordered movies
	 */
	public Programme organizeMovies(LinkedList<Movie> movies) {
		Programme orgProgram = new Programme();
		LinkedList<Double> timeList = new LinkedList<>();

		for (int i = 0; i < movies.size(); i++) {
			if(movies.get(i).simulcast == false) {
				timeList.add(movies.get(i).showtime);
			}
		}

		for (int i = 0; i < timeList.size(); i++) {

			if (timeList.get(i) >= 700 && timeList.get(i) <= 1200) {
				for (int h = 0; h < movies.size(); h++) {
					if (movies.get(h).showtime == timeList.get(i)) {
						orgProgram.matinee.add(movies.get(h));
					}
				}
			}
			if (timeList.get(i) >= 1200 && timeList.get(i) <= 2000) {
				for (int h = 0; h < movies.size(); h++) {
					if (movies.get(h).showtime == timeList.get(i)) {
						orgProgram.primetime.add(movies.get(h));
					}
				}
			}
			if ((timeList.get(i) >= 2000 && timeList.get(i) <= 2400) || (timeList.get(i) > -1 && timeList.get(i) <= 200)) {
				for (int h = 0; h < movies.size(); h++) {
					if (movies.get(h).showtime == timeList.get(i)) {
						orgProgram.soiree.add(movies.get(h));
					}
				}
			}


		}
		return orgProgram;
	}
}
		/*
		Programme orgProgramme = new Programme();
		LinkedList<Movie> newMatinees = new LinkedList<>();
		LinkedList<Movie> newPrimetime = new LinkedList<>();
		LinkedList<Movie> newSoiree = new LinkedList<>();

		for(int i = 0; i<movies.size(); i++) {
			if (movies.get(i).simulcast == true) {
				movies.remove(i);
			}
		}
		for(int i = 0; i< movies.size(); i++){

		if(movies.get(i).showtime <= 1200 && 700 <= movies.get(i).showtime){
			newMatinees.add(movies.get(i));
			//	movies.remove(i);
		}
		if(movies.get(i).showtime <= 2000 && 1200 <= movies.get(i).showtime){
			newPrimetime.add(movies.get(i));
			//movies.remove(i);
		}
		if((movies.get(i).showtime >= 0 && 200 >= movies.get(i).showtime) || (movies.get(i).showtime <= 2400 && 2000 <= movies.get(i).showtime)){
			newPrimetime.add(movies.get(i));
			//movies.remove(i);
				}
			}
		for(int i = 0; i<newMatinees.size(); i++){
			orgProgramme.matinee.add(newMatinees.get(i));
		}
		for(int i = 0; i<newSoiree.size(); i++){
			orgProgramme.soiree.add(newSoiree.get(i));
		}
		for(int i = 0; i<newPrimetime.size(); i++){
			orgProgramme.primetime.add(newPrimetime.get(i));
		}

		return orgProgramme;
	}
	/*
	Matinees 7am-12
	Primetime 12-20
	Soiree 20-2

	Cycle list
	Throw out  all that simulcast = true
	cycle list
	make 3 lists of all the different showtimes
	distribute movies amongst list
	cycle through each Programme list and add each item into its respective list
	 */

