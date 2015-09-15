package entities;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "moviePref", catalog = "PopcornFlavor")
public class MoviePref {
	private int idMoviePref;
	private int idMovie;
	private String username;
	
	public MoviePref() {
		
	}
	
	public MoviePref(int idMovie, String username) {
		this.setIdMovie(idMovie);
		this.setUsername(username);
	}
	@Column(name = "idMovie", unique = true, nullable = false)
	public int getIdMovie() {
		return idMovie;
	}

	public void setIdMovie(int idMovie) {
		this.idMovie = idMovie;
	}
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idMoviePref", unique = true, nullable = false)
	public int getIdMoviePref() {
		return idMoviePref;
	}
	
	public void setIdMoviePref(int idMoviePref) {
		this.idMoviePref = idMoviePref;
	}

	@Column(name = "username", unique = true, length = 45)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
