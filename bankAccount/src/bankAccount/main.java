package bankAccount;
import java.util.Scanner;
public class main {
	static bankAccount[] account = new bankAccount[10];  		//10 ก็มี account 10 ช่องแหละครับ ซึ่งว่างอยู่ แล้วเราก็จะ ไปกำหนดค่าให้ทีหลัง
	static int accNum;  		//ใช้บ่อยน่ะ สำหรับ ชี้ว่า เป็น array ช่องไหน
				//ประกาศมาเพื่อ สามารถใช้ได้ทุกที่ใน file main.java
	//----------------------------------Start Main---------------------------------------------
	public static void main(String[] args) {
		creatBankAccount(1,"Mr.A",111,100,"DDWDDWWWW",0.2); 			// ประกอบด้วย ลำดับใน array , ชื่อ , เลขประจำตัว , เงิน , ประวัติ , อัตราดอกเบี้ย
		creatBankAccount(2,"Mr.B",222,200,"DDDDDW",0.2);							//	arrey[ตรงนี้] , customerName , accountNumber , balance , Transaction , InterestRate ตามลำดับครับผม
		creatBankAccount(3,"Mr.C",333,300,"DDWWWWWW",0.2);
		creatBankAccount(4,"Mr.D",444,400,"DWWWDDDDDD",0.2);
		creatBankAccount(5,"Mr.E",555,500,"DDDDWWWD",0.2);
				// มีการสร้าง account 5 อันเสร็จแล้วครับ ตรงนี้
		for (int i = 0 ; i >=0 ; i++) {
			Scanner keyboard = new Scanner(System.in);
			System.out.println("------------------------Select Account-----------------------");
			System.out.println("[1-5] or 0 to Exit");			//กรอกเลือก account ที่ต้องการใช้งานครับผม
			System.out.print("Select Account : ");
			accNum = keyboard.nextInt();
			if (accNum == 0) {			//ถ้ากรอก account เป็น 0 ก็คือออกจากโปรแกรมครับ
				System.out.println("------------------------Exit-----------------------");
				break;
			}else {			//ถ้า account ไม่ไช่ 0 แต่เป็น 1-5 ก็จะเข้าหน้าให้เราเลือกเมนูครับผม
				for(int j = 0 ; j >= 0 ; j++) {
					Scanner kmenu = new Scanner(System.in);
					System.out.println("------------"+account[accNum].customerName+"------------Select Menu-----------------------");
					System.out.print("Enter Menu [1]:Show Balance [2]:Deposit [3]:Withdraw [0:Exit]  : ");
					int menu = kmenu.nextInt();			//เหมือนเลือก account อันนี้เลือก menu
					if( menu == 0 ) {			//ถ้า menu เป็น 0 คือกลับไปหน้า เลือก account แต่จะแสดง คนมีมากสุด กับน้อยสุดก่อนออก  โค้ดจะอยู่ตอนจบ loop  เป็น ฟังชัน ชื่อ find highlow ครับ
						System.out.println("------------"+account[accNum].customerName+"------------Logout-----------------------\n\n\n");
						break;
					}else {
						switch(menu) {
							case 1 :		
											System.out.print("Your balance is :");
											System.out.println(account[accNum].showBalance()+"\n"); //  บรรทัดนี้ถ้าเข้าใจก็ทำได้เหมือนนนท์แล้วครับ เพราะ account คือชื่อ array
																															// .showBalance() คือฟังค์ชัน  ลองดูตัวอย่างของอาจารย์ได้ คล้าย getArea()
																															//accNum เป็นแค่ตัวแปรกำหนดว่า เป็น อาเรย์ช่องที่เท่าไหร่แค่นั้นครับ
																															// พอทุกอันรวมกัน ก็จะแปลง่ายๆว่า เอาข้อมูลของ account[ที่เท่านี้] มาเช้าฟังค์ชันแสดง เงินออกมาสิ
											break;
							case 2 : 		
											Scanner DepoMonney = new Scanner(System.in);		//อันนี้คือคำสั่ง scanf ทั่วไปนะ ไม่ต้อง งง
											System.out.print("Deposit Monney : ");
											Double Depo = DepoMonney.nextDouble();		// ต้องมาคู่กับอันนี้เสมอ  รับมา แล้วก็เอาค่าไปใส่ในตัวแปรครับ
											System.out.println("Deposit Successful!!\nYour Balance : "+account[accNum].deposit(Depo));		 // ใช้ฟังค์ชันพร้อมแสดง โดยแสดงค่าที่ return ออกมาครับ คล้ายๆ Withdraw เลยยยน้า
											break;
							case 3 : 		
											Scanner withDraw = new Scanner(System.in);		//อันนี้คือคำสั่ง scanf ทั่วไปนะ ไม่ต้อง งง
											System.out.print("Withdraw Monney : ");
											Double wd = withDraw.nextDouble();		// ต้องมาคู่กับอันนี้เสมอ  รับมา แล้วก็เอาค่าไปใส่ในตัวแปรครับ
											if (wd <= account[accNum].showBalance()) { 		// คือ wd คือค่าที่เรากรอกเนอะครับ แล้วเราก็เอาไปเช็คกับเงินที่มีในบัญชีผ่าน ฟังค์ชั่น .showbalance ที่ลิงค์ไปอีกหน้านึงครับ
												System.out.println("Withdraw Successful!!\nYour Balance : "+account[accNum].withdraw(wd));		// เป็นการใช้ฟังค์ชั่น พร้อมกับ แสดงค่า เพราะค่าที่จะแสดงก็เป็นค่า return มาจาก ฟังชันที่ชื่อ withdraw(double) ที่อยู่อีกหน้า
											}else { 		// ถ้าเงินไม่พอ จาก if ก็จะไม่สามารถ ถอนเงินได้ เป็นอันเข้าใจง่ายๆครับ
												System.out.println("Withdraw False!!\n");
											}
											break;
						}
					}
				}
			}
			//หาว่าใครมีเงินเยอะ และ น้อยที่สุด ตรงนี้คือต้องออกมาจาก menu ของ account ก่อนก็จะแสดงทุกครั้งครับ
			findhighlow();
			//หาว่า ในแต่ละ account มีการฝาก-ถอนติดกันกี่ครั้ง และคืออะไร
			findTransaction();
		}
	}
	//--------------------------------------End Main-------------------------------------------------
	//----------------------------------ฟังค์ชันในการสร้าง account รับค่ามาจากใน mainc-------------------------------------------------------------------
	static void creatBankAccount (int x,String name,int num,double b,String tran,double rate) {
		account[x] = new bankAccount(); 		// ง่ายๆ คือ ทำให้เราสามารถสร้างตัว account ใหม่ได้ ถ้าไม่มี account[x] จะซ้ำกับตัวเดิม เราต้งอไป new ก่อน
		account[x].customerName = name;
		account[x].accountNumber = num;
		account[x].balance = b;
		account[x].Transaction = tran;
		account[x].interestRate = rate;
				//คือ ชื่อตัวแปร สามารถเปลี่ยนได้ตามใจชอบเลยนะ แต่ว่า bankAccount คือชื่อเดียวกับ อีก File ขอให้สังเกตุนะครับ เป็นการทำงานแบบ ให้ ร่วมกันได้ประมาณนั้น
	}
//--------------------------------------find highlow funtion---------ฟังค์ชันหาว่าใครมีเงิน มากที่สุดและน้อยที่สุดครับ------------------------------------
	static void findhighlow() {
		int h = 1,l = 1;
		double high = account[1].balance , low = account[1].balance;
		for(int i = 1 ; i <=5 ;i++) {
			if(account[i].balance > high) { 		//อันนี้หาว่า ใครมีเงินมากที่สุด
				high = account[i].balance; 		//เก็บค่าเงิน มาหาต่อ
				h = i;				//เก็บลำกับใน array
			}
			if(account[i].balance < low) { 		//อันนี้หาว่าใครมีเงินน้อยที่สุด
				low = account[i].balance; 		//เก็บค่าเงิน มาเพื่อหาต่อ
				l = i; 	 			//เก็บลำดับใน array 
			}
		}
		System.out.println("The person with highest account balance is "+account[h].customerName+"($"+ high +")");
		System.out.println("The person with lowest account balance is "+account[l].customerName+"($"+ low +")");
	}
	//-----------------------------------ฟังค์ชันหาว่ามีการทำอะไรติดต่อกันกี่ครั้ง และคืออะไร--------------------------------------------------------
	static void findTransaction() {
		int total_tran[] = new int[10]; 		//ตัวแปรเพื่อเก็บว่า คนนี้เท่าไหร่ มีจำนวนติดกันกี่ครั้ง
		char total_type[] = new char[10]; 		//ตัวแปรเพื่อเก็บว่า คนที่เท่าไหร่ ทำอะไรติดกันบ่อยสุด
		for(int i = 1 ; i <= 5 ; i++) {		 //loop เพื่อให้ทำตามจำนวน account
			int temp = 0;  		//ไว้เก็บ จำนวนที่ติดกัน
			char state = ' ';		 //ไว้เก็บประเภทที่ติดกัน เช่น 'D' หรือ 'W'
			for(int j = 0 ; j < account[i].Transaction.length() ; j++) { 		 //เป็นการวน loop โดยใข้ .length() คือคำสั่งให้หาว่า Transaction ของ account นี้ มีกี่ตัว   -- เพื่อที่จะได้วนloop ตามนั้นๆ แต่ละ account ไม่เท่ากันครับ
				if (state == account[i].Transaction.charAt(j)){				// ใช้เพื่อเช็ค Transaction ที่ละตัว ของ account ที่ i  ถ้า Transaction ซ้ำ ก็จะบวก temp ไปเรื่อยๆ
					temp++;  		//เพื่อจำนวนซ้ำไปเรื่อยๆ
					if (temp>=total_tran[i]){ 			//ถ้า จำนวนที่ซ้ำ มากว่าหรือเท่ากับ ก็ให้เก็บค่าไว้เลย รอไปแสดงผลถ้าไม่มีการเปลี่ยนแปลง   พูดง่ายๆคือ มีไว้สำหรับว่า ถ้ามีอีก type ที่ซ้ำเยอะกว่าตัวที่จะแสดงผลก็จะเปลี่ยนไปครับ
						total_tran[i]=temp;
						total_type[i]=state;
					}
				}else{  		//อันนี้เริ่มนับ ก็จะมาที่นี่ก่อน เพาะไม่มีข้อมูล 
					temp=1; 			//รับตัวแรกก็ต้องเป็น 1 แล้วก็จะเพื่อเรื่อยๆถ้าซ้ำ ^ อยู่ข้างบนนะ
					state=account[i].Transaction.charAt(j);		//เก็บว่าตัวแรกคืออะไร
				}
			}// จบ loop ที่ใช้เช็คความซ้ำ แต่ยังไม่แสดงนะครับ แสดงผลอยู่บรรทัดข้างล่างนี้
			System.out.print(account[i].customerName+" Long repeating Activity : ");
			if(total_type[i] == 'D') {//เป็นการระบุว่าเป็น Deposit หรือ Withdraw ที่บ่อย
				System.out.print("Deprosit ("+total_tran[i]+" Times)\n");
			}else {
				System.out.print("Withdraw ("+total_tran[i]+" Times)\n");
			}
		}// จบ loop ที่ไว้เช็คความซ้ำ และ แสดงจนครบทุก account แล้ว
	}
}// ปีกกาสุดท้ายนะอันนี้ ลืมเองอะ  ทุกคำสั่งต้องอยู่ใน "public class main {" นะครับ