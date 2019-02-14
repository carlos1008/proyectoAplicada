package dao;

import entity.Combo;
import entity.Departamento;
import entity.Usuario;
import entity.iDAO;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import utility.myLog;

/**
 *
 * @author carlosalberto
 */
public class daoUsuario implements iDAO{

    @Override
    public boolean create(Object obj) {
    boolean flag = false;
        try {
            Usuario objU = (Usuario) obj;
            String[] datoV = {objU.getCedula()};
            if (exists(datoV)) {
                myLog.message("Usuario ya existe", 1, "create()", "daoUsuario");
                return false;
            }
            
            Connection con = myConnection.ConectToMysql();
            String sql = "INSERT INTO tbl_usuario(usa_nombre, usa_apellido, usa_email, usa_codigo , usa_cedula, usa_departamento) VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, objU.getNombre());
            ps.setString(2, objU.getApellido());
            ps.setString(3,objU.getEmail());
            ps.setString(4,objU.getCodigo());
            ps.setString(5,objU.getCedula());
            ps.setInt(6, objU.getObjDepartamento().getId());
            //ps.setString(6,objU.getObjDepartamento().getId());
            ps.executeUpdate();
            flag = true;
        } catch (Exception e) {
            myLog.message(e.toString(), 0, "create()", "daoUsuario");
        }
        return flag;   
    }

    @Override
    public Object read(String dato) {
     Usuario obj = null;
        try {
            Connection conex = myConnection.ConectToMysql();
            String sql
                    = "SELECT * FROM tbl_usuario,tbl_departamernt WHERE dep_id=usa_departamento AND usa_id=?";
            PreparedStatement ps = conex.prepareStatement(sql);
            ps.setString(1, dato);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                obj = new Usuario();
                obj.setId(rs.getInt("usa_id"));
                obj.setNombre(rs.getString("usa_nombre"));
                obj.setApellido(rs.getString("usa_apellido"));
                obj.setEmail(rs.getString("usa_email"));
                obj.setCodigo(rs.getString("usa_codigo"));
                obj.setCedula(rs.getString("usa_cedula"));
                obj.setObjDepartamento(new Departamento(rs.getInt("dep_id"), rs.getString("dep_nombre")));
            }
        } catch (Exception e) {
            myLog.message(e.toString(), 0, "create()", "daoUsuario");
        }
        return obj;   
    }
    
    @Override
    public boolean update(Object obj) {
        boolean flag = false;
        try {
            Usuario objU = (Usuario) obj;
            Connection con = myConnection.ConectToMysql();
            String sql = "UPDATE tbl_usuario SET usa_nombre=?, usa_apellido=?, usa_email=?,usa_codigo=?, usa_cedula=?,"
                    +"usa_departamento=? WHERE usa_id=?";
             PreparedStatement ps = con.prepareStatement(sql);           
            ps.setString(1, objU.getNombre());
            ps.setString(2, objU.getApellido());
            ps.setString(3,objU.getEmail());
            ps.setString(4,objU.getCodigo());
            ps.setString(5,objU.getCedula());
            ps.setString(6,objU.getObjDepartamento().getNombre());
            ps.setInt(7, objU.getId());
            ps.executeUpdate();
            flag = true;
        } catch (Exception e) {
            myLog.message(e.toString(), 0, "create()", "daoUsuario");
        }
        return flag;   
    }

    @Override
    public boolean delete(Object obj) {
          boolean flag = false;
        try {
            Usuario objU = (Usuario) obj;
            Connection conex = myConnection.ConectToMysql();
            String sql = "DELETE FROM tbl_usuario WHERE usa_id=?";
            PreparedStatement ps = conex.prepareStatement(sql);
            ps.setInt(1, objU.getId());
            ps.executeUpdate();
            flag = true;
        } catch (HeadlessException | SQLException e) {
            myLog.message(e.toString(), 0, "delete()", "daoUsuario");
        }
        return flag;
    }

    @Override
    public boolean exists(String[] dato) {
    boolean flag = false;
        try {
            Connection con = myConnection.ConectToMysql();
            String sql = "SELECT usa_id FROM tbl_usuario WHERE usa_cedula=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dato[0]);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                flag = true;
            }
        } catch (Exception e) {
            myLog.message(e.toString(), 0, "exists()", "daoUsuario");
        }
        return flag;
    }
    
    public boolean validarCodigos(String codigo) throws SQLException{
        ResultSet rs = null;
        Connection conex = myConnection.ConectToMysql();
            String sql
                    = "SELECT usa_codigo FROM tbl_usuario WHERE usa_codigo=?" ;
            
            PreparedStatement st = conex.prepareStatement(sql);
            st.setString(1,codigo);
            rs = st.executeQuery();
            
            System.out.println(st.toString());
            System.out.println(rs.toString());
            
           
            return rs.first();
          
    }
    
    public Usuario validarUsuario(String codigo) throws SQLException{
        ResultSet rs = null;
        Connection conex = myConnection.ConectToMysql();
            String sql
                    = "SELECT usa_id FROM tbl_usuario WHERE usa_codigo=?" ;
            
            PreparedStatement st = conex.prepareStatement(sql);
            st.setString(1,codigo);
            rs = st.executeQuery();
            
            Usuario u = new Usuario();
            rs.next();
            
            u.setId(rs.getInt("usa_id"));
            System.out.println(rs.getInt("usa_id"));
            
            return u;
        
    }
    

    @Override
    public void fillDataTable(DefaultTableModel listado, String[] dato) {
    try {
            Connection con = myConnection.ConectToMysql();
            String sql = "SELECT * FROM tbl_usuario,tbl_departamento WHERE dep_id=usa_departamento "
                    + "AND (usa_nombre LIKE '%" + dato[0] + "%' OR usa_apellido LIKE '%" + dato[0] + "%') ORDER BY usa_apellido";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            listado.getDataVector().clear();
            while (rs.next()) {
                Object[] row = new Object[7];
                row[0] = rs.getInt("usa_id");
                row[1] = rs.getString("usa_nombre");
                row[2] = rs.getString("usa_apellido");
                row[3] = rs.getString("usa_email");
                row[4] = rs.getString("usa_codigo");
                row[5] = rs.getString("usa_cedula");
                row[6] = rs.getString("dep_nombre");
                listado.addRow(row);
            }
        } catch (Exception e) {
            myLog.message(e.toString(), 0, "exists()", "daoUsuario");
        }
    }

    @Override
    public void fillComboBox(JComboBox cmb) {
     try {
            Connection con = myConnection.ConectToMysql();
            String sql = "SELECT * FROM tbl_usuario ORDER BY usa_apellido";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            cmb.removeAllItems();
            while (rs.next()) {
                String n = rs.getString("usa_apellido") + " " + rs.getString("usa_nombre");
                Combo objC = new Combo(rs.getInt("usa_id"), n);
                cmb.addItem(objC);
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
            String sql = "SELECT * FROM tbl_usuario,tbl_departamento WHERE dep_id=usa_departamento ORDER BY usa_apellido";
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(sql);
        } catch (Exception e) {
            myLog.message(e.toString(), 0, "fillDataNavigation()", "daoUsuario");
        }
        return rs;
    }
    
    
}
