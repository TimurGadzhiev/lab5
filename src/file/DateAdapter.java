package file;

import com.google.gson.*;
import java.lang.reflect.Type;
import java.util.Date;


/**
 * Адаптер для сериализации/десериализации Date в JSON.
 * Преобразует Date в Long (timestamp) и обратно.
 */
public class DateAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {

    /**
     * Преобразует объект Date в JSON элемент (число).
     *
     * @param src исходный объект Date
     * @param typeOfSrc тип исходного объекта
     * @param context контекст сериализации
     * @return JsonElement, содержащий timestamp
     */
    @Override
    public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
        // src.getTime() - получаем количество миллисекунд с 1 января 1970 года
        // new JsonPrimitive() - создаем JSON число из этого значения
        return new JsonPrimitive(src.getTime());
    }

    /**
     * Преобразует JSON элемент (число) обратно в объект Date.
     *
     * @param json JSON элемент с timestamp
     * @param typeOfT тип целевого объекта
     * @param context контекст десериализации
     * @return восстановленный объект Date
     * @throws JsonParseException если не удалось распарсить JSON
     */
    @Override
    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        // json.getAsLong() - читаем число из JSON
        // new Date() - создаем новую дату из этого числа
        return new Date(json.getAsLong());
    }
}