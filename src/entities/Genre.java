package entities;

// Generated Jul 29, 2015 11:12:29 AM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Genre", catalog = "PopcornFlavor", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Genre implements java.io.Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 6084856306310713709L;
	private int idGenre;
	private String name;

	public Genre() {
	}

	public Genre(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idGenre", unique = true, nullable = false)
	public Integer getIdGenre() {
		return this.idGenre;
	}

	public void setIdGenre(Integer idGenre) {
		this.idGenre = idGenre;
	}

	@Column(name = "name", unique = true, nullable = false, length = 12)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
