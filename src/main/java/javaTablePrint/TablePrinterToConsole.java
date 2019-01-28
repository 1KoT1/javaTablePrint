package javaTablePrint;

import java.util.Formatter;
import java.util.List;
import java.util.function.Function;

public class TablePrinterToConsole implements ITablePrinter {

	private static final String CEL_TEMPLATE = "%-15s";

	public <T> String print(Iterable<T> dataSource, int countOfColumn, Function<T, List<String>> rowReader) {
		StringBuilder res = new StringBuilder();
		try (Formatter formatter = new Formatter(res)) {
			for (T row : dataSource) {
				List<String> rowStr = rowReader.apply(row);
				for (int i = 0; i < countOfColumn; i++) {
					formatter.format(CEL_TEMPLATE, rowStr.get(i));
				}
				res.append('\n');
			}
		}
		return res.toString();
	}

	@Override
	public <T> String print(Iterable<T> dataSource, List<String> headers, Function<T, List<String>> rowReader) {
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
