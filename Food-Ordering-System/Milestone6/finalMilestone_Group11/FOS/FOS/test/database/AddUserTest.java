package database;
/**
 * Create By Duke
 */

import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.*;

public class AddUserTest {

    /**
     * Test the add user function.
     * The temp user will be deleted after.
     * @throws Exception
     */
    @Test
    public void addUser() throws Exception {
        GoConnection connection = new GoConnection();
        AddUser addUser = new AddUser();
        addUser.addUser("ABC","DEF","c");

        try {
            connection.connect();

            String query = "select * from users where username = 'ABC'";
            Statement statement = connection.coon.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()){
                assertEquals("DEF",resultSet.getString(3));
            }

            query = "delete from users where username = 'ABC'";
            statement.executeQuery(query);

            connection.coon.close();
        } catch (SQLException e) {

        }
    }

}