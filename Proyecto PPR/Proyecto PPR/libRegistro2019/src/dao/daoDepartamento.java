package dao;

import entity.Departamento;
import entity.Combo;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import entity.iDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import utility.myLog;

public class daoDepartamento implements iDAO {

    @Override
    public boolean create(Object obj) {
        boolean flag = false;
        try {
            Departamento objD = (Departamento) obj;
            String[] datoV = {objD.getNombre()};
            if (exists(datoV)) {
                myLog.message("Departamento ya existe", 1, "create()", "daoDepartamento");
                return false;
            }
            Connection con = myConnection.ConectToMysql();
            String sql = "INSERT INTO tbl_departamento(dep_nombre) VALUES(?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, objD.getNombre());
            ps.executeUpdate();
            flag = true;
        } catch (Exception e) {
            myLog.message(e.toString(), 0, "create()", "daoDepartamento");
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
        boolean flag = false;
        try {
            Connection con = myConnection.ConectToMysql();
            String sql = "SELECT dep_id FROM tbl_departamento WHERE dep_nombre=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dato[0]);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                flag = true;
            }
        } catch (Exception e) {
            myLog.message(e.toString(), 0, "exists()", "daoDepartamento");
        }
        return flag;
    }

    @Override
    public void fillDataTable(DefaultTableModel listado, String[] dato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void fillComboBox(JComboBox cmb) {
        try {
            Connection con = myConnection.ConectToMysql();
            String sql = "SELECT * FROM tbl_departamento ORDER BY dep_nombre";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            cmb.removeAllItems();
            while (rs.next()) {
                Combo objU = new Combo(rs.getInt("dep_id"), rs.getString("dep_nombre"));
                cmb.addItem(objU);
            }
        } catch (Exception e) {
            myLog.message(e.toString(), 0, "exists()", "daoDepartamento");
        }
    }

    @Override
    public ResultSet fillDataNavigation() {
        ResultSet rs = null;
        try {
            Connection con = myConnection.ConectToMysql();
            String sql = "SELECT * FROM tbl_departamento ORDER BY dep_nombre";
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(sql);
        } catch (Exception e) {
            myLog.message(e.toString(), 0, "fillDataNavigation()", "daoDepartamento");
        }
        return rs;
    }

}
