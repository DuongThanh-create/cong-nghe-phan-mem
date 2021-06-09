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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.SachMuon;
public class SachMuonDAO {
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
    public void themSachMuon(List<SachMuon> sach,Long maDG){
        List<Long> ids=new ArrayList<>();
        
        for(SachMuon s:sach){
            if(s.getMa()==null){
                try {
                dbCon=getConnection();
                String sql="insert into tblsachmuon(tblSachma,tblTheBanDocma,ngayMuon) values(?,?,?);";
                Long id=null;
                PreparedStatement statement=dbCon.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
              
                statement.setLong(1,s.getSach().getMa());  
                statement.setLong(2,maDG);
                statement.setDate(3,s.getNgayMuon());
              
                statement.executeUpdate();
                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next()) {
                   id = resultSet.getLong(1);
                   ids.add(id);
                }
                dbCon.close();
                statement.close();
                resultSet.close();
                } catch (SQLException ex) {
                Logger.getLogger(SachMuonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else ids.add(s.getMa());
        }
        PhieuMuonDAO pDAO=new PhieuMuonDAO();
        pDAO.themPhieuMuon(ids, maDG);
    }
}
