package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FilmDAO {

    public Film insert(String title, String description, LocalDate date, int price) throws Exception {
        String query = "insert into film(`title`, `description`, `date`, `price`) values (?, ?, ?, ?)";

        Film journal = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DaoConnection.getInstance().getConnection();

            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, title);
            statement.setString(2, description);
            statement.setDate(3, Date.valueOf(date));
            statement.setInt(4, price);
            int rows = statement.executeUpdate();
            System.out.printf("%d row(s) added!\n", rows);

            if (rows == 0) {
                throw new Exception("Creating film failed, no rows affected!");
            } else {
                resultSet = statement.getGeneratedKeys();

                if (resultSet.next()) {
                    journal = new Film(resultSet.getInt(1), title, description, date, price);
                }
            }
        } catch (SQLException e) {
            throw new Exception("Creating film failed!", e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                System.err.println("Result set can't be closed!" + e);
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.err.println("Prepared statement can't be closed!" + e);
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Connection can't be closed!" + e);
            }
        }

        System.out.println(journal + " is added to database!");
        return journal;
    }

    public boolean delete(String title) throws Exception {
        String sqlQuery = "delete from film where title = ?";

        Connection connection = null;
        PreparedStatement statement = null;
        boolean result = false;

        try {
            connection = DaoConnection.getInstance().getConnection();

            statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, title);
            int rows = statement.executeUpdate();
            System.out.printf("%d row(s) deleted!\n", rows);

            if (rows == 0) {
                throw new Exception("Deleting film failed, no rows affected!");
            } else {
                result = true;
            }
        } catch (SQLException e) {
            throw new Exception("Deleting film failed!", e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.err.println("Prepared statement can't be closed!" + e);
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Connection can't be closed!" + e);
            }
        }

        if (result == false) {
            System.err.println("Deleting film failed, no rows affected!");
        } else {
            System.out.println("Film with title" + title + " is deleted from database!");
        }
        return result;
    }

    public List<Film> readAll() throws Exception {
        String sqlQuery = "select * from film";

        List<Film> journalList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DaoConnection.getInstance().getConnection();
            statement = connection.prepareStatement(sqlQuery);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                journalList.add(new Film(resultSet.getInt("id"), resultSet.getString("title"),
                        resultSet.getString("description"), resultSet.getDate("date").toLocalDate(),
                        resultSet.getInt("price")));
            }
        } catch (SQLException e) {
            throw new Exception("Getting list of film failed!", e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                System.err.println("Result set can't be closed!" + e);
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.err.println("Prepared statement can't be closed!" + e);
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Connection can't be closed!" + e);
            }
        }

        return journalList;
    }

    public Film readByID(int id) throws Exception {
        String sqlQuery = "select * from film where id = ?";

        Film journal = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DaoConnection.getInstance().getConnection();
            statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                journal = new Film(resultSet.getInt("id"), resultSet.getString("title"),
                        resultSet.getString("description"), resultSet.getDate("publish_date").toLocalDate(),
                        resultSet.getInt("subscribe_price"));
            }
        } catch (SQLException e) {
            throw new Exception("Getting film by id failed!", e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                System.err.println("Result set can't be closed!" + e);
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.err.println("Prepared statement can't be closed!" + e);
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Connection can't be closed!" + e);
            }
        }

        System.out.println(journal + " is getted from database!");
        return journal;
    }

}
