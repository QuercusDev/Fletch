package com.company;
import java.io.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		File data = new File("C:\\Users\\Steph\\Downloads\\prepopulaterdata.csv");
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

			File apt = new File("C:\\Users\\Steph\\Downloads\\TimberMaticH12_H16_Master_Template_V10.apt");
			Scanner aptScanner = new Scanner(apt);

			File newApt = new File("C:\\APT files\\JD\\TimberMaticH12_H16_" + HUNumber + ".apt");
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



