package iit.webalk.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LibrarianEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long libId;
	private String name;
	private String emailAddress;
	
	public Long getLibId() {
		return libId;
	}
	public void setLibId(Long libId) {
		this.libId = libId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	

}
