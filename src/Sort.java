public class Sort {

    private final Action user;
    private int start;
    private int stop;
    private String option;
    public Sort() {
        user = new Action();
    }

    public void inputData(Array mass) {
        System.out.print("Enter option (>, <): ");
        this.user.userInputString();
        option = user.getStringAns();
        while (!option.equals(">") && !option.equals("<") && !option.equals(">=") && !option.equals("<=")) {
            System.out.print("Unknown command X(\n");
            System.out.print("Enter option (>, <): ");
            user.userInputInt();
            option = user.getStringAns();
        }
        System.out.print("!!!Indexing starts with 1!!!\n");
        System.out.print("Enter start index: ");

        user.userInputInt();
        start = user.getIntAns();
        while (start < 1 || start > mass.getSize()) {
            System.out.print("Invalid value! (1 <= start <= " + mass.getSize() + ")\nEnter start index: ");
            user.userInputInt();
            start = user.getIntAns();
        }
        System.out.print("Enter end index: ");
        user.userInputInt();
        stop = user.getIntAns();
        while (stop < 0 || stop > mass.getSize() || stop < start) {
            System.out.print("Invalid value! (" + start + " <= end <= " + mass.getSize() + ")\nEnter end index: ");
            user.userInputInt();
            stop = user.getIntAns();
        }
    }
    public void insertionSort(Array mass) {
        int index = start, temp;
        while (index < stop) {
            temp = mass.getElement(index);
            for (int i = index; i >= start - 1; --i) {
                if (i == start - 1) {
                    mass.changeElement(i, temp);
                } else
                    switch (option) {
                        case (">"):
                            if (mass.getElement((i - 1)) > temp) {
                                mass.swapElements((i - 1), i);
                            }
                            else {
                                mass.changeElement(i, temp);
                                break;
                            }
                            break;
                        case ("<"):
                            if (mass.getElement((i - 1)) < temp) {
                                mass.swapElements((i - 1), i);
                            }
                            else {
                                mass.changeElement(i, temp);
                                break;
                            }
                            break;
                    }
            }
            index++;
        }
        System.out.print("Sort has been completed successfully!\n");
    }
}
