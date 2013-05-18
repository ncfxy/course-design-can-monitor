package com.tju.CanCommunication.test;

import java.util.Enumeration;
import java.util.Scanner;

import com.tju.CanCommunication.Communication.*;
import gnu.io.CommPortIdentifier;
import com.tju.CanCommunication.*;

public class Main {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// communicationTest();
		//testRXTX();
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			String cinCmd = cin.next();
			final Command newCmd = new Command(cinCmd);
			new Thread(new Runnable() {
				public void run() {
					Rs232Command rs232 = new Rs232Command(newCmd, "COM3");
					ReceiveAnswer ans = rs232.sendCommand();
					String str = ans.getAnsString();
					char ch = str.charAt(0);
					System.out.println((int) ch);
					System.out.println(str);
				}
			}).start();
		}
	}

	public static void communicationTest() {
		Rs232Command mycommand = new Rs232Command();
		String cmdStr = "";
		Command sendCmd = new Command(cmdStr);
		mycommand.setCmd(sendCmd);
		mycommand.sendCommand();
	}

	public static void testRXTX() throws InterruptedException {
		Enumeration portList = CommPortIdentifier.getPortIdentifiers(); // 得到当前连接上的端口

		CommUtil comm3 = new CommUtil(portList, "COM3");
		int i = 0;
		while (i < 1) {

			comm3.send("C\r");
			Thread.sleep(100);
			String newStr = new String(comm3.readBuffer);
			char ch = newStr.charAt(0);
			System.out.println((int) ch);
			i++;
		}
		comm3.ClosePort();
	}

	public static void operationTest() {

	}

}
