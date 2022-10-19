import com.spire.xls.*;
import java.util.*;

public class mainProgram {

	public static void main(String[] args) {
		System.out.println("Please write the name of the new general file: ");
		Scanner filename_reader = new Scanner(System.in);
		String general_file_name = filename_reader.nextLine();		//this is the name of the end result
		excel_file general_file = new excel_file(general_file_name);			//creating the general_file object
		String added_file = "1";									//the file we want to add
		
		while(added_file.contentEquals("break") != true){
			System.out.println("Please write the name of the file that you want to add to the general file (type break to stop): ");
			added_file = filename_reader.nextLine();
			
			if(added_file.contentEquals("break")) {
				break;
			}
			
			excel_file additional_excel_file = new excel_file(added_file);
			add_new_file (general_file, additional_excel_file);
		}
		write_file (general_file, general_file_name);
	}
	
	public static void add_new_file	(excel_file file1, excel_file file2){ //file1 is the general file, file2 is the new file
	
		int if_counter1 = 0;
		int if_counter2 = 0;
		
		System.out.println("Before the for loops. Counter one is: " + file1.get_counter());
		System.out.println("Before the for loops. Counter two is: " + file2.get_counter());
		
		for(int i2 = 1; i2 < file2.get_counter(); i2++){ //here we check for similarities between the files and exclude the doubles
			int guard = 0;
			//System.out.println("For loop 1: i2 = " + i2);
			
			for(int i1 = 1; i1 < file1.get_counter(); i1++){
				
				//System.out.println("Surname2: " + file2.get_cell(i2).get_surname().toLowerCase());
				//System.out.println("Surname1: " + file1.get_cell(i1).get_surname().toLowerCase());
				
				//System.out.println("For loop 2: i1 = " + i1);
				try {
					if(file2.get_cell(i2).get_surname().toLowerCase().contentEquals(file1.get_cell(i1).get_surname().toLowerCase()) &&
						file2.get_cell(i2).get_first_name().toLowerCase().contentEquals(file1.get_cell(i1).get_first_name().toLowerCase()) ){
						guard = 1;
						
						System.out.println("First if.");
						
						if_counter1++;
					}
				}
				
				catch(Exception e) {
					//guard = 1;
					System.out.println("Catch Exception.");
				}
			}
			if((file2.get_cell(i2).get_address() == null || file2.get_cell(i2).get_address().contentEquals(",")) && file2.get_cell(i2).get_phone() == null && 
					file2.get_cell(i2).get_cell_phone() == null && file2.get_cell(i2).get_phone_long() == 0 && file2.get_cell(i2).get_cell_phone_long() == 0) {
				//disposing empty addresses, phones checking both the String and long values of the phones
				guard = 1;
				System.out.println("Second if.");
				System.out.println(file2.get_cell(i2).get_address());
				System.out.println(file2.get_cell(i2).get_cell_phone());
				System.out.println(file2.get_cell(i2).get_cell_phone_long());
				
				if_counter2++;
			}
			if(guard == 0){
				file1.add_cell(file2.get_cell(i2));
				//System.out.println("This is the member card due pointer ..." + file2.get_member_card_due_pointer());
				//System.out.println("This is the member card due date: " + (int)(file2.get_sheet().getNumber(3,10)));
				System.out.println("Adding cell to general file ...");
			}
			if(guard == 1) {
				System.out.println("Didn't add cell to general file.");
			}
		}
		//
		System.out.println("IF counter1: " + if_counter1 + " IF counter2: " + if_counter2);
		//
	}
	
	public static void write_file (excel_file general_file, String general_file_name) {
		Workbook wb = new Workbook();
		wb.loadFromFile(general_file_name);
		Worksheet sheet = wb.getWorksheets().get(0);
		
		for(int i = 2; i < general_file.get_counter(); i++) {
			try {
				//System.out.println(general_file.get_cell(i-1).get_surname());
				sheet.setText(i, 1, general_file.get_cell(i-1).get_surname());
			}
			catch(Exception e) {
				
			}
			try {
				//System.out.println(general_file.get_cell(i-1).get_first_name());
				sheet.setText(i, 2, general_file.get_cell(i-1).get_first_name());
			}
			catch(Exception e) {
				
			}
			try {
				//System.out.println(general_file.get_cell(i-1).get_fathers_name());
				sheet.setText(i, 3, general_file.get_cell(i-1).get_fathers_name());
			}
			catch(Exception e) {
				
			}
			try {
				//Checking if the cell_phone String is null
				
				//System.out.println(general_file.get_cell(i-1).get_cell_phone());
				if(general_file.get_cell(i-1).get_cell_phone() != null) {
					sheet.setText(i, 4, general_file.get_cell(i-1).get_cell_phone());
				}
				else {
					sheet.setText(i, 4, Long.toString(general_file.get_cell(i-1).get_cell_phone_long()));
				}
			}
			catch(Exception e) {
				
			}
			try {
				//Checking if the phone String is null
				
				//System.out.println(general_file.get_cell(i-1).get_phone());
				if(general_file.get_cell(i-1).get_phone() != null) {
					sheet.setText(i, 5, general_file.get_cell(i-1).get_phone());
				}
				else {
					sheet.setText(i, 5, Long.toString(general_file.get_cell(i-1).get_phone_long()));
				}
			}
			catch(Exception e) {
				
			}
			try {
				//System.out.println(general_file.get_cell(i-1).get_email());
				sheet.setText(i, 6, general_file.get_cell(i-1).get_email());
			}
			catch(Exception e) {
				
			}
			try {
				//System.out.println(general_file.get_cell(i-1).get_address());
				sheet.setText(i, 7, general_file.get_cell(i-1).get_address());
			}
			catch(Exception e) {
				
			}
			try {
				//System.out.println(general_file.get_cell(i-1).get_postal_code());
				sheet.setText(i, 8, Integer.toString(general_file.get_cell(i-1).get_postal_code()));
			}
			catch(Exception e) {
				
			}
			try {
			//System.out.println(general_file.get_cell(i-1).get_town());
			sheet.setText(i, 9, general_file.get_cell(i-1).get_town());
			}
			catch(Exception e) {
				
			}
			try {
				//System.out.println(general_file.get_cell(i-1).get_birthday());
				sheet.setText(i, 10, Integer.toString(general_file.get_cell(i-1).get_birthday()));
			}
			catch(Exception e) {
				
			}
			try {
				//System.out.println(general_file.get_cell(i-1).get_topiki());
				sheet.setText(i, 11, general_file.get_cell(i-1).get_topiki());
			}
			catch(Exception e) {
				
			}
			try { //We have to treat member_card_due date as a double number because we can't handle it as a string
				//System.out.println(general_file.get_cell(i-1).get_member_card_due());
				sheet.setText(i, 12, Integer.toString(general_file.get_cell(i-1).get_member_card_due()));
			}
			catch(Exception e) {
				
			}
			try {
				//System.out.println(general_file.get_cell(i-1).get_profession());
				sheet.setText(i, 13, general_file.get_cell(i-1).get_profession());
			}
			catch(Exception e) {
				
			}
			try {
			//System.out.println(general_file.get_cell(i-1).get_eklogiko_diamerisma());
			sheet.setText(i, 14, general_file.get_cell(i-1).get_eklogiko_diamerisma());
			}
			catch(Exception e) {
				
			}
		}
		for(int j = 1; j < sheet.getLastColumn() + 1; j++) {
			sheet.autoFitColumn(j);
		}
		wb.saveToFile(general_file_name, ExcelVersion.Version2016);

	}

}
