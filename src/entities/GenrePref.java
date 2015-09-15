package entities;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "genrePref", catalog = "PopcornFlavor")
public class GenrePref {
	private int idGenrePref;
	private int idGenre;
	private String username;
	
	public GenrePref() {
		
	}
	
	public GenrePref(int idGenre, String username) {
		this.setIdGenre(idGenre);
		this.setUsername(username);
	}
	@Column(name = "idGenre", unique = true, nullable = false)
	public int getIdGenre() {
		return idGenre;
	}

	public void setIdGenre(int idGenre) {
		this.idGenre = idGenre;
	}
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idGenrePref", unique = true, nullable = false)
	public int getIdGenrePref() {
		return idGenrePref;
	}
	
	public void setIdGenrePref(int idGenrePref) {
		this.idGenrePref = idGenrePref;
	}

	@Column(name = "username", unique = true, length = 45)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
