//Source file: C:\\Users\\Administrator\\Desktop\\com\\tju\\CanCommunication\\Operation\\SendMsgAndCmd.java

package com.tju.CanCommunication.Operation;

import com.tju.CanCommunication.Communication.Command;
import com.tju.CanCommunication.Communication.ReceiveAnswer;
import com.tju.CanCommunication.Communication.Rs232Command;

public class SendMsgAndCmd {

	/**
	 * @roseuid 5193494D02CA
	 */
	public SendMsgAndCmd() {

	}

	/**
	 * @roseuid 519353770011 ���ͱ�׼11bit���֡���������
	 *          ʹ��t����,�ڽ������б�����Ӽ��麯��valueֵ�ĵ�һ���ַ��Ƿ���"t"
	 */
	public ReceiveAnswer sendStandard11WithData(String value) {
		ReceiveAnswer ans = null;
		if (CanInformation._open == true) {
			Command newCmd = new Command(value);
			Rs232Command rs232 = new Rs232Command(newCmd,
					CanInformation._portName);
			ans = rs232.sendCommand();
			return ans;
		}
		return ans;
	}

	/**
	 * ����11λ���֡��������ݲ��� ͬ����Ҫ�ڽ�����������жϺ��������ݵ�һλ֪���ǡ�r��
	 */
	public ReceiveAnswer sendStandard11WithoutData(String value) {
		ReceiveAnswer ans = null;
		if (CanInformation._open == true) {
			Command newCmd = new Command(value);
			Rs232Command rs232 = new Rs232Command(newCmd,
					CanInformation._portName);
			ans = rs232.sendCommand();
			return ans;
		}
		return ans;
	}

	/**
	 * @roseuid 5193540202DE ����29λ����ݵ���չ���֡����Ҫ�����֡
	 *          ��Ҫ�ڽ����������Ŷ���κ����͵�һλ�Ƿ���'T'
	 */
	public ReceiveAnswer sendExtend29WithoutData(String value) {
		ReceiveAnswer ans = null;
		if (CanInformation._open == true) {
			Command newCmd = new Command(value);
			Rs232Command rs232 = new Rs232Command(newCmd,
					CanInformation._portName);
			ans = rs232.sendCommand();
			return ans;
		}
		return ans;
	}

	/**
	 * @roseuid 5193550201B4
	 */
	public ReceiveAnswer sendExtend29WithData(String value) {
		ReceiveAnswer ans = null;
		if (CanInformation._open == true) {
			Command newCmd = new Command(value);
			Rs232Command rs232 = new Rs232Command(newCmd,
					CanInformation._portName);
			ans = rs232.sendCommand();
			return ans;
		}
		return ans;
	}

	/**
	 * @roseuid 519355330092 ���ļ��������
	 */
	public void getCmdFromFile(String value) {

	}

	/**
	 * @roseuid 5193554200B0 ����ź�
	 */
	public void addSignal() {

	}

	/**
	 * @roseuid 519355A60308
	 */
	public void addMsg() {

	}

	/**
	 * @roseuid 519355B701A0
	 */
	public void addSignalToMsg() {

	}
}
