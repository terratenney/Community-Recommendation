package com.souris.nick;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONObject;

public class Parser2 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {

		int[] zipCodes = { 10001, 10002, 10003, 10004, 10005, 10006, 10007,
				10009, 10010, 10011, 10012, 10013, 10014, 10016, 10017, 10018,
				10019, 10020, 10021, 10022, 10023, 10024, 10025, 10026, 10027,
				10028, 10029, 10030, 10031, 10032, 10033, 10034, 10035, 10036,
				10037, 10038, 10039, 10040, 10044, 10065, 10069, 10075, 10103,
				10110, 10111, 10112, 10115, 10119, 10128, 10152, 10153, 10154,
				10162, 10165, 10167, 10168, 10169, 10170, 10171, 10172, 10173,
				10174, 10177, 10199, 10271, 10278, 10279, 10280, 10282, 10301,
				10302, 10303, 10304, 10305, 10306, 10307, 10308, 10309, 10310,
				10311, 10312, 10314, 10451, 10452, 10453, 10454, 10455, 10456,
				10457, 10458, 10459, 10460, 10461, 10462, 10463, 10464, 10465,
				10466, 10467, 10468, 10469, 10470, 10471, 10472, 10473, 10474,
				10475, 11004, 11005, 11101, 11102, 11103, 11104, 11105, 11106,
				11109, 11201, 11203, 11204, 11205, 11206, 11207, 11208, 11209,
				11210, 11211, 11212, 11213, 11214, 11215, 11216, 11217, 11218,
				11219, 11220, 11221, 11222, 11223, 11224, 11225, 11226, 11228,
				11229, 11230, 11231, 11232, 11233, 11234, 11235, 11236, 11237,
				11238, 11239, 11351, 11354, 11355, 11356, 11357, 11358, 11359,
				11360, 11361, 11362, 11363, 11364, 11365, 11366, 11367, 11368,
				11369, 11370, 11371, 11372, 11373, 11374, 11375, 11377, 11378,
				11379, 11385, 11411, 11412, 11413, 11414, 11415, 11416, 11417,
				11418, 11419, 11420, 11421, 11422, 11423, 11424, 11425, 11426,
				11427, 11428, 11429, 11430, 11432, 11433, 11434, 11435, 11436,
				11451, 11691, 11692, 11693, 11694, 11697 };

		int counter = 0;
		String s;
		FileWriter jsonFileWriter = new FileWriter("crime2.json");
		//jsonFileWriter.write("")
		String pat = " violent crime, on a scale from 1 \\(low crime\\) to 100, is (\\d+)";
		String pat2 = " property crime, on a scale from 1 \\(low\\) to 100, is (\\d+)";
		Pattern pattern = Pattern.compile(pat);
		Pattern pattern2 = Pattern.compile(pat2);		
		JSONObject json = new JSONObject();		
		
		jsonFileWriter.write("[");
		for (int i : zipCodes) {
			URL url = new URL("http://www.bestplaces.net/crime/zip-code/new_york/new_york/"+ i);
			URLConnection conn = url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));		
			//json.put("zipcode", Integer.toString(i));
			jsonFileWriter.write("{ \"fields\": ");
			json.put("zipcode", Integer.toString(i));
			while ((s = br.readLine()) != null) {

				Matcher match = pattern.matcher(s);
				Matcher match2 = pattern2.matcher(s);
				if (match.find()) {
					json.put("crime", match.group(1));									
					System.out.println("zip code: " + i + "\t crime rate "+ match.group(1));

				}
				if (match2.find()) {
					json.put("property", match2.group(1));										
					System.out.println("zip code: " + i + "\t property rate "+ match2.group(1));

				}
				
			
			}
			jsonFileWriter.write(json.toJSONString());
			jsonFileWriter.write(", \"model\": \"crimeData\",");
			jsonFileWriter.write("\"pk\": "+(counter+1));
			jsonFileWriter.write("}");
			if(i != 11697){
				jsonFileWriter.write(",");
			}
			json.clear();
			jsonFileWriter.flush();
			counter++;
		}		
		jsonFileWriter.write("]");
        jsonFileWriter.close();
	}

}

