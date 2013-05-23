package com.tju.CanCommunication.Operation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.scene.BoundsAccessor;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.effect.Effect;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CanInformation {
	public static String _portName;
	public static boolean _open;
	public static String _openModeId;
	public static String _bitRate;
	public static String _SJARegisterValue;
	public static String _ACRRegisterValue;
	public static String _BTRRegisterValue;
	public static String _AMRRegisterValue;
	public static boolean _isFlush = false;
	public static String _DocCmdCycle;
	public static String _baudRate;
	public static ArrayList<TreeItem<String>> _messageTreeItem;
	public static ArrayList<TreeItem<String>> _signalTreeItem;
	public static ArrayList<Message> _message;
	public static ArrayList<Signal> _signal;
	public static TextArea _systemState;
	public static Stage _addMessageWindow;
	public static Stage _addSignalWindow;
	public static Stage _addSignalToMessage;
	public static Map<Message, ArrayList<Signal>> _map;
	public static String _timeStamp;
	public static String _block;

	public static void setDefault() {
		_portName = "COM3";
		_openModeId = new String();
		_bitRate = new String();
		_SJARegisterValue = new String();
		_ACRRegisterValue = new String();
		_BTRRegisterValue = new String();
		_AMRRegisterValue = new String();
		_DocCmdCycle = new String();
		_baudRate = "19200";
		_messageTreeItem = new ArrayList<TreeItem<String>>();
		_signalTreeItem = new ArrayList<TreeItem<String>>();
		_message = new ArrayList<Message>();
		_signal = new ArrayList<Signal>();
		_map = new HashMap<Message, ArrayList<Signal>>();
		_timeStamp = new String("OFF");
		_block = new String("OFF");
	}

	public static void addMessage(String name, String id, String length,
			String type) {
		Message msg = new Message(name, id, length, type);
		_message.add(msg);
		_messageTreeItem.add(new TreeItem<String>(name));
	}

	public static void addSignal(String name, String id, String length,
			String start, String end) {
		Signal sig = new Signal(name, id, length, start, end);
		_signal.add(sig);
		_signalTreeItem.add(new TreeItem<String>(name));
	}

	public static void setSystemStates() {
		String ans = "";
		ans += "Mode: ";
		if (_open == false) {
			ans += "Reset Mode\n";
		} else {
			switch (_openModeId) {
			case "0":
				ans += "Self Test Mode\n";
				break;
			case "1":
				ans += "Normal Mode\n";
				break;
			case "2":
				ans += "Listen Only\n";
				break;
			default:
				break;
			}
		}
		ans += "BaudRate: " + _baudRate + "\n";
		ans += "Port: " + _portName + "\n";
		ans += "Bit Rate: ";
		if (_bitRate.equals("")) {
			ans += "Not Set\n";
		} else {
			ans += _bitRate + "\n";
		}
		ans += "TimeStamp: " + _timeStamp + "\n";
		ans += "Block: " + _block + "\n";
		ans += "BTRRegisterValue: ";
		ans += _BTRRegisterValue + "\n";
		ans += "ACRRegisterValue: ";
		ans += _ACRRegisterValue + "\n";
		ans += "AMRRegisterValue: ";
		ans += _AMRRegisterValue + "\n";
		_systemState.setText(ans);
	}

	public static void setSystemStates(TextArea infoText) {
		_systemState = infoText;
		setSystemStates();
	}

	public static String getOpenMode() {
		if (_openModeId == "0") {
			return "Self Test";
		} else if (_openModeId == "1") {
			return "Normal Mode";
		} else {
			return "Listen Only";
		}
	}

}
