package tw.org.iii.tutor;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

//URL   
//跟農委會 取的ＪＳＯＮ字串
public class Brad61 {

	public static void main(String[] args) {
		
		try {
			URL url =new URL("https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvAgriculturalProduce.aspx?&UnitId=197");
			URLConnection urlConnection =url.openConnection();
			
			//為了使用它的功能 強制轉型
			HttpsURLConnection conn =(HttpsURLConnection)urlConnection;
			
			//取得頁面原始碼
			BufferedReader br =new BufferedReader (new InputStreamReader(conn.getInputStream()));
			
			String line ;
			//農委會
			StringBuffer sb =new StringBuffer();
			
			while ((line=br.readLine())!=null) {
				//System.out.println(line);
				//將line的字串與sb字串相加
				sb.append(line);
			}
			
			br.close();
			//呼叫解JSON方法
			parseJson(sb.toString());
		}catch (Exception e) {
			System.out.println(e);
		}
		

	}
	//解json字串方法
	private static void parseJson(String json){
		//這邊使用外接API 因為原廠沒有這個AIP  上網去抓別人的Jar
		JSONArray root =new JSONArray(json);
		for(int i=0; i<root.length();i++) {
			//將取的的物件放到row裡面
			JSONObject row =root.getJSONObject(i);
			System.out.printf("%s:%f\n" ,row.getString("Name"),row.getDouble("Latitude"));
		}
	}
}
