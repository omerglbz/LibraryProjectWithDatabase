package org.example;

import java.sql.*;

public class Personel {
    /*
    CREATE TABLE personel(
    tc_no int,
    isim VARCHAR(30),
    soyisim VARCHAR(30),
    maas int,
    yas int
    )
     */
    DatabaseUtils databaseUtils = new DatabaseUtils();
    public void personelEkle(int tc_no, String isim, String soyIsim, int maas, int yas) throws SQLException {
        Connection con = databaseUtils.Db_connection();
        String sql = "INSERT INTO personel VALUES(?,?,?,?,?)";
        PreparedStatement pS = con.prepareStatement(sql);
        pS.setInt(1,tc_no);
        pS.setString(2,isim);
        pS.setString(3,soyIsim);
        pS.setInt(4,maas);
        pS.setInt(5,yas);
        int countPS = pS.executeUpdate();
        if (countPS > 0){
            System.out.println("Ekleme basarili.");
        }
    }
    public void personelMaasZam(int tc_no, int zamMiktari) throws SQLException {
        Statement st = databaseUtils.db_statement();
        String sql = "UPDATE personel SET maas = maas " + zamMiktari +" WHERE tc_no = "+tc_no;
        int countSt = st.executeUpdate(sql);
        if (countSt > 0){
            System.out.println("Islem basarili...");
        }
    }
    public void personelSil(int tc_no) throws SQLException {
        Statement st = databaseUtils.db_statement();
        String sql = "DELETE FROM personel WHERE tc_no = " + tc_no;
        int countSt = st.executeUpdate(sql);
        if (countSt > 0){
            System.out.println("Islem basarili...");
        }
    }
    public void personelGoruntule(String isim) throws SQLException {
        Statement st = databaseUtils.db_statement();
        String sql = "SELECT * FROM personel WHERE isim = '" + isim + "'";
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()){
            System.out.println(rs.getInt(1) + " " + rs.getString(2)
                    + " " +rs.getString(3) + " " + rs.getInt(4) + " " + rs.getInt(5) );

        }
    }
    public void butunPersonelleriGoruntule() throws SQLException {
        Statement st = databaseUtils.db_statement();
        String sql = "SELECT * FROM personel";
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()){
            System.out.println(rs.getInt(1) + " " + rs.getString(2)
                    + " " +rs.getString(3) + " " + rs.getInt(4) + " " + rs.getInt(5) );

        }
    }
}
