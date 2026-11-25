package com.example.mytunes;

import javafx.scene.control.*;

import javafx.scene.layout.VBox;

import java.util.Optional;

public class PlaylisteManage extends Dialogvindue{

    private MyTunesController myTunesController;
    private Playliste playliste;
    private TextField titelfelt = new TextField();
public PlaylisteManage(MyTunesController myTunesController, Playliste playliste) {
    this.myTunesController = myTunesController;
    this.playliste = playliste;
}

    public void tilføjPlayliste() {
        Dialog<ButtonType> dialogvindue = new Dialog<>();
        dialogvindue.setTitle("Tilføj Playliste");
        dialogvindue.setHeaderText("Ny playliste");
        dialogvindue.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        titelfelt.setPromptText("Playliste navn:");

        dialogvindue.getDialogPane().setContent(new VBox(10, titelfelt));
        Optional<ButtonType> knap = dialogvindue.showAndWait();

        if (knap.isPresent() && knap.get() == ButtonType.OK) {
            try {
                Playliste ny = new Playliste(titelfelt.getText(), playliste.getAntalSange(), playliste.getSamlagtTid());
                myTunesController.playlisteObsListe.add(ny);
            } catch (NumberFormatException e) {
                System.out.println("tid skal være et helt tal");
            }
        }
    }

    @Override
    void gem() {

    }

    public void redigerSang(Playliste p) {
        Dialog<ButtonType> dialogvindue = new Dialog();
        dialogvindue.setTitle("Rediger person");
        dialogvindue.setHeaderText("Person");
        dialogvindue.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        VBox box = new VBox(titelfelt);
        dialogvindue.getDialogPane().setContent(box);

        titelfelt.setText(p.getPlaylisteNavn());

        Optional<ButtonType> knap = dialogvindue.showAndWait();

        if (knap.get() == ButtonType.OK) {
            p.setPlaylisteNavn(titelfelt.getText());
            myTunesController.playlisteTableview.refresh();
            myTunesController.playlisteTableview.sort();
        }


    }
}
