/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;

/**
 *
 * @author Numata
 */
public class Student {
    
    private String name;
    private int home, fal, lifeO, math, el1, el2, el3;
    
    
    public Student(String name, int home, int fal, int lifeO, int math,  int el1, int el2, int el3) {
        this.name = name;
        this.home = home;
        this.fal = fal;
        this.lifeO = lifeO;
        this.math = math;
        this.el1 = el1;
        this.el2 = el2;
        this.el3 = el3;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the home
     */
    public int getHome() {
        return home;
    }

    /**
     * @param home the home to set
     */
    public void setHome(int home) {
        this.home = home;
    }

    /**
     * @return the fal
     */
    public int getFal() {
        return fal;
    }

    /**
     * @param fal the fal to set
     */
    public void setFal(int fal) {
        this.fal = fal;
    }

    /**
     * @return the lifeO
     */
    public int getLifeO() {
        return lifeO;
    }

    /**
     * @param lifeO the lifeO to set
     */
    public void setLifeO(int lifeO) {
        this.lifeO = lifeO;
    }

    /**
     * @return the math
     */
    public int getMath() {
        return math;
    }

    /**
     * @param math the math to set
     */
    public void setMath(int math) {
        this.math = math;
    }

    /**
     * @return the el1
     */
    public int getEl1() {
        return el1;
    }

    /**
     * @param el1 the el1 to set
     */
    public void setEl1(int el1) {
        this.el1 = el1;
    }

    /**
     * @return the el2
     */
    public int getEl2() {
        return el2;
    }

    /**
     * @param el2 the el2 to set
     */
    public void setEl2(int el2) {
        this.el2 = el2;
    }

    /**
     * @return the el3
     */
    public int getEl3() {
        return el3;
    }

    /**
     * @param el3 the el3 to set
     */
    public void setEl3(int el3) {
        this.el3 = el3;
    }
    
    
    public String printData() {
        return name + "\n===============================\nHome Language: " + home + "\nFirst Additional Languages: " + fal + "\nLife Orientation: " + lifeO 
                + "\nMaths/Maths Literacy: " + math + "\nElective 1: " + el1 + "\nElective 2: " + el2 + "\nElective 3: " + el3 
                + "\n===============================";
    }
    
}
