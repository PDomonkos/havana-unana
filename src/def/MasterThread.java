package def;

import java.io.File;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class MasterThread extends Application implements Runnable {

	@Override
	public void run() {
		Application.launch();	
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		String uriString = new File("resources/xy.mp3").toURI().toString();
		
		MediaPlayer player = new MediaPlayer(new Media(uriString));
		player.play(); // or stop() or pause() etc etc
	}

}
