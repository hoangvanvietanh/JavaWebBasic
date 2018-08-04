package entities;

public class Product {
	private String msp;
	private String tensp;
	private Integer gia;
	private String hinh;
	private String madm;
	public Product() {
		
	}
	
	public String getMadm() {
		return madm;
	}

	public void setMadm(String madm) {
		this.madm = madm;
	}

	public Product(String msp, String tensp, Integer gia, String hinh, String madm) {
		this.msp = msp;
		this.tensp = tensp;
		this.gia = gia;
		this.hinh = hinh;
		this.madm = madm;
	}

	public String getMsp() {
		return msp;
	}

	public void setMsp(String msp) {
		this.msp = msp;
	}

	public String getTensp() {
		return tensp;
	}

	public void setTensp(String tensp) {
		this.tensp = tensp;
	}

	public Integer getGia() {
		return gia;
	}

	public void setGia(Integer gia) {
		this.gia = gia;
	}

	public String getHinh() {
		return hinh;
	}

	public void setHinh(String hinh) {
		this.hinh = hinh;
	}
	
	
}
