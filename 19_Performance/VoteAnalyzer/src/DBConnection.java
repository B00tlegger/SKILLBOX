import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    private static Connection connection;

    private static final String dbName = "learn";
    private static final String dbUser = "root";
    private static final String dbPass = "testtest";
    private static StringBuilder insertQuery = new StringBuilder();

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/" + dbName +
                                "?user=" + dbUser + "&password=" + dbPass);
                connection.createStatement().execute("DROP TABLE IF EXISTS voter_count");
                connection.createStatement().execute("CREATE TABLE voter_count(" +
                        "id INT NOT NULL AUTO_INCREMENT, " +
                        "name TINYTEXT NOT NULL, " +
                        "birthDate DATE NOT NULL, " +
                        "`count` INT NOT NULL, " +
                        "PRIMARY KEY(id))");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void insertMultiQuery() {
        String query = "INSERT INTO voter_count(name, birthDate, `count`) " +
                "VALUES" + insertQuery.toString();
        try {
            DBConnection.getConnection().createStatement().execute(query);
            System.out.println("Запрос отправлен " + LocalDateTime.now());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void countVoter(String name, String birthDay) throws SQLException {
        birthDay = birthDay.replace('.', '-');
            if (insertQuery.capacity() > 4000000) {
                insertMultiQuery();
                insertQuery = new StringBuilder();
            }
            insertQuery.append((insertQuery.length() == 0 ? "" : ",") + "('" + name + "', '" + birthDay + "', 1 )");
    }

    public static void uniqueDB(){
        try {
            ResultSet resultSet = DBConnection.getConnection().createStatement().executeQuery("SELECT id, name, birthDate, count, count(*) AS num " +
                    "FROM voter_count " +
                    "GROUP BY name, birthDate " +
                    "HAVING count(*) > 1");
            System.out.println("Дубликаты найдены");
            while (resultSet.next()){
                deleteDuplicate(resultSet);
                DBConnection.getConnection().createStatement().execute("UPDATE learn.voter_count " +
                        "SET count=" + resultSet.getInt("num") +
                        " WHERE" +
                            " name='" + resultSet.getString("name") + "' AND " +
                            "birthDate='" + resultSet.getString("birthDate") + "'");
                System.out.println("Строка изменена");

            }
            resultSet.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void deleteDuplicate(ResultSet resultSet) {
        List<Integer> id = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getConnection().createStatement().executeQuery("SELECT id " +
                            "FROM learn.voter_count " +
                            "WHERE name='" + resultSet.getString("name") + "' " +
                            "AND birthDate='" + resultSet.getString("birthDate") + "', " +
                            "ORDER BY id ");
            while (rs.next()){
                id.add(resultSet.getInt("id"));
            }
            for (int i = 1 ; i < id.size() ; i++){
                DBConnection.getConnection().createStatement().execute("DELETE FROM voter_count " +
                        "WHERE id=" + id.get(i));
                System.out.println("Дубликат удалён");
            }
            rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void printVoterCounts() throws SQLException {
        String sql = "SELECT  name, birthDate, `count` FROM voter_count WHERE `count` > 1";
        ResultSet rs = DBConnection.getConnection().createStatement().executeQuery(sql);
        while (rs.next()) {
            System.out.println("\t" + rs.getString("name") + " (" +
                    rs.getString("birthDate") + ") - " + rs.getInt("count"));
        }
    }
}
