package com.example.mytunes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javafx.scene.text.Text;

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
    public TableView<Playliste> playlisteTableview;

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
    public TableView<Sang> sangeTableview;

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
    Playliste playliste = new Playliste("", 0, 0);

    public void initialize() {
        sangKolonne.setCellValueFactory(new PropertyValueFactory<Sang, String>("sangTitel"));
        kunstnerKolonne.setCellValueFactory(new PropertyValueFactory<Sang, String>("sangKunstner"));
        sangTidKolonne.setCellValueFactory(new PropertyValueFactory<Sang, Integer>("sangTid"));


        playlisteNavnKolonne.setCellValueFactory(new PropertyValueFactory<Playliste, String>("playlisteNavn"));
        playlisteTidKolonne.setCellValueFactory(new PropertyValueFactory<Playliste, Integer>("samlagtTid"));
        playlisteAntalSangeKolonne.setCellValueFactory(new PropertyValueFactory<Playliste, Integer>("antalSange"));
        playlisteSangeKolonne.setCellValueFactory(new PropertyValueFactory<PlaylisteSange, String>("sangInfoPlayliste"));

        sangObsListe.add(new Sang("Baby", "Justin Bieber", 223, "12"));


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

        new PlaylisteManage(this, playliste).tilføjPlayliste();

    }

    @FXML
    void nySang(ActionEvent event) {

        new SangManage(this).tilføjSang();;
    }



    @FXML
    void næsteKnap(ActionEvent event) {

    }

    @FXML
    void redigerPlayliste(ActionEvent event) {

        Playliste p = playlisteTableview.getSelectionModel().getSelectedItem();
        if (p != null)
            redigerLinjePlayliste(p);

    }

    @FXML
    void redigerSang(ActionEvent event) {

        Sang s = sangeTableview.getSelectionModel().getSelectedItem();
        if (s != null)
            redigerLinjeSang(s);

    }



    @FXML
    void sletPlayliste(ActionEvent event) {

        Playliste valgt = playlisteTableview.getSelectionModel().getSelectedItem();
        if (valgt != null) {
            playlisteObsListe.remove(valgt);
        }

    }

    @FXML
    void sletSang(ActionEvent event) {

        Sang valgt = sangeTableview.getSelectionModel().getSelectedItem();
        if (valgt != null) {
            sangObsListe.remove(valgt);
        }

    }

    @FXML
    void sletSangPlaylist(ActionEvent event) {

    }

    private static MediaPlayer mediaPlayer;
    @FXML
    void startPauseKnap(ActionEvent event) {
        try {
            Media lyd = new Media(String.valueOf(getClass().getResource("sample-3s.mp3")));
            mediaPlayer = new MediaPlayer(lyd);
            mediaPlayer.seek(mediaPlayer.getStartTime());
            mediaPlayer.play();

        } catch (Exception e) {
            System.out.println("Fejl: " + e.getMessage());
        }
    }

    public void sangHøjreKlik(MouseEvent mouseEvent) {
        //spørg erik
        TableRow<Sang> række = new TableRow<>();
        ContextMenu cm = new ContextMenu();
        MenuItem afspil = new MenuItem("Afspil sang");
        MenuItem tilføjTilPlayliste = new MenuItem("Tilføj til playliste");
        cm.getItems().addAll(afspil, tilføjTilPlayliste);
        cm.show(række,mouseEvent.getX(),mouseEvent.getY());

    }

    private void redigerLinjeSang(Sang s) {

        new SangManage(this).redigerSang(s);

    }

    private void redigerLinjePlayliste(Playliste p) {

        new PlaylisteManage(this, p).redigerSang(p);

    }
}