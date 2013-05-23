package com.tju.CanMonitor.Windows;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.tju.CanCommunication.Operation.CanInformation;
import com.tju.CanCommunication.Operation.Message;
import com.tju.CanCommunication.Operation.Signal;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.TreeItem;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class MessageAddSignalWindow {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private GridPane bitMapPane;

	@FXML
	private TextField dataMode;

	@FXML
	private TextField msgId;

	@FXML
	private MenuButton msgMenu;

	@FXML
	private Button msgMenuSelect;

	@FXML
	private TextField msgName;

	@FXML
	private TextField msgType;

	@FXML
	private TextField sigLength;

	@FXML
	private MenuButton sigMenu;

	@FXML
	private Button sigMenuSelect;

	@FXML
	private TextField sigName;

	@FXML
	private TableView sigTableView;

	@FXML
	private Button addButton;

	@FXML
	private Button confirmButton;

	@FXML
	private TableColumn endColumn;

	@FXML
	private TableColumn indexColumn;

	@FXML
	private TableColumn startColumn;

	@FXML
	private TableColumn nameColumn;

	private ToggleButton[][] bitMapButton = new ToggleButton[10][10];
	private Message _selectMsg;
	private Signal _selectSignal;
	private TreeItem<String> _selectMsgTree;
	private Integer _indexNum;
	private final ObservableList<Select> data = FXCollections
			.observableArrayList();

	// WARNING: fx:id="startBit" cannot be injected: several objects share the
	// same fx:id;

	@FXML
	void addSignalToMsg(MouseEvent event) {
		data.add(new Select(_indexNum.toString(), _selectSignal.sigName,
				_selectSignal.startBit, _selectSignal.endBit));
		_indexNum++;
		int begin = Integer.parseInt(_selectSignal.startBit);
		int end = Integer.parseInt(_selectSignal.endBit);
		for (int i = begin; i <= end; i++) {
			int a = i / 8;
			int b = i % 8;
			if (bitMapButton[a][b].isSelected()) {
				System.out.println("This signal can't add to this message");
				return;
			}
		}
		for (int i = begin; i <= end; i++) {
			int a = i / 8;
			int b = i % 8;
			bitMapButton[a][b].setSelected(true);
		}
		ArrayList<Signal> msgSig = null;
		msgSig = CanInformation._map.get(_selectMsg);
		if (msgSig == null) {
			msgSig = new ArrayList<Signal>();
		}
		msgSig.add(_selectSignal);
		CanInformation._map.put(_selectMsg, msgSig);
		_selectMsgTree.getChildren().add(
				new TreeItem<String>(_selectSignal.sigName));
	}

	@FXML
	void confirm(MouseEvent event) {
		CanInformation._addSignalToMessage.close();
	}

	@FXML
	void initialize() {
		assert addButton != null : "fx:id=\"addButton\" was not injected: check your FXML file 'MessageAddSignal.fxml'.";
		assert bitMapPane != null : "fx:id=\"bitMapPane\" was not injected: check your FXML file 'MessageAddSignal.fxml'.";
		assert confirmButton != null : "fx:id=\"confirmButton\" was not injected: check your FXML file 'MessageAddSignal.fxml'.";
		assert dataMode != null : "fx:id=\"dataMode\" was not injected: check your FXML file 'MessageAddSignal.fxml'.";
		assert endColumn != null : "fx:id=\"endColumn\" was not injected: check your FXML file 'MessageAddSignal.fxml'.";
		assert indexColumn != null : "fx:id=\"indexColumn\" was not injected: check your FXML file 'MessageAddSignal.fxml'.";
		assert msgId != null : "fx:id=\"msgId\" was not injected: check your FXML file 'MessageAddSignal.fxml'.";
		assert msgMenu != null : "fx:id=\"msgMenu\" was not injected: check your FXML file 'MessageAddSignal.fxml'.";
		assert msgMenuSelect != null : "fx:id=\"msgMenuSelect\" was not injected: check your FXML file 'MessageAddSignal.fxml'.";
		assert msgName != null : "fx:id=\"msgName\" was not injected: check your FXML file 'MessageAddSignal.fxml'.";
		assert msgType != null : "fx:id=\"msgType\" was not injected: check your FXML file 'MessageAddSignal.fxml'.";
		assert nameColumn != null : "fx:id=\"nameColumn\" was not injected: check your FXML file 'MessageAddSignal.fxml'.";
		assert sigLength != null : "fx:id=\"sigLength\" was not injected: check your FXML file 'MessageAddSignal.fxml'.";
		assert sigMenu != null : "fx:id=\"sigMenu\" was not injected: check your FXML file 'MessageAddSignal.fxml'.";
		assert sigMenuSelect != null : "fx:id=\"sigMenuSelect\" was not injected: check your FXML file 'MessageAddSignal.fxml'.";
		assert sigName != null : "fx:id=\"sigName\" was not injected: check your FXML file 'MessageAddSignal.fxml'.";
		assert sigTableView != null : "fx:id=\"sigTableView\" was not injected: check your FXML file 'MessageAddSignal.fxml'.";
		assert startColumn != null : "fx:id=\"startColumn\" was not injected: check your FXML file 'MessageAddSignal.fxml'.";

		addBitMapButton();
		setMsgAndSig();
		setColumn();
	}

	public void addBitMapButton() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				bitMapButton[i][j] = new ToggleButton();
				int a = i * 8 + j;
				if (a < 10) {
					bitMapButton[i][j].setText("0" + a + "");
				} else {
					bitMapButton[i][j].setText(a + "");
				}
				bitMapPane.add(bitMapButton[i][j], j, i);
			}
		}
	}

	public void setMsgAndSig() {
		for (int i = 0; i < CanInformation._message.size(); i++) {
			String str = CanInformation._message.get(i).msgName;
			MenuItem item = new MenuItem(str);
			item.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					MenuItem item = (MenuItem) event.getSource();
					String name = item.getText();
					for (int i = 0; i < CanInformation._message.size(); i++) {
						if (name == CanInformation._message.get(i).msgName) {
							Message msg = CanInformation._message.get(i);
							msgName.setText(msg.msgName);
							msgId.setText(msg.msgId);
							msgType.setText(msg.msgType);
							_selectMsg = msg;
							_selectMsgTree = CanInformation._messageTreeItem
									.get(i);
							msgMenu.setText(msg.msgName);
							ArrayList<Signal> msgSig = null;
							msgSig = CanInformation._map.get(msg);
							if (msgSig == null) {
								return;
							}
							for (int j = 0; j < msgSig.size(); j++) {
								Signal sig = msgSig.get(j);
								data.add(new Select(_indexNum.toString(),
										sig.sigName, sig.startBit, sig.endBit));
								_indexNum++;
								int begin = Integer.parseInt(sig.startBit);
								int end = Integer.parseInt(sig.endBit);
								for (int k = begin; k <= end; k++) {
									int a = k / 8;
									int b = k % 8;
									bitMapButton[a][b].setSelected(true);
								}
							}
							break;
						}
					}
				}
			});
			msgMenu.getItems().add(item);
		}
		for (int i = 0; i < CanInformation._signal.size(); i++) {
			String str = CanInformation._signal.get(i).sigName;
			MenuItem item = new MenuItem(str);
			item.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					MenuItem item = (MenuItem) event.getSource();
					String name = item.getText();
					for (int i = 0; i < CanInformation._signal.size(); i++) {
						if (name == CanInformation._signal.get(i).sigName) {
							Signal sig = CanInformation._signal.get(i);
							sigName.setText(sig.sigName);
							sigLength.setText(sig.sigLength);
							dataMode.setText(sig.sigId);
							_selectSignal = sig;
							sigMenu.setText(sig.sigName);
							break;
						}
					}
				}
			});
			sigMenu.getItems().add(item);
		}
	}

	public void setColumn() {
		indexColumn
				.setCellValueFactory(new PropertyValueFactory<Select, String>(
						"index"));
		nameColumn
				.setCellValueFactory(new PropertyValueFactory<Select, String>(
						"signalName"));
		startColumn
				.setCellValueFactory(new PropertyValueFactory<Select, String>(
						"startBit"));
		endColumn.setCellValueFactory(new PropertyValueFactory<Select, String>(
				"endBit"));
		_indexNum = 1;
		sigTableView.setItems(data);
	}

	public static class Select {
		private final SimpleStringProperty index;
		private final SimpleStringProperty signalName;
		private final SimpleStringProperty startBit;
		private final SimpleStringProperty endBit;

		public Select(String id, String name, String start, String end) {
			this.index = new SimpleStringProperty(id);
			this.signalName = new SimpleStringProperty(name);
			this.startBit = new SimpleStringProperty(start);
			this.endBit = new SimpleStringProperty(end);
		}

		public String getIndex() {
			return index.get();
		}

		public void setIndex(String id) {
			index.set(id);
		}

		public String getSignalName() {
			return signalName.get();
		}

		public void setSignalName(String name) {
			signalName.set(name);
		}

		public String getStartBit() {
			return startBit.get();
		}

		public void setStartBit(String start) {
			startBit.set(start);
		}

		public String getEndBit() {
			return endBit.get();
		}

		public void setEndBit(String end) {
			endBit.set(end);
		}
	}

}
