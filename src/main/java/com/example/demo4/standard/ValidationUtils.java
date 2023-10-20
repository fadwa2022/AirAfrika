package com.example.demo4.standard;

import java.util.regex.Pattern;

public class ValidationUtils {
        public boolean isValidString(String str) {
            return str != null && !str.trim().isEmpty();
        }
        public boolean isValidEmail(String email) {
            String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
            return Pattern.matches(emailRegex, email);
        }

        public boolean isValidTelephone(String telephone) {
            if (!isValidString(telephone) || telephone.length() < 10 || telephone.length() > 15) {
                return false;
            }

            if (!telephone.matches("^[0-9-+]+$")) {
                return false;
            }

            return true;
        }
}
