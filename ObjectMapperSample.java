
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

import org.json.simple.parser.ParseException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * {
	"name": "MyApp",
	"id": "01AbCC",
	"displayName": "My App",
	"audience": "http://mysite.com",
	"scopes": [{
		"value": "docs",
		"description": "open document"
	}],
	"appRoles": [
		"useradmin",
		"resourceadmin"
	]
}
 * @author svenigan
 *
 */

public class ObjectMapperSample {

	public static void main (String args[]) throws ParseException, IOException, JsonProcessingException {
		String jsonStr = "{\r\n" + 
				"	\"name\": \"MyApp\",\r\n" + 
				"	\"id\": \"01AbCC\",\r\n" + 
				"	\"displayName\": \"My App\",\r\n" + 
				"	\"audience\": \"http://mysite.com\",\r\n" + 
				"	\"scopes\": [{\r\n" + 
				"		\"value\": \"docs\",\r\n" + 
				"		\"description\": \"open document\"\r\n" + 
				"	}],\r\n" + 
				"	\"appRoles\": [\r\n" + 
				"		\"useradmin\",\r\n" + 
				"		\"resourceadmin\"\r\n" + 
				"	]\r\n" + 
				"}";
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.readTree(jsonStr);
		/*
		Getting nodes from path.
		ObjectNode objNode = (ObjectNode)rootNode.path("scopes");
		*/
		Iterator<String> nameList = (Iterator)rootNode.getFieldNames();
		// Using method references.
		nameList.forEachRemaining(System.out::println);
		System.out.println("==============");
		Iterator<Entry<String, JsonNode>> nameValLst = (Iterator)rootNode.getFields();
		nameValLst.forEachRemaining(System.out::println);
	}
}
	
/*
Output: -
name
id
displayName
audience
scopes
appRoles
==============
name="MyApp"
id="01AbCC"
displayName="My App"
audience="http://mysite.com"
scopes=[{"value":"docs","description":"open document"}]
appRoles=["useradmin","resourceadmin"]
*/
