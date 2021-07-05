package com.example.userregisteration.repository.util;

import java.util.regex.Pattern;

public class InputValidator {

    private static final Pattern sortCodePattern = Pattern.compile("^[0-9]{2}-[0-9]{2}-[0-9]{2}$");

    private static final Pattern accountNumberPattern = Pattern.compile("^[0-9]{8}$");

    public static boolean isSearchCriteriaValid(AccountUtil accountInput) {
        return sortCodePattern.matcher(accountInput.getSortCode()).find() &&
                accountNumberPattern.matcher(accountInput.getAccountNumber()).find();
    }

    public static boolean isSearchTransactionValid(TransactionUtil transactionUtil) {
        // TODO Add checks for large amounts; consider past history of account holder and location of transfers

        if (!isSearchCriteriaValid(transactionUtil.getSourceAccount()))
            return false;

        if (!isSearchCriteriaValid(transactionUtil.getTargetAccount()))
            return false;

        if (transactionUtil.getSourceAccount().equals(transactionUtil.getTargetAccount()))
            return false;

        return true;
    }
}