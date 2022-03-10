package opencv;

import org.opencv.core.CvType;
import org.opencv.core.Mat;

import nu.pattern.OpenCV;

public class HelloCV {

	public static void main(String[] args) {
		OpenCV.loadShared();
		Mat mat = Mat.eye(3, 3, CvType.CV_8UC1);
		System.out.println("Mat = " + mat.dump());
		System.out.println("Done");
	}
	
}
