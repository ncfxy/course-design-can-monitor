package com.tju.CanCommunication.test;

import java.util.Enumeration;
import java.util.Scanner;

import com.tju.CanCommunication.Communication.*;
import gnu.io.CommPortIdentifier;
import com.tju.CanCommunication.*;
import com.tju.CanCommunication.Operation.*;

public class Main {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// communicationTest();
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			String cinCmd = cin.next();
			Command newCmd = new Command(cinCmd);
			Rs232Command rs232 = new Rs232Command(newCmd, "COM3");
			ReceiveAnswer ans = rs232.sendCommand();
			
			String str = ans.getAnsString();
			char ch = str.charAt(0);
			System.out.println((int) ch);
			System.out.println(str);
		}
	}

	public static void communicationTest() {
		Rs232Command mycommand = new Rs232Command();
		String cmdStr = "";
		Command sendCmd = new Command(cmdStr);
		mycommand.setCmd(sendCmd);
		mycommand.sendCommand();
	}

}

