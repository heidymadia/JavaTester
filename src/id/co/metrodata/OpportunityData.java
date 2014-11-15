package id.co.metrodata;

import id.co.metrodata.JSONParser;
import id.co.metrodata.ActivityData.DataItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OpportunityData {
	public String url = "";
	public String accesstoken = "";
	public String instanceurl = "";
	public static List<DataItem> ITEMS = new ArrayList<DataItem>();
	public static Map<String, DataItem> ITEM_MAP = new HashMap<String, DataItem>();
	
	static {
		String loginurl = "https://login.salesforce.com/services/oauth2/token?"+
				  "grant_type=password&"+
				  "client_id=3MVG9xOCXq4ID1uEcTLh_Hpmux7N.Tc.0DR1OSUgpjhmWU3OHGB5mTd.5tJL93j92_4k3v1SxmYDLK615qKYD&"+
				  "client_secret=596107376026049304&"+
				  "username=radit.sdo@mii.demo&"+
				  "password=metrodata.2";
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
			url         = instanceurl+"/services/apexrest/OpportunitiesBarcodeScannerREST/";
			
			jsonAr = jParser.getJSONArrayFromUrl(url, accesstoken);
			if(jsonAr.length() > 0){
		  	for(int i=0; i<jsonAr.length(); i++){
		  		JSONObject c = jsonAr.getJSONObject(i);
		  		addItem( new DataItem(c.getString("Id"), c.getString("Name")));
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
		public String content;
		
		public DataItem(String id, String content){
			this.id = id;
			this.content = content;
		}
		
		@Override
		public String toString(){
			return content;
		}
	}
}
