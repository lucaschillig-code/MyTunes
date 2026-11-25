package com.example.mytunes;

import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.Optional;

public class SangManage extends Dialogvindue {

    private MyTunesController myTunesController;


    private ComboBox<Playliste> playlisteComboBox;
    private ComboBox<String> genreComboBox = new ComboBox<>();
    private TextField titelfelt = new TextField();
    private TextField tidsfelt = new TextField();
    private TextField mp3felt = new TextField();
    private TextField kunstnerfelt = new TextField();

    public SangManage(MyTunesController myTunesController) {
        this.myTunesController = myTunesController;
    }

    public void tilføjSang() {
        dialogvindue();

        playlisteComboBox = new ComboBox<>(myTunesController.playlisteObsListe);
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

        dialog.getDialogPane().setContent(new VBox(10, titelfelt, kunstnerfelt, tidsfelt, genreComboBox, playlisteComboBox, new HBox(5, mp3felt, mp3knap)));
        Optional<ButtonType> knap = dialog.showAndWait();

        if (knap.isPresent() && knap.get() == ButtonType.OK) {
            try {
                int tid = Integer.parseInt(tidsfelt.getText());
                Playliste valgtPlayliste = playlisteComboBox.getValue();
                if (valgtPlayliste == null) return;
                Sang ny = new Sang(titelfelt.getText(), kunstnerfelt.getText(), tid, mp3felt.getText());
                myTunesController.sangObsListe.add(ny);
                valgtPlayliste.tilføjSang(ny);
            } catch (NumberFormatException e) {
                System.out.println("tid skal være et helt tal");
            }
        }
    }

    @Override
    void gem() {

    }
}