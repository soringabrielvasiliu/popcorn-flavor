package entities;

public class UserWatchlist {
	private String idMovie;
	private String title;
	
	public UserWatchlist(String idMovie, String title) {
		super();
		this.idMovie = idMovie;
		this.title = title;
	}

	public String getIdMovie() {
		return idMovie;
	}

	public void setIdMovie(String idMovie) {
		this.idMovie = idMovie;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
