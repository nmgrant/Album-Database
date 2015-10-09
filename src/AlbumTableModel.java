
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class AlbumTableModel extends AbstractTableModel {

    private final int ALBUM_TITLE = 0;
    private final int GROUP_NAME = 1;
    private final int STUDIO_NAME = 2;
    private final int DATE_RECORDED = 3;
    private final int LENGTH = 4;
    private final int NUMBER_OF_SONGS = 5;
    
    private String[] columnNames = { "Title", "Group", "Studio",
     "Date", "Length", "# of Songs"
    };
    
    private ArrayList<String> albums;
    
    public AlbumTableModel(ArrayList<String> album) {
        albums = album;
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
    public String getValueAt(int row, int col) {
        
        switch (col) {
            case ALBUM_TITLE:
                return albums.get(ALBUM_TITLE);
            case GROUP_NAME:
                return albums.get(GROUP_NAME);
            case STUDIO_NAME:
                return albums.get(STUDIO_NAME);
            case DATE_RECORDED:
                return albums.get(DATE_RECORDED);
            case LENGTH:
                return albums.get(LENGTH);
            case NUMBER_OF_SONGS:
                return albums.get(NUMBER_OF_SONGS);
            default:
                return albums.get(ALBUM_TITLE);
        }
    }
}
