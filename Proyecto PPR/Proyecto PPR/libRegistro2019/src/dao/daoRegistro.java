package dao;

import entity.Registro;
import entity.iDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import utility.myLog;

/**
 *
 * @author carlosalberto
 */
public class daoRegistro implements iDAO{

    @Override
    public boolean create(Object obj) {
    boolean flag = false;
        try {
            Registro objR = (Registro) obj;
            Connection con = myConnection.ConectToMysql();
            String sql = "INSERT INTO tbl_registro(reg_usuario, reg_foto, reg_fecha, reg_hora, reg_tipo) VALUES(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, objR.getObjUsuario().getId());
            ps.setString(2, objR.getFoto());
            ps.setString(3, objR.getFecha());
            ps.setString(4,objR.getHora());
            ps.setString(5,objR.getTipo());
            ps.executeUpdate();
            flag = true;
        } catch (Exception e) {
            myLog.message(e.toString(), 0, "create()", "daoRegistro");
        }
        return flag;
    }

    @Override
    public Object read(String dato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean exists(String[] dato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void fillDataTable(DefaultTableModel listado, String[] dato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void fillComboBox(JComboBox cmb) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet fillDataNavigation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
