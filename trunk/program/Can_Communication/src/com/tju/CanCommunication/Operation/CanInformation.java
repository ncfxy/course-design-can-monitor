package com.tju.CanCommunication.Operation;

public class CanInformation{
	public static String _portName;
	public static boolean _open;
	public static String _openMode;
	public static String _openModeId;
	public static String _bitRate;
	public static String _SJARegisterValue;
	public static String _ACRRegisterValue;
	public static String _BTRRegisterValue;
	public static String _AMRRegisterValue;
	public static boolean _isFlush = false;  //�Ƿ����f����Ƿ��Ѿ�Flush
	public static String _DocCmdCycle;       //�����ļ����������
	
	
	public static void setDefault(){
		_portName = "COM3";
		_openMode = new String();
		_openModeId = new String();
		_bitRate = new String();
		_SJARegisterValue = new String();
		_ACRRegisterValue = new String();
		_BTRRegisterValue = new String();
		_AMRRegisterValue = new String();
		_DocCmdCycle = new String();
	}

}
