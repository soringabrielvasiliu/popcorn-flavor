package entities;

// Generated Jul 29, 2015 11:12:29 AM by Hibernate Tools 4.3.1

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MovieGenre", catalog = "PopcornFlavor")
public class MovieGenre implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9056161707107250298L;
	private int idMovieGenre;
	private int idMovie;
	private int idGenre;

	public MovieGenre() {
	}

	public MovieGenre(int idMovie, int idGenre) {
		this.idMovie = idMovie;
		this.idGenre = idGenre;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idMovieGenre", unique = true, nullable = false)
	public int getIdMovieGenre() {
		return idMovieGenre;
	}

	public void setIdMovieGenre(int idMovieGenre) {
		this.idMovieGenre = idMovieGenre;
	}

	@Column(name = "idMovie", nullable = false)
	public int getIdMovie() {
		return idMovie;
	}

	public void setIdMovie(int idMovie) {
		this.idMovie = idMovie;
	}

	@Column(name = "idGenre", nullable = false)
	public int getIdGenre() {
		return idGenre;
	}

	public void setIdGenre(int idGenre) {
		this.idGenre = idGenre;
	}

}
