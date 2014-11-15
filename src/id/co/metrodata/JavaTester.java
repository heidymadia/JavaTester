package id.co.metrodata;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class JavaTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//String url = "http://earthquake.usgs.gov/earthquakes/feed/geojsonp/2.5/week";
		String url = "https://login.salesforce.com/services/oauth2/token?grant_type=password&client_id=3MVG9xOCXq4ID1uEcTLh_Hpmux7N.Tc.0DR1OSUgpjhmWU3OHGB5mTd.5tJL93j92_4k3v1SxmYDLK615qKYD&client_secret=596107376026049304&username=radit.sdo@mii.demo&password=metrodata.2";
		//String url = "https://na17.salesforce.com/services/apexrest/ActivitiesBarcodeScannerREST/";
		//String accesstoken = "00Do0000000Ht2i!AQcAQMZhnbMwajKsS5lbDD5ws8GOXhm3QOoTFyY.du_yriyKGHSUzRXT.e42OFfmDiyWHy0D01LI9P02sSkbMOiBGqD0mHVL";
		
		System.out.println(url);
		
		JSONParser jParser = new JSONParser();
		JSONObject json = jParser.postJSONObjectFromURL(url);
		//JSONArray json = jParser.getJSONFromUrl(url, accesstoken);
		System.out.println(json);
		System.out.println(json.get("access_token"));
		
		List<String> list_values = new ArrayList<String>();
		list_values.add(json.getString("access_token"));
		
        /*
		try{
			for(int i=0; i<json.length(); i++){
				JSONObject c = json.getJSONObject(i);
				
				list_values.add(c.getString("access_token"));
				//list_values.add(c.getString("Subject"));
			}
		} catch (JSONException e){
			e.printStackTrace();
		}
		*/
		
        
		System.out.println(list_values);
		
	}

}
