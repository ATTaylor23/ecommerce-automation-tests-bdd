package utilities;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class TestDBUtil {

    public static void main(String[] args) throws SQLException {



        DButility.createConnection();

        String query = "Select * from users limit 10";

        List<List<Object>> queryResultAsListOfLists = DButility.getQueryResultAsListOfLists(query);

        System.out.println(queryResultAsListOfLists);

        for (List<Object> eachRow : queryResultAsListOfLists) {
            System.out.println(eachRow);
        }

        System.out.println(queryResultAsListOfLists.get(1).get(2));


        List<Map<String, Object>> queryResultListOfMaps = DButility.getQueryResultListOfMaps(query);

        for (Map<String, Object> eachRow : queryResultListOfMaps) {
            System.out.println(eachRow);
        }
        System.out.println(queryResultListOfMaps.get(1).get("firstName"));


        System.out.println(DButility.getColumnNames(query));



        // update
        DButility.updateQuery("update users Set email = 'dutoech2023@gmail.com' Where username = 'duotech'");

        System.out.println(queryResultAsListOfLists.get(0).get(4));

    }

}
