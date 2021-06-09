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
import Model.Sach;
import java.util.Date;
import Model.SachTra;
public class SachTraDAO {
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
    public void themSachTra(List<SachTra> ids){
        for(SachTra id:ids){
            try {
            dbCon=getConnection();
            String sql="insert into tblsachtra(ma,ngayTra) values(?,?);";
            PreparedStatement statement=dbCon.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1,id.getMa());
            statement.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
            statement.executeUpdate();
            dbCon.close();
            statement.close();
            } catch (SQLException ex) {
            Logger.getLogger(SachMuonDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public List<SachTra> timKiemSachTra(Long maDG){
        List<SachTra> sach=new ArrayList<>();
        try {
                dbCon=getConnection();
                String sql="SELECT S.*, SM.ngayMuon, ST.ngayTra, DATE_ADD(SM.ngayMuon,INTERVAL 1 MONTH) AS ngayPhaiTra FROM tblsachtra AS ST, tblsachmuon AS SM, tblsach AS S " +
                            "WHERE ST.ma=SM.ma AND SM.tblSachma=S.ma AND SM.tblTheBanDocma=?;";
                PreparedStatement statement=dbCon.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                statement.setLong(1,maDG);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    Sach s=new Sach();
                    s.setMa(resultSet.getLong("ma"));
                    s.setTen(resultSet.getString("ten"));
                    s.setTacGia(resultSet.getString("tacGia"));
                    s.setMaVach(resultSet.getString("maVach"));
                    s.setNam(resultSet.getInt("namXB"));
                    s.setSoLuong(resultSet.getInt("soLuong"));
                    s.setMoTa(resultSet.getString("moTa"));
                    s.setGiaBia(resultSet.getDouble("giaBia"));
                    SachTra st=new SachTra();
                    st.setSach(s);
                    st.setNgayMuon(resultSet.getDate("ngayMuon"));
                    st.setNgayPhaiTra(resultSet.getDate("ngayPhaiTra"));
                    st.setNgayTra(resultSet.getDate("ngayTra"));
                    sach.add(st);
                }
                dbCon.close();
                statement.close();
                resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(SachMuonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sach;
    }
}
