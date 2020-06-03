package com.company;
import java.io.*;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws FileNotFoundException {
       String dataSource = dataFilePath();
       String[] aptControllerData = controllerSelection();
       populater(dataSource, aptControllerData);
    }

    public static String dataFilePath() {
        System.out.println("Please enter the filepath of the data you want to pre-populate into the APT files:");
        Scanner userInput = new Scanner(System.in);
        String dataSource = userInput.nextLine();
        return dataSource;
    }

    public static String[] controllerSelection() {
        System.out.println("Please select the controller make for your APT files: \n1 - Timbermatic \n2 - Opti \n3 - Maxi");
        Scanner userInput = new Scanner(System.in);
        int controllerNumber = userInput.nextInt();
        System.out.println("Please enter the filepath you would like the newly created APT files to be saved in:");
        String saveFilePath = userInput.next();
        String aptFile = " ";
        String newApt = saveFilePath;
        if (controllerNumber == 1) {
            aptFile = "C:\\Users\\Steph\\Downloads\\TimberMaticH12_H16_Master_Template_V10.apt";
        } else if (controllerNumber == 2) {
            aptFile = "C:\\Users\\Steph\\Downloads\\TimberMaticH12_H16_Master_Template_V10.apt";
        } else if (controllerNumber == 3) {
            aptFile = "C:\\Users\\Steph\\Downloads\\TimberMaticH12_H16_Master_Template_V10.apt";
        }
        String aptControllerData[] = new String[2];
        aptControllerData[0] = aptFile;
        aptControllerData[1] = newApt;
        return aptControllerData;
    }

    public static void populater(String dataSource, String aptControllerData[]) throws FileNotFoundException {
        File data = new File(dataSource);
        Scanner dataScanner = new Scanner(data);
        int i = 0;
        for (i = 0; dataScanner.hasNextLine(); i++) {
            String dataLine = dataScanner.nextLine();
            String[] HUDetail = dataLine.split(",");
            System.out.println(i + dataLine);

            String BAU = HUDetail[0];
            String forest = HUDetail[4];
            String HUNumber = HUDetail[3];
            String hType = HUDetail[5];
            String contractCode = HUDetail[30];
            String contractor = HUDetail[31];

            String editBAU = "AAAA";
            String editForest = "BBBB";
            String editHUNumber = "CCCC";
            String editHType = "DDDD";
            String editContractCode = "EEEE";
            String editContractor = "FFFF";

            File apt = new File(aptControllerData[0]);
            Scanner aptScanner = new Scanner(apt);

            File newApt = new File(aptControllerData[1] + HUNumber + ".apt");
            try {
                newApt.createNewFile();
            } catch (IOException e) {
                System.out.println("Filecreator error");
            }

            try (BufferedWriter out = new BufferedWriter(new FileWriter(newApt))) {
                //System.out.println(HUNumber);

                while (aptScanner.hasNextLine()) {
                    String aptLine = aptScanner.nextLine();
                    //System.out.println(aptLine);
                    String HUNumberApt = aptLine.replaceAll(editBAU, BAU)
                            .replaceAll(editForest, forest)
                            .replaceAll(editHUNumber, HUNumber)
                            .replaceAll(editHType, hType)
                            .replaceAll(editContractCode, contractCode)
                            .replaceAll(editContractor, contractor);
                    out.write(HUNumberApt + "\n");


                    //System.out.println(HUNumberApt);
                }
            } catch (IOException e) {
                System.out.println("Filewriter error");
            }

        }
    }
}









