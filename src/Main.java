
import Controller.csvFileController;
import Model.CSV;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author HI
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<CSV> csvList = new ArrayList<>();
        csvList.add(new CSV(1, "Duong   nguyen    phu  qUY", "quyduong0304@gmail.com", "0797958073", "Danang     - VietNam"));
        csvList.add(new CSV(2, "Vo thi   hong  anh ", "honganhcutie@gmail.com", "0123456789", "Hue   -     VietNam"));
        csvList.add(new CSV(3, "nguyen   Ngoc    Linh    nHI", "nnln2511@gmail.com", "0987654321", "Danang - VietNam"));
        new csvFileController().run(csvList);
    }
    
}
