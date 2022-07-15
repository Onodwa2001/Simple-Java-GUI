/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Numata
 */
public class Test {
    
    public static void main(String[] args) {
        
        Student st = new Student("Onodwa Siyotula", 65, 78, 45, 87, 43, 89, 43);
        Student st1 = new Student("Likho Dyantyi", 65, 78, 45, 87, 43, 89, 43);
        
        FileHandler fh = new FileHandler("file.txt");
        fh.writeToFile(st.printData());
        fh.close();
        
        
        
    }
    
}
