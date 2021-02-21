// CalcService.aidl
package com.example.mycalcapp;

// Declare any non-default types here with import statements

interface CalcService {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

           int add(int valOne, int valTwo);
           int subtract(int valOne, int valTwo);
           int multiply(int valOne, int valTwo);
           int divide(int valOne, int valTwo);

}