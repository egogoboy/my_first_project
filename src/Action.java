import java.util.Scanner;

public class Action {
    private final Scanner in = new Scanner(System.in);
    private String user;
    private int user_int;
    public Action() {
        System.out.print("user actions is ready to use\n");
    }
    public void userInputString() {
        System.out.print("> ");
        user = in.nextLine();
    }
    public void userInputInt() {
        user_int = in.nextInt();
    }

    public int getIntAns(){
        return user_int;
    }
    public String getStringAns() { return user; }
    public void displayError() {
        System.out.print("Unknown command X(\n");
    }
    public void arrayIsAlreadyCreated() {
        System.out.print("The array has already been created. Do you want to delete the current array and create a new one?[y/n]\n");
    }
    public void displayManual() {
        System.out.print("""
                -----Manual-----
                new array : deletes the old array and creates a completely new one
                set array name : sets the name of the current array
                set array size : sets the size of the current array (this will destroy all the elements!)
                set array : set array elements
                view array : outputs the contents of the current array
                start sort : starts sorting the array
                exit : breaks the program
                """);
    }
}
