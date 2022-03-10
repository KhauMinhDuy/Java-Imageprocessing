package tutorialspoint;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;

import nu.pattern.OpenCV;

public class DisplayingImagesUsingSwings {

	public static void main(String[] args) throws IOException {
		OpenCV.loadShared();
		
		Mat imageMatrix = Imgcodecs.imread("a.jpg");
		
		MatOfByte matOfByte = new MatOfByte();
		
		Imgcodecs.imencode(".jpg", imageMatrix, matOfByte);
		
		byte[] bytes = matOfByte.toArray();
		
		InputStream inputStream = new ByteArrayInputStream(bytes);
		
		BufferedImage image = ImageIO.read(inputStream);
		
		JFrame frame = new JFrame();
		
		frame.getContentPane().add(new JLabel(new ImageIcon(image)));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	
}
