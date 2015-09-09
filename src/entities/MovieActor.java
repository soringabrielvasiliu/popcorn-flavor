package entities;

// Generated Jul 29, 2015 11:12:29 AM by Hibernate Tools 4.3.1

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MovieActor", catalog = "PopcornFlavor")
public class MovieActor implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7201594742938304945L;
	private int idMovieActor;
	private int idMovie;
	private int idActor;
	private String role;

	public MovieActor() {
	}

	public MovieActor(int idMovie, int idActor, String role) {
		this.idMovie = idMovie;
		this.idActor = idActor;
		this.role = role;
	}

	public void setIdMovieActor(int idMovieActor) {
		this.idMovieActor = idMovieActor;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idMovieActor", unique = true, nullable = false)
	public int getIdMovieActor() {
		return this.idMovieActor;
	}

	@Column(name = "idMovie", nullable = false)
	public int getIdMovie() {
		return this.idMovie;
	}

	public void setIdMovie(int idMovie) {
		this.idMovie = idMovie;
	}

	@Column(name = "idActor", nullable = false)
	public int getIdActor() {
		return this.idActor;
	}

	public void setIdActor(int idActor) {
		this.idActor = idActor;
	}

	@Column(name = "role", length = 1500)
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
