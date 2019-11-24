package com.seiduAbbas.ecommerce.enums;

public enum ProductType {

        BOOK(   isMembership()),    VIDEO (isMembership()  );

        private static boolean membership ;

        ProductType(boolean membership) {
        this.setMembership(membership);
    }
        public static boolean isMembership() {
        return membership;
    }
        public void setMembership(boolean membership) {
        this.membership = membership;
    }
}
