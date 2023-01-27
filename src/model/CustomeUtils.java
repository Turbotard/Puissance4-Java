package model;

import java.text.ParseException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomeUtils {
    /**
     * Récupère la chaine de caractères saisie par l'utilisateur
     *
     * @return La chaine de caractères saisie par l'utilisateur
     */
    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();
            return userInput;
        
    }
    public static String matchValue(String value, String pattern, String errorMessage) throws ParseException {
        Pattern pat = Pattern.compile(pattern);
        Matcher matcher = pat.matcher(value);

        if (matcher.matches()) {
            return value;
        } else {
            ParseException e = new ParseException(errorMessage, 0);
            throw e;
        }
    }
}