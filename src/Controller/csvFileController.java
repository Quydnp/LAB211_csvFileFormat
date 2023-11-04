/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Common.Validation;
import Menu.Menu;
import Model.CSV;
import Repository.csv_Repo;
import java.util.ArrayList;

/**
 *
 * @author HI
 */
public class csvFileController extends Menu<String> {

    private static final String[] choices
            = {"Import CSV",
                "Format Address",
                "Format Name",
                "Export CSV",
                "Exit"};
    Validation val;
    csv_Repo repo;

    public csvFileController() {
        super("======= Format CSV Program =======", choices);
        val = new Validation();
        repo = new csv_Repo();
    }

    @Override
    public void execute(int choice, ArrayList<CSV> csvList) {
        switch (choice) {
            case 1:
                repo.importFile(csvList);
                break;
            case 2:
                val.formatAddress(csvList);
                break;
            case 3:
                val.formatName(csvList);
                break;
            case 4:
                repo.exportFile(csvList);
                break;
            case 5:

                break;
        }
    }

}
