package bankAccount;
import java.util.Scanner;
public class main {
	static bankAccount[] account = new bankAccount[10];  		//10 ���� account 10 ��ͧ���Ф�Ѻ �����ҧ���� ������ҡ�� 仡�˹����������ѧ
	static int accNum;  		//����¹�� ����Ѻ ������ �� array ��ͧ�˹
				//��С�������� ����ö����ء���� file main.java
	//----------------------------------Start Main---------------------------------------------
	public static void main(String[] args) {
		creatBankAccount(1,"Mr.A",111,100,"DDWDDWWWW",0.2); 			// ��Сͺ���� �ӴѺ� array , ���� , �Ţ��Шӵ�� , �Թ , ����ѵ� , �ѵ�Ҵ͡����
		creatBankAccount(2,"Mr.B",222,200,"DDDDDW",0.2);							//	arrey[�ç���] , customerName , accountNumber , balance , Transaction , InterestRate ����ӴѺ��Ѻ��
		creatBankAccount(3,"Mr.C",333,300,"DDWWWWWW",0.2);
		creatBankAccount(4,"Mr.D",444,400,"DWWWDDDDDD",0.2);
		creatBankAccount(5,"Mr.E",555,500,"DDDDWWWD",0.2);
				// �ա�����ҧ account 5 �ѹ�������Ǥ�Ѻ �ç���
		for (int i = 0 ; i >=0 ; i++) {
			Scanner keyboard = new Scanner(System.in);
			System.out.println("------------------------Select Account-----------------------");
			System.out.println("[1-5] or 0 to Exit");			//��͡���͡ account ����ͧ�����ҹ��Ѻ��
			System.out.print("Select Account : ");
			accNum = keyboard.nextInt();
			if (accNum == 0) {			//��ҡ�͡ account �� 0 �����͡�ҡ�������Ѻ
				System.out.println("------------------------Exit-----------------------");
				break;
			}else {			//��� account ����� 0 ���� 1-5 ������˹�����������͡���٤�Ѻ��
				for(int j = 0 ; j >= 0 ; j++) {
					Scanner kmenu = new Scanner(System.in);
					System.out.println("------------"+account[accNum].customerName+"------------Select Menu-----------------------");
					System.out.print("Enter Menu [1]:Show Balance [2]:Deposit [3]:Withdraw [0:Exit]  : ");
					int menu = kmenu.nextInt();			//����͹���͡ account �ѹ������͡ menu
					if( menu == 0 ) {			//��� menu �� 0 ��͡�Ѻ�˹�� ���͡ account ����ʴ� �����ҡ�ش �Ѻ�����ش��͹�͡  �鴨�����͹�� loop  �� �ѧ�ѹ ���� find highlow ��Ѻ
						System.out.println("------------"+account[accNum].customerName+"------------Logout-----------------------\n\n\n");
						break;
					}else {
						switch(menu) {
							case 1 :		
											System.out.print("Your balance is :");
											System.out.println(account[accNum].showBalance()+"\n"); //  ��÷Ѵ��������㨡��������͹�������Ǥ�Ѻ ���� account ��ͪ��� array
																															// .showBalance() ��Ϳѧ��ѹ  �ͧ�ٵ�����ҧ�ͧ�Ҩ������ ����� getArea()
																															//accNum �������á�˹���� �� �������ͧ�������������鹤�Ѻ
																															// �ͷء�ѹ����ѹ ����ŧ������� ��Ң����Ţͧ account[�����ҹ��] ����ҿѧ��ѹ�ʴ� �Թ�͡����
											break;
							case 2 : 		
											Scanner DepoMonney = new Scanner(System.in);		//�ѹ����ͤ���� scanf ����仹� ����ͧ ��
											System.out.print("Deposit Monney : ");
											Double Depo = DepoMonney.nextDouble();		// ��ͧ�Ҥ��Ѻ�ѹ�������  �Ѻ�� ���ǡ���Ҥ������㹵���ä�Ѻ
											System.out.println("Deposit Successful!!\nYour Balance : "+account[accNum].deposit(Depo));		 // ��ѧ��ѹ������ʴ� ���ʴ���ҷ�� return �͡�Ҥ�Ѻ ������ Withdraw ����¹��
											break;
							case 3 : 		
											Scanner withDraw = new Scanner(System.in);		//�ѹ����ͤ���� scanf ����仹� ����ͧ ��
											System.out.print("Withdraw Monney : ");
											Double wd = withDraw.nextDouble();		// ��ͧ�Ҥ��Ѻ�ѹ�������  �Ѻ�� ���ǡ���Ҥ������㹵���ä�Ѻ
											if (wd <= account[accNum].showBalance()) { 		// ��� wd ��ͤ�ҷ����ҡ�͡��Ф�Ѻ ������ҡ������礡Ѻ�Թ�����㹺ѭ�ռ�ҹ �ѧ���� .showbalance ����ԧ����ա˹�ҹ֧��Ѻ
												System.out.println("Withdraw Successful!!\nYour Balance : "+account[accNum].withdraw(wd));		// �繡����ѧ���� ������Ѻ �ʴ���� ���Ф�ҷ����ʴ����繤�� return �Ҩҡ �ѧ�ѹ������ withdraw(double) ��������ա˹��
											}else { 		// ����Թ���� �ҡ if ����������ö �͹�Թ�� ���ѹ���㨧�����Ѻ
												System.out.println("Withdraw False!!\n");
											}
											break;
						}
					}
				}
			}
			//����������Թ���� ��� ���·���ش �ç����͵�ͧ�͡�Ҩҡ menu �ͧ account ��͹����ʴ��ء���駤�Ѻ
			findhighlow();
			//����� ����� account �ա�ýҡ-�͹�Դ�ѹ������ ��Ф������
			findTransaction();
		}
	}
	//--------------------------------------End Main-------------------------------------------------
	//----------------------------------�ѧ��ѹ㹡�����ҧ account �Ѻ����Ҩҡ� mainc-------------------------------------------------------------------
	static void creatBankAccount (int x,String name,int num,double b,String tran,double rate) {
		account[x] = new bankAccount(); 		// ����� ��� ������������ö���ҧ��� account ������ �������� account[x] �Ы�ӡѺ������ ��ҵ��� new ��͹
		account[x].customerName = name;
		account[x].accountNumber = num;
		account[x].balance = b;
		account[x].Transaction = tran;
		account[x].interestRate = rate;
				//��� ���͵���� ����ö����¹����㨪ͺ��¹� ����� bankAccount ��ͪ������ǡѺ �ա File ������ѧࡵعФ�Ѻ �繡�÷ӧҹẺ ��� �����ѹ�����ҳ���
	}
//--------------------------------------find highlow funtion---------�ѧ��ѹ����������Թ �ҡ����ش��й��·���ش��Ѻ------------------------------------
	static void findhighlow() {
		int h = 1,l = 1;
		double high = account[1].balance , low = account[1].balance;
		for(int i = 1 ; i <=5 ;i++) {
			if(account[i].balance > high) { 		//�ѹ�������� �����Թ�ҡ����ش
				high = account[i].balance; 		//�纤���Թ ���ҵ��
				h = i;				//���ӡѺ� array
			}
			if(account[i].balance < low) { 		//�ѹ�������������Թ���·���ش
				low = account[i].balance; 		//�纤���Թ �������ҵ��
				l = i; 	 			//���ӴѺ� array 
			}
		}
		System.out.println("The person with highest account balance is "+account[h].customerName+"($"+ high +")");
		System.out.println("The person with lowest account balance is "+account[l].customerName+"($"+ low +")");
	}
	//-----------------------------------�ѧ��ѹ������ա�÷����õԴ��͡ѹ������ ��Ф������--------------------------------------------------------
	static void findTransaction() {
		int total_tran[] = new int[10]; 		//�������������� ������������ �ըӹǹ�Դ�ѹ������
		char total_type[] = new char[10]; 		//�������������� ������������ �����õԴ�ѹ�����ش
		for(int i = 1 ; i <= 5 ; i++) {		 //loop �������ӵ���ӹǹ account
			int temp = 0;  		//����� �ӹǹ���Դ�ѹ
			char state = ' ';		 //����纻��������Դ�ѹ �� 'D' ���� 'W'
			for(int j = 0 ; j < account[i].Transaction.length() ; j++) { 		 //�繡��ǹ loop ���� .length() ��ͤ������������ Transaction �ͧ account ��� �ա����   -- ���ͷ�����ǹloop ������� ���� account �����ҡѹ��Ѻ
				if (state == account[i].Transaction.charAt(j)){				// �������� Transaction ����е�� �ͧ account ��� i  ��� Transaction ��� ��кǡ temp ��������
					temp++;  		//���ͨӹǹ�����������
					if (temp>=total_tran[i]){ 			//��� �ӹǹ����� �ҡ���������ҡѺ ������纤�������� ����ʴ��Ŷ������ա������¹�ŧ   �ٴ������� ���������Ѻ��� ������ա type ��������С��ҵ�Ƿ����ʴ��š������¹令�Ѻ
						total_tran[i]=temp;
						total_type[i]=state;
					}
				}else{  		//�ѹ���������Ѻ ����ҷ�����͹ �������բ����� 
					temp=1; 			//�Ѻ����á���ͧ�� 1 ���ǡ��������������ҫ�� ^ �����ҧ����
					state=account[i].Transaction.charAt(j);		//����ҵ���á�������
				}
			}// �� loop ������礤������ ���ѧ����ʴ��Ф�Ѻ �ʴ��������÷Ѵ��ҧ��ҧ���
			System.out.print(account[i].customerName+" Long repeating Activity : ");
			if(total_type[i] == 'D') {//�繡���к������ Deposit ���� Withdraw ������
				System.out.print("Deprosit ("+total_tran[i]+" Times)\n");
			}else {
				System.out.print("Withdraw ("+total_tran[i]+" Times)\n");
			}
		}// �� loop �������礤������ ��� �ʴ����ú�ء account ����
	}
}// �ա���ش���¹��ѹ��� ����ͧ��  �ء����觵�ͧ����� "public class main {" �Ф�Ѻ