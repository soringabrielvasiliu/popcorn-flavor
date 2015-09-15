package entities;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "actorPref", catalog = "PopcornFlavor")
public class ActorPref {
	private int idActorPref;
	private int idActor;
	private String username;
	
	public ActorPref() {
		
	}
	
	public ActorPref(int idActor, String username) {
		this.setIdActor(idActor);
		this.setUsername(username);
	}
	@Column(name = "idActor", unique = true, nullable = false)
	public int getIdActor() {
		return idActor;
	}

	public void setIdActor(int idActor) {
		this.idActor = idActor;
	}
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idActorPref", unique = true, nullable = false)
	public int getIdActorPref() {
		return idActorPref;
	}
	
	public void setIdActorPref(int idActorPref) {
		this.idActorPref = idActorPref;
	}

	@Column(name = "username", unique = true, length = 45)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
