import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        actions input = new actions();
        array mass = new array();
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
                    mass = new array();
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

class actions {
    static String user;
    {
        System.out.print("user actions is ready to use\n");
    }
    public void userInput(){
        Scanner in = new Scanner(System.in);
        System.out.print("> ");
        user = in.nextLine();
    }
    public String getAns(){
        return this.user;
    }
    public void displayError() {
        System.out.print("Unknown command X(\n");
    }
    public void arrayIsAlreadyCreated() {
        System.out.print("The array has already been created. Do you want to delete the current array and create a new one?[y/n]\n");
    }
    public void displayManual() {
        System.out.print("-----Manual-----\n" +
                "new array : deletes the old array and creates a completely new one\n" +
                "set array name : sets the name of the current array\n" +
                "set array size : sets the size of the current array (this will destroy all the elements!)\n" +
                "set array : set array elements\n" +
                "view array : outputs the contents of the current array\n" +
                "start sort : starts sorting the array\n" +
                "exit : breaks the program\n");
    }
}
class Sort {
    static Scanner in = new Scanner(System.in);
    public static void insertionSort(array m) throws IOException{
        System.out.print("Enter option (>, <): ");
        String option = in.next();
        while (!option.equals(">") && !option.equals("<") && !option.equals(">=") && !option.equals("<=")) {
            System.out.print("Unknown command X(\n> ");
            option = in.next();
        }
        System.out.print("!!!Indexing starts with 1!!!\n");
        System.out.print("Enter start index: ");
        int start = in.nextInt();
        System.out.print("Enter end index: ");
        int stop = in.nextInt();
        int ind = start, temp = m.getElement(ind);
        while (ind < stop) {
            temp = m.getElement(ind);
            for (int i = ind; i >= start - 1; --i) {
                if (i == start - 1) {
                    m.changeElement(i, temp);
                } else
                    switch (option) {
                        case (">"):
                            if (m.getElement((i - 1)) > temp) {
                                m.swapElements((i - 1), i);
                            }
                            else {
                                m.changeElement(i, temp);
                                break;
                            }
                        break;
                        case ("<"):
                            if (m.getElement((i - 1)) < temp) {
                                m.swapElements((i - 1), i);
                            }
                            else {
                                m.changeElement(i, temp);
                                break;
                            }
                        break;
                    }
            }
            ind++;
        }
        System.out.print("Sort has been completed successfully!\n");
    }
}
class array{
    Scanner in = new Scanner(System.in);
    static int size;
    static int[] nums;
    static String name;
    private actions input = new actions();
    static boolean created = false, elements = false;
    {
        this.size = 0;
        name = "null";
        created = true;
        elements = false;
        System.out.print("array created successfully!\n");
    }
    public void createArray() throws IOException {
        setName();
        setSize();
        nums = new int[size];
        setElements();
    }
    public void setElements() throws IOException {
        if (!elements) {
            System.out.print("Enter new elements of " + name + ": ");
            elements = true;
            for (int i = 0; i < size; ++i) {
                nums[i] = in.nextInt();
            }
            System.out.print("The array has been filled successfully!\n");
        }
        else {
            System.out.print("The array is already filled. Do you want to fill it out again? [y/n]\n");
            input.userInput();
            while (!input.getAns().equals("y") && !input.getAns().equals("n")) {
                input.userInput();
                input.displayError();
            }
            if (input.getAns().equals("y")) {
                System.out.print("Enter new elements of " + name + ": ");
                elements = true;
                for (int i = 0; i < size; ++i) {
                    nums[i] = in.nextInt();
                }
                System.out.print("The array has been filled successfully!\n");
            }
        }
    }
    public void setSize() throws IOException{
        System.out.print("Enter new size of " + name + ": ");
        int size = in.nextInt();
        if (this.size == 0) {
            this.size = size;
            System.out.print("New size of array: " + this.size + "\n");
        }
        else {
            System.out.print("The size of the array has already been set. do you want to change it?" +
                    " (this will destroy all the elements!) [y/n]\n");
            input.userInput();
            while (!input.getAns().equals("y") && !input.getAns().equals("n")) {
                input.userInput();
                input.displayError();
            }
            if (input.getAns().equals("y")) {
                this.size = size;
                elements = false;
                System.out.print("New size of array: " + this.size + "\n");
            }
        }
        nums = new int[this.size];

    }
    public void setName() throws IOException{
        System.out.print("Enter the new name of array: ");
        String name = in.next();
        while (name.equals("null")) {
            System.out.print("You cannot use this name!\nEnter the new name of array: ");
            name = in.next();
        }
        if (this.name.equals("null")) {
            this.name = name;
            System.out.print("New name of array: " + this.name + "\n");
        }
        else {
            System.out.print("The array already has a name. Are you sure you want to rename it? [y/n]\n");
            input.userInput();
            while (!input.getAns().equals("y") && !input.getAns().equals("n")) {
                input.userInput();
                input.displayError();
            }
            if (input.getAns().equals("y")) {
                this.name = name;
                System.out.print("New name of mass: " + this.name + "\n");
            }
        }
    }
    public int getSize() {
        return this.size;
    }
    public int getElement(int ind) {
        return nums[ind];
    }
    public boolean getStatus() {
        return created;
    }
    public int[] getArray() {
        return this.nums;
    }
    public void changeElement(int ind, int temp) {
        nums[ind] = temp;
        return;
    }
    public void swapElements(int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
        return;
    }
    public void displayArray() {
        System.out.print("Name of array: " + name +
                "\nSize of array: " + size +
                "\nElements of array: ");
        for (int i = 0; i < size; ++i)
            System.out.print(nums[i] + " ");
        System.out.print("\n");
    }
    public void notCreated() {
        created = false;
    }
}