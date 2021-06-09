/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
/**
 *
 * @author DUONG VAN THANH
 */
import java.sql.*;
public class SachMuon {
    private Long ma;
    private Sach sach;
    private TheBanDoc docGia;
    private Date ngayMuon;
    private Date ngayPhaiTra;
    private NguoiDungHeThong nhanVien;

    public Long getMa() {
        return ma;
    }

    public void setMa(long ma) {
        this.ma = ma;
    }

    public Sach getSach() {
        return sach;
    }

    public void setSach(Sach sach) {
        this.sach = sach;
    }

    public TheBanDoc getDocGia() {
        return docGia;
    }

    public void setDocGia(TheBanDoc docGia) {
        this.docGia = docGia;
    }

    public Date getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public Date getNgayPhaiTra() {
        return ngayPhaiTra;
    }

    public void setNgayPhaiTra(Date ngayPhaiTra) {
        this.ngayPhaiTra = ngayPhaiTra;
    }

    public NguoiDungHeThong getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NguoiDungHeThong nhanVien) {
        this.nhanVien = nhanVien;
    }

    public SachMuon() {
    }

    public SachMuon(long ma, Sach sach, TheBanDoc docGia, Date ngayMuon, Date ngayPhaiTra, NguoiDungHeThong nhanVien) {
        this.ma = ma;
        this.sach = sach;
        this.docGia = docGia;
        this.ngayMuon = ngayMuon;
        this.ngayPhaiTra = ngayPhaiTra;
        this.nhanVien = nhanVien;
    }
    
}
