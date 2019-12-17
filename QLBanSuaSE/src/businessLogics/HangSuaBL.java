package businessLogics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaBeans.HangSua;

public class HangSuaBL {
	public static List<HangSua> docTatCa() {
		String sql = "select * from hang_sua";
		List<HangSua> dshs = taoDanhSach(sql);
		return dshs;
	}
	
	public static String timTheoTenHangSua(String tenHang) {
		String ret = null;
		
		String sql = "select * from hang_sua where Ten_hang_sua = ?";
		
		try (Connection ketNoi = CSDL.getConnection()){
			PreparedStatement pst = ketNoi.prepareStatement(sql);
			
			pst.setString(1,tenHang);
			
			ResultSet rs = pst.executeQuery(sql);
			
			while (rs.next()) {
				ret = rs.getString("Ma_hang_sua");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ret;
	}
	
	private static List<HangSua> taoDanhSach(String sql) {
		List<HangSua> dshs = new ArrayList<>();
		try (Connection ketNoi = CSDL.getConnection()){
			Statement stm = ketNoi.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while (rs.next()) {
				HangSua sp = new HangSua();
				sp.setEmail(rs.getString("Email"));
				sp.setDienThoai(rs.getString("Dien_thoai"));
				sp.setDiaChi(rs.getString("Dia_chi"));
				sp.setTenHang(rs.getString("Ten_hang_sua"));
				sp.setMaHang(rs.getString("Ma_hang_sua"));
				
				dshs.add(sp);
			}
		} catch (Exception e) {
			throw new RuntimeException("Bi loi: " + e.getMessage());
		}
		return dshs;
	}
	    
}

