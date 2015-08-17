package entities;
// Generated Jul 29, 2015 11:12:29 AM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * MovieActorId generated by hbm2java
 */
@Embeddable
public class MovieActorId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3970431163265560595L;
	private int idMovie;
	private int idActor;

	public MovieActorId() {
	}

	public MovieActorId(int idMovie, int idActor) {
		this.idMovie = idMovie;
		this.idActor = idActor;
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MovieActorId))
			return false;
		MovieActorId castOther = (MovieActorId) other;

		return (this.getIdMovie() == castOther.getIdMovie()) && (this.getIdActor() == castOther.getIdActor());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdMovie();
		result = 37 * result + this.getIdActor();
		return result;
	}

}
