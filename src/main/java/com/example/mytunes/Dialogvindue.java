package com.example.mytunes;

import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

import java.io.File;

public abstract class Dialogvindue {

    protected Dialog<ButtonType> dialog;


    public void dialogvindue() {
        Dialog<ButtonType> dialogvindue = new Dialog<>();
        dialogvindue.setTitle("Tilføj sang");
        dialogvindue.setHeaderText("Ny sang");
        dialogvindue.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

    }
    abstract void gem();

    public void fotryd() {

    }
}
