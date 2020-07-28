package bankAccount;
public class bankAccount {// class name
	//Properties
		String customerName;
		String Transaction;
		int accountNumber;
		double interestRate;
		double balance;
	//Constructor
		public bankAccount () {	
		}
	//Methods
		double showBalance(){		
			return balance;
		}
		double withdraw(double monney){
			balance = balance - monney;
			Transaction = Transaction + "W"; //เพื่อตัว W ต่อท้าย
			return balance;
		}
		double deposit(double monney) {
			balance = balance + monney;
			Transaction = Transaction + "D"; //เพิ่มตัว D ต่อท้าย
			return balance;
		}		
}