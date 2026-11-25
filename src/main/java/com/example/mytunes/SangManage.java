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
        Dialog<ButtonType> dialogvindue = new Dialog<>();
        dialogvindue.setTitle("Tilføj sang");
        dialogvindue.setHeaderText("Ny sang");
        dialogvindue.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

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

        dialogvindue.getDialogPane().setContent(new VBox(10, titelfelt, kunstnerfelt, tidsfelt, genreComboBox, playlisteComboBox, new HBox(5, mp3felt, mp3knap)));
        Optional<ButtonType> knap = dialogvindue.showAndWait();

        if (knap.isPresent() && knap.get() == ButtonType.OK) {
            try {

                Playliste valgtPlayliste = playlisteComboBox.getValue();
                int tid = Integer.parseInt(tidsfelt.getText());
                valgtPlayliste.setTid(tid);
                Sang ny = new Sang(titelfelt.getText(), kunstnerfelt.getText(), tid, mp3felt.getText());
                myTunesController.sangObsListe.add(ny);
                valgtPlayliste.tilføjSang(ny);
                valgtPlayliste.antalSangePlus();
                valgtPlayliste.TidPlus();
                myTunesController.playlisteTableview.refresh();

            } catch (NumberFormatException e) {
                System.out.println("tid skal være et helt tal");
            }
        }
    }

    @Override
    void gem() {

    }

    public void redigerSang(Sang s) {

        Dialog<ButtonType> dialogvindue = new Dialog<>();
        dialogvindue.setTitle("Rediger sang");
        dialogvindue.setHeaderText("Sang");
        dialogvindue.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        titelfelt.setText(s.getSangTitel());
        kunstnerfelt.setText(s.getSangKunstner());
        tidsfelt.setText(String.valueOf(s.getSangTid()));
        mp3felt.setText(s.getMp3fil());
        mp3felt.setEditable(false);

        Button mp3knap = new Button("Vælg fil");
        mp3knap.setOnAction(e -> {
            FileChooser fc = new FileChooser();
            fc.setInitialDirectory(new File("src/main/resources/com/example/mytunes/MP3"));
            File valgt = fc.showOpenDialog(dialogvindue.getDialogPane().getScene().getWindow());
            if (valgt != null) {
                mp3felt.setText(valgt.getName());
            }
        });

        VBox box = new VBox(10, titelfelt, kunstnerfelt, tidsfelt, new HBox(5, mp3felt, mp3knap));
        dialogvindue.getDialogPane().setContent(box);

        Optional<ButtonType> knap = dialogvindue.showAndWait();

        if (knap.isPresent() && knap.get() == ButtonType.OK) {
            try {
                s.setSangTitel(titelfelt.getText());
                s.setSangKunstner(kunstnerfelt.getText());
                s.setSangTid(Integer.parseInt(tidsfelt.getText()));
                s.setMp3fil(mp3felt.getText());
                myTunesController.sangeTableview.refresh();
                myTunesController.sangeTableview.sort();
            } catch (NumberFormatException e) {
                System.out.println("tid skal være et helt tal");
            }
        }
    }
}