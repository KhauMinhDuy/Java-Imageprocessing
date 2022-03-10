package tutorialspoint;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;

public class CameraSnapshotJavaFXDemo extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		CameraSnapshotJavaFX obj = new CameraSnapshotJavaFX();
		WritableImage writableImage = obj.cameraCapture();
		obj.saveImage();
		// Setting the image view
		ImageView imageView = new ImageView(writableImage);

		// setting the fit height and width of the image view
		imageView.setFitHeight(400);
		imageView.setFitWidth(600);

		// Setting the preserve ratio of the image view
		imageView.setPreserveRatio(true);

		// Creating a Group object
		Group root = new Group(imageView);

		// Creating a scene object
		Scene scene = new Scene(root, 600, 400);

		// Setting title to the Stage
		stage.setTitle("Capturing an image");

		// Adding scene to the stage
		stage.setScene(scene);

		// Displaying the contents of the stage
		stage.show();
	}

}
