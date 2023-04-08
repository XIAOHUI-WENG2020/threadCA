/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadca;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static threadca.StandardDev.value;

/**
 *
 * @author xiaohui Weng
 *         2020387
 */
public class mulitMatrix extends Thread{
//    public mulitMatrix(){}
        /*
        task 2
        2.Assume the data is in the form of two square matrices, 
           one after another. Multiply the two matrices together
        ------
        a.Read arrayList.size() 
        b. split into two 2d arrays
        c. 2D array ,which arr[][]
        d. use loop to store the data into 2d array
        e. Find the format of multiplication
        */
    static int[][]matrix1 = new int[10][10];
    static int[][]matrix2 = new int[10][10];
    static int[][]result = new int [10][10];
    static int indexRow=0;
    static boolean Indexbounds = true;
    static int num;
    public void mulitMatrix(){
        File myFile = new File("data/data.csv");
        Scanner sc = null;
            try {
                sc = new Scanner(myFile);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(mulitMatrix.class.getName()).log(Level.SEVERE, null, ex);
            }
    //use loop to store the data into two 2d array as matrixes
    while(sc.hasNext()){
        String data = sc.nextLine();
        value = data.split(",");
        
        for(int indexColum=0; indexColum<value.length; indexColum++ ){               
            num = Integer.parseInt(value[indexColum].trim());
            if(Indexbounds){
                matrix1[indexRow][indexColum]=num;
            }else{
                matrix2[indexRow][indexColum]=num;
            } 
        }
        indexRow++;
         if (indexRow == 10 && Indexbounds) {
            Indexbounds = false;
            indexRow = 0;
        }
    }    
    //if need to, will be able print out 2 matrixes
        //System.out.println("----matrix 1:--- " );
//        for (int[] rows : matrix1) {
//            for (int col : rows) {
//                System.out.print(col + " |");
//            }
//            System.out.println();
//        }
//
//        System.out.println("----matrix 2:--- " );
//        for (int[] rows : matrix2) {
//            for (int col : rows) {
//                System.out.print(col + " |");
//            }
//            System.out.println();
//        }
        int sum=0;
        try {
            
            Thread.sleep(10);
        System.out.println("-----Answer Task2------");
        System.out.println("----matrix result:--- " );
        //mutilplication of two matrixes
        for(int i=0; i< 10; i++){
            for(int j=0; j < 10; j++){
                for(int k =0; k < 10; k++){
                    sum += matrix1[i][k] * matrix2[k][j];    
                }
                result[i][j]= sum;
                sum=0;  
            }
        }
        
        for (int[] rows : result) {
            for (int col : rows) {
                System.out.print(col + "| ");
            }
            System.out.println();
        }
        }catch (InterruptedException e) {
           e.printStackTrace();
        }
    }
    @Override
    public void run(){
       mulitMatrix();
    }
}

