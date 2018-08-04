package model;

import java.util.ArrayList;
import java.util.HashMap;

import entities.Item;
import entities.Product;

public class CartModel {
	HashMap<String, Item> cart;

	public CartModel() {
		cart = new HashMap<>();
	}

	public CartModel(HashMap<String, Item> cart) {
		this.cart = cart;
	}

	public HashMap<String, Item> getCart() {
		return cart;
	}

	public void setCart(HashMap<String, Item> cart) {
		this.cart = cart;
	}
	
	public void addList(String masp) {
		if(cart.containsKey(masp))
		{
			Item item = cart.get(masp);
			
			int count = item.getSoluong();
			count = count + 1;
			item.setSoluong(count);
		}
		else
		{
			Product sanpham = new ProductModel().getProductByMasp(masp);
			Item item = new Item(sanpham,1);
			cart.put(masp, item);
		}
	}
	/*public void addPro(String masp) {
		Product sanpham = new ProductModel().getProductByMasp(masp);
		Item item = new Item(sanpham);
		cart.put(masp, item);
	}*/
	public void removeProduct(String masp) {
		cart.remove(masp);
	}
	
	public void removeAll() {
		cart.clear();
	}
	
	public int totalList() {
		int total = 0;
		for(Item item:cart.values())
		{
			total = total + (item.getSanpham().getGia()*item.getSoluong());
		}
		return total;
	}
	
	public ArrayList<Item> getListItems() {
		ArrayList<Item> listItems = new ArrayList<>();
		for(Item i:cart.values())
		{
			listItems.add(i);
		}
		return listItems;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
