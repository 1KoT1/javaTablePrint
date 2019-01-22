package javaTablePrint;

import java.util.Formatter;

public class TablePrinterToConsole implements ITablePrinter {

	private static final String CEL_TEMPLATE = "%-15s";

	public <T> String print(Iterable<T> dataSource, int countOfColumn, IRowReader<T> rowReader) {
		StringBuilder res = new StringBuilder();
		try (Formatter formatter = new Formatter(res)) {
			for (T row : dataSource) {
				for (int i = 0; i < countOfColumn; i++) {
					formatter.format(CEL_TEMPLATE, rowReader.getCell(row, i));
				}
				res.append('\n');
			}
		}
		return res.toString();
	}
}
