/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Numata
 */
public class FileHandler {
    
    String fileName;
    FileReader fr;
    BufferedReader br;
    FileWriter fw;
    BufferedWriter bw;
    
    public FileHandler(String fileName) {
        try {
            this.fileName = fileName;
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
        } catch(FileNotFoundException fnf) {
            System.out.println("New file " + fileName + " will be created");
        }
    }
    
    public void writeToFile(String data) {
        try {
            fw = new FileWriter(fileName);
            bw = new BufferedWriter(fw);
            
            bw.append(data);
        } catch(IOException io) {
            System.out.println("An error occurred");
        }
    }
    
    public void close() {
        try {
            br.close();
            bw.close();
            
            fr.close();
            fw.close();
        } catch(IOException io){
            System.out.println("An error occurred");
        }
    }
}
