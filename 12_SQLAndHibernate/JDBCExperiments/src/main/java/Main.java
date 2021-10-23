import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/skillbox", "root", "testtest");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(" SELECT courses.name, SUM(subscriptions.student_id) / 12 FROM courses " +
                    "JOIN subscriptions ON courses.id = subscriptions.course_id " +
                    "WHERE YEAR(subscriptions.subscription_date) = 2018 " +
                    "GROUP BY courses.name ORDER BY AVG(subscriptions.student_id)");
            System.out.println("Название курса | среднее число покупок за 2018 год");
            while (resultSet.next()) {
                String result = resultSet.getString("courses.name") + " | " +
                        resultSet.getString("SUM(subscriptions.student_id) / 12");
                System.out.println(result);
            }
            connection.close();
            resultSet.close();
            statement.close();

        } catch (Exception exception) {
            exception.printStackTrace();

        }
    }
}
