package maciejprogramuje.com.facebook.table;

public class TableArr {
	Integer[][] arr;
	int rows, columns, index;
	
	public Integer[][] getArr() {
		return arr;
	}

	public TableArr(TableGrid firstTable) {
		rows = firstTable.getRows();
		columns = firstTable.getColumns();
		arr = new Integer[columns][rows];
		index = 1;
	}
	
	public void fillTableArr() {
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				arr[j][i] = index;
				index++;
			}
		}
	}
	
	public TableArr rotateClockwise(TableGrid secondTable) {
		TableArr tempArr = new TableArr(secondTable); 
		
		for(int i = 0; i < secondTable.getColumns(); i++) {
			for(int j = 0; j < secondTable.getRows(); j++) {
				tempArr.getArr()[i][j] = arr[j][secondTable.getColumns() - 1 - i];
			}
		}
		
		return tempArr; 
	}
	
	public TableArr rotateCounterClockwise(TableGrid secondTable) {
		TableArr tempArr = new TableArr(secondTable); 
		
		for(int i = 0; i < secondTable.getColumns(); i++) {
			for(int j = 0; j < secondTable.getRows(); j++) {
				tempArr.getArr()[i][j] = arr[secondTable.getRows() - 1 - j][i];
			}
		}
		
		return tempArr; 
	}
}
