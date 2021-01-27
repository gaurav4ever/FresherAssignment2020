package com.nuclei.assignment4.main;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.nuclei.assignment4.beans.Item;
import com.nuclei.assignment4.service.ItemService;

public class Main {
	
	static volatile HashSet<Item> items = new HashSet<Item>();
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String name, type;
		double price = 0;
		int quantity = 0;
		int sentinel = 0;
		int choice = 0;
		boolean con = true;
		while(sentinel++ < 999) {
			System.out.println("1. Insert 2. Compute");
			while(con) {
				try {
					choice = sc.nextInt();
					con = false;
				}catch(InputMismatchException e) {
					System.out.println("Enter an integer value");
				}
			}
			switch(choice) {
			case 1:	//iNSERT
					con = true;
					sc.nextLine();
					System.out.println("Enter Item name, price, quantity and type");
					name = sc.nextLine();
					while(con) {
						try {
							price = sc.nextDouble();
							con = false;
						}catch(InputMismatchException e) {
							sc.next();
							System.out.println("Please enter a valid price");
						}
					}
					con = true;
					while(con) {
						try {
							quantity = sc.nextInt();
							con = false;
						}catch(InputMismatchException e) {
							sc.next();
							System.out.println("Please enter a valid quantity");
						}
					}
					sc.nextLine();
					type = sc.nextLine();
					while(!"raw".equals(type) && !"manufactured".equals(type) && !"imported".equals(type)) {
						System.out.println("Please enter valid item type \t raw, manufactured or imported");
						type = sc.nextLine();
					}
					ItemService.save(new Item(name, price, quantity, type));
					break;
			case 2:	//COMPUTE
					Thread read = new Thread(new Runnable() {
						
						public void run() {
							// TODO Auto-generated method stub
							items = ItemService.listAll();
						}
					});
					
					Thread eval = new Thread(new Runnable() {
						
						public void run() {
							// TODO Auto-generated method stub
							for(Item i : items) {
								System.out.println(i);
							}
						}
					});
					
					read.start();
					eval.start();
					
					try {
						read.join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						eval.join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					break;
					
			default: System.out.println("Enter valid optionk");
			}
			
			
			
		}
		sc.close();
	}

}
