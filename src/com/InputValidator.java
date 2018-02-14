package com;

import com.Option;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputValidator {
    private Scanner input = new Scanner(System.in);

    private float NewFloat() {
        float Value;
        try {
            Value=input.nextFloat();
            input.next();
            return Value;
        }
        catch (NumberFormatException | InputMismatchException e){
            System.err.println("Your enter is not valid. Please try again.");
            input.next();
            return NewFloat();
        }
    }

    private float getArg(String arg){
        float Value;
        try {
            Value = Float.parseFloat(arg);
            return Value;
        }
        catch (NumberFormatException | InputMismatchException e){
            System.err.println("Your enter " +arg+ " is not valid. Please try again. (If input more than one element just the first one will be considered)");
            return NewFloat();
        }
    }

    private String[] insertString() {
        System.out.println("Insert Your Inputs with a space between the values");
        String toSplit = input.nextLine();
        return toSplit.split(" ");
    }

    public float[] validateArgs(String[] args) {
        float[] values = new float[args.length];
        if (args.length < 2 || args.length > 4) {
           System.err.println("Incorrect number of arguments: " + args.length);
           return validateArgs(insertString());
        }
        for (int i = 0; i < args.length; i++) {
            values[i] = getArg(args[i]);
        }
        return values;
    }

    public float[] newFloatArgs() {
        return validateArgs(insertString());
    }

    public Option getOption() {
        String str = input.nextLine();
        str = str.trim();
        try {
            int value = Integer.parseInt(str);
            if(value < 1 || value > 7 ){
                System.err.println("Your enter is not valid. Please try again.");
                return getOption();
            }
            else {
                return Option.fromCode(value);
            }
        } catch (NumberFormatException | InputMismatchException e) {
            System.err.println("Your enter is not valid. Please try again.");
            return getOption();
        }
    }
}
