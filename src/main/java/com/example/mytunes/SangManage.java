package com.example.mytunes;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.Optional;

public class SangManage extends Dialogvindue {

    private MyTunesController myTunesController;
    public SangManage (MyTunesController myTunesController) {
    }

    /*
    public void tilføjSang() {
        dialogvindue();
        ComboBox<Playliste> playlisteComboBox = new ComboBox<>(playlisteObsListe);
        ComboBox<String> genreComboBox = new ComboBox<>();

        TextField titelfelt = new TextField();
        TextField tidsfelt = new TextField();
        TextField mp3felt = new TextField();
        TextField kunstnerfelt = new TextField();
        genreComboBox.getItems().addAll("POP", "Rock", "Country", "techno");
        genreComboBox.setPromptText("Vælg genre");
        mp3felt.setEditable(false);
        mp3felt.setPromptText("vælg MP3");
        kunstnerfelt.setPromptText("Kunstner:");
        titelfelt.setPromptText("Titel:");
        playlisteComboBox.setPromptText("Vælg playliste");
        tidsfelt.setPromptText("Varighed:");

        Button mp3knap = new Button("Vælg fil");
        mp3knap.setOnAction(e -> {
            FileChooser fc = new FileChooser();
            fc.setInitialDirectory(new File("src/main/resources/com/example/mytunes/MP3"));
            File valgt = fc.showOpenDialog(mp3knap.getScene().getWindow());
            if (valgt != null) {
                mp3felt.setText(valgt.getName());
            }
        });

        dialogvindue.getDialogPane().setContent(new VBox(10, titelfelt, kunstnerfelt, tidsfelt, genreComboBox, playlisteComboBox, new HBox(5, mp3felt, mp3knap)));
        Optional<ButtonType> knap = dialogvindue.showAndWait();

        if (knap.isPresent() && knap.get() == ButtonType.OK) {
            try {
                int tid = Integer.parseInt(tidsfelt.getText());
                Playliste valgtPlayliste = playlisteComboBox.getValue();
                if (valgtPlayliste == null) return;
                Sang ny = new Sang(titelfelt.getText(), kunstnerfelt.getText(), tid, mp3felt.getText());
                sangObsListe.add(ny);
                valgtPlayliste.tilføjSang(ny);
            } catch (NumberFormatException e) {
                System.out.println("tid skal være et helt tal");
            }
        }
    }

     */

    @Override
    void gem() {

    }
}
