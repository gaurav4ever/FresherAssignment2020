package com.nuclei.assignment4.service;

import java.util.HashSet;

import com.nuclei.assignment4.DAO.ItemDAO;
import com.nuclei.assignment4.beans.Item;

public class ItemService {

	static ItemDAO dao = new ItemDAO();
	public static void save(Item item) {
		dao.save(item);
	}
	
	public static void delete(Item item) {
		dao.delete(item);
	}
	
	public static HashSet<Item> listAll(){
		return dao.listAll();
	}
}
