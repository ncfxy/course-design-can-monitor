package com.tju.CanMonitor.Windows;

import java.net.URL;
import java.util.ResourceBundle;

import sun.nio.ch.WindowsAsynchronousChannelProvider;

import com.tju.CanCommunication.Operation.CanInformation;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;

public class AddSignalWindow {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button addButton;

	@FXML
	private TextField endBit;

	@FXML
	private TextField signalId;

	@FXML
	private TextField signalLength;

	@FXML
	private TextField signalName;

	@FXML
	private TextField startBit;

	@FXML
	void addSignal(MouseEvent event) {
		String sigName = signalName.getText();
		String sigId = signalId.getText();
		String sigLength = signalLength.getText();
		String sBit = startBit.getText();
		String eBit = endBit.getText();
		CanInformation.addSignal(sigName, sigId, sigLength, sBit, eBit);
		CanInformation._addSignalWindow.close();
	}

	@FXML
	void initialize() {
		assert addButton != null : "fx:id=\"addButton\" was not injected: check your FXML file 'AddSignal.fxml'.";
		assert endBit != null : "fx:id=\"endBit\" was not injected: check your FXML file 'AddSignal.fxml'.";
		assert signalId != null : "fx:id=\"signalId\" was not injected: check your FXML file 'AddSignal.fxml'.";
		assert signalLength != null : "fx:id=\"signalLength\" was not injected: check your FXML file 'AddSignal.fxml'.";
		assert signalName != null : "fx:id=\"signalName\" was not injected: check your FXML file 'AddSignal.fxml'.";
		assert startBit != null : "fx:id=\"startBit\" was not injected: check your FXML file 'AddSignal.fxml'.";

	}

}
