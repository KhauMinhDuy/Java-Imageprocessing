package com.khauminhduy.imageprocessing.opencv;

import nu.pattern.OpenCV;

public class FaceDetectApp {

	public static void main(String[] args) {
		OpenCV.loadShared();
		FaceDetection.detectFace("b.jpg", "output2.jpg");
	}
	
}
