package id.co.metrodata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class JSONParser {
	static InputStream is = null;
	static JSONObject jObj = null;
	static JSONArray jArray = null;
	static String json = "";
	
	public JSONParser() {
		
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
		jOb.put("id", String.valueOf(hm.get("id")));
		jOb.put("barcode", String.valueOf(hm.get("barcode")));
		
		return jOb.toString();
	}
	
	public JSONObject postJSONObjectFromURL (String url){
		// Making HTTP Request
				try{
					// default HTTPClient
					DefaultHttpClient httpClient = new DefaultHttpClient();
					HttpPost httpPost = new HttpPost(url);
					httpPost.setHeader("Content-type", "application/json");
					
					HttpResponse httpResponse = httpClient.execute(httpPost);
					HttpEntity httpEntity = httpResponse.getEntity();
					is = httpEntity.getContent();
					
				} catch (UnsupportedEncodingException e){
					e.printStackTrace();
				} catch (ClientProtocolException e){
					e.printStackTrace();
				} catch (IOException e){
					e.printStackTrace();
				}
				try{
					BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
					StringBuilder sb = new StringBuilder();
					String line = null;
					while((line = reader.readLine()) != null){
						sb.append(line + "\n");
					}
					is.close();
					json = sb.toString();
				} catch (Exception e){
					e.printStackTrace();
				}
				
				try {
		            jObj = new JSONObject(json);
		        } catch (JSONException e) {
		            e.printStackTrace();
		        }
				
				// return JSON String
				return jObj;
	}
	
	public JSONArray postJSONArrayFromURL (String url){
		// Making HTTP Request
				try{
					// default HTTPClient
					DefaultHttpClient httpClient = new DefaultHttpClient();
					HttpPost httpPost = new HttpPost(url);
					httpPost.setHeader("Content-type", "application/json");
					
					HttpResponse httpResponse = httpClient.execute(httpPost);
					HttpEntity httpEntity = httpResponse.getEntity();
					is = httpEntity.getContent();
					
				} catch (UnsupportedEncodingException e){
					e.printStackTrace();
				} catch (ClientProtocolException e){
					e.printStackTrace();
				} catch (IOException e){
					e.printStackTrace();
				}
				try{
					BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
					StringBuilder sb = new StringBuilder();
					String line = null;
					while((line = reader.readLine()) != null){
						sb.append(line + "\n");
					}
					is.close();
					json = sb.toString();
				} catch (Exception e){
					e.printStackTrace();
				}
				
				try {
		            jArray = new JSONArray(json);
		        } catch (JSONException e) {
		            e.printStackTrace();
		        }
				
				// return JSON String
				return jArray;
	}
	
	public JSONObject postJSONObjectFromURL (String url, String accesstoken){
		// Making HTTP Request
				try{
					// default HTTPClient
					DefaultHttpClient httpClient = new DefaultHttpClient();
					HttpPost httpPost = new HttpPost(url);
					httpPost.setHeader("Content-type", "application/json");
					httpPost.setHeader("Authorization", "Bearer " + accesstoken	);
					
					HttpResponse httpResponse = httpClient.execute(httpPost);
					HttpEntity httpEntity = httpResponse.getEntity();
					is = httpEntity.getContent();
					
				} catch (UnsupportedEncodingException e){
					e.printStackTrace();
				} catch (ClientProtocolException e){
					e.printStackTrace();
				} catch (IOException e){
					e.printStackTrace();
				}
				try{
					BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
					StringBuilder sb = new StringBuilder();
					String line = null;
					while((line = reader.readLine()) != null){
						sb.append(line + "\n");
					}
					is.close();
					json = sb.toString();
				} catch (Exception e){
					e.printStackTrace();
				}
				
				try {
		            jObj = new JSONObject(json);
		        } catch (JSONException e) {
		            e.printStackTrace();
		        }
				
				// return JSON String
				return jObj;
	}

	public JSONArray postJSONArrayFromURL (String url, String accesstoken){
		// Making HTTP Request
				try{
					// default HTTPClient
					DefaultHttpClient httpClient = new DefaultHttpClient();
					HttpPost httpPost = new HttpPost(url);
					httpPost.setHeader("Content-type", "application/json");
					httpPost.setHeader("Authorization", "Bearer " + accesstoken	);
					
					HttpResponse httpResponse = httpClient.execute(httpPost);
					HttpEntity httpEntity = httpResponse.getEntity();
					is = httpEntity.getContent();
					
				} catch (UnsupportedEncodingException e){
					e.printStackTrace();
				} catch (ClientProtocolException e){
					e.printStackTrace();
				} catch (IOException e){
					e.printStackTrace();
				}
				try{
					BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
					StringBuilder sb = new StringBuilder();
					String line = null;
					while((line = reader.readLine()) != null){
						sb.append(line + "\n");
					}
					is.close();
					json = sb.toString();
				} catch (Exception e){
					e.printStackTrace();
				}
				
				try {
		            jArray = new JSONArray(json);
		        } catch (JSONException e) {
		            e.printStackTrace();
		        }
				
				// return JSON String
				return jArray;
	}
	
	public String postStringFromURL(String url, String accesstoken, StringEntity entity) {
		// Making HTTP Request
		try{
			// default HTTPClient
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost httpPost = new HttpPost(url);
			httpPost.setHeader("Content-type", "application/json");
			httpPost.setHeader("Authorization", "Bearer " + accesstoken	);
			httpPost.setEntity(entity);
			
			HttpResponse httpResponse = httpClient.execute(httpPost);
			HttpEntity httpEntity = httpResponse.getEntity();
			is = httpEntity.getContent();
			
		} catch (UnsupportedEncodingException e){
			e.printStackTrace();
		} catch (ClientProtocolException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while((line = reader.readLine()) != null){
				sb.append(line + "\n");
			}
			is.close();
			json = sb.toString();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		// return JSON String
		return json;
	}
	
	public JSONObject postJSONObjectFromURL(String url, String accesstoken, StringEntity entity) {
		// Making HTTP Request
		try{
			// default HTTPClient
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost httpPost = new HttpPost(url);
			httpPost.setHeader("Content-type", "application/json");
			httpPost.setHeader("Authorization", "Bearer " + accesstoken	);
			httpPost.setEntity(entity);
			
			HttpResponse httpResponse = httpClient.execute(httpPost);
			HttpEntity httpEntity = httpResponse.getEntity();
			is = httpEntity.getContent();
			
		} catch (UnsupportedEncodingException e){
			e.printStackTrace();
		} catch (ClientProtocolException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while((line = reader.readLine()) != null){
				sb.append(line + "\n");
			}
			is.close();
			json = sb.toString();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		try {
            jObj = new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
		
		// return JSON String
		return jObj;
	}
	
	public JSONArray postJSONArrayFromURL(String url, String accesstoken, StringEntity entity) {
		// Making HTTP Request
		try{
			// default HTTPClient
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost httpPost = new HttpPost(url);
			httpPost.setHeader("Content-type", "application/json");
			httpPost.setHeader("Authorization", "Bearer " + accesstoken	);
			httpPost.setEntity(entity);
			
			HttpResponse httpResponse = httpClient.execute(httpPost);
			HttpEntity httpEntity = httpResponse.getEntity();
			is = httpEntity.getContent();
			
		} catch (UnsupportedEncodingException e){
			e.printStackTrace();
		} catch (ClientProtocolException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while((line = reader.readLine()) != null){
				sb.append(line + "\n");
			}
			is.close();
			json = sb.toString();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		try {
            jArray = new JSONArray(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
		
		// return JSON String
		return jArray;
	}
	
	public JSONObject getJSONObjectFromUrl(String url){
		// Making HTTP Request
		try{
			// default HTTPClient
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(url);
			httpGet.setHeader("Content-type", "application/json");
			
			HttpResponse httpResponse = httpClient.execute(httpGet);
			HttpEntity httpEntity = httpResponse.getEntity();
			is = httpEntity.getContent();
			
		} catch (UnsupportedEncodingException e){
			e.printStackTrace();
		} catch (ClientProtocolException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while((line = reader.readLine()) != null){
				sb.append(line + "\n");
			}
			is.close();
			json = sb.toString();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		try {
            jObj = new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
		
		// return JSON String
		return jObj;
	}
	
	public JSONArray getJSONArrayFromUrl(String url){
		// Making HTTP Request
		try{
			// default HTTPClient
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(url);
			httpGet.setHeader("Content-type", "application/json");
			
			HttpResponse httpResponse = httpClient.execute(httpGet);
			HttpEntity httpEntity = httpResponse.getEntity();
			is = httpEntity.getContent();
			
		} catch (UnsupportedEncodingException e){
			e.printStackTrace();
		} catch (ClientProtocolException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while((line = reader.readLine()) != null){
				sb.append(line + "\n");
			}
			is.close();
			json = sb.toString();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		try {
            jArray = new JSONArray(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
		
		// return JSON String
		return jArray;
	}
	
	public JSONObject getJSONObjectFromUrl(String url, String accesstoken){
		// Making HTTP Request
		try{
			// default HTTPClient
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(url);
			httpGet.setHeader("Authorization", "Bearer " + accesstoken	);
			httpGet.setHeader("Content-type", "application/json");
			
			HttpResponse httpResponse = httpClient.execute(httpGet);
			HttpEntity httpEntity = httpResponse.getEntity();
			is = httpEntity.getContent();
			
		} catch (UnsupportedEncodingException e){
			e.printStackTrace();
		} catch (ClientProtocolException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while((line = reader.readLine()) != null){
				sb.append(line + "\n");
			}
			is.close();
			json = sb.toString();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		try {
            jObj = new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
		
		// return JSON String
		return jObj;
	}
	
	public JSONArray getJSONArrayFromUrl (String url, String accesstoken){
		// Making HTTP Request
		try{
			// default HTTPClient
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(url);
			httpGet.setHeader("Authorization", "Bearer " + accesstoken	);
			httpGet.setHeader("Content-type", "application/json");
			
			HttpResponse httpResponse = httpClient.execute(httpGet);
			HttpEntity httpEntity = httpResponse.getEntity();
			is = httpEntity.getContent();
			
		} catch (UnsupportedEncodingException e){
			e.printStackTrace();
		} catch (ClientProtocolException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while((line = reader.readLine()) != null){
				sb.append(line + "\n");
			}
			is.close();
			json = sb.toString();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		try {
            jArray = new JSONArray(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
		
		// return JSON String
		return jArray;
	}
}


