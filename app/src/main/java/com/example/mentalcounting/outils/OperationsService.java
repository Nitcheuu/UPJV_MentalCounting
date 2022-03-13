package com.example.mentalcounting.outils;


import com.example.mentalcounting.models.OperationModel;
import com.example.mentalcounting.models.exceptions.DiviseException;
import com.example.mentalcounting.models.exceptions.OperatorException;
import com.example.mentalcounting.models.exceptions.ResultException;

import java.io.Console;

public class OperationsService {

    public int computeResult(OperationModel operation)
            throws ResultException, DiviseException, OperatorException {
        String firstValueAsString = operation.getFirstValue();
        String secondValueAsString = operation.getSecondValue();
        String operator = operation.getOperator();

        int firstValue;
        int secondValue;
        System.out.println("Etape 1");
        try {
            firstValue = Integer.parseInt(firstValueAsString);
            secondValue = Integer.parseInt(secondValueAsString);
        } catch(NumberFormatException ex){
            throw new ResultException("values are not numbers", ex);
        }

        int result;

        System.out.println("Opération : " + firstValue + operator + secondValue);
        switch (operator) {
            case "+":
                result = firstValue + secondValue;
                break;
            case "-":
                result = firstValue - secondValue;
                break;
            case "x":
                result = firstValue * secondValue;
                break;
            case "/":
                if(secondValue == 0) {
                    throw new DiviseException("divise by 0");
                }

                result = firstValue / secondValue;
                break;
            default:
                throw new OperatorException("operator invalid");
        }

        return result;
    }
}
