package com.khauminhduy.imageprocessing.opencv;

import nu.pattern.OpenCV;

public class FaceDetectApp {

	public static void main(String[] args) throws InterruptedException {
		OpenCV.loadShared();
		FaceDetection.detectFace("b.jpg", "output3.jpg");
		System.out.println("Done");
	}
	
}
