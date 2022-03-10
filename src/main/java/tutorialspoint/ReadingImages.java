package tutorialspoint;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import nu.pattern.OpenCV;

public class ReadingImages {

	public static void main(String[] args) {
		OpenCV.loadShared();
		
		Mat mat = Imgcodecs.imread("b.jpg");
		System.out.println(mat);
		
		System.out.println("Done");
		
	}
	
}
