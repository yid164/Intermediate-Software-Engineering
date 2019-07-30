package gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import database.*;

public class Account {

    Stage pop = new Stage();
    Login login = new Login();
    Stage windows = new Stage();
    public void account(){

        windows.setTitle("Signed In");
        windows.initModality(Modality.APPLICATION_MODAL);
        windows.setMinHeight(200);
        windows.setMinWidth(300);
        Scene scene = new Scene(layout());
        scene.getStylesheets().add("gui/account_style.css");
        windows.setScene(scene);
        windows.showAndWait();
    }

    private GridPane layout(){
        GridPane sign = new GridPane();
        Button submit = new Button("Submit");
        Label user_name = new Label("Username: ");
        Label pass_word = new Label("Password: ");
        Label error = new Label("");
        user_name.setPadding(new Insets(15,5,15,5));
        pass_word.setPadding(new Insets(15,5,15,10));
        TextField username = new TextField();
        PasswordField password = new PasswordField();
        Label signed_in = new Label("Welcome to FOS");
        signed_in.setFont(new Font(25));
        sign.add(signed_in,1,0);
        sign.add(user_name,0,1);
        sign.add(pass_word,0,2);
        sign.add(error,1,3);
        sign.add(submit,3,4);
        sign.add(username,1,1);
        sign.add(password,1,2);
        sign.setPadding(new Insets(30,100,15,100));
        submit.setOnAction(ActionEvent->{
            login.login(username.getText(),password.getText());
            if(login.message=="Okay, Login")
            {
                pop();
                windows.close();

            }
            else {
                error.setText("Wrong username or password");
                error.setWrapText(true);
                error.setTextFill(Color.RED);
            }
        });
        return sign;
    }

    private Stage pop() {
        pop.setMinWidth(200);
        VBox vBox = new VBox();
        Label messageLabel = new Label("You are successfully Login");
        messageLabel.setTextFill(Color.ORANGE);
        Label quit = new Label("Click to close");
        quit.setTextFill(Color.RED);
        quit.setFont(new Font(18));
        quit.setOnMousePressed(e -> pop.close());
        vBox.getChildren().addAll(messageLabel, quit);
        Scene scene = new Scene(vBox);
        pop.setScene(scene);
        pop.show();
        return pop;
    }

}