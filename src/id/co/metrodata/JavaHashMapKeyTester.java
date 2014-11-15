package id.co.metrodata;

import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;

public class JavaHashMapKeyTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		HashMap<String, String> map  = new HashMap<String, String>();
//		map.put("1","one");
//	    map.put("2","two");
//	    map.put("3","three");
//	    map.put("4","four");
//	    System.out.println(map.toString());
//	    
//	    Iterator<String> keySetIterator = map.keySet().iterator();
//	    System.out.println(keySetIterator.toString());
//	    
//	    while(keySetIterator.hasNext()){
//	    	String key = keySetIterator.next();
//	    	System.out.println("key: " + key + " value: " + map.get(key));
//	    	
//	    }
	    
	    String url = "https://meh.meh.com/?meh=meh&weh=weh&heh=heh&password=password&username=username";
	    HashMap<String, String> hm = getURLParameter(url);
	    System.out.println(hm.toString());
	    
	    String stringEntity = getStringEntity(hm);
	    System.out.println(stringEntity.toString());
	    
	}
	
	public static HashMap<String, String> getURLParameter(String url){
		String[] url_parameter = url.split("\\?");
		String[] parameter = url_parameter[1].split("&");
		HashMap<String, String> map_parameter = new HashMap<String, String>();
		
		for(int i=0; i<parameter.length; i++){
			String[] par = parameter[i].split("=");
			map_parameter.put(par[0], par[1]);
		}
		
		return map_parameter;
		
	}
	
	public static String getStringEntity(HashMap<String, String> hm){
		JSONObject jOb = new JSONObject();
		Iterator<String> keySetIterator = hm.keySet().iterator();
		System.out.println(hm.toString());
		try {
			
			while(keySetIterator.hasNext()){
				String key = keySetIterator.next();
				jOb.put(key, String.valueOf(hm.get(key)));
			}
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		System.out.println(jOb.toString());
		return jOb.toString();
	}

}
