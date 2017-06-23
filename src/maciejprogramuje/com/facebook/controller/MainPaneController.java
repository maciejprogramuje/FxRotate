package maciejprogramuje.com.facebook.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import maciejprogramuje.com.facebook.table.TableArr;
import maciejprogramuje.com.facebook.table.TableGrid;

public class MainPaneController implements Initializable {
	@FXML ControlPaneController controlPaneController;
	@FXML FirstPaneController firstPaneController;
	@FXML SecondPaneController secondPaneController;
	
	Integer numOfColumns, numOfRows;
	TableGrid firstTable, secondTable;
	GridPane gp1;
	GridPane gp2;
	TableArr firstTableArr, secondTableArr;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Button clockwiseButton = controlPaneController.getClockwiseButton();
		Button counterClockwiseButton = controlPaneController.getCounterClockwiseButton();
		gp1 = firstPaneController.getGridPane();
		gp2 = secondPaneController.getGridPane();
						
		clockwiseButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				readNumbers();
				makeTableGrids();
				makeTableArrays();								
				firstTableArr.fillTableArr();
				secondTableArr = firstTableArr.rotateClockwise(secondTable);
				printTables();
			}		
		});
		
		counterClockwiseButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				readNumbers();
				makeTableGrids();
				makeTableArrays();
				firstTableArr.fillTableArr();
				secondTableArr = firstTableArr.rotateCounterClockwise(secondTable);
				printTables();				
			}		
		});	
	}
	
	private void readNumbers() {
		numOfColumns = Integer.valueOf(controlPaneController.getColTextField().getText());
		numOfRows = Integer.valueOf(controlPaneController.getRowTextField().getText());
		if(numOfColumns > 20 || numOfRows > 20) {
			numOfColumns = 0;
			numOfRows = 0;
			controlPaneController.setColTextField("0");
			controlPaneController.setRowTextField("0");
			
			Parent parent = null;
            try {
                parent = FXMLLoader.load(getClass().getResource("/maciejprogramuje/com/facebook/view/CautionPane.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.show();
		}
	}
	
	private void makeTableGrids() {
		firstTable = new TableGrid(numOfColumns, numOfRows, gp1);
		secondTable = new TableGrid(numOfRows, numOfColumns, gp2);
	}
	
	private void makeTableArrays() {
		firstTableArr = new TableArr(firstTable);
		secondTableArr = new TableArr(secondTable);
	}
	
	private void printTables() {
		firstTable.print(firstTableArr);
		secondTable.print(secondTableArr);
	}
}
