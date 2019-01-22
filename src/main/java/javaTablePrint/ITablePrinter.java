package javaTablePrint;

import java.util.List;

public interface ITablePrinter {
	<T> String print(Iterable<T> dataSource, int countOfColumn, IRowReader<T> rowReader);

	<T> String print(Iterable<T> dataSource, List<String> headers, IRowReader<T> rowReader);
}
