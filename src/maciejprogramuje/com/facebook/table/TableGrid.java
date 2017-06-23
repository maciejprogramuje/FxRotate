package maciejprogramuje.com.facebook.table;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class TableGrid {
	Integer columns;
	Integer rows;
	GridPane gp;
	
	public Integer getColumns() {
		return columns;
	}
	public Integer getRows() {
		return rows;
	}

	public TableGrid(Integer columns, Integer rows, GridPane gp) {
		this.columns = columns;
		this.rows = rows;
		this.gp = gp;
	}
	
	public void print(TableArr arr) {
		clearTable();
		int labelWidth = calculateMaxWidthOfLabel();
				
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				Label lab = new Label(arr.getArr()[j][i].toString());
				lab.setPrefWidth(labelWidth);
				gp.add(lab, j, i);
			}
		}
	}
	
	private void clearTable() {
		gp.getChildren().clear();
		gp.getRowConstraints().clear();
		gp.getColumnConstraints().clear();
	}
	
	private int calculateMaxWidthOfLabel() {
		int tempNumber = columns * rows;
		int widthIndex = 1;
		
		while(tempNumber / 10 > 0) {
			widthIndex++;
			tempNumber /= 10;
		}
		
		return 15 * widthIndex;
	}
}
