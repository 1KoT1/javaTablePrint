package javaTablePrint;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Hello world!
 *
 */
public class App {

	// Make simple class for example. You can use any own class.
	public static class MyClass {
		public int field1;
		public String field2;

		MyClass(int field1, String field2) {
			this.field1 = field1;
			this.field2 = field2;
		}
	}

	public static void main(String[] args) {
		// It is example to print collection of objects to table.

		// Create source collection.
		Collection<MyClass> col = new ArrayList<>();
		col.add(new MyClass(516, "test"));
		col.add(new MyClass(54, "qqqqqq wwwwww"));

		// Print console.
		// Create printer which can create string with formatting text for print to
		// console.
		ITablePrinter tp = new TablePrinterToConsole();
		// Print table to string.
		// You need implement IRowReader for convert fields of your class to strings.
		String q = tp.print(col, 2, new IRowReader<MyClass>() {
			@Override
			public String getCell(MyClass dataSourceRow, int columnId) {
				switch (columnId) {
				case 0:
					return Integer.toString(dataSourceRow.field1);
				case 1:
					return dataSourceRow.field2;
				default:
					return "";
				}
			}
		});
		// Output string to console.
		System.out.print(q);
		// It print
		// 516            test           
		// 54             qqqqqq wwwwww  
	}
}
