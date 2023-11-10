import java.io.IOException;
import java.util.Scanner;

public class Sort {
    static Scanner in = new Scanner(System.in);
    public static void insertionSort(Array m) throws IOException {
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
