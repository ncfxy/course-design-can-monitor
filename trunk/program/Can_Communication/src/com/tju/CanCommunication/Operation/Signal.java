package com.tju.CanCommunication.Operation;

public class Signal {
	public String sigName, sigId, sigLength, startBit, endBit;

	Signal(String name, String id, String length, String start, String end) {
		sigName = name;
		sigId = id;
		sigLength = length;
		startBit = start;
		endBit = end;
	}
}
