package org.example;

import java.sql.*;

public class Uye {
    /*
     CREATE TABLE uye(
    tc_no int,
    isim VARCHAR(30),
    soyisim VARCHAR(30),
    uye_no int
    )
     */
    DatabaseUtils databaseUtils = new DatabaseUtils();
    public void uyeEkle(int tc_no, String isim, String soyisim, int uye_no) throws SQLException {
        Connection con = databaseUtils.Db_connection();
        String sqlCode = "INSERT INTO uye VALUES (?,?,?,?)";
        PreparedStatement prSt = con.prepareStatement(sqlCode);
        prSt.setInt(1,tc_no);
        prSt.setString(2,isim);
        prSt.setString(3,soyisim);
        prSt.setInt(4,uye_no);
        int prStCount = prSt.executeUpdate();
        if (prStCount > 0){
            System.out.println("Uye eklendi.");
        }
    }
    public void uyeSil(int tc_no) throws SQLException {
        Statement st = databaseUtils.db_statement();
        String sql = "DELETE FROM uye WHERE tc_no = " + tc_no;
        int countSt = st.executeUpdate(sql);
        if (countSt > 0){
            System.out.println("Islem basarili...");
        }
    }
    public void uyeGoruntule(String isim) throws SQLException {
        Statement st = databaseUtils.db_statement();
        String sql = "SELECT * FROM uye WHERE isim = '" + isim + "'";
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()){
            System.out.println(rs.getInt(1) + " " + rs.getString(2)
                    + " " +rs.getString(3) + " " + rs.getInt(4) );

        }
    }
    public void butunUyeleriGoruntule() throws SQLException {
        Statement st = databaseUtils.db_statement();
        String sql = "SELECT * FROM uye";
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()){
            System.out.println(rs.getInt(1) + " " + rs.getString(2)
                    + " " +rs.getString(3) + " " + rs.getInt(4) );

        }
    }
}
