package com.tju.CanMonitor.Windows;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Start extends Application{
	
	public static void main(String[] args){
		Application.launch(args);
	}
	
	public void start(Stage stage) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
		Scene scene = new Scene(root,960,640);
		stage.initStyle(StageStyle.DECORATED);
		stage.setScene(scene);
		stage.setTitle("MainWindow");
		stage.show();
	}

}
