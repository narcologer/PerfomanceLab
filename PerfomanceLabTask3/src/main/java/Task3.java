import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;

public class Task3 {

        public static JsonNode traverseAndMerge(HashMap<Integer,String> problems, JsonNode root){
        String id = "";
        if(root.isObject()){
            Iterator<String> fieldNames = root.fieldNames();

            while(fieldNames.hasNext()) {
                String fieldName = fieldNames.next();
                JsonNode fieldValue = root.get(fieldName);
                traverseAndMerge(problems, fieldValue);
            }
        } else if(root.isArray()){
            ArrayNode arrayNode = (ArrayNode) root;
            for(int i = 0; i < arrayNode.size(); i++) {
                JsonNode arrayElement = arrayNode.get(i);
                int idTest = Integer.parseInt(arrayElement.path("id").toString());
                ((ObjectNode) arrayElement).put("value",problems.get(idTest));
                traverseAndMerge(problems, arrayElement);
            }
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        HashMap<Integer,String> problems = new HashMap<>();
        JsonNode tests = mapper.readTree(Paths.get(args[0]).toFile());
        JsonNode values = mapper.readTree(Paths.get(args[1]).toFile());
        for (JsonNode value : values.path("values")) {
            problems.put(Integer.parseInt(value.path("id").toString()),value.path("value").toString().replace("\"", ""));
        }
        tests=traverseAndMerge(problems, tests);
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(Paths.get("report.json").toFile(), tests);
    }
}
