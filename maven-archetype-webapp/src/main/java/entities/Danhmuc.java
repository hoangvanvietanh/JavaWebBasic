package entities;

import org.omg.CORBA.PRIVATE_MEMBER;

public class Danhmuc {
	private String madm;
	private String tendm;
	
	public Danhmuc() {
	}

	public Danhmuc(String madm, String tendm) {
		this.madm = madm;
		this.tendm = tendm;
	}

	public String getMadm() {
		return madm;
	}

	public void setMadm(String madm) {
		this.madm = madm;
	}

	public String getTendm() {
		return tendm;
	}

	public void setTendm(String tendm) {
		this.tendm = tendm;
	}
	
}
