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
import java.util.ArrayList;
import java.util.List;
public class PhieuMuon {
    private long ma;
    private int tong;
    private Date ngayInPhieu;
    private List<SachMuon> sach=new ArrayList<>();
    private TheBanDoc docGia;
    private NguoiDungHeThong nhanVien;

    public long getMa() {
        return ma;
    }

    public void setMa(long ma) {
        this.ma = ma;
    }

    public int getTong() {
        return tong;
    }

    public void setTong(int tong) {
        this.tong = tong;
    }

    public Date getNgayInPhieu() {
        return ngayInPhieu;
    }

    public void setNgayInPhieu(Date ngayInPhieu) {
        this.ngayInPhieu = ngayInPhieu;
    }

    public List<SachMuon> getSach() {
        return sach;
    }

    public void setSach(List<SachMuon> sach) {
        this.sach = sach;
    }

    public TheBanDoc getDocGia() {
        return docGia;
    }

    public void setDocGia(TheBanDoc docGia) {
        this.docGia = docGia;
    }

    public NguoiDungHeThong getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NguoiDungHeThong nhanVien) {
        this.nhanVien = nhanVien;
    }

    public PhieuMuon() {
    }

    public PhieuMuon(long ma, int tong, Date ngayInPhieu, List<SachMuon> sach, TheBanDoc docGia, NguoiDungHeThong nhanVien) {
        this.ma = ma;
        this.tong = tong;
        this.ngayInPhieu = ngayInPhieu;
        this.sach = sach;
        this.docGia = docGia;
        this.nhanVien = nhanVien;
    }
    
}
