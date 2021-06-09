/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Sach;
import Model.TheBanDoc;

/**
 *
 * @author DUONG VAN THANH
 */
public class TheBanDocDAO {
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
    public TheBanDoc timKiemBanDoc(Long maDG){
        TheBanDoc bd=new TheBanDoc();
        try {
                dbCon=getConnection();
                String sql="SELECT * FROM tblTheBanDoc WHERE ma=?";
                PreparedStatement statement=dbCon.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                statement.setLong(1,maDG);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                      bd.setMa(resultSet.getLong("ma"));
                      bd.setDiaChi(resultSet.getString("diaChi"));
                      bd.setNgaySinh(resultSet.getString("ngaySinh"));
                      bd.setSdt(resultSet.getString("sdt"));
                      bd.setTen(resultSet.getString("ten"));
                }
                dbCon.close();
                statement.close();
                resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(SachMuonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bd;
    }
}
