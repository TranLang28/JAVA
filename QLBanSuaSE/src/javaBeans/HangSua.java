package javaBeans;

import java.io.Serializable;

public class HangSua implements Serializable{
	private String email;
	private String dienThoai;
	private String diaChi;
	private String tenHang;
	private String maHang;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDienThoai() {
		return dienThoai;
	}
	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getTenHang() {
		return tenHang;
	}
	public void setTenHang(String tenHangSua) {
		this.tenHang = tenHangSua;
	}
	public String getMaHang() {
		return maHang;
	}
	public void setMaHang(String maHangSua) {
		this.maHang = maHangSua;
	}
	public HangSua() {
		super();
	}
	
	
}
