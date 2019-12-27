package dao;

import vo.BookVO;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface BookDAO {

    Connection getConnection() throws NamingException, SQLException;

    void close(ResultSet resultSet, PreparedStatement preparedStatement,Connection connection);

    void register(BookVO bookVO) throws SQLException, NamingException;

    Boolean login(String username,String passward) throws SQLException, NamingException;
}
