package entities;
// Generated Jul 29, 2015 11:12:29 AM by Hibernate Tools 4.3.1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * MovieActor generated by hbm2java
 */
@Entity
@Table(name = "MovieActor", catalog = "PopcornFlavor")
public class MovieActor implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7201594742938304945L;
	private MovieActorId id;
	private String role;

	public MovieActor() {
	}

	public MovieActor(MovieActorId id) {
		this.id = id;
	}

	public MovieActor(MovieActorId id, String role) {
		this.id = id;
		this.role = role;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "idMovie", column = @Column(name = "idMovie", nullable = false) ),
			@AttributeOverride(name = "idActor", column = @Column(name = "idActor", nullable = false) ) })
	public MovieActorId getId() {
		return this.id;
	}

	public void setId(MovieActorId id) {
		this.id = id;
	}

	@Column(name = "role", length = 1500)
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}