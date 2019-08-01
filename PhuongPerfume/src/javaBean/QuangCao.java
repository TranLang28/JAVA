package javaBean;

import java.io.Serializable;
import java.util.Date;

public class QuangCao implements Serializable{
	private Date ngayDang;
	private String ttChiTiet;
	private String thongDiep;
	private String hinhAnh;
	private int id;
	public Date getNgayDang() {
		return ngayDang;
	}
	public void setNgayDang(Date ngayDang) {
		this.ngayDang = ngayDang;
	}
	public String getTtChiTiet() {
		return ttChiTiet;
	}
	public void setTtChiTiet(String ttChiTiet) {
		this.ttChiTiet = ttChiTiet;
	}
	public String getThongDiep() {
		return thongDiep;
	}
	public void setThongDiep(String thongDiep) {
		this.thongDiep = thongDiep;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public QuangCao() {
		super();
	}	
}
