package UI.Account;

import database.DisplayUserInformation;
import database.GetUserId;
import database.Login;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
/**
 * Create By Hao Li at Oct. 12th
 */

class Signed_In {
    // creation
    private Login login = new Login();
    private Stage windows = new Stage();
    private Registration registration = new Registration();
    personal personal = new personal();
    GetUserId u_id = new GetUserId();
    DisplayUserInformation d_u = new DisplayUserInformation();

    // access
    Signed_In(){

        // set up modality
        windows.initModality(Modality.APPLICATION_MODAL);
        //change size for info & address
        personal.info.setPrefSize(100,20);
        personal.address.setPrefSize(200,20);
        // call listener
        setinfo();

    }

    // info & address listeners. To change the text and function
    private void setinfo(){

        // info listener
        personal.info.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!personal.getCheck()){
                    personal.PA();
                }
                else {
                    info();
                }
            }
        });

        // address listener
        personal.address.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!personal.getCheck()){
                    System.out.println("Address");
                }
                else {
                    registration.Reg();
                }
            }
        });
    }

    // make frame for signed in
    private void info(){
        windows.setTitle("Signed In");
        windows.setMinHeight(200);
        windows.setMinWidth(300);
        Scene scene = new Scene(layout());
        scene.getStylesheets().add("css/account_style.css");
        windows.setScene(scene);
        windows.show();
    }

    // method for signed in
    private GridPane layout(){

        // create signed in pane, button, label
        GridPane sign = new GridPane();
        Button submit = new Button("Submit");
        Label user_name = new Label("Username: ");
        Label pass_word = new Label("Password: ");
        Label error = new Label("");
        Label signed_in = new Label("Welcome to FOS");
        TextField username = new TextField();
        PasswordField password = new PasswordField();

        // listener for submit button
        submit.setOnAction(ActionEvent->{
            login.login(username.getText(),password.getText());
            if(login.message.equals("true"))
            {
                //pop();
                u_id.getUserId(username.getText(),password.getText());
                personal.user_id = u_id.user_id;
                d_u.getCustomerInfo(u_id.user_id);
                personal.u_name = d_u.customer_last_name+" "+d_u.customer_first_name;
                personal.u_address=d_u.customer_location;
                personal.u_email = d_u.customer_email;
                personal.phone_num = d_u.customer_phone_num;
                personal.info.setText("Hi, "+login.name);
                personal.address.setText(d_u.customer_location);
                personal.setCheck(false);
                setinfo();
                windows.close();


            }
            else {
                error.setText("Wrong username or password");
                error.setWrapText(true);
                error.setTextFill(Color.RED);
            }
        });


        // set padding
        user_name.setPadding(new Insets(15,5,15,5));
        pass_word.setPadding(new Insets(15,5,15,10));
        sign.setPadding(new Insets(30,100,15,100));
        signed_in.setFont(new Font(25));



        //Add all
        sign.add(signed_in,1,0);
        sign.add(user_name,0,1);
        sign.add(pass_word,0,2);
        sign.add(error,1,3);
        sign.add(submit,3,4);
        sign.add(username,1,1);
        sign.add(password,1,2);


        return sign;
    }


}