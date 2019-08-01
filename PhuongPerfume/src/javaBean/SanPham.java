package javaBean;

import java.io.Serializable;
import java.sql.Date;

public class SanPham implements Serializable{
	private int idTH;
	private int idLoai;
	private int hienThi;
	private Date ngayTao;
	private int soLuong;
	private double donGiaKM;
	private double donGia;
	private String hinhAnh;
	private String moTa;
	private String tenSP;
	private int id;
	
	
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public int getIdTH() {
		return idTH;
	}
	public void setIdTH(int idTH) {
		this.idTH = idTH;
	}
	public int getIdLoai() {
		return idLoai;
	}
	public void setIdLoai(int idLoai) {
		this.idLoai = idLoai;
	}
	public int getHienThi() {
		return hienThi;
	}
	public void setHienThi(int hienThi) {
		this.hienThi = hienThi;
	}
	public Date getNgayTao() {
		return ngayTao;
	}
	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getDonGiaKM() {
		return donGiaKM;
	}
	public void setDonGiaKM(double donGiaKM) {
		this.donGiaKM = donGiaKM;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public SanPham() {
		super();
	}
	
	
}
