package recognition01;

import java.io.File;
import java.io.FileNotFoundException;

import com.ibm.watson.developer_cloud.service.security.IamOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.DetectFacesOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.DetectedFaces;

public class Recognition01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		VisualRecognition service = new VisualRecognition("2018-03-19");
		// Set the endpoint
		service.setEndPoint("https://gateway.watsonplatform.net/visual-recognition/api");
		IamOptions options = new IamOptions.Builder()
		    //.url("https://gateway.watsonplatform.net/visual-recognition/api") // Optional
		    .apiKey("p3q2HVvSEu46y_fbUPOtgmuzmxlfTpoNapSBwePHZ6rp")
		    .build();
		service.setIamCredentials(options);

				//VisualRecognition service = new VisualRecognition("2018-03-19", options);

				DetectFacesOptions detectFacesOptions = null;
				try {
					detectFacesOptions = new DetectFacesOptions.Builder()
					  .imagesFile(new File("img/GGIA-HumanFace.jpg"))
					  .build();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				DetectedFaces result = service.detectFaces(detectFacesOptions).execute();
				System.out.println(result);

	}

}
