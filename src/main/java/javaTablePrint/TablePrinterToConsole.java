package javaTablePrint;

import java.util.Formatter;
import java.util.List;

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

	@Override
	public <T> String print(Iterable<T> dataSource, List<String> headers, IRowReader<T> rowReader) {
		StringBuilder res = new StringBuilder();
		try (Formatter formatter = new Formatter(res)) {
			for (String header : headers) {
				formatter.format(CEL_TEMPLATE, header);
			}
			res.append('\n');
		}
		res.append(print(dataSource, headers.size(), rowReader));
		return res.toString();
	}

}
