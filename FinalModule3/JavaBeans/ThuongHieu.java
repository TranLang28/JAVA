package JavaBeans;

import java.io.Serializable;

public class ThuongHieu implements Serializable{
	private String hinhAnh;
	private String tenThuongHieu;
	private int id;
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public String getTenThuongHieu() {
		return tenThuongHieu;
	}
	public void setTenThuongHieu(String tenThuongHieu) {
		this.tenThuongHieu = tenThuongHieu;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ThuongHieu() {
		super();
	}
}
