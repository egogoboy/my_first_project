import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Action input = new Action();
        Array mass = new Array();
        mass.notCreated();
        Sort sort = new Sort();
        displayHello();
        do {
            input.userInput();
            switch (input.getAns()) {
                case ("manual") : input.displayManual(); break;
                case ("new array") :
                    if (mass.getStatus()) {
                        input.arrayIsAlreadyCreated();
                        input.userInput();
                        while (!input.getAns().equals("y") && !input.getAns().equals("n")) {
                            input.userInput();
                            input.displayError();
                        }
                        if (input.getAns().equals("n"))
                            break;
                    }
                    mass = new Array();
                    mass.createArray();
                break;
                case ("set array name"): mass.setName(); break;
                case ("set array size"): mass.setSize(); break;
                case ("set array"): mass.setElements(); break;
                case ("view array"): mass.displayArray(); break;
                case ("start sort"):
                    sort.insertionSort(mass); break;
                default : if (!input.getAns().equals("exit"))
                            input.displayError();
                break;
            }
        } while (!input.getAns().equals("exit"));

    }
    static void displayHello() {
        System.out.print("Welcome to my first project!\nIf you want to see manual, enter 'manual'\n" +
                "If you want to exit, enter 'exit'\n");
    }
}