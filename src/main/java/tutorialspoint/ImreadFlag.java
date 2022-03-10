package tutorialspoint;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import nu.pattern.OpenCV;

public class ImreadFlag {

	public static void main(String[] args) {
		OpenCV.loadShared();
		
		Mat imreadColor = Imgcodecs.imread("input.jpg", Imgcodecs.IMREAD_COLOR);
		Imgcodecs.imwrite("imread_color.jpg", imreadColor);
		
		Mat imreadGrayScale = Imgcodecs.imread("input.jpg", Imgcodecs.IMREAD_GRAYSCALE);
		Imgcodecs.imwrite("imread_grayscale.jpg", imreadGrayScale);
		
		Mat imreadLoadGDAL = Imgcodecs.imread("input.jpg", Imgcodecs.IMREAD_LOAD_GDAL);
		Imgcodecs.imwrite("imread_loadgdal.jpg", imreadLoadGDAL);
		
		Mat imreadAnyColor = Imgcodecs.imread("input.jpg", Imgcodecs.IMREAD_ANYCOLOR);
		Imgcodecs.imwrite("imread_anycolor.jpg", imreadAnyColor);
		
		Mat imreadReduceColor2 = Imgcodecs.imread("input.jpg", Imgcodecs.IMREAD_REDUCED_COLOR_2);
		Imgcodecs.imwrite("imread_reducecolor2.jpg", imreadReduceColor2);
		
		Mat imreadReduceColor4 = Imgcodecs.imread("input.jpg", Imgcodecs.IMREAD_REDUCED_COLOR_4);
		Imgcodecs.imwrite("imread_reducecolor4.jpg", imreadReduceColor4);
		
		Mat imreadReduceColor8 = Imgcodecs.imread("input.jpg", Imgcodecs.IMREAD_REDUCED_COLOR_8);
		Imgcodecs.imwrite("imread_reducecolor8.jpg", imreadReduceColor8);
		
		Mat imreadReduceGrayScale2 = Imgcodecs.imread("input.jpg", Imgcodecs.IMREAD_REDUCED_GRAYSCALE_2);
		Imgcodecs.imwrite("imread_reducegrayscale2.jpg", imreadReduceGrayScale2);
		
		Mat imreadUnchange = Imgcodecs.imread("input.jpg", Imgcodecs.IMREAD_UNCHANGED);
		Imgcodecs.imwrite("imread_unchange.jpg", imreadUnchange);
		
		System.out.println("Done");
	}
	
}
