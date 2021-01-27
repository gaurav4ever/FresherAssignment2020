package org.nuclei.serviceImpl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class importTaxServiceTest {

    @Test
    void calculateTax() {
    double tax,testTax;
        testTax=8;
        int price =30;
        tax = price*10/100;
        if(tax + price<=100){
            tax = tax + 5;
        }
        else if(tax + price<=200){
            tax = tax + 10;
        }
        else {
            tax = tax + (price + tax)*5/100;
        }
        assertEquals(testTax,tax);
    }

}