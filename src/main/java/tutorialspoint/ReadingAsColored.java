package tutorialspoint;

import java.awt.image.BufferedImage;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;
import nu.pattern.OpenCV;

public class ReadingAsColored extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		WritableImage writableImage = loadImage();
		// Setting the image view
		ImageView imageView = new ImageView(writableImage);

		// Setting the position of the image
		imageView.setX(10);
		imageView.setY(10);

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
		stage.setTitle("Reading as colored image");

		// Adding scene to the stage
		stage.setScene(scene);

		// Displaying the contents of the stage
		stage.show();

	}

	private WritableImage loadImage() {
		OpenCV.loadShared();

		Mat src = Imgcodecs.imread("input.jpg", Imgcodecs.IMREAD_COLOR);
		Mat des = new Mat();

		byte[] data = new byte[src.cols() * src.rows() * (int) (src.elemSize())];
		src.get(0, 0, data);

		BufferedImage image = new BufferedImage(src.cols(), src.rows(), BufferedImage.TYPE_3BYTE_BGR);
		image.getRaster().setDataElements(0, 0, src.cols(), src.rows(), data);

		return SwingFXUtils.toFXImage(image, null);
	}

}
