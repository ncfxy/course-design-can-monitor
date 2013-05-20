//Source file: C:\\Users\\Administrator\\Desktop\\com\\tju\\CanCommunication\\Operation\\Settings.java

package com.tju.CanCommunication.Operation;

import com.tju.CanCommunication.Communication.Command;
import com.tju.CanCommunication.Communication.ReceiveAnswer;
import com.tju.CanCommunication.Communication.Rs232Command;

public class Settings {

	/**
	 * @roseuid 5193494D025C
	 */
	public Settings() {

	}

	/**
	 * @roseuid 519347C30395
	 */
	public void setBaud(String bitRate) {
		if (CanInformation._open == false && judgeBitRateSet()) {
			Command newCmd = new Command("S" + bitRate);
			Rs232Command rs232 = new Rs232Command(newCmd,
					CanInformation._portName);
			ReceiveAnswer ans = rs232.sendCommand();
			CanInformation._bitRate = bitRate;
		}
	}

	/**
	 * @roseuid 5193480D00B7
	 */
	public void setCANMode(String modeId) {
		if (CanInformation._open == true) {
			Command newCmd = new Command("C");
			Rs232Command rs232 = new Rs232Command(newCmd,
					CanInformation._portName);
			ReceiveAnswer ans = rs232.sendCommand();
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			newCmd = new Command("O" + modeId);
			rs232 = new Rs232Command(newCmd, CanInformation._portName);
			ans = rs232.sendCommand();
			CanInformation._openModeId = modeId;
		} else {
			if (judgeBitRateSet()) {
				Command newCmd = new Command("O" + modeId);
				Rs232Command rs232 = new Rs232Command(newCmd,
						CanInformation._portName);
				ReceiveAnswer ans = rs232.sendCommand();
				CanInformation._openModeId = modeId;
			} else {
				System.out.println("No S6");
			}
		}

	}

	/**
	 * @roseuid 5193482501D9
	 */
	public void setSJA_Register(String value) {
		

	}
	
	public void setACR_Register(String value){
		if (judgeBitRateSet() && CanInformation._open == false) {
			Command newCmd = new Command("M" + value);
			Rs232Command rs232 = new Rs232Command(newCmd,
					CanInformation._portName);
			ReceiveAnswer ans = rs232.sendCommand();
			CanInformation._SJARegisterValue = value;
		}
	}

	/**
	 * @roseuid 51934FE1024A
	 */
	public void setOtherRegister() {

	}

	/**
	 * @roseuid 51934FFE033A
	 */
	public void clearAndInit() {

	}

	/**
	 * @roseuid 5193502F02EA
	 */
	public void setDocCmdCycle() {

	}

	/**
	 * @roseuid 5193505A0308
	 */
	public void isAddTimeFlag() {

	}

	/**
	 * @roseuid 5193506A01AA
	 */
	public void isBlockMode() {

	}

	private boolean judgeBitRateSet() {
		return CanInformation._bitRate.compareTo("0") >= 0
				&& CanInformation._bitRate.compareTo("8") <= 0;
	}
}
