package jdbctesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CRUDProject {
    public static void main(String[] args) throws Exception {

        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.println("Driver loaded successfully!");

        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "scott";
        String password = "tiger";

        try (Connection conn =
                     DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
             Statement stmt = conn.createStatement()) {

            System.out.println("Connection established successfully!");
            System.out.println("Statement object created successfully!");

            String query1 =
                    "INSERT INTO CUSTOMER VALUES " +
                            "(104, 'ROHIT PARMAR', 'rohit@example.com')";

            String query2 =
                    "INSERT INTO CUSTOMER VALUES " +
                            "(105, 'AMIT SHARMA', 'amit@example.com')";

            String query3 =
                    "INSERT INTO CUSTOMER VALUES " +
                            "(106, 'RAHUL VERMA', 'rahul@example.com')";

            int count1 = stmt.executeUpdate(query1);
            int count2 = stmt.executeUpdate(query2);
            int count3 = stmt.executeUpdate(query3);

            System.out.println("Rows inserted: "
                    + (count1 + count2 + count3));

            System.out.println("Connection and statement closed successfully!");
        }
    }
}
