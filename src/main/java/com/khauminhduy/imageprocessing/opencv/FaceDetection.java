package com.khauminhduy.imageprocessing.opencv;

import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.objdetect.Objdetect;
import org.opencv.videoio.VideoCapture;

public class FaceDetection {

	public static Mat loadImage(String imagePath) {
		return Imgcodecs.imread(imagePath);
	}
	
	public static void saveImage(Mat imageMatrix, String targetPath) {
		Imgcodecs.imwrite(targetPath, imageMatrix);
	}
	
	public static void detectFace(String sourceImagePath, String targetImagePath) throws InterruptedException {
		Thread.sleep(1000);
		VideoCapture capture = new VideoCapture(0);
		Mat loadedImage = new Mat();
		capture.read(loadedImage);
		
//		Mat loadedImage = loadImage(sourceImagePath); 
		MatOfRect facesDetect = new MatOfRect();
		CascadeClassifier cascadeClassifier = new CascadeClassifier();
		int minFaceSize = Math.round(loadedImage.rows() * 0.5f);
		System.out.println(minFaceSize);
		cascadeClassifier.load("./src/main/resources/haarcascade/haarcascade_frontalface_alt.xml");
//		cascadeClassifier.load("./src/main/resources/haarcascade/haarcascade_frontalface_alt2.xml");
//		cascadeClassifier.load("./src/main/resources/haarcascade/haarcascade_frontalcatface_extended.xml");
//		cascadeClassifier.load("./src/main/resources/haarcascade/haarcascade_frontalface_alt_tree.xml");
//		cascadeClassifier.load("./src/main/resources/haarcascade/haarcascade_frontalface_default.xml");
//		cascadeClassifier.load("./src/main/resources/haarcascade/haarcascade_fullbody.xml");
		
//		cascadeClassifier.detectMultiScale(loadedImage, facesDetect, 1.1, 3, Objdetect.CASCADE_DO_CANNY_PRUNING, new Size(minFaceSize, minFaceSize), new Size());
//		cascadeClassifier.detectMultiScale(loadedImage, facesDetect, 1.05, 1, Objdetect.CASCADE_DO_CANNY_PRUNING, new Size(minFaceSize, minFaceSize));
//		cascadeClassifier.detectMultiScale(loadedImage, facesDetect, 1.1);
		cascadeClassifier.detectMultiScale(loadedImage, facesDetect, 1.1, 2, Objdetect.CASCADE_SCALE_IMAGE);
//		cascadeClassifier.detectMultiScale(loadedImage, facesDetect);
		
		
		Rect[] facesArray = facesDetect.toArray();
		System.out.println("facesArray: " + facesArray.length);
		int i = 1;
		int scaleSize = 40;
		for(Rect face : facesArray) {
			Mat submat = loadedImage.submat(face.y - scaleSize, face.y + face.height + scaleSize, face.x - scaleSize, face.x + face.width + scaleSize);
			Imgcodecs.imwrite(i++ + "_"+ face.width + "_" + face.height + ".jpg", submat);
		}
		
		for(Rect face : facesArray) {
			Imgproc.rectangle(loadedImage, face.tl(), face.br(), new Scalar(0, 0, 255), 3 );
		}
		
//		if(facesArray.length != 0) {
//			saveImage(loadedImage, targetImagePath);
//		}
		
		saveImage(loadedImage, targetImagePath);
	}
	
}
