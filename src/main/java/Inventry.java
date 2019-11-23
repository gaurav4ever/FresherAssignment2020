/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akash
 */
import java.io.*;
public class Inventry {
    
    //Global Declaration
    public static String itemName[] = new String[100];
    public static int quantity[] = new int[100];
    public static int type[] = new int[100];
    public static int price[] = new int[100];
    public static double taxedPrice[] = new double[100];
    public static double tax, importDuty, payAmount=0.0;
    static final double taxRate = .125;
    public static int numElements,i;
     
    public static void readInput()throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char moreDetailCheck;
        Boolean flag =true;
        
        for(i=0;flag;i++)
        {
            System.out.println("Enter Name, Price, Quantity and Type(1 for Raw, 2 for Manifactured, 3 for Imported )");
            itemName[i] = br.readLine();
            price[i] = Integer.parseInt(br.readLine());
            quantity[i] = Integer.parseInt(br.readLine());
            type[i] = Integer.parseInt(br.readLine());
            //Check
            System.out.println("Do you want to enter details of any other item (y/n):");
            moreDetailCheck = br.readLine().charAt(0);
            if(moreDetailCheck == 'n' || moreDetailCheck == 'N')
                flag = false;
        }
        numElements=i-1;
    }
    public static void taxCalculation()
    {
        for(i=0;i<=numElements;i++)
        {
            switch(type[i])
            {
                case 1: tax  = taxRate * price[i];
                        taxedPrice[i] = tax + price[i];
                        break;

                case 2:tax  = taxRate * price[i];
                       taxedPrice[i] = tax + .02 * (tax+price[i]) + price[i];  
                       break;

                case 3:importDuty = .1 * price[i];
                       tax = taxRate * price[i];
                       taxedPrice[i] = price[i] + importDuty + tax;
                       if(taxedPrice[i] <= 100)
                            taxedPrice[i] += 5;
                       else if(taxedPrice[i] > 100 && taxedPrice[i] <=200)
                            taxedPrice[i] += 10;
                       else
                            taxedPrice[i] += .05 * taxedPrice[i];
            }
            payAmount = taxedPrice[i]*quantity[i]+payAmount;
        }
        

    }
    public static void printDetails()
    {
        
        System.out.println("__________________________________________________________________________________________________________________");
        System.out.println("Name"+ "\t" + "Price" + "\t" + "Quantity" + "\t" + "Type" + "\t" + "Final Price");
        System.out.println("__________________________________________________________________________________________________________________");
        for(i=0;i<=numElements;i++)
        {
            System.out.println();
            System.out.println( itemName[i] + "\t" +  price[i]  + "\t" +  quantity[i]  + "\t\t" +  type[i] + "\t" + taxedPrice[i]);
        }
        System.out.println("__________________________________________________________________________________________________________________");
        System.out.println("Total \t\t\t\t" + payAmount);
    }
}
