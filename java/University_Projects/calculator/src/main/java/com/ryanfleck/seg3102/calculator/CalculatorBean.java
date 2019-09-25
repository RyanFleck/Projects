/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ryanfleck.seg3102.calculator;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author rflec028
 */
@Named(value = "calculatorBean")
@SessionScoped
public class CalculatorBean implements Serializable {

    private double valueA;
    private double valueB;

    private double result;

    /**
     * Creates a new instance of CalculatorBean
     */
    public CalculatorBean() {
        System.out.println("CalculatorBean created.");
    }

    public String add() {
        this.result = this.valueA + this.valueB;
        return "result";
    }
    
    public String subtract() {
        this.result = this.valueA - this.valueB;
        return "result";
    }
    
    public String multiply(){
        this.result = this.valueA * this.valueB;
        return "result";
    }
    
    public String divide(){
        this.result = this.valueA / this.valueB;
        return "result";
    }

    /*
     * Getters and setters:
     */
    public double getResult() {
        return result;
    }

    public void setResult(double x) {
        this.result = x;
    }

    public void setValueA(double x) {
        this.valueA = x;
    }

    public void setValueB(double x) {
        this.valueB = x;
    }

    public double getValueA() {
        return valueA;
    }

    public double getValueB() {
        return valueB;
    }

}
