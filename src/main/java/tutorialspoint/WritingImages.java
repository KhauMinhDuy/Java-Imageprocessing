package tutorialspoint;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import nu.pattern.OpenCV;

public class WritingImages {

	public static void main(String[] args) {
		OpenCV.loadShared();
		
		Mat mat = Imgcodecs.imread("a.jpg");
		
		boolean imwrite = Imgcodecs.imwrite("output.jpg", mat);
		System.out.println(imwrite);
		
		System.out.println("Done");
	}
	
}
