/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  DUONG VAN THANH
 * Created: Jun 6, 2021
 */
use thuvien;
CREATE TABLE tblsach(
	ma bigint NOT NULL PRIMARY KEY auto_increment,
    ten VARCHAR(255) NOT NULL,
	tacGia VARCHAR(255) NOT NULL,
    soLuong INTEGER NOT NULL,
    namXB INTEGER NOT NULL,
    maVach VARCHAR(255) NOT NULL,
    moTa VARCHAR(255) NOT NULL,
    giaBia Double NOT NULL
);
CREATE TABLE tblTheBanDoc(
	ma bigint NOT NULL PRIMARY KEY auto_increment,
    ngaySinh VARCHAR(255) NOT NULL,
    diaChi VARCHAR(255) NOT NULL,
    sdt VARCHAR(255) NOT NULL,
    ten VARCHAR(255) NOT NULL
);
CREATE TABLE tblSachMuon(
	ma bigint NOT NULL PRIMARY KEY auto_increment,
    ngayMuon DATE,
    ngayPhaiTra DATE,
    tblSachma bigint NOT NULL,
    tblNguoiDungHeThongma bigint NOT NULL,
    tblTheBanDocma bigint NOT NULL
);
CREATE TABLE tblSachTra(
	ma bigint NOT NULL PRIMARY KEY,
    ngayTra DATE
);
CREATE TABLE tblNguoiDungHeThong(
	ma bigint NOT NULL PRIMARY KEY auto_increment,
    ten VARCHAR(255) NOT NULL,
    tenDangNhap VARCHAR(255) NOT NULL,
    matKhau  VARCHAR(255) NOT NULL,
    viTri VARCHAR(255) NOT NULL
);
CREATE TABLE tblPhieuMuon(
	ma bigint NOT NULL PRIMARY KEY auto_increment,
    ngayInPhieu DATE,
    tblTheBanDocma bigint NOT NULL,
    tblNguoiDungHeThongma  bigint NOT NULL
);
CREATE TABLE tblPhieuPhat(
	ma bigint NOT NULL PRIMARY KEY auto_increment,
    tblPhieuMuonma bigint NOT NULL,
    tblTheBanDocma bigint NOT NULL,
    tblNguoiDungHeThongma bigint NOT NULL
);
CREATE TABLE tblSachMuon_PhieuMuon(
	ma bigint NOT NULL PRIMARY KEY auto_increment,
    tblPhieuMuonma bigint NOT NULL,
    tblSachMuonma bigint NOT NULL
);
ALTER TABLE tblsachmuon ADD CONSTRAINT  FOREIGN KEY (tblSachma) REFERENCES tblsach(ma);
ALTER TABLE tblsachmuon ADD CONSTRAINT  FOREIGN KEY (tblTheBanDocma) REFERENCES tblthebandoc(ma);
ALTER TABLE tblsachmuon ADD CONSTRAINT  FOREIGN KEY (tblNguoiDungHeThongma) REFERENCES tblnguoidunghethong(ma);

ALTER TABLE tblsachtra ADD CONSTRAINT  FOREIGN KEY (ma) REFERENCES tblsachmuon(ma);
ALTER TABLE tblsachtra ADD CONSTRAINT  FOREIGN KEY (tblPhieuPhatma) REFERENCES tblphieuphat(ma);

ALTER TABLE tblphieumuon ADD CONSTRAINT  FOREIGN KEY (tblTheBanDocma) REFERENCES tblthebandoc(ma);
ALTER TABLE tblphieumuon ADD CONSTRAINT  FOREIGN KEY (tblNguoiDungHeThongma) REFERENCES tblnguoidunghethong(ma);


ALTER TABLE tblphieuphat ADD CONSTRAINT  FOREIGN KEY (tblSachTrama) REFERENCES tblsachtra(ma);
ALTER TABLE tblphieuphat ADD CONSTRAINT  FOREIGN KEY (tblTheBanDocma) REFERENCES tblthebandoc(ma);
ALTER TABLE tblphieuphat ADD CONSTRAINT  FOREIGN KEY (tblNguoiDungHeThongma) REFERENCES tblnguoidunghethong(ma);
ALTER TABLE tblphieuphat ADD CONSTRAINT  FOREIGN KEY (tblPhieuMuonma) REFERENCES tblphieumuon(ma);

ALTER TABLE tblsachmuon_phieumuon ADD CONSTRAINT  FOREIGN KEY (tblSachMuonma) REFERENCES tblsachmuon(ma);
ALTER TABLE tblsachmuon_phieumuon ADD CONSTRAINT  FOREIGN KEY (tblPhieuMuonma) REFERENCES tblphieumuon(ma);
