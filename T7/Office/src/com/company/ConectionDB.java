package com.company;
import javax.management.Query;
import java.sql.*;

public class ConectionDB implements AutoCloseable{
    private Connection connection;
    private PreparedStatement preparedStatement;
    public ConectionDB() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "amir", "myjava123");
        connection.setAutoCommit(false);
    }
    public void insert(EmployeeEntity entity) throws Exception {
        preparedStatement = connection.prepareStatement("insert into employee ( name, family, personalid, eduid) values (?,?,?,?)");

        preparedStatement.setString(1, entity.getName());
        preparedStatement.setString(2, entity.getFamily());
        preparedStatement.setInt(3, entity.getID_code());
        preparedStatement.setInt(4, entity.getEducation());
        preparedStatement.executeUpdate();
        System.out.println("welcome to our office  "+entity.getName());

    }

    public void update(EmployeeEntity entity,String name,String family,int idcode) throws Exception{
        preparedStatement=connection.prepareStatement("update employee set name=?,family=?,personalid=?,eduid=? where name=? and family=? and personalid=?");

        preparedStatement.setString(1, entity.getName());
        preparedStatement.setString(2, entity.getFamily());
        preparedStatement.setInt(3, entity.getID_code());
        preparedStatement.setInt(4, entity.getEducation());

        preparedStatement.setString(5,name);
        preparedStatement.setString(6,family);
        preparedStatement.setInt(7,idcode);
        preparedStatement.executeUpdate();

        System.out.println("update sucessfully");

    }
    public void delete(String name,String family,int idcode) throws Exception{
        preparedStatement=connection.prepareStatement("delete from employee where name=? and family=? and PERSONALID=?");
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,family);
        preparedStatement.setInt(3,idcode);
        preparedStatement.executeUpdate();

        System.out.println("delete sucessfully");

    }
    public void Showemp()throws Exception{
        String query ="select * from EMPLOYEE" ;
        Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet rset = stmt.executeQuery(query);
        System.out.println("number      |      name     |       fammily     |       personalid     |        edu\n");
        int i=1;
        while (rset.next())
        {
            System.out.println(
                    i+"      |      "+
               rset.getString(1)+"      |      "+
               rset.getString(2)+"      |      "+
               rset.getInt(3)+"      |      "+
               rset.getInt(4));
            System.out.println("----------------------------------------------------------------------------------");
            i++;
        }


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

