package maciejprogramuje.com.facebook.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControlPaneController implements Initializable {
	@FXML private Button counterClockwiseButton;
	@FXML private Button clockwiseButton;
    @FXML private TextField colTextField;
   	@FXML private Label label1;
    @FXML private Label label2;
    @FXML private TextField rowTextField;

	public TextField getColTextField() {
		return colTextField;
	}
	public TextField getRowTextField() {
		return rowTextField;
	}
	public Button getCounterClockwiseButton() {
		return counterClockwiseButton;
	}
	public Button getClockwiseButton() {
		return clockwiseButton;
	}
	public void setColTextField(String text) {
		this.colTextField.setText(text);
	}
	public void setRowTextField(String text) {
		this.rowTextField.setText(text);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
