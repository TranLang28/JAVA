package BusinessLogics;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import JavaBeans.SanPham;
import JavaBeans.SanPhamMua;

public class GioHang {
	private Hashtable<Integer,Integer> dshh;  //key: id san pham, value: so luong mua
	public GioHang() {
		dshh = new Hashtable<>();
	}
	public void them(int idsp, int slm) {
		if(dshh.containsKey(idsp))
			dshh.replace(idsp,dshh.get(idsp)+slm);
		else
			dshh.put(idsp, slm);
	}
	public int soMatHang() {
		return dshh.size();
	}
	public double tongTien() {
		double tt = 0;
		for(Integer idsp:dshh.keySet()) {
			SanPham sp = SanPhamBL.docTheoID(idsp);
			tt += sp.getDonGiaKM()*dshh.get(idsp);
		}
		return tt;
	}
	public List<SanPhamMua> danhSachHang(){
		List<SanPhamMua> dsspm = new ArrayList<SanPhamMua>();
		for(Integer idsp:dshh.keySet()) {
			SanPham sp = SanPhamBL.docTheoID(idsp);
			SanPhamMua spm = new SanPhamMua();
			
			spm.setId(sp.getId());
			spm.setTenSanPham(sp.getTenSanPham());
			spm.setMoTa(sp.getMoTa());
			spm.setHinhAnh(sp.getHinhAnh());
			spm.setDonGia(sp.getDonGia());
			spm.setDonGiaKM(sp.getDonGiaKM());
			spm.setSoLuong(sp.getSoLuong());
			spm.setNgayTao(sp.getNgayTao());
			spm.setHienThi(sp.getHienThi());
			spm.setIdLoai(sp.getIdLoai());
			spm.setIdThuongHieu(sp.getIdThuongHieu());
			
			spm.setSoLuongMua(dshh.get(idsp));
			
			dsspm.add(spm);
		}
		return dsspm;
	}

}