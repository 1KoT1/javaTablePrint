package javaTablePrint;

import java.util.ArrayList;
import java.util.Arrays;
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
		String q = tp.print(col, 2,
				dataSourceRow -> Arrays.asList(Integer.toString(dataSourceRow.field1), dataSourceRow.field2));
		// Output string to console.
		System.out.print(q);
		// It print
		// 516            test           
		// 54             qqqqqq wwwwww  

		// Print console with headers.
		// Create printer which can create string with formatting text for print to
		// console.
		ITablePrinter tp2 = new TablePrinterToConsole();
		// Print table to string.
		// You need implement IRowReader for convert fields of your class to strings.
		String q2 = tp2.print(col, Arrays.asList("Header1", "Header2"),
				dataSourceRow -> Arrays.asList(Integer.toString(dataSourceRow.field1), dataSourceRow.field2));
		// Output string to console.
		System.out.print(q2);
		// It print
		// Header1        Header2        
		// 516            test           
		// 54             qqqqqq wwwwww 

		// Print console with headers.
		// Create printer which can create string with formatting text for print to
		// console.
		ITablePrinter tp3 = new TablePrinterToHtml();
		// Print table to string.
		// You need implement IRowReader for convert fields of your class to strings.
		String q3 = tp3.print(col, Arrays.asList("Header1", "Header2"),
				dataSourceRow -> Arrays.asList(Integer.toString(dataSourceRow.field1), dataSourceRow.field2));
		// Output string to console.
		System.out.print(q3);
		// It print
		// <table><tr><th>Header1</th><th>Header2</th></tr><tr><td>516</td><td>test</td></tr><tr><td>54</td><td>qqqqqq wwwwww</td></tr></table>
	}
}
