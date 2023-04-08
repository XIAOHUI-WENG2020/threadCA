/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadca;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static threadca.StandardDev.*;




/**
 *
 * @author xiaohui Weng
 *         2020387
 */
public class sortData extends Thread {
    /*
    Task 3
    Use merge sort to sort the data from largest to smallest
    a. covevt arrayList into an new Array
    b. split data
    c. compare the value, if value greater or smaller than the other
       will need to asgin the value into the new array[]
    c. print out value
    */
    public sortData(){};
        @Override
    public void run(){
       //synchronized(StandardDev){
        try {
            Thread.sleep(70);
            sort();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(sortData.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
            
    }
    public static void sort() throws FileNotFoundException{
        int [] sort= new int [arr.size()];
        for(int i =0; i<n; i++){
            sort[i]=arr.get(i);
            }
        mSort(sort,0,sort.length-1);
        System.out.println();
        System.out.println("-----Answer Task3------");
        System.out.println("Data already sorted ftom largest to smallest");
        for(int x =0; x < sort.length; x++){
            System.out.println(sort[x]);
        }
        System.out.println("--------Task3-----------");
    }

    private static void mSort(int[] sort, int low, int high) {
        if(low < high){
            int mid = (low + high) /2 ;
            mSort(sort, low , mid);
            mSort(sort, mid+1, high);
            merge(sort, low, mid, high);
        }
    }
    private static void merge(int[] sort, int low, int mid, int high) {
        int i = low;
        int j = mid+1;
        int k = low;
        int [] b = new int[sort.length];
        
        while(i <= mid && j <= high){
            if(sort[i] < sort[j]){
                b[k] = sort[j];
                
                j++;
                k++;
            }else{
                b[k] = sort[i];
                i++;
                k++;
            }
        }

        while(i <= mid){
            b[k] = sort[i];
            i++;
            k++;
        }
        while(j <= high){
            b[k] = sort[j];
            j++;
            k++;
        }
        
        for(i= low; i<=high; i++){
            sort[i] =b[i];
        }
    }

}
