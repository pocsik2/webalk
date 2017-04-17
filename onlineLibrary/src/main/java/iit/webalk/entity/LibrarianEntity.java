package iit.webalk.entity;

import javax.persistence.Entity;

@Entity
public class LibrarianEntity {
	
	private long libId;
	private String name;
	
	public long getLibId() {
		return libId;
	}
	public void setLibId(long libId) {
		this.libId = libId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
