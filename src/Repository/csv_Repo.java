/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Common.Validation;
import Model.CSV;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author HI
 */
public class csv_Repo {
    Scanner in = new Scanner(System.in);
    Validation val = new Validation();
    
    public void exportFile(ArrayList<CSV> csvList) {
        String line = "";
        BufferedReader fileReader = null;
        System.out.print("Enter Path: ");
        String fileName = in.nextLine().trim();
        try {
            fileReader = new BufferedReader(new FileReader(fileName));
            while ((line = fileReader.readLine()) != null) {
                System.out.println(line);
                String[] splitCSV = line.split(",");
                csvList.add(new CSV(Integer.parseInt(splitCSV[0].trim()), splitCSV[1],
                        splitCSV[2], splitCSV[3], splitCSV[4]));

            }
            System.err.println("Export: Done");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void importFile(ArrayList<CSV> csvList) {
        FileWriter fileWriter = null;
        System.out.print("Enter Path: ");
        String fileName = in.nextLine();
        try {
            fileWriter = new FileWriter(fileName);
            for (CSV csv : csvList) {
                fileWriter.append(String.valueOf(csv.getId()));
                fileWriter.append(",");
                fileWriter.append(String.valueOf(csv.getName()));
                fileWriter.append(",");
                fileWriter.append(String.valueOf(csv.getEmail()));
                fileWriter.append(",");
                fileWriter.append(String.valueOf(csv.getPhone()));
                fileWriter.append(",");
                fileWriter.append(String.valueOf(csv.getAddress()));
                fileWriter.append("\n");
            }
            System.err.println("Import: Done");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
