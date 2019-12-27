package dao.Impl;

import dao.BookDAO;
import vo.RecordVO;
import vo.UserVO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO {
    @Override
    public Connection getConnection() throws NamingException, SQLException {
        Context context = new InitialContext();
        DataSource dataSource = (DataSource)context.lookup("java:/comp/env/jdbc/bbs");
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
    public int register(UserVO userVO) throws SQLException, NamingException {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        Connection connection = this.getConnection();
        preparedStatement = connection.prepareStatement("INSERT into guestbook.user(username, password, email) values (?,?,?)");
        preparedStatement.setString(1, userVO.getUsername());
        preparedStatement.setString(2, userVO.getPassword());
        preparedStatement.setString(3, userVO.getEmail());
        int state = preparedStatement.executeUpdate();
        this.close(resultSet,preparedStatement,connection);
        return state;
    }
    @Override
    public int login(String username, String password) throws SQLException, NamingException {
        int state = 0;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        Connection connection = this.getConnection();
        preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE username = ?");
        preparedStatement.setString(1,username);
        resultSet = preparedStatement.executeQuery();
        resultSet.next();
        String passwordTemp = resultSet.getString(3);
        if (passwordTemp.equals(password))
        {
            state = 1;
        }
        else
        {
            state = 0;
        }
        return state;
    }
    @Override
    public int addMessage(RecordVO recordVO) throws SQLException, NamingException {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        Connection connection = this.getConnection();
        preparedStatement = connection.prepareStatement("INSERT into guestbook.record(name, title, content) values (?,?,?)");
        preparedStatement.setString(1, recordVO.getName());
        preparedStatement.setString(2, recordVO.getTitle());
        preparedStatement.setString(3, recordVO.getContent());
        int state = preparedStatement.executeUpdate();
        this.close(resultSet,preparedStatement,connection);
        return state;
    }
    @Override
    public ArrayList<RecordVO> showAllMessage() throws SQLException, NamingException {
        List<RecordVO> listRecord = new ArrayList<RecordVO>();
        RecordVO recordVO = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        String sql = "SELECT * FROM guestbook.record";
        connection = this.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
            recordVO = new RecordVO(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3));
            listRecord.add(recordVO);
        }
        this.close(resultSet,preparedStatement,connection);
        return (ArrayList<RecordVO>)listRecord;
    }
}
