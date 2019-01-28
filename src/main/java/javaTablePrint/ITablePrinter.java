package javaTablePrint;

import java.util.List;
import java.util.function.Function;

public interface ITablePrinter {
	<T> String print(Iterable<T> dataSource, int countOfColumn, Function<T, List<String>> rowReader);

	<T> String print(Iterable<T> dataSource, List<String> headers, Function<T, List<String>> rowReader);
}
