package dao.Impl;

import dao.BookDAO;
import vo.BookVO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDAOImpl implements BookDAO {

    @Override
    public Connection getConnection() throws NamingException, SQLException {
        Context context = new InitialContext();
        DataSource dataSource = (DataSource) context.lookup("java:/comp/env/jdbc/bbs");
        Connection connection = dataSource.getConnection();
        return connection;
    }

    @Override
    public void close(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void register(BookVO bookVO) throws SQLException, NamingException {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        Connection connection = this.getConnection();
        preparedStatement = connection.prepareStatement("INSERT into guestbook.user(username, password, email) values(?,?,?)");
        preparedStatement.setString(1,bookVO.getUsernname());
        preparedStatement.setString(2,bookVO.getPassword());
        preparedStatement.setString(3,bookVO.getEmail());
        preparedStatement.executeUpdate();
        this.close(resultSet,preparedStatement,connection);
    }

    @Override
    public Boolean login(String username, String passward) throws SQLException, NamingException {
        Boolean judge = false;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        Connection connection = this.getConnection();
        preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE username = ? AND password = ?");
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,passward);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            judge = true;
        }
        this.close(resultSet,preparedStatement,connection);
        return judge;
    }
}
