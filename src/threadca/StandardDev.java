/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadca;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xiaohui Weng
 *         2020387
 */
public class StandardDev implements Runnable{   

        /*
        task1
        1. Find the standard deviation of the data.
        -------------
        a.Read a CVS file
        b.FileRead
        c.Filename
        d.Split data by ‘,’
        e.Use loop to store all data from data file into the ArrayList
         */     
    protected static File myFile = new File("data/data.csv");
    static float total = 0;
    float ave; //average or mean
    protected static int n =0;//the number of data points
    int sumDev=0;
    protected static String [] value;
    int num;
    protected static ArrayList<Integer> arr = new ArrayList<>();
    protected static Scanner myReader = null;
    public void StandardDev(){
        //System.out.println("Thread id :" +id);
        try {
            myReader = new Scanner(myFile);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StandardDev.class.getName()).log(Level.SEVERE, null, ex);
        }try{
            while(myReader.hasNext()){
                String data = myReader.nextLine();
                value = data.split(","); 

                for(int i =0; i<value.length; i++){
                    num = Integer.parseInt(value[i].trim());
                    arr.add(num);
                    //System.out.println(num);
                    total += num;
                    n ++;                          
        }
    }       
            //System.out.println("total: " + total);
            //System.out.println("n: " + n);
            ave = total/ n;
            //System.out.println("average of numbers:"  + ave);
            for(int i =0; i< n; i++){
              sumDev += (int) Math.pow(arr.get(i) - ave, 2);
              //get  ∑   
            }
            //standard deviation: the square root of 1/n * sumDev
            float SD= (float) Math.sqrt((sumDev/(n-1)));
            System.out.println("-----Answer Task1------");
            System.out.println("standard Deviation of data CSV File about " + String.format("%.2f", SD));
            System.out.println();
    }catch(NumberFormatException e){
            System.out.println("Invalida number format: " + e.getMessage());
        }
        
    }
    
    @Override
    public void run(){
        
        StandardDev();
    }  

} 
