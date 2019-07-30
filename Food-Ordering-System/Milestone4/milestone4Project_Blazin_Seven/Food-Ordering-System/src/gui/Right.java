package gui;

import database.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;


public class Right extends BorderPane {
    Button Quit = new Button();
    Button search_button = new Button("Search");
    TextField search = new TextField();
    SearchRestaurants searchRestaurants = new SearchRestaurants();
    public Right(){
        setTop(top());
        setCenter(centre());
        setBottom(bottom());
    }


    private GridPane top(){
        GridPane set = new GridPane();

        Button sign_up = new Button("Sign up");
        Button Log_in = new Button(" Log in");
        Label display = new Label();

        Log_in.setOnAction(e->new Account().account());
        sign_up.setOnAction(e->new Registration().Reg());



        set.add(search,0,0);
        set.add(search_button,1,0);
        set.add(sign_up,0,1);
        set.add(Log_in,1,1);
        set.add(display,0,2);
        search.setPadding(new Insets(6,80,6,0));

        return set;
    }

    private StackPane centre() {
        StackPane centre = new StackPane();
        Label display = new Label();
        search_button.setOnAction(e->{

            searchRestaurants.SearchRestaurant(search.getText());

            if(searchRestaurants.message=="Can not search the empty input")
            {
                display.setText(searchRestaurants.message);
            }
            else if (searchRestaurants.message=="Not found")
            {
                display.setText("Not found the restaurant that you search, please try again");
            }
            else if(searchRestaurants.message=="Found")
            {
                display.setText(searchRestaurants.restaurantFound);
            }
            else {
                display.setText("Please enter something");
            }


        });

        display.setWrapText(true);
        centre.getChildren().add(display);
        centre.setAlignment(Pos.CENTER);
        centre.setMaxSize(220,600);
        return centre;
    }

    public HBox bottom() {
        HBox bottom = new HBox();

        Quit.setText("      Quit        ");
        //Quit.setStyle("-fx-background-color: red");
        bottom.setAlignment(Pos.CENTER_RIGHT);
        bottom.getChildren().addAll(Quit);
        //bottom.setMaxSize(220,200);
        return bottom;
    }
}
