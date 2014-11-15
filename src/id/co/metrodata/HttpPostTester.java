package id.co.metrodata;


import javax.swing.text.html.parser.Entity;

import org.apache.http.entity.StringEntity;
import org.json.JSONArray;
import org.json.JSONObject;

public class HttpPostTester {
	public static void main(String[] args){
		String loginurl = "https://login.salesforce.com/services/oauth2/token?"+
				  "grant_type=password&"+
				  "client_id=3MVG9xOCXq4ID1uEcTLh_Hpmux7N.Tc.0DR1OSUgpjhmWU3OHGB5mTd.5tJL93j92_4k3v1SxmYDLK615qKYD&"+
				  "client_secret=596107376026049304&"+
				  "username=radit.sdo@mii.demo&"+
				  "password=metrodata.2";
		JSONObject jsonOb  = new JSONObject();
		JSONArray  jsonAr  = new JSONArray();
		String     result  = "";
		
		String instanceurl = "";
		String accesstoken = "";
		String url         = "";
		String url_param   = "";
		
		JSONParser jParser = new JSONParser();
		try{
		  // Getting accesstoken
			jsonOb = jParser.postJSONObjectFromURL(loginurl);
			instanceurl = jsonOb.getString("instance_url");
			accesstoken = jsonOb.getString("access_token");
			url         = instanceurl+"/services/apexrest/ActivitiesBarcodeScannerREST/";
			url_param = instanceurl+"/services/apexrest/ActivitiesBarcodeScannerREST/?id=00Uo0000001T8HsEAK&barcode=test123";
			System.out.println(instanceurl);
			System.out.println(accesstoken);
			System.out.println(url);
			System.out.println(url_param);
			
			StringEntity entity = new StringEntity(JSONParser.getStringEntity(JSONParser.getURLParameter(url_param)));
			System.out.println(JSONParser.getStringEntity(JSONParser.getURLParameter(url_param)));
			
			result = jParser.postStringFromURL(url_param, accesstoken, entity);
			System.out.println(result);
//			if(jsonAr.length() > 0){
//			  	for(int i=0; i<jsonAr.length(); i++){
//			  		JSONObject c = jsonAr.getJSONObject(i);
//			  		System.out.println(c.toString());
//			  	}
//			}
			
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
