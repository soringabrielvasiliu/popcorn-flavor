package entities;

public class OtherMovies {

	private String idMovie;
	private String title;
	private String year;
	private String role;
	
	public OtherMovies (String idMovie, String title, String year, String role) {
		this.idMovie = idMovie;
		this.title = title;
		this.year = year;
		this.role = role;
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
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
