package json;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    HashMap<String, Json> jsonPairs;

    public JsonObject(JsonPair... jsonPairs) {
        // ToDo
        this.jsonPairs = new HashMap<>();
        for (JsonPair el : jsonPairs) {
            add(el);
        }

    }

    @Override
    public String toJson() {
        String skopka = "{";
        if (jsonPairs.size() == 0) {
            return "{}";
        }
        Set my = jsonPairs.entrySet();
        for (Object counter : my) {
            Map.Entry cup = (Map.Entry) counter;
            skopka +=  cup.getKey().toString() + ": ";
            if (cup.getValue() instanceof Json) {
                skopka += ((Json) cup.getValue()).toJson() + ',';
            }
        }
        return skopka.substring(0, skopka.length() - 1) + '}';
    }

    public void add(JsonPair jsonPair) {
        jsonPairs.put(jsonPair.key, jsonPair.value);
    }

    public Json find(String name) {
        if (jsonPairs.get(name) != null) {
            return jsonPairs.get(name);
        }
        return null;
    }

    public JsonObject projection(String... names) {
    JsonObject newJsonObject = new JsonObject();
        for(String ele : names) {
            if(jsonPairs.get(ele) != null) {
                newJsonObject.add(new JsonPair(ele, jsonPairs.get(ele)));
            }
        }
        return newJsonObject;
    }
}
