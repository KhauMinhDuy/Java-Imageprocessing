package com.khauminhduy.imageprocessing.opencv;

import java.io.ByteArrayInputStream;

import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.objdetect.Objdetect;
import org.opencv.videoio.VideoCapture;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import nu.pattern.OpenCV;

public class CameraStream extends Application {

	private VideoCapture capture;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		OpenCV.loadShared();
		capture = new VideoCapture(0);
		ImageView imageView = new ImageView();
		HBox box = new HBox(imageView);
		Scene scene = new Scene(box);
		primaryStage.setScene(scene);
		primaryStage.show();

		AnimationTimer animationTimer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				imageView.setImage(getCapture());
			}
		};
		animationTimer.start();
	}

	private Image getCapture() {
		Mat mat = new Mat();
		capture.read(mat);
		Mat detectFace = detectFace(mat);
		return mat2Img(detectFace);
	}

	private Image mat2Img(Mat mat) {
		MatOfByte bytes = new MatOfByte();
		Imgcodecs.imencode(".jpg", mat, bytes);
		ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes.toArray());
		return new Image(inputStream);
	}

	private static Mat detectFace(Mat inputImage) {
		MatOfRect facesDetected = new MatOfRect();
		CascadeClassifier cascadeClassifier = new CascadeClassifier();
//		int minFaceSize = Math.round(inputImage.rows() * 0.1f);
		cascadeClassifier.load("./src/main/resources/haarcascade/haarcascade_frontalface_alt.xml");
		cascadeClassifier.detectMultiScale(inputImage, facesDetected, 1.05, 3, Objdetect.CASCADE_SCALE_IMAGE);
		Rect[] facesArray = facesDetected.toArray();
		for (Rect face : facesArray) {
			Imgproc.rectangle(inputImage, face.tl(), face.br(), new Scalar(0, 255, 0), 1);
		}
		return inputImage;
	}

}
