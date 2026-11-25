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
import javafx.scene.input.MouseEvent;
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
    boolean højreKlikCheck = true;
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
    @FXML
    void sangHøjreKlik(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseButton.SECONDARY && højreKlikCheck) {
            if (sangeTableview.getSelectionModel().getSelectedItem() != null) {
                Sang s = sangeTableview.getSelectionModel().getSelectedItem();
                ContextMenu menu = new ContextMenu();
                MenuItem miSpilSang = new MenuItem("Afspil sang");
                MenuItem miTilføjTilPlayliste = new MenuItem("Tilføj til playliste");
                MenuItem miRedigerSang = new MenuItem("Rediger sang");
                MenuItem miSletSang = new MenuItem("Slet sang");

                højreKlikCheck = false;

                miSpilSang.setOnAction(event -> {
                    Media lyd = new Media(String.valueOf(getClass().getResource("sample-3s.mp3")));
                    mediaPlayer = new MediaPlayer(lyd);
                    mediaPlayer.seek(mediaPlayer.getStartTime());
                    mediaPlayer.play();
                    højreKlikCheck = true;

                });
                miTilføjTilPlayliste.setOnAction(event -> {
                    højreKlikCheck = true;
                });

                menu.getItems().addAll(miSpilSang,miTilføjTilPlayliste );


                // Placer dialog hvor musen er, dvs ved rækken
                menu.show(sangeTableview, mouseEvent.getScreenX(), mouseEvent.getScreenY());
            }
        }
    }
}