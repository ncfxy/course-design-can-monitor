package com.tju.CanMonitor.Windows;

import java.net.URL;
import java.util.ResourceBundle;

import com.tju.CanCommunication.Operation.CanInformation;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AddMessageWindow {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField MsgLength;

	@FXML
	private Button addMsg;

	@FXML
	private RadioButton msgExtend;

	@FXML
	private TextField msgID;

	@FXML
	private TextField msgName;

	@FXML
	private RadioButton msgStd;

	@FXML
	private GridPane signalStd;

	@FXML
	void addMsg(MouseEvent event) {
		String name = msgName.getText();
		String id = msgID.getText();
		String length = MsgLength.getText();
		String type = null;
		if (msgStd.isSelected()) {
			type = "Standard";
		} else if (msgExtend.isSelected()) {
			type = "Extend";
		}
		CanInformation.addMessage(name, id, length, type);
		CanInformation._addMessageWindow.close();
	}

	@FXML
	void initialize() {
		assert MsgLength != null : "fx:id=\"MsgLength\" was not injected: check your FXML file 'AddMessage.fxml'.";
		assert addMsg != null : "fx:id=\"addMsg\" was not injected: check your FXML file 'AddMessage.fxml'.";
		assert msgExtend != null : "fx:id=\"msgExtend\" was not injected: check your FXML file 'AddMessage.fxml'.";
		assert msgID != null : "fx:id=\"msgID\" was not injected: check your FXML file 'AddMessage.fxml'.";
		assert msgName != null : "fx:id=\"msgName\" was not injected: check your FXML file 'AddMessage.fxml'.";
		assert msgStd != null : "fx:id=\"msgStd\" was not injected: check your FXML file 'AddMessage.fxml'.";
		assert signalStd != null : "fx:id=\"signalStd\" was not injected: check your FXML file 'AddMessage.fxml'.";

		setRadioButton();
	}

	public void setRadioButton() {
		final ToggleGroup group = new ToggleGroup();
		msgStd.setToggleGroup(group);
		msgStd.setSelected(true);
		msgExtend.setToggleGroup(group);
	}

}
