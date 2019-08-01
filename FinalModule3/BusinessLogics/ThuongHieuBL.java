package BusinessLogics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import JavaBeans.ThuongHieu;

public class ThuongHieuBL {
	public static List<ThuongHieu> docTatCa(){
        List<ThuongHieu> dsth = null;
        try {
            Connection con = CSDL.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from thuonghieu");
            dsth = new ArrayList<>();
            while(rs.next()){
            	ThuongHieu hs = new ThuongHieu();
                hs.setHinhAnh(rs.getString("hinhanh"));
                hs.setTenThuongHieu(rs.getString("tenthuonghieu"));
                hs.setId(rs.getInt("id"));
                dsth.add(hs);
            }
            con.close();
        } catch (Exception e) {
            throw new RuntimeException("Bá»‹ lá»-i: "+e.getMessage());
        }
        return dsth;
    }
}
