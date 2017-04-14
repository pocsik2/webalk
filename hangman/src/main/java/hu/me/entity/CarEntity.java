package hu.me.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CarEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;
	public String tipus;
	public String marka;
	
	public CarEntity(long id, String tipus, String marka) {
		super();
		this.id = id;
		this.tipus = tipus;
		this.marka = marka;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTipus() {
		return tipus;
	}
	public void setTipus(String tipus) {
		this.tipus = tipus;
	}
	public String getMarka() {
		return marka;
	}
	public void setMarka(String marka) {
		this.marka = marka;
	}
	
	
}
