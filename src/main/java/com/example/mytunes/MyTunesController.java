package com.example.mytunes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;


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

    public final ObservableList<Sang> sangObsListe = FXCollections.observableArrayList();
    public final ObservableList<Playliste> playlisteObsListe = FXCollections.observableArrayList();

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

        new SangManage(this).tilføjSang();

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