
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class AlbumTableModel extends AbstractTableModel {

    private final int ALBUM_TITLE = 0;
    private final int GROUP_NAME = 1;
    private final int STUDIO_NAME = 2;
    private final int DATE_RECORDED = 3;
    private final int LENGTH = 4;
    private final int NUMBER_OF_SONGS = 5;

    private String[] columnNames = {"Title", "Group", "Studio",
        "Date", "Length", "# of Songs"
    };
    private boolean[] editableCells = { true, true, true, true, true, true };

    private ArrayList<String> albums;

    public AlbumTableModel(ArrayList<String> album) {
        this.albums = album;
        for (int i = 0; i < 6; i++) {
            setValueAt(album.get(i), 0, i);
        }
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return 1;
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return editableCells[col];
    }
    
    public void setCellsEditable(boolean value) {
        for (int i = 0; i < editableCells.length; i++)
            editableCells[i] = value;
    }

    @Override
    public void setValueAt(Object value, int row, int col) {

        albums.set(col, value.toString());
        fireTableCellUpdated(row, col);

    }

    @Override
    public Object getValueAt(int row, int col) {
        return albums.get(col);
    }

    
}
