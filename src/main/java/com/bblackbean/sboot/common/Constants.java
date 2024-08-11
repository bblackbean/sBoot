package com.bblackbean.sboot.common;

public class Constants {
    public enum ExceptionClass {
        // 상수 정의
        PRODUCT("Product"), ORDER("Order"), PROVIDER("Provider");

        private String exceptionClass;

        ExceptionClass(String exceptionClass) {this.exceptionClass = exceptionClass;}

        public String getExceptionClass() {return exceptionClass;}

        @Override
        public String toString() {return getExceptionClass() + " Exception. ";}
    }
}
