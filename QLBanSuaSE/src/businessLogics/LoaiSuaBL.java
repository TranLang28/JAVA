package businessLogics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaBeans.LoaiSua;

public class LoaiSuaBL {
	
	public static List<LoaiSua> docTatCa() {
		String sql = "select * from loai_sua";
		List<LoaiSua> dss = taoDanhSach(sql);
		return dss;
	}
	
	public static String timTheoTenLoaiSua(String tenSua) {
		String ret = null;
		
		String sql = "select * from loai_sua where loai_sua.Ten_sua = ?";
		
		try (Connection ketNoi = CSDL.getConnection()){
			PreparedStatement pst = ketNoi.prepareStatement(sql);
			
			pst.setString(1,tenSua);
			
			ResultSet rs = pst.executeQuery(sql);
			
			while (rs.next()) {
				ret = rs.getString("Ma_loai_sua");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ret;
	}
	
	private static List<LoaiSua> taoDanhSach(String sql) {
		List<LoaiSua> dsls = new ArrayList<>();
		try (Connection ketNoi = CSDL.getConnection()){
			Statement stm = ketNoi.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while (rs.next()) {
				LoaiSua sp = new LoaiSua();
				sp.setTenLoai(rs.getString("Ten_loai"));
				sp.setMaLoai(rs.getString("Ma_loai_sua"));
				
				dsls.add(sp);
			}
		} catch (Exception e) {
			throw new RuntimeException("Bi loi: " + e.getMessage());
		}
		return dsls;
	}
}
