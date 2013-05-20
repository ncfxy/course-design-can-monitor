package com.tju.CanCommunication.Operation;

public class CanInformation{
	public static String _portName;
	public static boolean _open;
	public static String _openModeId;
	public static String _bitRate;
	public static String _SJARegisterValue;
	
	public static void setDefault(){
		_portName = "COM3";
	}

}
