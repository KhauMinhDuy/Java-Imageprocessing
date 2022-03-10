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

public class ReadingAsGrayscale extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		WritableImage writingImages = loadImage();

		ImageView imageView = new ImageView(writingImages);

		imageView.setX(10);
		imageView.setY(10);

		imageView.setFitHeight(400);
		imageView.setFitWidth(600);

		imageView.setPreserveRatio(true);

		Group root = new Group(imageView);

		Scene scene = new Scene(root, 600, 400);

		primaryStage.setScene(scene);
		primaryStage.show();

	}

	private WritableImage loadImage() {
		OpenCV.loadShared();

		Mat imageMatrix = Imgcodecs.imread("input.jpg", Imgcodecs.IMREAD_GRAYSCALE);

		byte[] data = new byte[imageMatrix.rows() * imageMatrix.cols() * (int) (imageMatrix.elemSize())];
		imageMatrix.get(0, 0, data);

		BufferedImage image = new BufferedImage(imageMatrix.cols(), imageMatrix.rows(), BufferedImage.TYPE_BYTE_GRAY);
		image.getRaster().setDataElements(0, 0, imageMatrix.cols(), imageMatrix.rows(), data);

		return SwingFXUtils.toFXImage(image, null);
	}

}
