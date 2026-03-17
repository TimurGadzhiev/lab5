package file;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.JsonParseException;

import model.Vehicle;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;


public class FileManager {
    private final Gson gson;
    private final String fileName;
    public FileManager(String fileName) {
        this.fileName = fileName;
        this.gson = new GsonBuilder().setPrettyPrinting().serializeNulls().registerTypeAdapter(Date.class, new DateAdapter()).create();
    }

    /**
     * Загружает коллекцию из JSON файла.
     *
     *
     * @return список транспортных средств
     * @throws IOException если ошибка чтения
     */
    public List<Vehicle> loadFromFile() throws IOException {
        File file = new File(fileName);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        StringBuilder jsonContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                jsonContent.append(line); // Читаем файл построчно
            }
        }

        String json = jsonContent.toString();

        // Если файл пустой - возвращаем пустую коллекцию
        if (json.isEmpty() || json.equals("[]")) {
            return new ArrayList<>();
        }

        try {
            // Создаем тип для List<Vehicle> (нужно для Gson)
            // TypeToken - специальный класс Gson для работы с generic типами
            Type listType = new TypeToken<ArrayList<Vehicle>>() {}.getType();
            List<Vehicle> vehicles = gson.fromJson(json, listType);

            // Проверяем, что все объекты имеют ID
            for (Vehicle v : vehicles) {
                if (v.getId() == null) {
                    throw new IOException("У объекта нет ID в файле");
                }
            }

            return vehicles != null ? vehicles : new ArrayList<>();

        } catch (JsonParseException e) {
            throw new IOException("Ошибка парсинга JSON: " + e.getMessage());
        }
    }

    /**
     * Сохраняет коллекцию в JSON файл.
     *
     * @param vehicles список транспортных средств
     * @throws IOException если ошибка записи
     */
    public void saveToFile(List<Vehicle> vehicles) throws IOException {
        String json = gson.toJson(vehicles);
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            byte[] bytes = json.getBytes();
            fos.write(bytes);
            fos.flush();
        }
    }
}