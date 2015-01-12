package com.shop.utils;

import java.util.Collection;


public class IdUtil {

    public static boolean isValidId(Object id) {
        if (id == null) return false;
        if (!(id instanceof Long)) return false;
        if (((Long)id).longValue() == 0) return false;
        return true;
    }

    public static Long toId(Object id) {
        if (id == null) return null;
        if (id instanceof Long) return (Long)id;
        if (id instanceof String) {
            try {
                return new Long((String) id);
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return null;
    }

   // Utility methods
    public static boolean isNotNullNorEmpty(String inputString){
        return ( (inputString != null) && (!inputString.trim().equals("")) );
    }

    public static boolean isNotNull(Object object){
        return (object != null);
    }

    public static boolean isNull(Object object){
        return object == null;
    }

    public static boolean isNonZeroLong(Long value){
        return (value != null && value.intValue() != 0 );
    }

    public static boolean isNonZeroPositiveLong(Long value){
        return (value != null && value.intValue() > 0 );
    }

    /**
     * Returns primitive boolean value of Boolean input,
     * and false for null Boolean input value.
     *
     * @param boole
     * @return boolean
     */
    public static boolean booleanValue(Boolean boole){
        if(boole != null) return boole.booleanValue();

        return false;
    }

    public static boolean isBothTrue(Boolean oneBoolean, Boolean anotherBoolean ){
        return booleanValue(oneBoolean) && booleanValue(anotherBoolean);
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || "".equals(str.trim());
    }

    public static Long toLong(Object number) {
        if (number == null) return null;
        if (number instanceof Long) return (Long)number;
        if (number instanceof String) {
            try {
                return new Long((String) number);
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return null;
    }

    public static Integer toInteger(Object number) {
        if (number == null) return null;
        if (number instanceof Integer) return (Integer)number;
        if (number instanceof String) {
            try {
                return new Integer((String) number);
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return null;
    }

    /**
     * Null safe check for Collection 
     * @param collection
     * @return  boolean
     */
    public static boolean isNotEmpty(Collection collection){
        return ( ( !isNull(collection) ) && (!collection.isEmpty()) );
    }
}
