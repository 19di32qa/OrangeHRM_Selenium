package OrangeHPM.Utilities;

import OrangeHPM.PageObjects.BaseClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class DataBase {
    Connection connection;
    String ip;
    String user;
    String password;
    public DataBase(String ip, String user, String password) {
        this.ip = ip;
        this.user = user;
        this.password = password;
    }
    public void setConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql:"+ip,user,password);
        Logger logger = LoggerFactory.getLogger(DataBase.class);
        logger.info("connection with database is set");
    }
    public ResultSet executeStatement(String string) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(string);
        return resultSet;
    }
}
