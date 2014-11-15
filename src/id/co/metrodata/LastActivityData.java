package id.co.metrodata;

import id.co.metrodata.JSONParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class LastActivityData {
	public String url = "";
	public String accesstoken = "";
	public String instanceurl = "";
	public static List<DataItem> ITEMS = new ArrayList<DataItem>();
	public static Map<String, DataItem> ITEM_MAP = new HashMap<String, DataItem>();
	
	public static void GetLastActivityDataITEMS() {
		ITEMS.clear();
		ITEM_MAP.clear();
		
		String loginurl = "https://login.salesforce.com/services/oauth2/token?"+
				  "grant_type=password&"+
				  "client_id=3MVG9xOCXq4ID1uEcTLh_Hpmux7N.Tc.0DR1OSUgpjhmWU3OHGB5mTd.5tJL93j92_4k3v1SxmYDLK615qKYD&"+
				  "client_secret=596107376026049304&"+
				  "username=lidya.dewi@mii.demo&"+
				  "password=metrodata.1";
		JSONObject jsonOb  = new JSONObject();
		JSONArray  jsonAr  = new JSONArray();
		String instanceurl = "";
		String accesstoken = "";
		String url         = "";
		
		JSONParser jParser = new JSONParser();
		try{
		  // Getting accesstoken
			jsonOb = jParser.postJSONObjectFromURL(loginurl);
			instanceurl = jsonOb.getString("instance_url");
			accesstoken = jsonOb.getString("access_token");
			url         = instanceurl+"/services/apexrest/ActivitiesBarcodeScannerREST/";
			
			jsonAr = jParser.getJSONArrayFromUrl(url, accesstoken);
			if(jsonAr.length() > 0){
		  	for(int i=0; i<jsonAr.length(); i++){
		  		JSONObject c = jsonAr.getJSONObject(i);
		  		addItem( 
		  				new DataItem(
		  						c.getString("Id"), 
		  						c.getString("Subject"),
		  						c.getString("Location"),
		  						c.getString("StartDateTime"),
		  						c.getString("EndDateTime"),
		  						c.getString("Barcode_Time__c")
  						)
  				);
		  	}
			}
			
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	private static void addItem(DataItem item) {
		ITEMS.add(item);
		ITEM_MAP.put(item.id, item);
	}
	
	public static class DataItem{
		public String id;
		public String subject;
		public String location;
		public String startdatetime;
		public String enddatetime;
		public String barcodetime;
		
		
		public DataItem(String id, String subject, String location, String startdatetime, String enddatetime, String barcodetime){
			this.id = id;
			this.subject = subject;
			this.location = location;
			this.startdatetime = startdatetime;
			this.enddatetime = enddatetime;
			this.barcodetime = barcodetime;
		}
		
		@Override
		public String toString(){
			return subject;
		}
	}
}
