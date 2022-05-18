package utilities;

import java.sql.*;

public class TestJDBC {


    public static void main(String[] args) throws SQLException {

        //jdbc:{driverType}://{urlToDBandSchema}
        String url = "jdbc:mysql://db-duotech.cc652zs7kmja.us-east-2.rds.amazonaws.com/duotify";

        Connection connection = DriverManager.getConnection(url, "duotech", "duotech2021");

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

        ResultSet resultSet = statement.executeQuery("Select * from users limit 10");

//        resultSet.next();
//
//        System.out.println(resultSet.getString(2));
//        System.out.println(resultSet.getString("username"));

        //To iterate through the result set
//        while(resultSet.next()){
//            System.out.println(resultSet.getString("username"));
//        }

        resultSet.next();
        System.out.println(resultSet.getString(2)); //indexes ar NOT zero-based

        resultSet.absolute(5);

        System.out.println(resultSet.getString("username"));

        resultSet.last();
        System.out.println(resultSet.getString("username"));

        ResultSetMetaData metaData = resultSet.getMetaData();  //getMetaData() returns ResultMetaData

        System.out.println(metaData.getColumnCount());  //to get column info use ResultSetMetaData

        System.out.println(metaData.getColumnName(2));

        // to find the no. of columns

        int columnCount = metaData.getColumnCount();

        // to get the row count

        // go to last row and grab the row number

        resultSet.last();
        int rowNo = resultSet.getRow();
        System.out.println(rowNo);

        resultSet.first();

        for (int i = 1; i <= rowNo; i++) {
            for (int j = 1; j <= columnCount; j++) {

                System.out.print(resultSet.getString(j) + "\t");

            }
            System.out.println();
            resultSet.next();
        }
    }


}
