package businessLogics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import java.sql.Connection;
import java.sql.PreparedStatement;

import javaBeans.Sua;

public class SuaBL {
	public static List<Sua> docTatCa() {
		String sql = "select * from sua";
		List<Sua> dss = taoDanhSach(sql);
		return dss;
	}
	
	public static Sua timSuaTheoMa(String maSua) {
		String sql = "select * from sua where Ma_sua= '" + maSua + "'";
		List<Sua> dss = taoDanhSach(sql);
		Sua ret = dss.get(0);
		return ret;
	}
	
	public static List<Sua> timSua(String tenSua) {
		List<Sua> ret = new ArrayList<Sua>();
		if(tenSua == "") {
			return ret;
		}
		List<Sua> temp = docTatCa();
		for(Sua item : temp) {
			if(item.getTenSua().indexOf(tenSua) > -1) {
				ret.add(item);
			}
		}
		
		return ret;
	}
	
	public static void themSua(Sua newOne) {
		
		String sql = "INSERT INTO sua(Hinh, Loi_ich, Tp_dinh_duong, Don_gia, Trong_luong, Ma_loai_sua, Ma_hang_sua, Ten_sua, Ma_sua) "
					+ "VALUES (?,?,?,?,?,?,?,?,?)";
		try (Connection ketNoi = CSDL.getConnection()){
			PreparedStatement pst = ketNoi.prepareStatement(sql);
			
			pst.setString(1,newOne.getHinh());
			pst.setString(2,newOne.getLoiIch());
			pst.setString(3,newOne.getTpDinhDuong());
			pst.setInt(4,newOne.getDonGia());
			pst.setInt(5,newOne.getTrongLuong());
			pst.setString(6,newOne.getMaLoaiSua());
			pst.setString(7,newOne.getMaHangSua());
			pst.setString(8,newOne.getTenSua());
			pst.setString(9,newOne.getMaSua());
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Sua> docSuaBanNhieu(){
		try (Connection ketNoi = CSDL.getConnection()){
			String sql = "select s.*,sum(ct.so_luong) as tsl from sua s inner join ct_hoadon ct on ct.Ma_sua=s.Ma_sua group by 1 order by sum(ct.so_luong) desc";
			/*
			 * Query<Sua> query = session.createQuery(sql,Sua.class);
			 * query.setFirstResult(0); query.setMaxResults(top); return query.list();
			 */
			List<Sua> dss = taoDanhSach(sql);
			return dss;
			
		} catch (Exception e) {
			return null;
		}
	}
	
	private static List<Sua> taoDanhSach(String sql) {
		List<Sua> dss = new ArrayList<>();
		try (Connection ketNoi = CSDL.getConnection()){
			Statement stm = ketNoi.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			//List<Sua> dss = new ArrayList<>();
			while (rs.next()) {
				Sua sp = new Sua();
				sp.setHinh(rs.getString("Hinh"));
				sp.setLoiIch(rs.getString("Loi_ich"));
				sp.setTpDinhDuong(rs.getString("Tp_dinh_duong"));
				sp.setDonGia(rs.getInt("Don_gia"));
				sp.setTrongLuong(rs.getInt("Trong_luong"));
				sp.setMaLoaiSua(rs.getString("Ma_loai_sua"));
				sp.setMaHangSua(rs.getString("Ma_hang_sua"));
				sp.setTenSua(rs.getString("Ten_sua"));
				sp.setMaSua(rs.getString("Ma_sua"));
				
				dss.add(sp);
			}
		} catch (Exception e) {
			throw new RuntimeException("Bi loi: " + e.getMessage());
		}
		return dss;
	}

	

	
}
