package javaTablePrint;

public interface IRowReader<T> {
	String getCell(T dataSourceRow, int columnId);
}
