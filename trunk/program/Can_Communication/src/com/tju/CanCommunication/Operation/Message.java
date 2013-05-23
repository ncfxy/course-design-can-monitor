package com.tju.CanCommunication.Operation;

public class Message {

	public String msgName, msgId, msgLength, msgType;

	Message(String name, String id, String length, String type) {
		msgName = name;
		msgId = id;
		msgLength = length;
		msgType = type;
	}

	public String getName() {
		return msgName;
	}

	public String getId() {
		return msgId;
	}

	public String getLength() {
		return msgLength;
	}

	public String getType() {
		return msgType;
	}

}
