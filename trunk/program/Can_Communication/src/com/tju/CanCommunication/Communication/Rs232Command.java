//Source file: C:\\Users\\Administrator\\Desktop\\com\\tju\\CanCommunication\\Communication\\Rs232Command.java

package com.tju.CanCommunication.Communication;

import gnu.io.CommPortIdentifier;

import java.util.Enumeration;

import com.tju.CanCommunication.test.CommUtil;

public class Rs232Command implements CmdCommunication {
	private Command _cmd;
	private ReceiveAnswer _ans;
	private String _portName;

	/**
	 * @roseuid 5194775903C8
	 */
	public Rs232Command() {

	}

	public Rs232Command(Command newCmd) {
		_cmd = newCmd;
	}

	public Rs232Command(Command newCmd, String portName) {
		_cmd = newCmd;
		_portName = portName;
	}

	/**
	 * @return com.tju.CanCommunication.Communication.Command
	 * @roseuid 51947BEA02F1
	 */
	public Command getCmd() {
		return _cmd;
	}

	/**
	 * @param newCmd
	 * @roseuid 51947BFA01EE
	 */
	public void setCmd(Command newCmd) {
		_cmd = newCmd;

	}

	/**
	 * @return com.tju.CanCommunication.Communication.ReceiveAnswer
	 * @roseuid 51947C55038E
	 */
	public ReceiveAnswer getAns() {
		return _ans;
	}

	/**
	 * @param _sendcmd
	 * @return com.tju.CanCommunication.Communication.ReceiveAnswer
	 * @roseuid 51947F3A016B
	 */
	public synchronized ReceiveAnswer sendCommand(Command sendCmd,
			String comPort) {

		Enumeration<CommPortIdentifier> portList = CommPortIdentifier
				.getPortIdentifiers(); // 得到当前连接上的端口

		CommUtil comm3 = new CommUtil(portList, comPort);
		comm3.send(sendCmd.getFinalString());
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		comm3.ClosePort();
		return new ReceiveAnswer(comm3.getAnsString());
	}

	public ReceiveAnswer sendCommand() {
		return sendCommand(_cmd, _portName);
	}

}
/**
 * void Rs232Command.sendCommand(){
 * 
 * }
 */
