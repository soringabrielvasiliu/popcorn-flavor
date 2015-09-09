package entities;

public class MovieCast {
	private String idActor;
	private String firstName;
	private String lastName;
	private String role;
	
	public MovieCast (String idActor, String firstName, String lastName, String role) {
		this.idActor = idActor;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}
	
	public String getIdActor() {
		return idActor;
	}
	public void setIdActor(String idActor) {
		this.idActor = idActor;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
