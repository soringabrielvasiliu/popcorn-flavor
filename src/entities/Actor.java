package entities;
// Generated Jul 29, 2015 11:12:29 AM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Actor generated by hbm2java
 */
@Entity
@Table(name = "Actor", catalog = "PopcornFlavor")
public class Actor implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 691184672001249235L;
	private Integer idActor;
	private String firstName;
	private String lastName;
	private String nickname;
	private String height;
	private String biography;
	private String dateBirth;
	private String dateDeath;
	private String img;

	public Actor() {
	}

	public Actor(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Actor(String firstName, String lastName, String nickname, String height, String biography, String dateBirth,
			String dateDeath, String img) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickname = nickname;
		this.height = height;
		this.biography = biography;
		this.dateBirth = dateBirth;
		this.dateDeath = dateDeath;
		this.img = img;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idActor", unique = true, nullable = false)
	public Integer getIdActor() {
		return this.idActor;
	}

	public void setIdActor(Integer idActor) {
		this.idActor = idActor;
	}

	@Column(name = "firstName", nullable = false, length = 110)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "lastName", nullable = false, length = 110)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "nickname", length = 110)
	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Column(name = "height", length = 10)
	public String getHeight() {
		return this.height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	@Column(name = "biography", length = 1000)
	public String getBiography() {
		return this.biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	@Column(name = "dateBirth", length = 100)
	public String getDateBirth() {
		return this.dateBirth;
	}

	public void setDateBirth(String dateBirth) {
		this.dateBirth = dateBirth;
	}

	@Column(name = "dateDeath", length = 100)
	public String getDateDeath() {
		return this.dateDeath;
	}

	public void setDateDeath(String dateDeath) {
		this.dateDeath = dateDeath;
	}

	@Column(name = "img", length = 45)
	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}
