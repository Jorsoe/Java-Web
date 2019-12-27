package dao;

import vo.RecordVO;
import vo.UserVO;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface BookDAO {

    Connection getConnection() throws NamingException, SQLException;

    void close(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection);

    int register(UserVO userVO) throws SQLException, NamingException;

    int login(String username,String password) throws SQLException, NamingException;

    int addMessage(RecordVO recordVO) throws SQLException, NamingException;

    ArrayList<RecordVO> showAllMessage() throws SQLException, NamingException;
}
