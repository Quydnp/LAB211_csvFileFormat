package Menu;

import Model.CSV;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Menu<T>  {

    protected String title;
    protected ArrayList<String> list = new ArrayList();
    
    public Menu(){}
    public Menu(String title, String[] s) {
        this.title = title;
        for (String item : s) {
            list.add(item);
        }
    }

    public void display() {
        System.out.println(title);
        System.out.println("--------------------");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }

    public int getChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter selection: ");
        int choice = scanner.nextInt();
        return choice;
    }

    public abstract void execute(int choice, ArrayList<CSV> csvList);

    public void run(ArrayList<CSV> csvList) {
        int choice;
        do {
            display();//hiện menu
            choice = getChoice();
            execute(choice, csvList);//xử lý 
        } while (choice > 0 && choice < list.size());

    }
}
