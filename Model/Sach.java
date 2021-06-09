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
public class Sach {
    private long ma;
    private String ten;
    private String tacGia;
    private int soLuong;
    private int nam;
    private String maVach;
    private String moTa;
    private double giaBia;

    public long getMa() {
        return ma;
    }

    public void setMa(long ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public String getMaVach() {
        return maVach;
    }

    public void setMaVach(String maVach) {
        this.maVach = maVach;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public double getGiaBia() {
        return giaBia;
    }

    public void setGiaBia(double giaBia) {
        this.giaBia = giaBia;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Sach() {
    }

    public Sach(long ma, String ten, String tacGia, int soLuong, int nam, String maVach, String moTa, double giaBia) {
        this.ma = ma;
        this.ten = ten;
        this.tacGia = tacGia;
        this.soLuong = soLuong;
        this.nam = nam;
        this.maVach = maVach;
        this.moTa = moTa;
        this.giaBia = giaBia;
    }
    
}
