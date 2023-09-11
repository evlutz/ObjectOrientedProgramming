//ewlutz
//Evan Lutz
//brmarsh
//Ben Marsh
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class MovieExamples
{
	MovieManager1 mm1 = new MovieManager1();

	MovieManager2 mm2 = new MovieManager2();
	LinkedList<Movie> movies = new LinkedList<Movie>();
	Programme programme1 = new Programme();

	Movie starTrek = new Movie("Star Trek Into Darkness", 1400, 132, false);
	Movie pinicchio = new Movie("GUILLERMO DEL TORO'S PINOCCHIO", 945, 114, false);
	Movie swampThing = new Movie("RiffTrax Live: The Return of Swamp Thing", 2030, 118, true);
	Movie sevenSamurai = new Movie("Seven Samurai", 0, 207, false);

	Movie theDeparted = new Movie("The Departed", 0, 217, true);

	Movie inception = new Movie("Inception", 2, 186, true);

	Movie inception2 = new Movie("Inception2", 2, 190, true);

	Movie bigDaddy = new Movie("BigDaddy", 2, 90, true);
	Movie bigDaddy2 = new Movie("Big Daddy", 2, 90, true);

	Movie goodWillHunting = new Movie("Good Will Hunting", 0, 0, false);
	Movie goodWillHunting2 = new Movie("Good Will Hunting", 0, 0, true);




	public MovieExamples()
	{
		movies.add(starTrek);
		programme1.primetime.add(starTrek);

		movies.add(pinicchio);
		programme1.matinee.add(pinicchio);

		movies.add(swampThing);
		programme1.soiree.add(swampThing);

		movies.add(sevenSamurai);
		programme1.soiree.add(sevenSamurai);
	}

	@Test
	public void instructorTestProgramme_EmptyReport() {
		Programme report2 = new Programme();
		assertFalse(programme1.equals(report2));
	}


	@Test
	public void instructorTestProgramme_WrongOrder() {
		Programme programme2 = new Programme();

		programme2.primetime.add(starTrek);
		programme2.matinee.add(pinicchio);
		programme2.soiree.add(sevenSamurai);
		programme2.soiree.add(swampThing);


		assertFalse(programme1.equals(programme2));
	}

	@Test
	public void instructorTestProgramme_DifferentInstances() {
		Programme programme2 = new Programme();

		Movie starTrek2 = new Movie("Star Trek Into Darkness", 1400, 132, false);
		Movie pinocchio2 = new Movie("GUILLERMO DEL TORO'S PINOCCHIO", 945, 114, false);
		Movie swampThing2 = new Movie("RiffTrax Live: The Return of Swamp Thing", 2030, 118, true);
		Movie sevenSamurai2 = new Movie("Seven Samurai", 0, 207, false);

		programme2.primetime.add(starTrek2);
		programme2.matinee.add(pinocchio2);
		programme2.soiree.add(swampThing2);
		programme2.soiree.add(sevenSamurai2);

		assertTrue(programme1.equals(programme2));
	}

	@Test
	public void instructorTestProgramme_SameInstances() {
		Programme programme2 = programme1;
		assertTrue(programme1.equals(programme2));
	}

	@Test
	public void equals_sameMovieDifValues(){
		Programme testProg = new Programme();
		Programme testProg2 = new Programme();
		testProg.matinee.add(inception);
		testProg2.matinee.add(inception2);

		assertFalse(testProg2.equals(testProg));

	}

	@Test
	public void equals_sameMovie2times(){
		Programme testProg = new Programme();
		Programme testProg2 = new Programme();
		testProg.matinee.add(inception);
		testProg2.matinee.add(inception);

		assertTrue(testProg2.equals(testProg));

	}

	@Test
	public void equals_sameMovies(){
		Programme testProg = new Programme();
		Programme testProg2 = new Programme();
		testProg.matinee.add(inception);
		testProg.matinee.add(inception);
		testProg2.matinee.add(inception);
		testProg2.matinee.add(inception);

		assertTrue(testProg2.equals(testProg));

	}

	@Test
	public void equals_sameMovieWithDifTitle(){
		Programme testProg = new Programme();
		Programme testProg2 = new Programme();
		testProg.matinee.add(bigDaddy);
		testProg2.matinee.add(bigDaddy2);

		assertFalse(testProg2.equals(testProg));

	}

	public void equals_sameMovieWithDifSimulcast(){
		Programme testProg = new Programme();
		Programme testProg2 = new Programme();
		testProg.matinee.add(goodWillHunting);
		testProg2.matinee.add(goodWillHunting2);

		assertFalse(testProg2.equals(testProg));

	}




	@Test
	public void instructorTestOrganizeMovies1()
	{
		Programme programme2 = mm1.organizeMovies(movies);
		programme1.soiree.remove(swampThing); //it's a simulcast
		assertEquals(programme1, programme2);
	}
	@Test
	public void instructorTestOrganizeMovies2()
	{
		Programme programme2 = mm2.organizeMovies(movies);
		programme1.soiree.remove(swampThing); //it's a simulcast
		assertEquals(programme1, programme2);
	}

	@Test
	public void TestOrganizeMovies1()
	{
		LinkedList<Movie> test1 = new LinkedList<>();
		LinkedList<Movie> test2 = new LinkedList<>();
		test1.add(pinicchio);
		test2.add(pinicchio);
		test1.add(sevenSamurai);
		test2.add(sevenSamurai);
		test1.add(starTrek);
		test2.add(starTrek);
		Programme programme2 = mm1.organizeMovies(test1);
		Programme programme1 = mm1.organizeMovies(test2);

		assertEquals(programme1, programme2);
	}


	@Test
	public void TestOrganizeMoviesWithDifMMFunctions()
	{
		LinkedList<Movie> test1 = new LinkedList<>();
		LinkedList<Movie> test2 = new LinkedList<>();
		test1.add(pinicchio);
		test2.add(pinicchio);
		test1.add(sevenSamurai);
		test2.add(sevenSamurai);
		test1.add(starTrek);
		test2.add(starTrek);
		Programme programme2 = mm1.organizeMovies(test1);
		Programme programme1 = mm2.organizeMovies(test2);

		assertEquals(programme1, programme2);
	}



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
	or the showtime is greater than 0 and less than 200
	add to Soiree
	 */
