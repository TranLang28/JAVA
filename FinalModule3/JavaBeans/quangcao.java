package JavaBeans;

import java.io.Serializable;
import java.util.Date;

public class quangcao implements Serializable{
	private Date ngayDang;
	private String thongTinChiTiet;
	private String thongDiep;
	private String hinhAnh;
	private int id;
	
	public quangcao() {
		super();
	}
	public Date getNgayDang() {
		return ngayDang;
	}
	public void setNgayDang(Date ngayDang) {
		this.ngayDang = ngayDang;
	}
	public String getThongTinChiTiet() {
		return thongTinChiTiet;
	}
	public void setThongTinChiTiet(String thongTinChiTiet) {
		this.thongTinChiTiet = thongTinChiTiet;
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
}
