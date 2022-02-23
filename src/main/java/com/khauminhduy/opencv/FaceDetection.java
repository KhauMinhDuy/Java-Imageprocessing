package com.khauminhduy.opencv;

import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.objdetect.Objdetect;

public class FaceDetection {

	public static Mat loadImage(String imagePath) {
		return Imgcodecs.imread(imagePath);
	}
	
	public static void saveImage(Mat imageMatrix, String targetPath) {
		Imgcodecs.imwrite(targetPath, imageMatrix);
	}
	
	public static void detectFace(String sourceImagePath, String targetImagePath) {
		Mat loadedImage = loadImage(sourceImagePath);
		MatOfRect facesDetect = new MatOfRect();
		CascadeClassifier cascadeClassifier = new CascadeClassifier();
		int minFaceSize = Math.round(loadedImage.rows() * 0.1f);
		cascadeClassifier.load("./src/main/resources/haarcascade/haarcascade_frontalface_alt.xml");
		cascadeClassifier.detectMultiScale(loadedImage, facesDetect, 1.1, 3, Objdetect.CASCADE_SCALE_IMAGE, new Size(minFaceSize, minFaceSize), new Size());
		Rect[] facesArray = facesDetect.toArray();
		for(Rect face : facesArray) {
			System.out.println(face);
			Imgproc.rectangle(loadedImage, face.tl(), face.br(), new Scalar(0, 0, 255), 3 );
		}
		saveImage(loadedImage, targetImagePath);
	}
	
}
