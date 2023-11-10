import java.io.IOException;
import java.util.Scanner;

public class Array {
    Scanner in = new Scanner(System.in);
    static int size;
    static int[] nums;
    static String name;
    private Action input = new Action();
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
