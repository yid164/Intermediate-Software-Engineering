package UI.Account;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;

/**
 * Create By Hao Li at Oct. 21th
 */

public class user_account extends VBox{

    // access for create vbox for make frame of account
    public user_account() {
        checkBox();
        setPrefHeight(100);
        setPrefWidth(100);
        getStylesheets().add("css/acc_main.css");
        Signed_In signedIn = new Signed_In();
        this.getChildren().addAll(signedIn.personal.info, signedIn.personal.address, checkBox());
    }



    // make frame for check box ----deliver
    private VBox checkBox(){
        //creation
        VBox checkbox = new VBox();
        CheckBox deliver = new CheckBox();
        CheckBox pick_up = new CheckBox();
        CheckBox reservation = new CheckBox();
        deliver.setText("Deliver");
        pick_up.setText("Pick Up");
        reservation.setText("Reservation");

        //listener for 3 checkboxes
        deliver.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                pick_up.setSelected(false);
                reservation.setSelected(false);
            }
        });
        pick_up.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                deliver.setSelected(false);
                reservation.setSelected(false);
            }
        });
        reservation.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                deliver.setSelected(false);
                pick_up.setSelected(false);

            }
        });

        //add all
        checkbox.getChildren().addAll(deliver,pick_up,reservation);
        return checkbox;
    }

}
