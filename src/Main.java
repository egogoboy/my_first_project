public class Main {
    public static void main(String[] args) {
        Action input = new Action();
        Array mass = new Array();
        mass.notCreated();
        displayHello();
        do {
            input.userInputString();
            switch (input.getStringAns()) {
                case ("manual") :
                    input.displayManual();
                break;
                case ("new array") :
                    if (mass.getCreatedStatus()) {
                        input.arrayIsAlreadyCreated();
                        input.userInputString();
                        while (!input.getStringAns().equals("y") && !input.getStringAns().equals("n")) {
                            input.userInputString();
                            input.displayError();
                        }
                        if (input.getStringAns().equals("n"))
                            break;
                    }
                    mass = new Array();
                    mass.createArray();
                break;
                case ("set array name"):
                    if (mass.getName().equals("null")) {
                        System.out.print("The array already has a name. Are you sure you want to rename it? [y/n]\n");
                        input.userInputString();
                        while (!input.getStringAns().equals("y") && !input.getStringAns().equals("n")) {
                            input.userInputString();
                            input.displayError();
                        }
                    }
                    if (input.getStringAns().equals("y") || !mass.getName().equals("null")) {

                        mass.setName();
                    }
                    break;
                case ("set array size"):
                    if (mass.getSize() != 0) {
                        System.out.print("The size of the array has already been set. do you want to change it?" +
                                " (this will destroy all the elements!) [y/n]\n");
                        input.userInputString();
                        while (!input.getStringAns().equals("y") && !input.getStringAns().equals("n")) {
                            input.userInputString();
                            input.displayError();
                        }
                    }
                    if (input.getStringAns().equals("y") || mass.getSize() == 0)
                        mass.setSize();
                    break;
                case ("set array"):
                    if (mass.getElementStatus()) {
                        System.out.print("The array is already filled. Do you want to fill it out again? [y/n]\n");
                        input.userInputString();
                        while (!input.getStringAns().equals("y") && !input.getStringAns().equals("n")) {
                            input.userInputString();
                            input.displayError();
                        }
                        if (input.getStringAns().equals("y"))
                            mass.setElements();
                    }
                    if (input.getStringAns().equals("y") || !mass.getElementStatus())
                        mass.setElements();
                break;
                case ("view array"): mass.displayArray(); break;
                case ("start sort"):
                    Sort sort = new Sort();
                    sort.inputData(mass);
                    sort.insertionSort(mass);
                break;
                default : if (!input.getStringAns().equals("exit"))
                            input.displayError();
                break;
            }
        } while (!input.getStringAns().equals("exit"));

    }
    static void displayHello() {
        System.out.print("""
                Welcome to my first project!
                If you want to see manual, enter 'manual'
                If you want to exit, enter 'exit'
                """);
    }
}