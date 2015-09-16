package entities;

public class RatingComment {
	private String idMovie;
	private String title;
	private String comment;
	private String date;
	private String rating;
	
	public RatingComment(String idMovie, String title, String comment, String date, String rating) {
		super();
		this.idMovie = idMovie;
		this.title = title;
		this.comment = comment;
		this.date = date;
		this.rating = rating;
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	
}
