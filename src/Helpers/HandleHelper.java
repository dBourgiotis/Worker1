/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import worker.Worker1;

/**
 *
 * @author dimbourgiotis
 */
public  class HandleHelper {
    
    public static HashMap workerHas = new HashMap();//saves keys and values
   
    
    public static String getValue(String key){
        //exei ginei elegxos prin thn klhsh gia to an uparxei
        String value = new String();
        
        value = workerHas.get(key).toString();
        
        //
        return value;
    }
    
    public static void saveInFileWorker(String key, String value ){
        File yourFile = new File("worker.txt");
        if(!yourFile.exists()) {
            try {
                yourFile.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Worker1.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        try { 
            FileOutputStream oFile = new FileOutputStream(yourFile, false);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Worker1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try
        {
            FileWriter fw = new FileWriter("worker.txt",true); //the true will append the new data
            fw.write(key+"~"+value+"\n");//appends the string to the file
            fw.close();
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }

    } 
    
   
    
    
    public static void loadWorker(){
        File yourFile = new File("worker.txt");
        ArrayList<String> temp = new ArrayList<String>();
        if(yourFile.exists()){
            try {
                Scanner scan = new Scanner(yourFile);                
                while (scan.hasNextLine()) {
                       temp.add(scan.nextLine());
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Worker1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(!temp.isEmpty()){
            for(int i = 0 ; i< temp.size(); i ++){
                String string = temp.get(i);
                String[] parts = string.split("~");
                String key = parts[0];
                String value = parts[1];
                workerHas.put(key, value);
            }
        }
    }
    
   
}
