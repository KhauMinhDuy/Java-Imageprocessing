package tutorialspoint;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.WritableImage;
import nu.pattern.OpenCV;

public class CameraSnapshotJavaFX {

	private Mat matrix;

	public WritableImage cameraCapture() {
		OpenCV.loadShared();

		VideoCapture capture = new VideoCapture(0);
		Mat matrix = new Mat();

		capture.read(matrix);

		WritableImage writableImage = null;
		if (capture.isOpened()) {
			if (capture.read(matrix)) {
				BufferedImage image = new BufferedImage(matrix.width(), matrix.height(), BufferedImage.TYPE_3BYTE_BGR);
				WritableRaster raster = image.getRaster();
				DataBufferByte bufferByte = (DataBufferByte) raster.getDataBuffer();
				byte[] data = bufferByte.getData();
				matrix.get(0, 0, data);
				this.matrix = matrix;
				writableImage = SwingFXUtils.toFXImage(image, null);

			}
		}
		return writableImage;
	}
	
	public void saveImage() {
		Imgcodecs.imwrite("output.jpg", matrix);
	}

}
