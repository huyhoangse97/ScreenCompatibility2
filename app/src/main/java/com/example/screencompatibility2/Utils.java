package com.example.screencompatibility2;

public class Utils {

    public static String convertString(String weatherName) {
        String[] parts = weatherName.split("_");
        parts[0] = parts[0].substring(0, 1).toUpperCase() + parts[0].substring(1);
        StringBuilder result = new StringBuilder(parts[0]);
        for (int i = 1; i < parts.length; i++){
            parts[i] = parts[i].substring(0, 1).toUpperCase() + parts[i].substring(1);
            result.append(" ").append(parts[i]);
        }
        return result.toString();
    }
}
