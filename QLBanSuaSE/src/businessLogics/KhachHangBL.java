package businessLogics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javaBeans.KhachHang;

public class KhachHangBL {
	public static void themKhachHang(KhachHang newOne) {
		String sql ="INSERT INTO khach_hang(Email, Dien_thoai, Dia_chi, Phai, Ten_khach_hang, Ma_khach_hang) "
				+ "VALUES (?,?,?,?,?,?)";
		
		try (Connection ketNoi = CSDL.getConnection()){
			PreparedStatement pst = ketNoi.prepareStatement(sql);
			
			pst.setString(1,newOne.getEmail());
			pst.setString(2,newOne.getDienThoai());
			pst.setString(3,newOne.getDiaChi());
			pst.setBoolean(4,newOne.isPhai());
			pst.setString(5,newOne.getTenKH());
			pst.setString(6,newOne.getMaKH());
			
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
