class Movie {

	/*
	Movies class
	@Param title, showtime, runtime, simulcast
	 */

	String title;
	double showtime;
	int runtime;
	boolean simulcast;
	
	public Movie(String title, double showtime, int runtime, boolean simulcast)
	{
		this.title = title;
		this.showtime = showtime;
		this.runtime = runtime;
		this.simulcast = simulcast;
	}
	
}
