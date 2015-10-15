
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class StudioTableModel extends AbstractTableModel {

    private final int STUDIO_NAME = 0;
    private final int STUDIO_ADDRESS = 1;
    private final int STUDIO_OWNER = 2;
    private final int STUDIO_PHONE = 3;

    private String[] columnNames = {"Name", "Address", "Owner",
        "Phone"};
    private boolean[] editableCells = { true, true, true, true };

    private ArrayList<String> studio;

    public StudioTableModel(ArrayList<String> studio) {
        this.studio = studio;
        for (int i = 0; i < 4; i++) {
            setValueAt(studio.get(i), 0, i);
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
        studio.set(col, value.toString());
        fireTableCellUpdated(row, col);

    }

    @Override
    public Object getValueAt(int row, int col) {
        return studio.get(col);
    }

}
