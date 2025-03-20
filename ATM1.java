package com.constructors;

import java.util.Random;
//MY ATM PROJECT 
import java.util.Scanner;

public class ATM1 {
	String name;
	int acno;
	long balance;
	int pin;

	public ATM1(String name, int acno, long balance, int pin) {
		this.name = name;
		this.acno = acno;
		this.balance = balance;
		this.pin = pin;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();

		ATM1 s1 = new ATM1("jeevan", 1230450, 120000, 1255);
		ATM1 s2 = new ATM1("vegeta", 1230451, 1210000, 1001);
		ATM1 s3 = new ATM1("kakarot", 1230452, 122000, 2552);
		ATM1[] st = { s1, s2, s3 };
		System.out.println("enter student acno > ");
		int n = sc.nextInt();
		boolean ns = true;

		for (ATM1 s : st) {
			if (s.acno == n) {
				ns = false;
				System.out.println("welcome" + " " + s.name);
				System.out.println();
				System.out.println("Enter Your Pin > ");
				int pin = sc.nextInt();
				if (s.pin == pin) {
					String y = null;
					do {
						System.out.println("PRESS 1 TO CHECK BALANCE > ");
						System.out.println("PRESS 2 TO DEPOSIT > ");
						System.out.println("PRESS 3 TO WITHDRAW > ");
						System.out.println("PRESS 4 TO PIN CHANGE > ");
						System.out.println("PRESS 5 INCASE FORGOT PIN > ");
						int num = sc.nextInt();
						switch (num) {
						case 1: {
							System.out.println("LEDGER AMOUNT > " + s.balance);
							System.out.println("Thank You");
						}
							break;
						case 2: {
							System.out.println("Enter amount for Deposit > ");
							int c = sc.nextInt();
							if (c <= 100000) {
								s.balance = c + s.balance;
								System.out.println("LEDGER AMOUNT > " + s.balance);
							} else {
								System.out.println("Deposit Limit is 1,00,000 in One Transaction !");
							}
						}
							break;
						case 3: {
							System.out.println("Enter Withdraw Amount > ");
							int w = sc.nextInt();
							if (w > s.balance) {
								System.out.println("Insufficient funds!");
								System.out.println("Please Check Balance !");
							} else if (w <= 25000) {
								s.balance = s.balance - w;
								System.out.println("LEDGER AMOUNT > " + s.balance);
							} else {
								System.out.println("Withtdraw Limit is 25000 At a Time!");
							}
						}
							break;
						case 4: {
							System.out.println("Enter your Old Pin > ");
							int old = sc.nextInt();
							if (old != s.pin) {
								System.out.println("Current Pin doesnot Matched !");
							} else {
								System.out.println("Enter New Pin");
								int npin = sc.nextInt();
								int temp = npin;
								s.pin = temp;
								System.out.println("Pin Change Successful !" + s.pin);
								break;
							}

						}
							break;
						case 5: {
							int f = r.nextInt(1000, 9999);
							System.out.println("Your OTP > " + f);
							System.out.println("Enter OTP");
							int o = sc.nextInt();
							if (o == f) {
								System.out.println("Enter new pin");
								int p = sc.nextInt();
								s.pin = p;
								System.out.println("new pin" + s.pin);
							} else {
								System.out.println("OTP not matched!");
							}

						}
							break;
						default:
							System.out.println(" INVALID INPUT ");
							break;

						}
						System.out.println(" To Goto Main Menu Press Y");
						System.out.println(" To Exit Press N");
						y = sc.next();

					} while (y.equalsIgnoreCase("y"));
					System.out.println("Thank You , Visit Us Again !");
				} else {
					System.out.println("invalid student pin");
					break;
				}

			}

		}
		if (ns) {
			System.out.println("invalid Acno");
		}
	}

}
