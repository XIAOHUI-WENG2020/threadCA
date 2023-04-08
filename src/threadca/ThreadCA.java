/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package threadca;

import java.io.FileNotFoundException;


/**
 *
 * @author xiaohui Weng
 *         2020387
 */
public class ThreadCA {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     
     */
    
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        //st1.run();;
        Thread task1 = new Thread(new StandardDev() );
        Thread task2 = new Thread(new mulitMatrix() );
        Thread task3 = new Thread(new sortData() );

        task1.start();
        task2.start();
        task3.start();
    }    
}
    

