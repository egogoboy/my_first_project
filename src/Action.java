import java.util.Scanner;

public class Action {
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
