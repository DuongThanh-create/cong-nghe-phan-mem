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
public class PhieuPhat {
    private long ma;
    private PhieuMuon phieuMuon;
    private SachTra[] sach;
    private double tongPhat;
    private TheBanDoc docGia;
    private NguoiDungHeThong nhanVien;

    public long getMa() {
        return ma;
    }

    public void setMa(long ma) {
        this.ma = ma;
    }

    public PhieuMuon getPhieuMuon() {
        return phieuMuon;
    }

    public void setPhieuMuon(PhieuMuon phieuMuon) {
        this.phieuMuon = phieuMuon;
    }

    public SachTra[] getSach() {
        return sach;
    }

    public void setSach(SachTra[] sach) {
        this.sach = sach;
    }

    public double getTongPhat() {
        return tongPhat;
    }

    public void setTongPhat(double tongPhat) {
        this.tongPhat = tongPhat;
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

    public PhieuPhat() {
    }

    public PhieuPhat(long ma, PhieuMuon phieuMuon, SachTra[] sach, double tongPhat, TheBanDoc docGia, NguoiDungHeThong nhanVien) {
        this.ma = ma;
        this.phieuMuon = phieuMuon;
        this.sach = sach;
        this.tongPhat = tongPhat;
        this.docGia = docGia;
        this.nhanVien = nhanVien;
    }
    
}
