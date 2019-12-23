package com.enums;

import com.models.ItemDetails;

public enum ItemType {
  RAW{
    @Override
    public void calculateTax(ItemDetails item){
      double tax;
      tax = item.getPrice()*(12.5/100);
      item.setTax(tax);
    }
  },
  MANUFACTURED{
    @Override
    public void calculateTax(ItemDetails item) {
      double tax;
      tax = item.getPrice()*12.5/100;
      tax += (item.getPrice() + tax)*2/100;
      item.setTax(tax);

    }
  },
  IMPORTED{
    @Override
    public void calculateTax(ItemDetails item) {
      double tax;
      tax = item.getPrice()*10/100;
      if(tax + item.getPrice()<=100){
        tax = tax + 5;
      }
      else if(tax + item.getPrice()<=200){
        tax = tax + 10;
      }
      else {
        tax = tax + (item.getPrice() + tax)*5/100;
      }
      item.setTax(tax);
    }
  };
  public abstract void calculateTax(ItemDetails item);
}
