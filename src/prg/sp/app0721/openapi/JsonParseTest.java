package prg.sp.app0721.openapi;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

// JSON? 자바스크립트 객체 표기법
// xml과 함께 이 기종간 데이터 교환 시 사용되는 데이터 포맷, 즉 그냥 문자열임 
// 단 자바는 json을 이해하지 못하므로,
// 따라서 문자열에 불과한 제이슨 포맷을 자바언억 이해하도록 처리 즉 해석하는 프로그래밍을 배워보자 (:파싱법)
public class JsonParseTest {
	
	public static void main(String[] args) {
		//외부의 라이브러리 -> maven
		String str="";
		str+="{";
		str+="\"name\" : \"철수\", ";
		str+="\"age\" : 28, ";
		str+="\"children\" : [{";
		str+="\"type\" : \"cat\",";
		str+="\"age\" : 2, ";
		str+="\"name\" : \"나비\", ";
		str+="\"color\" : \"black\"}, ";
		str+="{";
		str+="\"type\" : \"dog\", ";
		str+="\"age\" : 5, ";
		str+="\"name\" : \"뽀미\", ";
		str+="\"color\" : \"white\"}]";
		str+="}";
		
		System.out.println(str);
		
		JSONParser jsonParser=new JSONParser();
		try {
			//JSON
			JSONObject obj=(JSONObject)jsonParser.parse(str);
			System.out.println(obj.get("name"));
			JSONArray array=(JSONArray)obj.get("children");
			System.out.println(array.size());
			for(int i=0; i<array.size(); i++) {
				JSONObject pet=(JSONObject)array.get(i);
				System.out.println("종류 "+pet.get("type"));
				System.out.println("나이 "+pet.get("age"));
				System.out.println("이름 "+pet.get("name"));
				System.out.println("색상 "+pet.get("color"));
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
}
