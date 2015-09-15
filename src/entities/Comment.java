package entities;
// Generated Jul 29, 2015 11:12:29 AM by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Comment generated by hbm2java
 */
@Entity
@Table(name = "Comment", catalog = "PopcornFlavor")
public class Comment implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8208430615847213902L;
	private Integer idComment;
	private Integer idMovie;
	private String username;
	private String comment;
	private Date date;
	private String rating;

	public Comment() {
	}

	public Comment(Integer idMovie, String username, String comment, Date date, String rating) {
		this.idMovie = idMovie;
		this.username = username;
		this.comment = comment;
		this.date = date;
		this.rating = rating;
	}
	
//	public Comment(Integer idMovie, String username, String comment, Date date) {
//		this.idMovie = idMovie;
//		this.username = username;
//		this.comment = comment;
//		this.date = date;
//	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idComment", unique = true, nullable = false)
	public Integer getIdComment() {
		return this.idComment;
	}

	public void setIdComment(Integer idComment) {
		this.idComment = idComment;
	}

	@Column(name = "idMovie")
	public Integer getIdMovie() {
		return this.idMovie;
	}

	public void setIdMovie(Integer idMovie) {
		this.idMovie = idMovie;
	}

	@Column(name = "username")
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "comment", length = 1000)
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date", length = 0)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "rating", length = 1)
	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

}
