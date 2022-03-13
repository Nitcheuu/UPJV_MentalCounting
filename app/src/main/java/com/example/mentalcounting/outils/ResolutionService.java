package com.example.mentalcounting.outils;

import com.example.mentalcounting.models.OperationModel;
import com.example.mentalcounting.models.exceptions.DiviseException;
import com.example.mentalcounting.models.exceptions.OperatorException;
import com.example.mentalcounting.models.exceptions.ResultException;

public class ResolutionService {
    public static boolean verifierResultat(OperationModel operation, String reponse) throws OperatorException, ResultException, DiviseException {

        boolean resultat_ok;
        int resultat;

        resultat = new OperationsService().computeResult(operation);

        return String.valueOf(resultat).equals(reponse);
    }
}
