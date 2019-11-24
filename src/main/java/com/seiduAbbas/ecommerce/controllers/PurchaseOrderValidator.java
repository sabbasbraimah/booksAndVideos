package com.seiduAbbas.ecommerce.controllers;

import com.seiduAbbas.ecommerce.domain.PurchaseOrdering;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.util.StringUtils;


    public class PurchaseOrderValidator implements Validator {

        private static final String REQUIRED = "required";

        @Override
        public boolean supports(Class<?> aClass) {
            return PurchaseOrdering.class.isAssignableFrom(aClass);
        }

        public void validate(Object obj, Errors errors) {
            PurchaseOrdering purchaseOrdering = (PurchaseOrdering) obj;
            Long id = purchaseOrdering.getId();
            // id validation
            if (id == null) {
                errors.rejectValue("id", REQUIRED, REQUIRED);
            }

            // totalCost validation
            if (purchaseOrdering.getTotalCost() == null) {
                errors.rejectValue("totalCost", REQUIRED, REQUIRED);
            }
            // customerID validation
            if (purchaseOrdering.getCustomerId() == null) {
                errors.rejectValue("customerID", REQUIRED, REQUIRED);
            }
    }
}