package com.co.pa;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    public static final char OPEN_PARENTHESES = '(';
    public static final char CLOSE_PARENTHESES = ')';
    public static final char OPEN_SQUARE_BRACKETS = '[';
    public static final char CLOSE_SQUARE_BRACKETS = ']';
    public static final char OPEN_BRACES = '{';
    public static final char CLOSE_BRACES = '}';

    public static Deque<Character> parentheses = new ArrayDeque<>();
    public static Deque<Character> squareBrackets = new ArrayDeque<>();
    public static Deque<Character> braces = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        System.out.println(isValidParentheses(line.trim()));
    }

    public static boolean isValidParentheses(String line){
        if (Boolean.TRUE.equals(firstValidation(line))) return false;
        for(int i = 0; i < line.length(); i++) validateChar(line.charAt(i));
        return parentheses.isEmpty() && squareBrackets.isEmpty() && braces.isEmpty();
    }

    public static boolean firstValidation(String line){
        boolean startWithClose = startWithClose(line);
        boolean endsWithOpen = endsWithOpen(line);
        return startWithClose && endsWithOpen;
    }

    public static boolean startWithClose(String line){
        char start = line.charAt(0);
        return start == CLOSE_PARENTHESES || start == CLOSE_BRACES || start == CLOSE_SQUARE_BRACKETS;
    }

    public static boolean endsWithOpen(String line){
        int length = line.length() -1;
        char end = line.charAt(length);
        return end == OPEN_PARENTHESES || end == OPEN_BRACES || end == OPEN_SQUARE_BRACKETS;
    }

    public static void validateChar(char aux){
        if(aux == OPEN_PARENTHESES || aux == CLOSE_PARENTHESES) validateParentheses(aux);
        else if(aux == OPEN_BRACES || aux == CLOSE_BRACES) validateBraces(aux);
        else if(aux == OPEN_SQUARE_BRACKETS || aux == CLOSE_SQUARE_BRACKETS) validateSquareBrackets(aux);
    }

    private static void validateParentheses(char aux) {
        if(aux == OPEN_PARENTHESES) parentheses.addFirst(aux);
        else {
            if(parentheses.isEmpty()) parentheses.addLast(aux);
            else parentheses.removeFirst();
        }
    }

    private static void validateBraces(char aux) {
        if(aux == OPEN_BRACES) braces.addFirst(aux);
        else {
            if(braces.isEmpty()) braces.addLast(aux);
            else braces.removeFirst();
        }
    }

    private static void validateSquareBrackets(char aux) {
        if(aux == OPEN_SQUARE_BRACKETS) squareBrackets.addFirst(aux);
        else {
            if(squareBrackets.isEmpty()) squareBrackets.addLast(aux);
            else squareBrackets.removeFirst();
        }
    }
}


