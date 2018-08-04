package model;

import java.util.ArrayList;
import java.util.HashMap;

import entities.Item;
import entities.Product;

public class ProCarModel {
	HashMap<String, Item> cart;
	
	public ProCarModel() {
		cart = new HashMap<>();
	}

	public ProCarModel(HashMap<String, Item> cart) {
		this.cart = cart;
	}

	public HashMap<String, Item> getCart() {
		return cart;
	}

	public void setCart(HashMap<String, Item> cart) {
		this.cart = cart;
	}
	public void addPro(String masp) 
	{
	Product sanpham = new ProductModel().getProductByMasp(masp);
	Item item = new Item(sanpham);
	cart.put(masp, item);
	}
	public ArrayList<Item> getListItems() {
		ArrayList<Item> listItems = new ArrayList<>();
		for(Item i:cart.values())
		{
			listItems.add(i);
		}
		return listItems;
	}
	public void removeProduct(String masp) {
		cart.remove(masp);
	}
}
