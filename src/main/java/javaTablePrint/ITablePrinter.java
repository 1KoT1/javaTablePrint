package javaTablePrint;

public interface ITablePrinter {
	<T> String print(Iterable<T> dataSource, int countOfColumn, IRowReader<T> rowReader);
}
