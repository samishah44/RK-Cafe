package Cafe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

interface Registration // Abstraction
{
	void login(); // Abstraction

	void signup(); // Abstraction
}

//{========================================= Registration =======================================}

class Regi implements Registration 
{
	private String name; // Data hiding
	private long contact = 1234567890L;
	private String email;
	String City;
	private String password = "admin";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getContact() {
		return contact;
	}

	public void setContact() {  // method Recursion 
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Contect Number :");
		contact = sc.nextLong();
		if (contact > 999999999L && contact < 100000000000L) {
			System.out.println("Contact is valid");
		} else {
			System.out.println("Please Enter a 10 digits");
			setContact();

		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) { // email changes chatgtp valid mail address collect
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void login() { // ======================================= Login page ===============================
		System.out.println("===========================================");
		System.out.println("             Login Process                 ");
		System.out.println("===========================================");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Contact :");
		long contact = sc.nextLong();
		sc.nextLine();
		System.out.println("Enter the password :");
		String password = sc.nextLine();
		if (this.contact == contact && this.password.equals(password)) {
			System.out.println("===========================================");
			System.out.println("                    Logged In Successfully ");
			System.out.println("===========================================");
		} else {
			System.out.println("Please Try Again");
			login();
		}

	}

	// {======================================================== signup Processs ======================================}
	public void signup() {
		System.out.println("======================================");
		System.out.println("                Signup                ");
		System.out.println("======================================");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name :");
		name = sc.nextLine();
		setContact();
		System.out.println("Enter your Email :");
		email = sc.nextLine();
		System.out.println("Enter your City :");
		City = sc.nextLine();
		System.out.println("Create your password :");
		password = sc.nextLine();
		System.out.println("===========================================");
		System.out.println("              Signup Successfully          ");
		System.out.println("===========================================");
		login();
	}
}

class Menu extends Regi {
	static ArrayList cartItems = new ArrayList();
	static double bill;

	public void totalBill() {
		System.out.println("");
		System.out.println("Hello " +getName());
		System.out.println("");
		System.out.println("Your E-bill will sent to you "+getEmail() );
		System.out.println("");
		System.out.println("Your Total bill amount is "+bill);
		System.out.println("Your total Bill is " + bill);
		int discount = (int) (bill * 0.1); // doubt ?????????????????????????????????????????????
		bill = bill - discount;
		System.out.println("After discount The bill is " + bill);
		System.out.println("The items Odered are:");
		for (Object z : cartItems) {
			System.out.println(z);
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for UPI");
		System.out.println("Press 2 for Cash");
		int m = sc.nextInt();
		switch (m) {
		case 1:
			System.out.println("Enter The UPI Number :");
			long contact = sc.nextLong();
			payment(contact);
			break;
		case 2:
			payment(bill);
			break;
		default:
			bill = bill + discount;
			totalBill();
			break;
		}
		System.exit(0);
	}

	public void payemnt(long upi) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The Amount :");
		int amount = sc.nextInt();
		System.out.println("===============================");
		System.out.println("Thank You For paying " + amount);
		System.out.println("===============================");

	}

	public void payment(double Bill) // doubt
	{
		System.out.println("================================");
		System.out.println("Thank You For paying " + Bill);// doubt bill nd double
		System.out.println("================================");

	}

	// {============================ Maine Menu ==============================================}
	public void menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Drinks");
		System.out.println("Press 2 for Foods");
		System.out.println("Press 0 for exit");

		int m = sc.nextInt();
		switch (m) {
		case 1:// Drinks
			Drinks s = new Drinks();
			s.Drinks();
			break;
		case 2: // Foods
			Foods f = new Foods();
			f.Foods();
		case 0:// exit
			System.out.println("===================================================================================");
			System.out.println("");
			System.out.println("                             Thanks for visiting                                    ");
			System.out.println("");
			System.out.println("====================================================================================");
			System.exit(0);
		default:
			System.out.println("Please select the correct Option");
			menu();
			break;
		}
	}
}

// ("================================= Drinks ==================================================")
class Drinks extends Menu {
	public void Drinks() {
		Scanner sc = new Scanner(System.in);
		System.out.println("========= Drinks =========");
		System.out.println("Press 1 For Hot Coffee");
		System.out.println("Press 2 For Cold Coffee");
		System.out.println("Press 3 For Tea");
		System.out.println("Press 4 For Frappuccino");
		System.out.println("Press 0 For previous Menu");
		int m = sc.nextInt();
		switch (m) {
		case 1://HotCoffee
			HotCoffee();
			break;
		case 2:// ColdCoffee
			ColdCoffee();
			break;
		case 3:// Tea
			Tea();
			break;
		case 4:// Frappuccino 
			Frappuccino();
			break;
		default:
			System.out.println("==================================");
			System.out.println("Please select Oder");
			System.out.println("==================================");
			menu();
			break;
		}
	}

	// {============================== Hot Coffee ==============================================}
	public void HotCoffee() {
		System.out.println("========= Hot Coffee =========");
		System.out.println("Press 1 for Hot Velvet Coffee");
		System.out.println("Press 2 for Caramel Macchiato");
		System.out.println("Press 3 For Cappuccino");
		System.out.println("Press 4 For Caramel Macchiato");
		System.out.println("Press 5 For Roasted nut latte");
		System.out.println("Press 6 For Pumpkin spice ");
		System.out.println("Press 7 For Caffe Latte");
		System.out.println("Press 8 For Chocolate Cappuccino");
		System.out.println("Press 9 For Chocolate Cappuccino");
		System.out.println("Press 10 For Caffè Mocha");
		System.out.println("====================================");
		System.out.println("Press 0 Go to The Previous");
		System.out.println("====================================");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		switch (n) {
		case 1:
			System.out.println("====================================");
			System.out.println("You have Selected Hot Velvet Coffee ");
			System.out.println("====================================");
			System.out.println("The Price is Rs.210.78");
			System.out.println("Press 1 to Add Item");
			System.out.println("Press Any Number to Go Back");
			n = sc.nextInt();
			if (n == 1) {
				bill = bill + 210.78;
			} else {
				HotCoffee();
			}
			break;
		case 2:
			System.out.println("==================================");
			System.out.println("You have Selected Caramel Macchiato");
			System.out.println("==================================");
			System.out.println("The Price is Rs.459.99");
			System.out.println("Press 1 For place Oder");
			System.out.println("Press Any Number to Go Back ");
			n = sc.nextInt();
			if (n == 1) {
				bill = bill + 210.78;
			} else {
				HotCoffee();
			}
			break;
		case 3:
			System.out.println("==================================");
			System.out.println("You have Selected Cappuccino");
			System.out.println("==================================");
			System.out.println("The Price is Rs.256.90 ");
			System.out.println("Press 1 to Add Item");
			n = sc.nextInt();
			if (n == 1) {
				bill = bill + 210.78;
			} else {
				HotCoffee();
			}
			break;
		case 4:
			System.out.println("==================================");
			System.out.println("You have Selected Caramel Macchiato");
			System.out.println("==================================");
			System.out.println("The Price is Rs.456.07");
			System.out.println("Press 1 to Add Item");
			System.out.println("Press Any Number to Go Back");
			n = sc.nextInt();
			if (n == 1) {
				bill = bill + 210.78;
			} else {
				HotCoffee();
			}
			break;
		case 5:
			System.out.println("==================================");
			System.out.println("You have Selected Roasted nut latte");
			System.out.println("==================================");
			System.out.println("The Price is Rs.482.97");
			System.out.println("Press 1 to Add Item");
			System.out.println("Press Any Number to Go Back");
			n = sc.nextInt();
			if (n == 1) {
				bill = bill + 210.78;
			} else {
				HotCoffee();
			}
			break;
		case 6:
			System.out.println("==================================");
			System.out.println("You have Selected Pumpkin spice");
			System.out.println("==================================");
			System.out.println("The Price is Rs.389.89");
			System.out.println("Press 1 to Add Item");
			System.out.println("Press Any Number to Go Back");
			n = sc.nextInt();
			if (n == 1) {
				bill = bill + 210.78;
			} else {
				HotCoffee();
			}
			break;
		case 7:
			System.out.println("==================================");
			System.out.println("You have Selected Caffe Latte");
			System.out.println("==================================");
			System.out.println("The Price is Rs.309.89");
			System.out.println("Press 1 to Add Item");
			System.out.println("Press Any Number to Go Back");
			n = sc.nextInt();
			if (n == 1) {
				bill = bill + 210.78;
			} else {
				HotCoffee();
			}
			break;
		case 8:
			System.out.println("======================================");
			System.out.println("You have Selected Chocolate Cappuccino");
			System.out.println("======================================");
			System.out.println("The Price is Rs.408.09");
			System.out.println("Press 1 to Add Item");
			System.out.println("Press Any Number to Go Back");
			n = sc.nextInt();
			if (n == 1) {
				bill = bill + 210.78;
			} else {
				HotCoffee();
			}
			break;
		case 9:
			System.out.println("==================================");
			System.out.println("You have Selected Chocolate Cappuccino");
			System.out.println("==================================");
			System.out.println("The Price is Rs.408.09");
			System.out.println("Press 1 to Add Item");
			System.out.println("Press Any Number to Go Back");
			n = sc.nextInt();
			if (n == 1) {
				bill = bill + 210.78;
			} else {
				HotCoffee();
			}
			break;
		case 10:
			System.out.println("==================================");
			System.out.println("You have Selected Caffè Mocha");
			System.out.println("==================================");
			System.out.println("The Price is Rs.400.00");
			System.out.println("Press 1 to Add Item");
			System.out.println("Press Any Number to Go Back");
			n = sc.nextInt();
			if (n == 1) {
				bill = bill + 210.78;
			} else {
				HotCoffee();
			}
			break;
		case 0:
			System.out.println("");
			Drinks();
		default:
			System.out.println("Please Select your correct Oder");
			HotCoffee();
			break;
		}
		System.out.println("Do you want to choose another Item.?");
		System.out.println("If yes then Press Y and No Press N ");
		char ch = sc.next().charAt(0);
		if (ch == 'y' || ch == 'Y') {
			menu();
		} else {
			totalBill();
		}
	}

	// =============================== Cold Coffee ============================================
	
	public void ColdCoffee() {
		System.out.println("========= Cold Coffee =========");
		System.out.println("Press 1 for Iced Roasted Nut Latte");
		System.out.println("Press 2 for Iced Pumpkin Spice Latte");
		System.out.println("Press 3 For Iced Caffè Americano");
		System.out.println("Press 4 For Iced Caffè Latte");
		System.out.println("Press 5 For Iced Caffè Mocha");
		System.out.println("Press 6 For Iced Cappuccino ");
		System.out.println("Press 7 For Iced Chocolate Cappuccino");
		System.out.println("Press 8 For Iced Velvet Vanilla Latte");
		System.out.println("Press 9 For Iced White Mocha");
		System.out.println("Press 10 For Pumpkin Spice Cream Frappuccino");
		System.out.println("====================================");
		System.out.println("Press 0 Go to The Previous");
		System.out.println("====================================");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		switch (n) {
		case 1:
			System.out.println("==================================");
			System.out.println("You have Selected Iced Roasted Nut Latte");
			System.out.println("==================================");
			System.out.println("The Price is Rs.500.00");
			System.out.println("Press 1 to Add Item");
			System.out.println("Press Any Number to Go Back");
			n = sc.nextInt();
			if (n == 1) {
				bill = bill + 210.78;
			} else {
				HotCoffee();
			}
			break;
		case 2:
			System.out.println("==================================");
			System.out.println("You have Selected Iced Pumpkin Spice Latte");
			System.out.println("==================================");
			System.out.println("The Price is Rs.670.25");
			System.out.println("Press 1 to Add Item");
			System.out.println("Press Any Number to Go Back");
			n = sc.nextInt();
			if (n == 1) {
				bill = bill + 210.78;
			} else {
				HotCoffee();
			}
			break;
		case 3:
			System.out.println("==================================");
			System.out.println("You have Selected Iced Caffè Americano");
			System.out.println("==================================");
			System.out.println("The Price is Rs.390.45");
			System.out.println("Press 1 to Add Item");
			System.out.println("Press Any Number to Go Back");
			n = sc.nextInt();
			if (n == 1) {
				bill = bill + 210.78;
			} else {
				HotCoffee();
			}
			break;
		case 4:
			System.out.println("==================================");
			System.out.println("You have Selected Iced Caffè Latte");
			System.out.println("==================================");
			System.out.println("The Price is Rs.445.00");
			System.out.println("Press 1 to Add Item");
			System.out.println("Press Any Number to Go Back");
			n = sc.nextInt();
			if (n == 1) {
				bill = bill + 210.78;
			} else {
				HotCoffee();
			}
			break;
		case 5:
			System.out.println("==================================");
			System.out.println("You have Selected Iced Caffè Mocha");
			System.out.println("==================================");
			System.out.println("The Price is Rs.367.99");
			System.out.println("Press 1 to Add Item");
			System.out.println("Press Any Number to Go Back");
			n = sc.nextInt();
			if (n == 1) {
				bill = bill + 210.78;
			} else {
				HotCoffee();
			}
			break;
		case 6:
			System.out.println("==================================");
			System.out.println("You have Selected Iced Cappuccino");
			System.out.println("==================================");
			System.out.println("The Price is Rs.256.99");
			System.out.println("Press 1 to Add Item");
			System.out.println("Press Any Number to Go Back");
			n = sc.nextInt();
			if (n == 1) {
				bill = bill + 210.78;
			} else {
				HotCoffee();
			}
			break;
		case 7:
			System.out.println("==================================");
			System.out.println("You have Selected Iced Chocolate Cappuccino");
			System.out.println("==================================");
			System.out.println("The Price is Rs.386.29");
			System.out.println("Press 1 to Add Item");
			System.out.println("Press Any Number to Go Back");
			n = sc.nextInt();
			if (n == 1) {
				bill = bill + 210.78;
			} else {
				HotCoffee();
			}
			break;
		case 8:
			System.out.println("==================================");
			System.out.println("You have Selected Iced Velvet Vanilla Latte");
			System.out.println("==================================");
			System.out.println("The Price is Rs.196.89");
			System.out.println("Press 1 to Add Item");
			System.out.println("Press Any Number to Go Back");
			n = sc.nextInt();
			if (n == 1) {
				bill = bill + 210.78;
			} else {
				HotCoffee();
			}
			break;
		case 9:
			System.out.println("==================================");
			System.out.println("You have Selected Iced White Mocha");
			System.out.println("==================================");
			System.out.println("The Price is Rs.300.00");
			System.out.println("Press 1 to Add Item");
			System.out.println("Press Any Number to Go Back");
			n = sc.nextInt();
			if (n == 1) {
				bill = bill + 210.78;
			} else {
				HotCoffee();
			}
			break;
		case 10:
			System.out.println("==================================");
			System.out.println("You have Selected Pumpkin Spice Cream Frappuccino");
			System.out.println("==================================");
			System.out.println("The Price is Rs.789.19");
			System.out.println("Press 1 to Add Item");
			System.out.println("Press Any Number to Go Back");
			n = sc.nextInt();
			if (n == 1) {
				bill = bill + 210.78;
			} else {
				HotCoffee();
			}
			break;

		case 0:
			System.out.println("");
			Drinks();
		default:
			System.out.println("Please Select your correct Oder");
			ColdCoffee();
			break;
		}
		System.out.println("Do you want to choose another Item.?");
		System.out.println("If yes then Press Y and No Press N ");
		char ch = sc.next().charAt(0);
		if (ch == 'y' || ch == 'Y') {
			menu();
		} else {
			totalBill();
		}

	}

	// ============================== Tea
	// ==================================================
	public void Tea() {
		System.out.println("");
		System.out.println("========= Tea =========");
		System.out.println("");
		System.out.println("Press 1 for Chai");
		System.out.println("Press 2 for Black Tea Latte");
		System.out.println("Press 3 For Masala Tea");
		System.out.println("Press 4 For Chai Tea Latte");
		System.out.println("Press 5 For Chamomile");
		System.out.println("Press 6 For English Breakfast Tea ");
		System.out.println("Press 7 For Emperor's Cloud and Mist Green Tea");
		System.out.println("Press 8 For Hibiscus Blend");
		System.out.println("Press 9 For Honey Citrus Mint Tea");
		System.out.println("Press 10 For Earl Grey");
		System.out.println("====================================");
		System.out.println("Press 0 Go to The Previous");
		System.out.println("====================================");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		switch (n) {
		case 1:
			System.out.println("======================");
			System.out.println("You have Selected Chai");
			System.out.println("======================");
			System.out.println("The Price is Rs.86.78");
			System.out.println("Press 1 to Add Item");
			System.out.println("Press Any Number to Go Back");
			n = sc.nextInt();
			if (n == 1) {
				bill = bill + 210.78;
			} else {
				HotCoffee();
			}
			break;
		case 2:
			System.out.println("=================================");
			System.out.println("You have Selected Black Tea Latte");
			System.out.println("==================================");
			System.out.println("The Price is Rs.109.78");
			System.out.println("Press 1 to Add Item");
			System.out.println("Press Any Number to Go Back");
			n = sc.nextInt();
			if (n == 1) {
				bill = bill + 210.78;
			} else {
				HotCoffee();
			}
			break;
		case 3:
			System.out.println("============================");
			System.out.println("You have Selected Masala Tea");
			System.out.println("============================");
			System.out.println("The Price is Rs.90.00");
			System.out.println("Press 1 to Add Item");
			System.out.println("Press Any Number to Go Back");
			n = sc.nextInt();
			if (n == 1) {
				bill = bill + 210.78;
			} else {
				HotCoffee();
			}
			break;
		case 4:
			System.out.println("================================");
			System.out.println("You have Selected Chai Tea Latte");
			System.out.println("================================");
			System.out.println("The Price is Rs.189.00");
			System.out.println("Press 1 to Add Item");
			System.out.println("Press Any Number to Go Back");
			n = sc.nextInt();
			if (n == 1) {
				bill = bill + 210.78;
			} else {
				HotCoffee();
			}
			break;
		case 5:
			System.out.println("===========================");
			System.out.println("You have Selected Chamomile");
			System.out.println("===========================");
			System.out.println("The Price is Rs.209.00");
			System.out.println("Press 1 to Add Item");
			System.out.println("Press Any Number to Go Back");
			n = sc.nextInt();
			if (n == 1) {
				bill = bill + 210.78;
			} else {
				HotCoffee();
			}
			break;
		case 6:
			System.out.println("=======================================");
			System.out.println("You have Selected English Breakfast Tea");
			System.out.println("=======================================");
			System.out.println("The Price is Rs.390.00");
			System.out.println("Press 1 to Add Item");
			System.out.println("Press Any Number to Go Back");
			n = sc.nextInt();
			if (n == 1) {
				bill = bill + 210.78;
			} else {
				HotCoffee();
			}
			break;
		case 7:
			System.out.println("====================================================");
			System.out.println("You have Selected Emperor's Cloud and Mist Green Tea");
			System.out.println("====================================================");
			System.out.println("The Price is Rs.270.00");
			System.out.println("Press 1 to Add Item");
			System.out.println("Press Any Number to Go Back");
			n = sc.nextInt();
			if (n == 1) {
				bill = bill + 210.78;
			} else {
				HotCoffee();
			}
			break;
		case 8:
			System.out.println("================================");
			System.out.println("You have Selected Hibiscus Blend");
			System.out.println("================================");
			System.out.println("The Price is Rs.150.90");
			System.out.println("Press 1 to Add Item");
			System.out.println("Press Any Number to Go Back");
			n = sc.nextInt();
			if (n == 1) {
				bill = bill + 210.78;
			} else {
				HotCoffee();
			}
			break;
		case 9:
			System.out.println("===========================================");
			System.out.println("You have Selected For Honey Citrus Mint Tea");
			System.out.println("===========================================");
			System.out.println("The Price is Rs.206.20");
			System.out.println("Press 1 to Add Item");
			System.out.println("Press Any Number to Go Back");
			n = sc.nextInt();
			if (n == 1) {
				bill = bill + 210.78;
			} else {
				HotCoffee();
			}
			break;
		case 10:
			System.out.println("===============================");
			System.out.println("You have Selected For Earl Grey");
			System.out.println("===============================");
			System.out.println("The Price is Rs.144.80");
			System.out.println("Press 1 to Add Item");
			System.out.println("Press Any Number to Go Back");
			n = sc.nextInt();
			if (n == 1) {
				bill = bill + 210.78;
			} else {
				HotCoffee();
			}
			break;
		case 0:
			Drinks();
			break;
		default:
			System.out.println("Please Select your correct Oder");
			Tea();
			break;
		}
		System.out.println("Do you want to choose another Item.?");
		System.out.println("If yes then Press Y and No Press N ");
		char ch = sc.next().charAt(0);
		if (ch == 'y' || ch == 'Y') {
			menu();
		} else {
			totalBill();
		}

	}

	// ============================= Frappuccino  =============================================\\
	public void Frappuccino() {
		System.out.println("========= Frappuccino =========");
		System.out.println("");
		System.out.println("Press 1 for Coffee Frappuccino");
		System.out.println("Press 2 for Java chips Frappuccino");
		System.out.println("Press 3 For Caremel Java Chip Frappuccino");
		System.out.println("Press 4 For Apple Crisp Oatmilk Frappuccino");
		System.out.println("Press 5 For Pumpkin Spice Frappuccino");
		System.out.println("Press 6 For Mocha Cookie Crumble Frappuccino");
		System.out.println("Press 7 For Caramel Ribbon Crunch Frappuccino");
		System.out.println("Press 8 For Mocha Frappucino");
		System.out.println("Press 9 For White Chocolate Mocha Frappucino");
		System.out.println("Press 10 For Double chocolate Frappuccino");
		System.out.println("====================================");
		System.out.println("Press 0 Go to The Previous");
		System.out.println("====================================");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		switch (n) {
		case 1:
			System.out.println("====================================");
			System.out.println("You have Selected Coffee Frappuccino ");
			System.out.println("====================================");
			System.out.println("The Price is Rs.344.28");
			System.out.println("Press 1 to Add Item");
			System.out.println("Press Any Number to Go Back");
			n = sc.nextInt();
			if (n == 1) {
				bill = bill + 210.78;
			} else {
				Frappuccino();
			}
			break;
		case 2:
			System.out.println("====================================");
			System.out.println("You have Selected Java chips Frappuccino ");
			System.out.println("====================================");
			System.out.println("The Price is Rs.278.20");
			System.out.println("Press 1 to Add Item");
			System.out.println("Press Any Number to Go Back");
			n = sc.nextInt();
			if (n == 1) {
				bill = bill + 210.78;
			} else {
				Frappuccino();
			}
			break;
		case 3:
			System.out.println("====================================");
			System.out.println("You have Selected Caremel Java Chip Frappuccino");
			System.out.println("====================================");
			System.out.println("The Price is Rs.390.99");
			System.out.println("Press 1 to Add Item");
			System.out.println("Press Any Number to Go Back");
			n = sc.nextInt();
			if (n == 1) {
				bill = bill + 210.78;
			} else {
				Frappuccino();
			}
			break;
		case 4:
			System.out.println("====================================");
			System.out.println("You have Selected Apple Crisp Oatmilk Frappuccino");
			System.out.println("====================================");
			System.out.println("The Price is Rs.189.00");
			System.out.println("Press 1 to Add Item");
			System.out.println("Press Any Number to Go Back");
			n = sc.nextInt();
			if (n == 1) {
				bill = bill + 210.78;
			} else {
				Frappuccino();
			}
			break;
		case 5:
			System.out.println("====================================");
			System.out.println("You have Selected Apple Crisp Oatmilk Frappuccino");
			System.out.println("====================================");
			System.out.println("The Price is Rs.189.00");
			System.out.println("Press 1 to Add Item");
			System.out.println("Press Any Number to Go Back");
			n = sc.nextInt();
			if (n == 1) {
				bill = bill + 210.78;
			} else {
				Frappuccino();
			}
			break;
		case 6:
			System.out.println("====================================");
			System.out.println("You have Selected Mocha Cookie Crumble Frappuccino");
			System.out.println("====================================");
			System.out.println("The Price is Rs.409.40");
			System.out.println("Press 1 to Add Item");
			System.out.println("Press Any Number to Go Back");
			n = sc.nextInt();
			if (n == 1) {
				bill = bill + 210.78;
			} else {
				Frappuccino();
			}
			break;
		case 7:
			System.out.println("====================================");
			System.out.println("You have Selected Caramel Ribbon Crunch Frappuccino");
			System.out.println("====================================");
			System.out.println("The Price is Rs.490.98");
			System.out.println("Press 1 to Add Item");
			System.out.println("Press Any Number to Go Back");
			n = sc.nextInt();
			if (n == 1) {
				bill = bill + 210.78;
			} else {
				Frappuccino();
			}
			break;
		case 8:
			System.out.println("====================================");
			System.out.println("You have Selected Mocha Frappucino");
			System.out.println("====================================");
			System.out.println("The Price is Rs.378.87");
			System.out.println("Press 1 to Add Item");
			System.out.println("Press Any Number to Go Back");
			n = sc.nextInt();
			if (n == 1) {
				bill = bill + 210.78;
			} else {
				Frappuccino();
			}
			break;
		case 9:
			System.out.println("====================================");
			System.out.println("You have Selected White Chocolate Mocha Frappucino");
			System.out.println("====================================");
			System.out.println("The Price is Rs.460.00");
			System.out.println("Press 1 to Add Item");
			System.out.println("Press Any Number to Go Back");
			n = sc.nextInt();
			if (n == 1) {
				bill = bill + 210.78;
			} else {
				Frappuccino();
			}
			break;
		case 10:
			System.out.println("====================================");
			System.out.println("You have Selected Double chocolate Frappuccino");
			System.out.println("====================================");
			System.out.println("The Price is Rs.390.00");
			System.out.println("Press 1 to Add Item");
			System.out.println("Press Any Number to Go Back");
			n = sc.nextInt();
			if (n == 1) {
				bill = bill + 210.78;
			} else {
				Frappuccino();
			}
			break;
		case 0:
			System.out.println("");
			Drinks();
		default:
			System.out.println("Please Select your correct Oder");
			Frappuccino();
			break;
		}
		System.out.println("Do you want to choose another Item.?");
		System.out.println("If yes then Press Y and No Press N ");
		char ch = sc.next().charAt(0);
		if (ch == 'y' || ch == 'Y') {
			menu();
		} else {
			totalBill();
		}
			
			

	}
}

	// {================================== Foods menu ==========================================}
	class Foods extends Menu {
		public void Foods() {
			Scanner sc = new Scanner(System.in);
			System.out.println("========= Foods =========");
			System.out.println("Press 1 For VegFoods");
			System.out.println("Press 2 For NonVegFoods");
			System.out.println("Press 3 For Cake");
			System.out.println("Press 4 For Dessert");
			System.out.println("Press 0 For Previouse Menu");
			int k = sc.nextInt();
			switch (k) {
			case 1:
				System.out.println("VegFoods");
				VegFoods();
				break;
			case 2:
				System.out.println("NonVegFoods");
				break;
			case 3:
				System.out.println("Cake");
				break;
			case 4:
				System.out.println("Dessert");
				break;
			default:
				System.out.println("==================================");
				System.out.println("Please sele Oder");
				System.out.println("==================================");
				menu();
				break;
				
			}

		}
		//{================================== VegFoods ===========================================}
		public void VegFoods() 
		{
			System.out.println("");
			System.out.println("========= VegFoods =========");
			System.out.println("");
			System.out.println("Press 1 for Margherita Pizza");
			System.out.println("Press 2 for Veggie Lover Pizza");
			System.out.println("Press 3 For Alfredo Pasta");
			System.out.println("Press 4 For Besil Pesto Pasta");
			System.out.println("Press 5 For Crunchy Potato Burger");
			System.out.println("Press 6 For Cheese Burst Burger ");
			System.out.println("Press 7 For Veg Grilled Sandwich");
			System.out.println("Press 8 For Jain Tax Max Sandwich");
			System.out.println("Press 9 For Paneer Tawa Pulao");
			System.out.println("Press 10 For Earl Grey");
			System.out.println("====================================");
			System.out.println("Press 0 Go to The Previous");
			System.out.println("====================================");
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			switch (n) {
			case 1:
				System.out.println("====================================");
				System.out.println("You have Selected Margherita Pizza");
				System.out.println("====================================");
				System.out.println("The Price is Rs.450.00");
				System.out.println("Press 1 to Add Item");
				System.out.println("Press Any Number to Go Back");
				n = sc.nextInt();
				if (n == 1) {
					bill = bill + 450.00;
				} else {
					VegFoods();
				}
				break;
			case 2:
				System.out.println("====================================");
				System.out.println("You have Selected Veggie Lover Pizza");
				System.out.println("====================================");
				System.out.println("The Price is Rs.750.00");
				System.out.println("Press 1 to Add Item");
				System.out.println("Press Any Number to Go Back");
				n = sc.nextInt();
				if (n == 1) {
					bill = bill + 750.00;
				} else {
					VegFoods();
				}
				break;
			case 3:
				System.out.println("====================================");
				System.out.println("You have Selected Alfredo Pasta");
				System.out.println("====================================");
				System.out.println("The Price is Rs.290.70");
				System.out.println("Press 1 to Add Item");
				System.out.println("Press Any Number to Go Back");
				n = sc.nextInt();
				if (n == 1) {
					bill = bill + 290.70;
				} else {
					VegFoods();
				}
				break;
			case 4:
				System.out.println("====================================");
				System.out.println("You have Selected Besil Pesto Pasta");
				System.out.println("====================================");
				System.out.println("The Price is Rs.300.00");
				System.out.println("Press 1 to Add Item");
				System.out.println("Press Any Number to Go Back");
				n = sc.nextInt();
				if (n == 1) {
					bill = bill + 300.00;
				} else {
					VegFoods();
				}
				break;
			case 5:
				System.out.println("====================================");
				System.out.println("You have Selected Crunchy Potato Burger");
				System.out.println("====================================");
				System.out.println("The Price is Rs.190.00");
				System.out.println("Press 1 to Add Item");
				System.out.println("Press Any Number to Go Back");
				n = sc.nextInt();
				if (n == 1) {
					bill = bill + 190.00;
				} else {
					VegFoods();
				}
				break;
			case 6:
				System.out.println("====================================");
				System.out.println("You have Selected Cheese Burst Burger");
				System.out.println("====================================");
				System.out.println("The Price is Rs.268.90");
				System.out.println("Press 1 to Add Item");
				System.out.println("Press Any Number to Go Back");
				n = sc.nextInt();
				if (n == 1) {
					bill = bill + 268.90;
				} else {
					VegFoods();
				}
				break;
			case 7:
				System.out.println("====================================");
				System.out.println("You have Selected Veg Grilled Sandwich");
				System.out.println("====================================");
				System.out.println("The Price is Rs.98.90");
				System.out.println("Press 1 to Add Item");
				System.out.println("Press Any Number to Go Back");
				n = sc.nextInt();
				if (n == 1) {
					bill = bill + 98.90;
				} else {
					VegFoods();
				}
				break;
			case 8:
				System.out.println("====================================");
				System.out.println("You have Selected Jain Tax Max Sandwich");
				System.out.println("====================================");
				System.out.println("The Price is Rs.108.00");
				System.out.println("Press 1 to Add Item");
				System.out.println("Press Any Number to Go Back");
				n = sc.nextInt();
				if (n == 1) {
					bill = bill + 108.00;
				} else {
					VegFoods();
				}
				break;
			case 9:
				System.out.println("====================================");
				System.out.println("You have Selected Paneer Tawa Pulao");
				System.out.println("====================================");
				System.out.println("The Price is Rs.340.90");
				System.out.println("Press 1 to Add Item");
				System.out.println("Press Any Number to Go Back");
				n = sc.nextInt();
				if (n == 1) {
					bill = bill + 340.90;
				} else {
					VegFoods();
				}
				break;
			case 10:
				System.out.println("====================================");
				System.out.println("You have Selected Earl Grey");
				System.out.println("====================================");
				System.out.println("The Price is Rs.70.00");
				System.out.println("Press 1 to Add Item");
				System.out.println("Press Any Number to Go Back");
				n = sc.nextInt();
				if (n == 1) {
					bill = bill + 70.00;
				} else {
					VegFoods();
				}
				break;
			case 0:
				Foods();
			default:
				System.out.println("Please Select your correct Oder");
				VegFoods();
				break;
			}
			System.out.println("Do you want to choose another Item.?");
			System.out.println("If yes then Press Y and No Press N ");
			char ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') {
				menu();
			} else {
				totalBill();
			}
		}
		public void NonVegFoods() {
			
		}
		public void Cake() {
			
		}
		public void Dessert() {
			
		}
	}
	




public class P1 {
	static {
		System.out.println("");
		System.out.println("========   Ｗｅｌｃｏｍ Ｔｏ ＲＫ－Ｃａｆｅ  ========");
		System.out.println("");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("========= Press 1 for Signup =========");
		System.out.println("========= Press 2 for Login  =========");
		System.out.println("========= Press 3 for Exit   =========");

		int n = sc.nextInt();
		Registration r = new Regi();
		switch (n) {
		case 1:
			r.signup();
			break;
		case 2:
			r.login();
			break;
		case 3:
			System.out.println("====================================================================================");
			System.out.println("");
			System.out.println("                                    Thanks for visiting                              ");
			System.out.println("");
			System.out.println("=====================================================================================");
			System.exit(0);
			break;
		default:
			System.out.println("Please Enter the correct input");
			main(null);
			break;
		}
		Menu m = new Menu();
		m.menu();

	}
	}

