package businessLogic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaBean.QuangCao;

public class QuangCaoBL {
	public static List<QuangCao> readAll(){
		List<QuangCao> dsqc = null;
		String sql ="select * from quangcao";
		
		Connection connect = CSDL.getConnection();
		try {
			Statement stm = connect.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			dsqc = new ArrayList<>();
			
			while(rs.next()) {
				QuangCao qc = new QuangCao();
				qc.setNgayDang(rs.getDate("ngaydang"));
				qc.setTtChiTiet(rs.getString("thongtinchitiet"));
				qc.setThongDiep(rs.getString("thongdiep"));
				qc.setHinhAnh(rs.getString("hinhanh"));
				qc.setId(rs.getInt("id"));
				
				dsqc.add(qc);		
			}
			
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsqc;
	}
}
