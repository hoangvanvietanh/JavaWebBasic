package entities;

public class Chitiethoadon {
	private int mahd;
	private String masp;
	private int soluong;
	
	//public Chitiethoadon() {
	//}

	public Chitiethoadon(int mahd,String masp, int soluong) {
		this.mahd = mahd;
		this.masp = masp;
		this.soluong = soluong;
	}

	public int getMahd() {
		return mahd;
	}

	public void setMahd(int mahd) {
		this.mahd = mahd;
	}

	public String getMasp() {
		return masp;
	}

	public void setMasp(String masp) {
		this.masp = masp;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	
	
}
