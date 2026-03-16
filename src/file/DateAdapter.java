package file;

import com.google.gson.*;
import java.lang.reflect.Type;
import java.util.Date;

/**
 * Адаптер для сериализации/десериализации Date в JSON.
 * Преобразует Date в Long (timestamp) и обратно.
 */
public class DateAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {

    @Override
    public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
        // src.getTime() - получаем количество миллисекунд с 1 января 1970 года
        // new JsonPrimitive() - создаем JSON число из этого значения
        return new JsonPrimitive(src.getTime());
    }


    @Override
    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        // json.getAsLong() - читаем число из JSON
        // new Date() - создаем новую дату из этого числа
        return new Date(json.getAsLong());
    }
}
