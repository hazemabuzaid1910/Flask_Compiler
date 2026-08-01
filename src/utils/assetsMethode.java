package Utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class assetsMethode {

    public static void removeEmpty(JsonElement element) {

        if (element == null || element.isJsonNull()) {
            return;
        }

        if (element.isJsonObject()) {

            JsonObject obj = element.getAsJsonObject();

            List<String> toRemove = new ArrayList<>();

            for (String key : obj.keySet()) {

                JsonElement child = obj.get(key);

                removeEmpty(child);

                if (child.isJsonArray()
                        && child.getAsJsonArray().isEmpty()) {

                    toRemove.add(key);
                }

                if (child.isJsonObject()
                        && child.getAsJsonObject().size() == 0) {

                    toRemove.add(key);
                }
            }

            toRemove.forEach(obj::remove);
        }

        else if (element.isJsonArray()) {

            JsonArray arr = element.getAsJsonArray();

            for (JsonElement child : arr) {
                removeEmpty(child);
            }
        }
    }
}