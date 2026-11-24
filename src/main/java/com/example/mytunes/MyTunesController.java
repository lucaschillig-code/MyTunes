package com.example.mytunes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    private TableView<PlaylisteSange> playlistSangeTableview = new TableView<>();

    @FXML
    //ret integer til hvad vi gør for " 00:00 "
    //spørg erik om problemet med <>
    private TableColumn<Playliste, Integer> playlisteAntalSangeKolonne = new TableColumn<Playliste, Integer>();

    @FXML
    private TableColumn<Playliste, String> playlisteNavnKolonne = new TableColumn<>();

    @FXML
    private TableColumn<PlaylisteSange, String> playlisteSangeKolonne = new TableColumn<>();

    @FXML
    private TableView<Playliste> playlisteTableview = new TableView<>();

    @FXML
    //ret integer til hvad vi gør for " 00:00 "
    private TableColumn<Playliste, Integer> playlisteTidKolonne = new TableColumn<>();

    @FXML
    private Text playlisterTitel;

    @FXML
    private Button redigerPlaylisteID;

    @FXML
    private Button redigerSangID;

    @FXML
    private ImageView sangBillede;

    @FXML
    private TableColumn<Sang, String> sangKolonne = new TableColumn<>();

    @FXML
    //ret integer til hvad vi gør for " 00:00 "

    private TableColumn<Sang, Integer> sangTidKolonne = new TableColumn<>();

    @FXML
    private TableView<Sang> sangeTableview = new TableView<>();

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
    private final ObservableList<PlaylisteSange> playlisteSangeObsListe = FXCollections.observableArrayList();

    public void initialize() {
        sangKolonne.setCellValueFactory(new PropertyValueFactory<Sang, String>("sangTitel"));
        kunstnerKolonne.setCellValueFactory(new PropertyValueFactory<Sang, String>("sangKunstner"));
        sangTidKolonne.setCellValueFactory(new PropertyValueFactory<Sang, Integer>("sangTid"));

        sangObsListe.add(new Sang("Baby","Justin Bieber", 223));

        playlisteNavnKolonne.setCellValueFactory(new PropertyValueFactory<Playliste, String>("playlisteNavn"));
        playlisteTidKolonne.setCellValueFactory(new PropertyValueFactory<Playliste, Integer>("samlagtTid"));
        playlisteAntalSangeKolonne.setCellValueFactory(new PropertyValueFactory<Playliste, Integer>("antalSange"));

        playlisteObsListe.add(new Playliste("Groovy", 12, 67));

        playlisteTableview.setItems(playlisteObsListe);
        sangeTableview.setItems(sangObsListe);

    }

    @FXML
    void forrigeKnap(ActionEvent event) {

    }

    @FXML
    void nyPlayliste(ActionEvent event) {

    }

    @FXML
    void nySang(ActionEvent event) {

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
