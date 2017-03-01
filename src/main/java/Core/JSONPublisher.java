package Core;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.entity.ContentType;
import org.json.JSONWriter;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;


public class JSONPublisher {
	

	
	
	public static void main(String[] args) {
		StringWriter JSONString = new StringWriter();
		JSONWriter jsonWriter = new JSONWriter(JSONString);
		
		List<String> keys = new ArrayList<String>();
		keys.add("ReadingType");
		keys.add("CollectorId");
		keys.add("PatientID");
		keys.add("SystolicBloodPressure");
		keys.add("DiastolicBloodPressure");
		keys.add("MeanBloodPressure");
		keys.add("BodyTemperature");
		keys.add("PulseRate");
		keys.add("TimeStamp");
		
		jsonWriter.object();
		for(int i = 0; i < 9; i++) {
			jsonWriter.key(keys.get(i))
				.value(args[i]);
		}
		
		jsonWriter.endObject();
		
		
			System.out.println(Request.Post(args[9])
				.bodyString(JSONString.toString(), ContentType.APPLICATION_JSON)
				.toString());
	
		
	}
			
}
