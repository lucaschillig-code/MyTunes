package com.example.mytunes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.Optional;

public class MyTunesController {

    @FXML
    private Button forrigeKnapID;

    @FXML
    private TableColumn<Sang, String> kunstnerKolonne;

    @FXML
    private Button nyPlaylisteID;

    @FXML
    private Button nySangID;

    @FXML
    private Button næsteKnapID;

    @FXML
    private TableView<PlaylisteSange> playlistSangeTableview;

    @FXML
    //ret integer til hvad vi gør for " 00:00 "
    private TableColumn<Playliste, Integer> playlisteAntalSangeKolonne;

    @FXML
    private TableColumn<Playliste, String> playlisteNavnKolonne;

    @FXML
    private TableColumn<PlaylisteSange, String> playlisteSangeKolonne;

    @FXML
    private TableView<Playliste> playlisteTableview;

    @FXML
    //ret integer til hvad vi gør for " 00:00 "
    private TableColumn<Playliste, Integer> playlisteTidKolonne;

    @FXML
    private Text playlisterTitel;

    @FXML
    private Button redigerPlaylisteID;

    @FXML
    private Button redigerSangID;

    @FXML
    private ImageView sangBillede;

    @FXML
    private TableColumn<Sang, String> sangKolonne;

    @FXML
    //ret integer til hvad vi gør for " 00:00 "
    private TableColumn<Sang, Integer> sangTidKolonne;

    @FXML
    private TableView<Sang> sangeTableview;

    @FXML
    private Text sangeTitel;

    @FXML
    private Button sletPlaylisteID;

    @FXML
    private Button sletSangID;

    @FXML
    private Button sletSangPlaylistID;

    @FXML
    private Button startKnapID;

    @FXML
    private TextField søgSangTekstfelt;

    @FXML
    private Text søgSangTitel;

    @FXML
    private Slider tidSlider;

    @FXML
    private Text valgtePlaylistTitel;

    @FXML
    private Slider volumeSlider;

    private final ObservableList<Sang> sangObsListe = FXCollections.observableArrayList();
    private final ObservableList<Playliste> playlisteObsListe = FXCollections.observableArrayList();

    public void initialize() {
        sangKolonne.setCellValueFactory(new PropertyValueFactory<Sang, String>("sangTitel"));
        kunstnerKolonne.setCellValueFactory(new PropertyValueFactory<Sang, String>("sangKunstner"));
        sangTidKolonne.setCellValueFactory(new PropertyValueFactory<Sang, Integer>("sangTid"));

        playlisteNavnKolonne.setCellValueFactory(new PropertyValueFactory<Playliste, String>("playlisteNavn"));
        playlisteTidKolonne.setCellValueFactory(new PropertyValueFactory<Playliste, Integer>("samlagtTid"));
        playlisteAntalSangeKolonne.setCellValueFactory(new PropertyValueFactory<Playliste, Integer>("antalSange"));
        playlisteSangeKolonne.setCellValueFactory(new PropertyValueFactory<PlaylisteSange, String>("sangInfoPlayliste"));

        sangObsListe.add(new Sang("Baby", "Justin Bieber", 223, "12"));
        Playliste p1 = new Playliste("Groovy", 0, 0);
        playlisteObsListe.add(new Playliste("Groovy", 0, 0));



        playlisteTableview.setItems(playlisteObsListe);
        sangeTableview.setItems(sangObsListe);

        playlisteTableview.getSelectionModel().selectedItemProperty().addListener((obs, gammel, valgt) -> {
            if (valgt != null) {
                playlistSangeTableview.setItems(valgt.getSange());
            }
        });
    }

    @FXML
    void forrigeKnap(ActionEvent event) {

    }

    @FXML
    void nyPlayliste(ActionEvent event) {

    }

    @FXML
    void nySang(ActionEvent event) {

        Dialog<ButtonType> dialogvindue = new Dialog<>();
        dialogvindue.setTitle("Tilføj sang");
        dialogvindue.setHeaderText("Ny sang");
        dialogvindue.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

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

    @FXML
    void næsteKnap(ActionEvent event) {

    }

    @FXML
    void redigerPlayliste(ActionEvent event) {

    }

    @FXML
    void redigerSang(ActionEvent event) {

    }

    @FXML
    void sletPlayliste(ActionEvent event) {

    }

    @FXML
    void sletSang(ActionEvent event) {

    }

    @FXML
    void sletSangPlaylist(ActionEvent event) {

    }

    @FXML
    void startPauseKnap(ActionEvent event) {

    }
}