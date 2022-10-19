import java.util.ArrayList;

import com.spire.xls.Workbook;
import com.spire.xls.Worksheet;

public class excel_file {

	private ArrayList <excel_cell> excel_table = new ArrayList<excel_cell>(); //Create an array to store each excel_cell
	private int counter = 0;  //counter
	
		private int surname_pointer = 15;
		private int first_name_pointer = 15;
		private int fathers_name_pointer = 15;
		private int cell_phone_pointer = 15;
		private int phone_pointer = 15;
		private int email_pointer = 15;
		private int address_pointer = 15;
		private int postal_code_pointer = 15;
		private int town_pointer = 15;
		private int birthday_pointer = 15;
		private int topiki_pointer = 15;
		private int member_card_due_pointer = 15;
		private int profession_pointer = 15;
		private int eklogiko_diamerisma_pointer = 15;
		private Worksheet sheet;
		
	private String file_name;
	private Workbook wb = new Workbook();
	
	public excel_file(String file_name) {
		this.file_name = file_name;
		wb.loadFromFile(file_name);
		sheet = wb.getWorksheets().get(0);
		
		for(int j = 1; j < sheet.getLastColumn() + 1; j++){ //initializing the pointers
			System.out.println(sheet.getText(1, j));
			System.out.println(j);
			if(sheet.getText(1, j).contentEquals("Surname")){
				surname_pointer = j;
			}
			else if(sheet.getText(1, j).contentEquals("First_Name")){
				first_name_pointer = j;
			}
			else if(sheet.getText(1, j).contentEquals("Fathers_Name")){
				fathers_name_pointer = j;
			}
			else if(sheet.getText(1, j).contentEquals("Cell_Phone")){
				cell_phone_pointer = j;
			}
			else if(sheet.getText(1, j).contentEquals("Phone")){
				phone_pointer = j;
			}
			else if(sheet.getText(1, j).contentEquals("Email")){
				email_pointer = j;
			}
			else if(sheet.getText(1, j).contentEquals("Address")){
				address_pointer = j;
			}
			else if(sheet.getText(1, j).contentEquals("Postal_Code")){
				postal_code_pointer = j;
			}
			else if(sheet.getText(1, j).contentEquals("Town")){
				town_pointer = j;
			}
			else if(sheet.getText(1, j).contentEquals("Birthday")){
				birthday_pointer = j;
			}
			else if(sheet.getText(1, j).contentEquals("Topiki")){
				topiki_pointer = j;
			}
			else if(sheet.getText(1, j).contentEquals("Member_Card_Due")){
				member_card_due_pointer = j;
			}
			else if(sheet.getText(1, j).contentEquals("Profession")){
				profession_pointer = j;
			}
			else if(sheet.getText(1, j).contentEquals("Eklogiko_Diamerisma")){
				eklogiko_diamerisma_pointer = j;
			}
		}
		
		System.out.println("This is the last row: " + sheet.getLastRow());
		for(int i = 1; i < sheet.getLastRow() + 1; i++){	//adding the cells to the file
			
			//System.out.println("This is the cell phone String before addition: " + sheet.getText(i,  cell_phone_pointer));
			//System.out.println("This is the cell phone Long before addition: " + sheet.getText(i,  cell_phone_pointer));
			//System.out.println("This is the member card due date: " + sheet.getText(i,  member_card_due_pointer));
			
			//creating the cell
			
			excel_cell cell = new excel_cell(sheet.getText(i, surname_pointer), sheet.getText(i, first_name_pointer), sheet.getText(i, fathers_name_pointer),
			 sheet.getText(i, cell_phone_pointer), sheet.getText(i, phone_pointer), sheet.getText(i, email_pointer), sheet.getText(i, address_pointer),
			 (int)sheet.getNumber(i, postal_code_pointer), sheet.getText(i, town_pointer), (int)sheet.getNumber(i, birthday_pointer), sheet.getText(i, topiki_pointer),
			 (int)sheet.getNumber(i, member_card_due_pointer) , sheet.getText(i, profession_pointer), sheet.getText(i, eklogiko_diamerisma_pointer));
			
			if(cell.get_cell_phone() == null) {
				cell.set_cell_phone_long( (long)sheet.getNumber(i, cell_phone_pointer));
			}
			else if(cell.get_phone() == null) {
				cell.set_phone_long( (long)sheet.getNumber(i, phone_pointer));
			}
			
			//adding the cell
			
			this.add_cell(cell);
			//try {
			//	System.out.println("This is the cell phone String after addition: " + this.get_cell(counter - 1).get_cell_phone());
			//	System.out.println("This is the cell phone Long after addition: " + this.get_cell(counter - 1).get_cell_phone_long());
			//}
			//catch (Exception e) {
			//	System.out.println("Can't display cell_phone");
			//}
		}
		
	}
	
	
	public void add_cell	(excel_cell new_cell) {
		excel_table.add(new_cell);
		counter++;
		System.out.println("This is the counter: " + counter);
		//System.out.println("Adding Cell");
	}
	public int get_member_card_due_pointer() {
		return member_card_due_pointer;
	}
	public int get_counter	() {
		return counter;
	}
	public excel_cell get_cell	(int i) {
		return excel_table.get(i);
	}
	
	public Worksheet get_sheet () {
		return sheet;
	}
	
}
