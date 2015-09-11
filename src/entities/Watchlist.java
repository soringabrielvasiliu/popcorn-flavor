package entities;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Watchlist", catalog = "PopcornFlavor")
public class Watchlist implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 691184672001249235L;
	private int idWatchlist;
	private int idMovie;
	private String username;

	public Watchlist() {

	}

	public Watchlist(int idMovie, String username) {
		this.idMovie = idMovie;
		this.username = username;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idWatchlist", unique = true, nullable = false)
	public int getIdWatchlist() {
		return idWatchlist;
	}

	public void setIdWatchlist(int idWatchlist) {
		this.idWatchlist = idWatchlist;
	}

	@Column(name = "idMovie", unique = true, nullable = false)
	public int getIdMovie() {
		return idMovie;
	}

	public void setIdMovie(int idMovie) {
		this.idMovie = idMovie;
	}

	@Column(name = "username", unique = true, length = 110)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
