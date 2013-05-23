package com.tju.CanMonitor.Windows;

import java.awt.Dimension;
import java.awt.Toolkit;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StartMessageAddSignal extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub

		Parent root = FXMLLoader.load(getClass().getResource("MessageAddSignal.fxml"));

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		Scene scene = new Scene(root,800,600);
		stage.initStyle(StageStyle.DECORATED);
		stage.setScene(scene);
		stage.setTitle("MainWindow");
		stage.show();
	}
	
	public void startWindow(){
		String[] args = null;
		Application.launch(args);
	}

}
