
public class excel_cell {

	private String surname, first_name, fathers_name,
	email, address, town, topiki, 
	profession, eklogiko_diamerisma = null;
	private int postal_code, birthday, member_card_due = 0;
	private String cell_phone, phone = null;
	private long cell_phone_long, phone_long = 0;
	
	public excel_cell (String surname, String first_name, String fathers_name, String cell_phone, String phone, String email, 
	String address, int postal_code, String town, int birthday, String topiki, int member_card_due, String profession, String eklogiko_diamerisma){
		this.surname = surname;
		this.first_name = first_name;
		this.fathers_name =fathers_name;
		this.cell_phone = cell_phone;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.postal_code = postal_code;
		this.town = town;
		this.birthday = birthday;
		this.topiki = topiki;
		this.member_card_due = member_card_due;
		this.profession = profession;
		this.eklogiko_diamerisma = eklogiko_diamerisma;
	}
	
	public void set_cell_phone_long (long cell_phone) {
		cell_phone_long = cell_phone;
	}
	public void set_phone_long (long phone) {
		phone_long = phone;
	}
	
	public long get_cell_phone_long() {
		return cell_phone_long;
	}
	public long get_phone_long() {
		return phone_long;
	}
	public String get_surname () {
		return surname;
	}
	public String get_first_name () {
		return first_name;
	}
	public String get_fathers_name () {
		return fathers_name;
	}
	public String get_cell_phone () {
		return cell_phone;
	}
	public String get_phone () {
		return phone;
	}
	public String get_email () {
		return email;
	}
	public String get_address () {
		return address;
	}
	public int get_postal_code () {
		return (int)postal_code;
	}
	public String get_town () {
		return town;
	}
	public int get_birthday () {
		return (int)birthday;
	}
	public String get_topiki () {
		return topiki;
	}
	public int get_member_card_due () {
		return (int)member_card_due;
	}
	public String get_profession () {
		return profession;
	}
	public String get_eklogiko_diamerisma () {
		return eklogiko_diamerisma;
	}
	
}
