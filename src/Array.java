public class Array {
    private int size;
    private int[] mass;
    private String name;
    private boolean created;
    private boolean elements;
    public Array() {
        size = 0;
        name = "null";
        created = true;
        elements = false;
        System.out.print("array created successfully!\n");
    }

    public void createArray() {
        setName();
        setSize();
        setElements();
    }
    public void setElements() {
        System.out.print("Enter new elements of " + name + ": ");
        elements = true;
        Action values = new Action();
        for (int i = 0; i < size; ++i) {
            values.userInputInt();
            mass[i] = values.getIntAns();
        }
        System.out.print("The array has been filled successfully!\n");
    }
    public void setSize() {
        System.out.print("Enter new size of " + name + ": ");
        Action values = new Action();
        values.userInputInt();
        int size = values.getIntAns();
        this.size = size;
        System.out.print("New size of array: " + size + "\n");
        mass = new int[size];
    }
    public void setName() {
        System.out.print("Enter the new name of array: ");
        Action name = new Action();
        name.userInputString();
        while (name.getStringAns().equals("null")) {
            System.out.print("You cannot use this name!\nEnter the new name of array: ");
            name.userInputString();
        }
        this.name = name.getStringAns();
        System.out.print("New name of array: " + this.name + "\n");

    }
    public int getSize() {
        return this.size;
    }
    public int getElement(int index) { return mass[index]; }
    public String getName() {return name; }
    public boolean getCreatedStatus() {
        return created;
    }
    public boolean getElementStatus() {return elements; }
    public void changeElement(int index, int temp) {
        mass[index] = temp;
    }
    public void swapElements(int l, int r) {
        int temp = mass[l];
        mass[l] = mass[r];
        mass[r] = temp;
    }
    public void displayArray() {
        System.out.print("Name of array: " + name +
                "\nSize of array: " + size +
                "\nElements of array: ");
        for (int i = 0; i < size; ++i)
            System.out.print(mass[i] + " ");
        System.out.print("\n");
    }
    public void notCreated() {
        created = false;
    }
}
