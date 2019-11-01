package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

import java.io.File;

import static java.lang.String.format;


public class Main extends Application {

    MediaPlayer mediaPlayer;
    private Label time;
    Duration duration;
    Button fullScreenButton;
    Scene scene;
    Media media;
    double width;
    double height;
    MediaView mediaView;
    private Label playTime;
    protected Slider vol;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Media media = new Media(new File("C:\\Users\\Boner Lord\\IdeaProjects\\MediaPlayerProject\\src\\sample\\StClouds Villainous Introduction_Large.mp4").toURI().toString());

        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        MediaView mediaView = new MediaView(mediaPlayer);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(mediaView);
        borderPane.setBottom(addToolBar());

        borderPane.setStyle("-fx-background-color: Black");

        Scene scene = new Scene(borderPane, 600, 600);
        scene.setFill(Color.BLACK);

        DropShadow dropshadow = new DropShadow();
        dropshadow.setOffsetY(5.0);
        dropshadow.setOffsetX(5.0);
        dropshadow.setColor(Color.WHITE);

        mediaView.setEffect(dropshadow);
        scene = setScene(this.width, this.height);

        primaryStage.setTitle("Media Player!");
        primaryStage.setScene(scene);

        fullScreenButton.setOnAction((ActionEvent e) -> {
            if (primaryStage.isFullScreen()) {
                primaryStage.setFullScreen(false);
            } else {
                primaryStage.setFullScreen(true);
            }
        });
        primaryStage.show();
    }

    private HBox addToolBar() {
        HBox toolBar = new HBox();
        toolBar.setPadding(new Insets(20));
        toolBar.setAlignment(Pos.CENTER);
        toolBar.alignmentProperty().isBound();
        toolBar.setSpacing(5);
        toolBar.setStyle("-fx-background-color: Black");
        Button firstButton = new Button();
        Button backButton = new Button();
        Button forwardButton = new Button();
        Button lastButton = new Button();
        Button reloadButton = new Button();
        Button filesButton = new Button();
        Button fullScreenButton = new Button();

        Image playButtonImage = new Image(getClass().getResourceAsStream("Play.png"));
        Button playButton = new Button();
        playButton.setGraphic(new ImageView(playButtonImage));
        playButton.setStyle("-fx-background-color: Black");

        playButton.setOnAction((ActionEvent e) -> {

        });
        playButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            playButton.setStyle("-fx-background-color: Black");
            playButton.setStyle("-fx-body-color: Black");
        });
        playButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            playButton.setStyle("-fx-background-color: Black");
        });

        Image pausedButtonImage = new Image(getClass().getResourceAsStream("Pause.png"));
        Button pauseButton = new Button();
        pauseButton.setGraphic(new ImageView(pausedButtonImage));
        pauseButton.setStyle("-fx-background-color: Black");

        pauseButton.setOnAction((ActionEvent e) -> {
        });

        pauseButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            pauseButton.setStyle("-fx-background-color: Black");
            pauseButton.setStyle("-fx-body-color: Black");
        });
        pauseButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            pauseButton.setStyle("-fx-background-color: Black");
        });

        playButton.setOnAction((ActionEvent e) -> {
            mediaPlayer.play();
        });

        pauseButton.setOnAction((ActionEvent e) -> {
            mediaPlayer.pause();
        });

        forwardButton.setOnAction((ActionEvent e) -> {
            mediaPlayer.seek(mediaPlayer.getCurrentTime().multiply(1.5));
        });

        backButton.setOnAction((ActionEvent e) -> {
            mediaPlayer.seek(mediaPlayer.getCurrentTime().divide(1.5));
        });

        firstButton.setOnAction((ActionEvent e) -> {
            mediaPlayer.seek(mediaPlayer.getStartTime());
            mediaPlayer.stop();
        });

        lastButton.setOnAction((ActionEvent e) -> {
            mediaPlayer.seek(mediaPlayer.getTotalDuration());
            mediaPlayer.stop();
        });

        reloadButton.setOnAction((ActionEvent e) -> {
            mediaPlayer.seek(mediaPlayer.getStartTime());
        });

        filesButton.setOnAction((ActionEvent e) -> {
            FileChooser fc = new FileChooser();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("*.flv", "*.mp4", "*.mpeg"));
            File file = fc.showOpenDialog(null);
            String path = file.getAbsolutePath();
            path = path.replace("\\", "/");
            media = new Media(new File(path).toURI().toString());
            mediaPlayer.stop();
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setAutoPlay(true);
            mediaView.setMediaPlayer(mediaPlayer);
        });

        time = new Label();
        time.setTextFill(Color.YELLOW);
        time.setPrefWidth(80);

        mediaPlayer.currentTimeProperty().addListener((Observable ov) -> {
            updateValues();
        });

        mediaPlayer.setOnReady(() -> {
            duration = mediaPlayer.getMedia().getDuration();
            updateValues();
        });


        toolBar.getChildren().addAll(filesButton, firstButton, backButton, playButton, pauseButton, forwardButton, lastButton, reloadButton, time, fullScreenButton);

        return toolBar;
    }

    protected void updateValues() {
        if (playTime != null && time != null && vol != null) {
            Platform.runLater(new Runnable() {
                public void run() {
                    Duration currentTime = mediaPlayer.getCurrentTime();
                    playTime.setText(formatTime(currentTime, duration));
                    time.setDisable(duration.isUnknown());
                    if (!time.isDisabled()
                            && duration.greaterThan(Duration.ZERO)) {

                    }
                    if (!vol.isValueChanging()) {
                        vol.setValue((int)Math.round(mediaPlayer.getVolume()
                                * 100));
                    }
                }
            });
        }
    }

    private static String formatTime(Duration elapsed, Duration duration) {
        int intElapsed = (int) Math.floor(elapsed.toSeconds());
        int elapsedHours = intElapsed / (60 * 60);
        if (elapsedHours > 0) {
            intElapsed -= elapsedHours * 60 * 60;
        }
        int elapsedMinutes = intElapsed / 60;
        int elapsedSeconds = intElapsed - elapsedHours * 60 * 60
                - elapsedMinutes * 60;

        if (duration.greaterThan(Duration.ZERO)) {
            int intDuration = (int) Math.floor(duration.toSeconds());
            int durationHours = intDuration / (60 * 60);
            if (durationHours > 0) {
                intDuration -= durationHours * 60 * 60;
            }
            int durationMinutes = intDuration / 60;
            int durationSeconds = intDuration - durationHours * 60 * 60
                    - durationMinutes * 60;
            if (durationHours > 0) {
                return format("%d:%02d:%02d/%d:%02d:%02d",
                        elapsedHours, elapsedMinutes, elapsedSeconds,
                        durationHours, durationMinutes, durationSeconds);
            } else {
                return format("%02d:%02d/%02d:%02d",
                        elapsedMinutes, elapsedSeconds, durationMinutes,
                        durationSeconds);
            }
        } else {
            if (elapsedHours > 0) {
                return format("%d:%02d:%02d", elapsedHours,
                        elapsedMinutes, elapsedSeconds);
            } else {
                return format("%02d:%02d", elapsedMinutes,
                        elapsedSeconds);
            }
        }
    }

    public Scene setScene(double width, double height) {
        this.height = height;
        this.width = width;
        //Add your own path of the vide that you want to play
        String path = "C:\\\\Users\\\\Boner Lord\\\\IdeaProjects\\\\MediaPlayerProject\\\\src\\\\sample\\\\StClouds Villainous Introduction_Large.mp4\"";

        media = new Media(new File(path).toURI().toString());

        mediaPlayer = new MediaPlayer(media);
        //AutoPlay set to false
        mediaPlayer.setAutoPlay(false);
        mediaView = new MediaView(mediaPlayer);

        // DropShadow effect
        DropShadow dropshadow = new DropShadow();
        dropshadow.setOffsetY(5.0);
        dropshadow.setOffsetX(5.0);
        dropshadow.setColor(Color.WHITE);

        mediaView.setEffect(dropshadow);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(mediaView);
        borderPane.setBottom(addToolBar());

        borderPane.setStyle("-fx-background-color: Black");
        scene = new Scene(borderPane, 600, 600);
        scene.setFill(Color.BLACK);
        return scene;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
