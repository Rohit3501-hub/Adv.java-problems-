package jdbctesting;

import java.sql.*;

public class FirstJDBCApplication {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/test";
        String userName = "root";
        String passWord = "tiger";

        try {
            // 1 Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2 Create a connection to the database

            Connection connection = DriverManager.getConnection(url, userName, passWord);

            System.out.println("Connection established successfully!");

            // 3. Create a statement object to execute SQL queries
            Statement statement = connection.createStatement();

            // 4. Execute SQL queries using the statement object
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student");

            // 5. Process the results
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String course = resultSet.getString("course");
                double fee = resultSet.getDouble("fee");
                System.out.println("ID: " + id + "\n Name: " + name + "\n Course: " + course + "\n Fee: " + fee);
            }
            // 6. Close the resources
            resultSet.close();
            statement.close();
            connection.close();

        }// Replace with your database name
        catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
