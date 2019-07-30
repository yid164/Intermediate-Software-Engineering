package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Create by Yinsheng Dong (yid164)
 * This class is used to add an user, this should be before add customer and restaurant
 **/
public class AddUser
{
    /** New connection */
    public GoConnection connect = new GoConnection();
    /** this is for user_status */
    public String st = null;
    /** this is for username */
    public String un = null;
    /** public message */
    public String message = "";
    PreparedStatement statement;

    /**
     * The function is use for inserting an user to the database
     * @param username username that user created
     * @param userPassword password that user created
     * @param status if they are restaurant or not
     * @Pre the username has not been used
     */
    public void addUser(String username, String userPassword, String status)
    {
        String Query;
        connect.connect();
        if(connect.coon != null)
        {
            try
            {
                // check if the username has been used or not
                Query = "select username from users where username = ?";
                this.insideHelper(Query,username);
                ResultSet rs = statement.executeQuery();
                if (rs.next())
                {
                    this.setMessage("This username has been used");
                }
                else
                {
                    // if not used username, then insert them to database
                    Query = "insert into users (username, passwords, user_status) values(?,?,?)";
                    un = username;
                    st = status;
                    this.insideHelper(Query,username);
                    statement.setString(2, userPassword);
                    statement.setString(3, status);
                    int affected = statement.executeUpdate();
                    if (affected > 0)
                    {
                        this.setMessage("You have successfully signed up");
                    }
                }
                connect.coon.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }


        }
    }

    private void insideHelper(String input, String username)
    {
        try
        {
            statement = connect.coon.prepareStatement(input);
            statement.setString(1, username);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    private void setMessage(String input)
    {
        message = input;
        System.out.println(message);
    }

    /**
     * main function for testing
     * @param arg
     */
    /**
    public static void main (String arg[])
    {
        AddUser addUser = new AddUser();
        addUser.connect.connect();
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the username: \n");
        String username = in.nextLine();
        System.out.println("Please enter the password: \n");
        String password = in.nextLine();
        System.out.println("Please enter your status: \n");
        String status = in.nextLine();
        addUser.addUser(username,password,status);

    }
     */


}
