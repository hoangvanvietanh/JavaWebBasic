package entities;

public class Item {
	Product sanpham;
	int soluong;
	
	public Item() {
	}

	public Item(Product sanpham, int soluong) {
		this.sanpham = sanpham;
		this.soluong = soluong;
	}
	public Item(Product sanpham) {
		this.sanpham = sanpham;
	}
	public Product getSanpham() {
		return sanpham;
	}

	public void setSanpham(Product sanpham) {
		this.sanpham = sanpham;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	
	
	
	
}
