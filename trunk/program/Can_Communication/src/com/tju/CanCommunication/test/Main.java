package com.tju.CanCommunication.test;

import com.tju.CanCommunication.Communication.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		communicationTest();
	}
	
	public static void communicationTest(){
		Rs232Command mycommand = new Rs232Command();
		String cmdStr = "";
		Command sendCmd = new Command(cmdStr);
		mycommand.setCmd(sendCmd);
		mycommand.sendCommand(sendCmd);
	}
	
	public static void operationTest(){
		
	}

}
