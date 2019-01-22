package javaTablePrint;

import java.util.List;

public class TablePrinterToHtml implements ITablePrinter {

	private static final String TABLE_BEGIN_TEG = "<table>";
	private static final String TABLE_END_TEG = "</table>";
	private static final String HEADER_BEGIN_TEG = "<th>";
	private static final String HEADER_END_TEG = "</th>";
	private static final String ROW_BEGIN_TEG = "<tr>";
	private static final String ROW_END_TEG = "</tr>";
	private static final String CELL_BEGIN_TEG = "<td>";
	private static final String CELL_END_TEG = "</td>";

	@Override
	public <T> String print(Iterable<T> dataSource, int countOfColumn, IRowReader<T> rowReader) {
		StringBuilder res = new StringBuilder();
		res.append(TABLE_BEGIN_TEG);
		for (T row : dataSource) {
			res.append(ROW_BEGIN_TEG);
			for (int i = 0; i < countOfColumn; i++) {
				res.append(CELL_BEGIN_TEG);
				res.append(rowReader.getCell(row, i));
				res.append(CELL_END_TEG);
			}
			res.append(ROW_END_TEG);
		}
		res.append(TABLE_END_TEG);
		return res.toString();
	}

	@Override
	public <T> String print(Iterable<T> dataSource, List<String> headers, IRowReader<T> rowReader) {
		StringBuilder res = new StringBuilder();
		res.append(TABLE_BEGIN_TEG);
		res.append(ROW_BEGIN_TEG);
		for (String header : headers) {
			res.append(HEADER_BEGIN_TEG);
			res.append(header);
			res.append(HEADER_END_TEG);
		}
		res.append(ROW_END_TEG);
		for (T row : dataSource) {
			res.append(ROW_BEGIN_TEG);
			for (int i = 0; i < headers.size(); i++) {
				res.append(CELL_BEGIN_TEG);
				res.append(rowReader.getCell(row, i));
				res.append(CELL_END_TEG);
			}
			res.append(ROW_END_TEG);
		}
		res.append(TABLE_END_TEG);
		return res.toString();
	}

}
