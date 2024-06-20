package tw.org.iii.apis;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//將資料庫內容讀出   Model 形成 表很重要要再看一下  （模型）
public class MyTable  extends JTable{
	//定義內部類別 讓外部類別可以使用
	private MyModel myModel;
	
	//擁有foodDB 物件
	private FoodDB foodDB;
	
	//外部建構式
	public MyTable() {
		try {
			foodDB = new FoodDB();
			foodDB.query();
		}catch(Exception e) {
			System.out.println(e);
		}
		
	
		myModel = new MyModel();
		setModel(myModel);
		
		//取得標題列
		myModel.setColumnIdentifiers(foodDB.getHeader());
	}
	
	//刪除功能
	public void delRow() {
		
		try {
			//滑鼠點擊取得那個row的位置
			//移動到滑鼠點擊的那裡
			foodDB.delData(getSelectedRow()+1);
			//刷新頁面
			repaint();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
	}
	
	//內部類別
	private class MyModel extends DefaultTableModel{
		//幾列
		@Override
		public int getRowCount() {
			return foodDB.getRows();
		}
		//幾欄
		@Override
		public int getColumnCount() {
			return foodDB.getCols();
		}
		//表格內容
		@Override
		public Object getValueAt(int row, int column) {
			return foodDB.getData(row+1, column+1);
		}
		
		//資料修改
		@Override
		public void setValueAt(Object aValue, int row, int column) {
			foodDB.updateData(row+1, column+1, (String)aValue);
		}
		
		//可刪除範圍
		@Override
		public boolean isCellEditable(int row, int column) {
			//預設都可以刪除
			boolean isEditable = true;
			//但當我碰到 ＩＤ那個欄位則不能刪除
			if (column == 0) isEditable = false;
			
			return isEditable;
		}
		
		
			
		
		
		
	}
}
