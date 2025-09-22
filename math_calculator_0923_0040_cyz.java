// 代码生成时间: 2025-09-23 00:40:46
package com.example.mathcalculator;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.util.Map;

/**
 * ManagedBean for the Math Calculator application using JSF.
 * This class provides methods for performing basic mathematical operations.
 */
@ManagedBean
@RequestScoped
public class MathCalculator {
    private double number1;
    private double number2;
    private String operation;
    private double result;

    /**
     * Default constructor.
     */
    public MathCalculator() {
    }

    /**
     * Getter for the first number.
     * @return the first number.
     */
    public double getNumber1() {
        return number1;
    }

    /**
     * Setter for the first number.
     * @param number1 the first number to set.
     */
    public void setNumber1(double number1) {
        this.number1 = number1;
    }

    /**
     * Getter for the second number.
     * @return the second number.
     */
    public double getNumber2() {
        return number2;
    }

    /**
     * Setter for the second number.
     * @param number2 the second number to set.
     */
    public void setNumber2(double number2) {
        this.number2 = number2;
    }

    /**
     * Getter for the operation to be performed.
     * @return the operation.
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Setter for the operation.
     * @param operation the operation to set.
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /**
     * Getter for the result of the operation.
     * @return the result.
     */
    public double getResult() {
        return result;
    }

    /**
     * Performs the mathematical operation based on the selected operation.
     * @return the navigation outcome for the JSF page.
     */
    public String calculate() {
        try {
            switch (operation) {
                case "add":
                    result = number1 + number2;
                    break;
                case "subtract":
                    result = number1 - number2;
                    break;
                case "multiply":
                    result = number1 * number2;
                    break;
                case "divide":
                    if (number2 != 0) {
                        result = number1 / number2;
                    } else {
                        FacesContext.getCurrentInstance().addMessage(null,
                                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Cannot divide by zero."));
                        return "error";
                    }
                    break;
                default:
                    FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Invalid operation."));
                    return "error";
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "An error occurred during calculation."));
            return "error";
        }

        return "success";
    }
}
