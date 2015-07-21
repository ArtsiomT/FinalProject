package by.epam.terehovich.internetprovider.dao;

import by.epam.terehovich.internetprovider.connection.ConnectionPool;
import by.epam.terehovich.internetprovider.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by aterehovich on 18.7.15.
 */
public class UserDAO extends AbstractDAO<Integer, User> {
    private final static String SELECT_PASSWORD_BY_LOGIN = "SELECT user.password FROM internet_provider.user" +
                                                        " WHERE login = ?";
    private final static String INSERT_NEW_USER = "INSERT INTO internet_provider.account (login, password, email, id_role, firstname, secondname, lastname, address, city, datebirth) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final static String SELECT_USER_BY_LOGIN = "SELECT * FROM `internet_provider`.`account` WHERE login = ?";
    private final static String SELECT_ALL = "SELECT * FROM `internet_provider`.`account`";


    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(SELECT_ALL);
            while (rs.next()){
                GregorianCalendar cal = new GregorianCalendar();
                cal.setTime(rs.getDate(11));
                users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8),
                        rs.getString(9), rs.getString(10), cal));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionPool.closeConnection(connection);
        }
        return users;
    }

    @Override
    public User findById(Integer id) {
        return null;
    }

    @Override
    public User findByLogin(String login) {
        User user = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SELECT_USER_BY_LOGIN);
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                GregorianCalendar cal = new GregorianCalendar();
                cal.setTime(rs.getDate(11));
                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8),
                        rs.getString(9), rs.getString(10), cal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(ps != null){
                try {
                    ps.close();
                    System.out.println("ps.close");
                } catch (SQLException e) {
                    System.out.println("ps.close exception");
                    e.printStackTrace();
                }
            }
            ConnectionPool.closeConnection(connection);
        }
        return user;
    }

    @Override
    public boolean insertNew(User entity) {
        PreparedStatement ps = null;
        try {
            ps = this.connection.prepareStatement(INSERT_NEW_USER);
            ps.setString(1, entity.getLogin());
            ps.setString(2, entity.getPassword());
            ps.setString(3, entity.getEmail());
            ps.setInt(4, entity.getRole());
            ps.setString(5, entity.getFirstname());
            ps.setString(6, entity.getSecondname());
            ps.setString(7, entity.getLastname());
            ps.setString(8, entity.getAddress());
            ps.setString(9, entity.getCity());
            ps.setDate(10, Date.valueOf(String.valueOf(entity.getBirth())));
            ps.executeUpdate();
            System.out.println("execute update");
        } catch (SQLException e) {
            System.out.println("Sql exception with inserting new user");
            return false;
        } finally {
            if(ps != null){
                try {
                    ps.close();
                    System.out.println("ps.close() insert");
                } catch (SQLException e) {
                    System.out.println("ps.close exception insert");
                    e.printStackTrace();
                }
            }
            ConnectionPool.closeConnection(connection);
        }
        return true;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }


}
