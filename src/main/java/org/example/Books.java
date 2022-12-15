package org.example;

import java.sql.*;

public class Books {
    DatabaseUtils databaseUtils = new DatabaseUtils();

    /*
    CREATE TABLE books (
    barkod_no int,
    kitap_adi VARCHAR(20),
    kitap_yazari VARCHAR(30),
    sayfa_sayisi int
    )


     */
    public void kitapEkle(int barkodNo,String kitapAdi, String kitapYazari, int sayfaSayisi) throws SQLException {
        Connection con = databaseUtils.Db_connection();
        String sqlCode = "INSERT INTO books VALUES (?,?,?,?)";
        PreparedStatement prSt = con.prepareStatement(sqlCode);
        prSt.setInt(1,barkodNo);
        prSt.setString(2,kitapAdi);
        prSt.setString(3,kitapYazari);
        prSt.setInt(4,sayfaSayisi);
        int prStCount = prSt.executeUpdate();
        if (prStCount > 0){
            System.out.println("Kitap eklendi.");
        }
    }
    public void kitapSil(int barkodNo) throws SQLException {
        Statement st = databaseUtils.db_statement();
        String sqlCode = "DELETE FROM books WHERE barkod_no = " + barkodNo;
        int stCount = st.executeUpdate(sqlCode);
        if (stCount > 0){
            System.out.println("Kitap silindi.");
        }
    }
    public void kitapGoruntule(String kitap_adi) throws SQLException {
        Statement st = databaseUtils.db_statement();
        String sql = "SELECT * FROM books WHERE kitap_adi = '" + kitap_adi + "'";
        ResultSet resultSet = st.executeQuery(sql);
        while (resultSet.next()){
            System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2)
                    + " " + resultSet.getString(3) + " " + resultSet.getInt(4));
        }
    }
    public void butunKitaplariGoruntule() throws SQLException {
        Statement st = databaseUtils.db_statement();
        String sql = "SELECT * FROM books";
        ResultSet resultSet = st.executeQuery(sql);
        while (resultSet.next()){
            System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2)
                    + " " + resultSet.getString(3) + " " + resultSet.getInt(4));
        }
    }

}
