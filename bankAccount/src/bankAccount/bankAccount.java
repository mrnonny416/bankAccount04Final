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
			Transaction = Transaction + "W"; //���͵�� W ��ͷ���
			return balance;
		}
		double deposit(double monney) {
			balance = balance + monney;
			Transaction = Transaction + "D"; //������� D ��ͷ���
			return balance;
		}		
}