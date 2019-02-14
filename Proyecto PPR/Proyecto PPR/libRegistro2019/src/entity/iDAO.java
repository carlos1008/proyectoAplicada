package entity;

import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public interface iDAO {
    public boolean create(Object obj);
    public Object read(String dato);
    public boolean update(Object obj);
    public boolean delete(Object obj);    
    public boolean exists(String[] dato);
    public void fillDataTable(DefaultTableModel listado, String dato[]);
    public void fillComboBox(JComboBox cmb);
    public ResultSet fillDataNavigation();
    
}
