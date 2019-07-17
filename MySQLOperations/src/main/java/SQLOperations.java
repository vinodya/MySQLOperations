import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class SQLOperations {

    void insertData(int id, String name, int age, String address) {
        String query = " INSERT INTO student(id, name, age, address) VALUES (?, ?, ?, ?)";
        try( Connection connection = Driver.connect()) {
            try (PreparedStatement preparedStmt=connection.prepareStatement(query)) {

                preparedStmt.setInt(1, id);
                preparedStmt.setString(2, name);
                preparedStmt.setInt(3, age);
                preparedStmt.setString(4, address);
                int executeUpdate = preparedStmt.executeUpdate();

                if (executeUpdate == 1) {
                    System.out.println("Data inserted successfully");
                }
            }

        } catch (SQLException e) {
            System.out.println("Connection error");
            e.printStackTrace();
        }
    }

    void deleteData(int id) {
        String query = " DELETE FROM student where id=?";
        try(Connection connection = Driver.connect()) {
            try (PreparedStatement preparedStmt=connection.prepareStatement(query)) {

                preparedStmt.setInt(1, id);
                int executeUpdate = preparedStmt.executeUpdate();

                if (executeUpdate == 1) {
                    System.out.println("Student" + id + "deleted successfully");
                }
            }
        } catch (SQLException e) {
            System.out.println("Connection error");
            e.printStackTrace();
        }
    }

    void updateData(int id, String name, int age, String address) {
        String query = " UPDATE student SET name=?, age=?, address=? WHERE id=?";
        try(Connection connection = Driver.connect()) {
            try (PreparedStatement preparedStmt=connection.prepareStatement(query)) {
                preparedStmt.setString(1, name);
                preparedStmt.setInt(2, age);
                preparedStmt.setString(3, address);
                preparedStmt.setInt(4, id);
                int executeUpdate = preparedStmt.executeUpdate();

                if (executeUpdate == 1) {
                    System.out.println("Student " + id + " updated successfully");
                } else {
                    System.out.println("Update error");
                }
            }
        } catch (SQLException e) {
            System.out.println("Connection error");
            e.printStackTrace();
        }
    }

    void viewDetails() {
        String query = "SELECT * FROM student";
        try(Connection connection = Driver.connect()) {
            try (PreparedStatement preparedStmt=connection.prepareStatement(query)) {
                try (ResultSet rs = preparedStmt.executeQuery(query)) {

                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String name = rs.getString("name");
                        int age = rs.getInt("age");
                        String address = rs.getString("address");
                        System.out.format("%s, %s, %s, %s\n", id, name, age, address);
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}