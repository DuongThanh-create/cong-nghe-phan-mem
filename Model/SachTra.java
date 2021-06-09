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
public class SachTra extends SachMuon{
    private Date ngayTra;

    public Date getNgayTra() {
        return ngayTra;
    }

    public void Date (Date ngayTra) {
        this.ngayTra = ngayTra;
    }

    public SachTra() {
    }

    public SachTra(long ma, Sach sach, TheBanDoc docGia, Date ngayMuon, Date ngayPhaiTra, NguoiDungHeThong nhanVien) {
        super(ma, sach, docGia, ngayMuon, ngayPhaiTra, nhanVien);
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }
    
}
