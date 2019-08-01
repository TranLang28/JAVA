package JavaBeans;

public class SanPhamMua extends SanPham {
	private int soLuongMua;

	public int getSoLuongMua() {
		return soLuongMua;
	}

	public void setSoLuongMua(int soLuongMua) {
		this.soLuongMua = soLuongMua;
	}
	
	public double getThanhTien() {
		return soLuongMua*getDonGiaKM();
	}

	public SanPhamMua() {
		super();
	}
}
