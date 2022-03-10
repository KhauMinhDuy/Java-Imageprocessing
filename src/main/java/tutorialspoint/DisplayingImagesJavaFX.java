package tutorialspoint;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;
import nu.pattern.OpenCV;

public class DisplayingImagesJavaFX extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		WritableImage writableImage = loadImage();
		
		ImageView imageView = new ImageView(writableImage);
		
	      //Setting the position of the image 
	      imageView.setX(50); 
	      imageView.setY(25); 
	        
	      //setting the fit height and width of the image view 
	      imageView.setFitHeight(400); 
	      imageView.setFitWidth(600);
	      
	      //Creating a Group object  
	      Group root = new Group(imageView);
	      
	      //Creating a scene object
	      Scene scene = new Scene(root, 700, 500);
	      
	      primaryStage.setScene(scene);
	      primaryStage.show();
	}

	private WritableImage loadImage() throws IOException {
		OpenCV.loadShared();
		
		Mat imageMatrix = Imgcodecs.imread("a.jpg");
		
		MatOfByte matOfByte = new MatOfByte();
		
		boolean imencode = Imgcodecs.imencode(".jpg", imageMatrix, matOfByte);
		if(!imencode) {
			throw new IllegalArgumentException("MatOfByte Error");
		}
		
		byte[] bytes = matOfByte.toArray();
		
		InputStream inputStream = new ByteArrayInputStream(bytes);
		
		BufferedImage image = ImageIO.read(inputStream);
		
		return SwingFXUtils.toFXImage(image, null);
		
		
		
	}
	
}
