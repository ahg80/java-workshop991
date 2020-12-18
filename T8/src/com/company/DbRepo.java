package com.company;
import java.sql.*;
public class DbRepo implements AutoCloseable {

    private Connection connection;
    private PreparedStatement preparedStatement;

    public DbRepo() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "amir", "myjava123");
        connection.setAutoCommit(false);
    }
    public void AddProduct(ProductEntity entity)throws Exception{

        preparedStatement = connection.prepareStatement("insert into anbar ( ASSORTMENT, PRODUCTNAME) values (?,?)");
        preparedStatement.setInt(1, entity.getSortID());
        preparedStatement.setString(2,entity.getName() );
        preparedStatement.executeUpdate();
        System.out.println("product aded");
    }
    public void Showeassortment()throws Exception {
        String query = "select * from assortment";
        Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rset = stmt.executeQuery(query);
        while (rset.next()) {
            String assortment = rset.getString(1);
            int sortid = rset.getInt(2);
            System.out.println(sortid + " | " + assortment);
        }

    }
    public void ShowProducts(int sort)throws Exception {
        String query = "select * from anbar where assortment='"+sort+"'";

        Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rset = stmt.executeQuery(query);


        while (rset.next()) {
            System.out.println( " | " + rset.getString(2));
        }
        stmt.close();
        connection.close();
    }
    public void commit() throws Exception {
        connection.commit ();
    }
    public void rollback() throws Exception {
        connection.rollback ();
    }
    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}
