package BusinessLogics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import JavaBeans.quangcao;

public class quangCaoBL {
	public static List<quangcao> docTatCa(){
        List<quangcao> dsqc = null;
        try {
            Connection con = CSDL.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from quangcao");
            dsqc = new ArrayList<>();
            while(rs.next()){
            	quangcao hs = new quangcao();
                hs.setNgayDang(rs.getDate("ngaydang"));
                hs.setThongTinChiTiet(rs.getString("thongtinchitiet"));
                hs.setThongDiep(rs.getString("thongdiep"));
                hs.setHinhAnh(rs.getString("hinhanh"));
                hs.setId(rs.getInt("id"));
                dsqc.add(hs);
            }
            con.close();
        } catch (Exception e) {
            throw new RuntimeException("Bá»‹ lá»-i: "+e.getMessage());
        }
        return dsqc;
    }

}
