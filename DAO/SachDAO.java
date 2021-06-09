/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author DUONG VAN THANH
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Sach;
public class SachDAO {
    Connection dbCon;
     private Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/thuvien";
            String user = "root";
            String password = "thanh175936";
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PhieuMuonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PhieuMuonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Sach timKiemSach(Long maS){
         Sach s=new Sach();
        try {
                dbCon=getConnection();
                String sql="SELECT * FROM tblsach WHERE ma=?";
                PreparedStatement statement=dbCon.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                statement.setLong(1,maS);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    s.setMa(resultSet.getLong("ma"));
                    s.setTen(resultSet.getString("ten"));
                    s.setTacGia(resultSet.getString("tacGia"));
                    s.setMaVach(resultSet.getString("maVach"));
                    s.setNam(resultSet.getInt("namXB"));
                    s.setSoLuong(resultSet.getInt("soLuong"));
                    s.setMoTa(resultSet.getString("moTa"));
                    s.setMaVach(resultSet.getString("maVach"));
                    s.setGiaBia(resultSet.getDouble("giaBia"));
                }
                dbCon.close();
                statement.close();
                resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(SachMuonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
}
