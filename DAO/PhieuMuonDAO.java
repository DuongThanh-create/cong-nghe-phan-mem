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
import Model.PhieuMuon;
import Model.Sach;
import Model.SachMuon;
import Model.TheBanDoc;
public class PhieuMuonDAO {
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
    public PhieuMuon timKiemPhieuMuon(long maDG){
        PhieuMuon p=new PhieuMuon();
         Long maP=null;
         List<SachMuon> s=new ArrayList<>();
        try {
            String sql="SELECT P.ma AS maP,p.ngayInPhieu,S.*,D.*,S.ma AS maS,D.ma AS maDG,SM.ma AS maSM,D.ten AS tenDG,SM.ngayMuon, DATE_ADD(SM.ngayMuon,INTERVAL 1 MONTH) AS ngayPhaiTra "
                    + "FROM tblphieumuon AS P, tblSachMuon AS SM, tblsach AS S, tblsachmuon_phieumuon AS SP,tblthebandoc AS D "
                    + "WHERE P.tblTheBanDocma="+maDG+" AND P.ma=(SELECT Max(ma) FROM tblphieumuon WHERE tblTheBanDocma="+
                    maDG+") AND P.ma=SP.tblPhieuMuonma AND SM.ma=SP.tblSachMuonma AND SM.tblSachma=S.ma AND D.ma=P.tblTheBanDocma";
            dbCon=getConnection();
            Statement statement=dbCon.createStatement();
            ResultSet result=statement.executeQuery(sql);
           
            while(result.next()){
                maP=result.getLong("maP");
               SachMuon sachM=new SachMuon();
               Sach sach=new Sach();
               TheBanDoc docGia=new TheBanDoc();
               sachM.setMa(result.getLong("maSM"));
               sach.setMa(result.getLong("ma"));
               sach.setGiaBia(result.getDouble("giaBia"));
               sach.setTen(result.getString("ten"));
               sach.setTacGia(result.getString("tacGia"));
               sach.setMaVach(result.getString("maVach"));
               sach.setMoTa(result.getString("moTa"));
               sach.setNam(result.getInt("namXB"));
               sachM.setSach(sach);
               docGia.setMa(result.getLong("maDG"));
               docGia.setTen(result.getString("tenDG"));
               docGia.setDiaChi(result.getString("diaChi"));
               sachM.setDocGia(docGia);
               sachM.setNgayMuon(result.getDate("ngayMuon"));
               sachM.setNgayPhaiTra(result.getDate("ngayPhaiTra"));
               s.add(sachM);
            }
            dbCon.close();
            statement.close();
            result.close();
        } catch (SQLException ex) {
            Logger.getLogger(PhieuMuonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        p.setSach(s);
        if(maP!=null) p.setMa(maP);
        return p;
    }
    public void themPhieuMuon(List<Long> ids,Long maDG){
        Long id=null;
            try {
                dbCon=getConnection();
                String sql="insert into tblphieumuon(tblTheBanDocma) values(?);";
                PreparedStatement statement=dbCon.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                statement.setLong(1,maDG);
                statement.executeUpdate();
                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next()) {
                    id = resultSet.getLong(1);
                }
                dbCon.close();
                statement.close();
                resultSet.close();
            } catch (SQLException ex) {
                Logger.getLogger(SachMuonDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            for(long i:ids){
                try {
                    dbCon=getConnection();
                    String sql="insert into tblsachmuon_phieumuon(tblSachMuonma,tblphieumuonma) values(?,?);";
                   
                    PreparedStatement statement=dbCon.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                    statement.setLong(1,i);
                    statement.setLong(2,id);
                    statement.executeUpdate();
                    ResultSet resultSet = statement.getGeneratedKeys();
                   
                    dbCon.close();
                    statement.close();
                    resultSet.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SachMuonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
      
}
