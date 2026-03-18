package collection;

import model.Vehicle;
import model.VehicleType;

import java.util.*;

/**
 * Класс для управления коллекцией транспортных средств.
 * Обеспечивает все операции с коллекцией: добавление, удаление, обновление,
 * поиск, сортировку и специальные операции.
 */
public class CollectionManager {

    /** Основное хранилище элементов коллекции */
    private ArrayList<Vehicle> vehicles;

    /** Множество занятых ID для обеспечения уникальности */
    private Set<Long> usedIds;

    /** Дата создания экземпляра менеджера (инициализации коллекции) */
    private Date initializationDate;

    /**
     * Конструктор, создающий пустой менеджер коллекции.
     * Инициализирует пустой список, пустое множество ID и запоминает текущую дату.
     */
    public CollectionManager() {
        this.vehicles = new ArrayList<>();
        this.usedIds = new HashSet<>();
        this.initializationDate = new Date();
    }

    /**
     * Генерирует новый уникальный идентификатор.
     * Находит первый положительный ID, не содержащийся в usedIds.
     *
     * @return уникальный ID, больший 0
     */
    public Long generateId() {
        long id = 1;
        while (usedIds.contains(id)) {
            id++;
        }
        usedIds.add(id);
        return id;
    }

    /**
     * Возвращает текущее количество элементов в коллекции.
     *
     * @return размер коллекции
     */
    public int size() {
        return vehicles.size();
    }

    /**
     * Приватный метод для сортировки коллекции.
     * Использует естественный порядок, определенный в compareTo класса Vehicle.
     */
    private void sort() {
        Collections.sort(vehicles);
    }

    /**
     * Возвращает информацию о коллекции.
     * Включает тип коллекции, дату инициализации и количество элементов.
     *
     * @return строка с информацией о коллекции
     */
    public String getInfo() {
        return "Тип коллекции: " + vehicles.getClass().getName() +"\n" + "Дата инициализации: " + initializationDate + "\n" + "Количество элементов: " + vehicles.size();
    }

    /**
     * Добавляет новый элемент в коллекцию.
     * Автоматически генерирует ID, добавляет элемент и сортирует коллекцию.
     *
     * @param vehicle добавляемый объект (не может быть null)
     * @throws IllegalArgumentException если vehicle равен null
     */
    public void add(Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle не может быть null");
        }
        vehicle.setId(generateId());
        vehicles.add(vehicle);
        sort();
    }

    /**
     * Обновляет существующий элемент по ID.
     * Сохраняет оригинальный ID и дату создания, остальные поля заменяются.
     *
     * @param id идентификатор обновляемого элемента
     * @param newVehicle новый объект с данными
     * @return true, если элемент найден и обновлен, иначе false
     */
    public boolean update(Long id, Vehicle newVehicle) {
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getId().equals(id)) {
                newVehicle.setId(id);
                newVehicle.setCreationDate(vehicles.get(i).getCreationDate());
                vehicles.set(i, newVehicle);
                sort();
                return true;
            }
        }
        return false;
    }

    /**
     * Очищает коллекцию, удаляя все элементы.
     * Также очищает множество использованных ID.
     */
    public void clear() {
        vehicles.clear();
        usedIds.clear();
    }

    /**
     * Перемешивает элементы коллекции в случайном порядке.
     */
    public void shuffle() {
        Collections.shuffle(vehicles);
    }

    /**
     * Изменяет порядок элементов на обратный.
     */
    public void reorder() {
        Collections.reverse(vehicles);
    }

    /**
     * Удаляет элемент по его ID.
     *
     * @param id идентификатор удаляемого элемента
     * @return true, если элемент найден и удален, иначе false
     */
    public boolean removeById(Long id) {
        Iterator<Vehicle> iterator = vehicles.iterator();
        while(iterator.hasNext()) {
            Vehicle v = iterator.next();
            if (v.getId().equals(id)) {
                usedIds.remove(id);
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    /**
     * Заменяет текущую коллекцию загруженной из файла.
     * Обновляет множество использованных ID и сортирует коллекцию.
     *
     * @param loadedVehicles список загруженных транспортных средств
     */
    public void setVehicles(List<Vehicle> loadedVehicles) {
        vehicles.clear();
        usedIds.clear();
        for (Vehicle v : loadedVehicles) {
            if (v != null) {
                vehicles.add(v);
                if (v.getId() != null) {
                    usedIds.add(v.getId());
                }
            }
        }
        sort();
    }

    /**
     * Удаляет все элементы с указанным типом.
     *
     * @param type тип удаляемых элементов
     * @return количество удаленных элементов
     */
    public int removeAllByType(VehicleType type) {
        int removed = 0;
        Iterator<Vehicle> iterator = vehicles.iterator();
        while (iterator.hasNext()) {
            Vehicle v = iterator.next();
            if (v.getType() == type) {
                usedIds.remove(v.getId());
                iterator.remove();
                removed++;
            }
        }
        return removed;
    }

    /**
     * Удаляет один (любой) элемент с указанным типом.
     *
     * @param type тип удаляемого элемента
     * @return true, если элемент найден и удален, иначе false
     */
    public boolean removeAnyByType(VehicleType type) {
        Iterator<Vehicle> iterator = vehicles.iterator();
        while(iterator.hasNext()) {
            Vehicle v = iterator.next();
            if (v.getType() == type) {
                usedIds.remove(v.getId());
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    /**
     * Возвращает список элементов, тип которых меньше указанного.
     * Сравнение происходит по порядку объявления в enum VehicleType.
     *
     * @param type тип для сравнения
     * @return список элементов с типом меньше заданного
     */
    public List<Vehicle> filterLessThanType(VehicleType type) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle v : vehicles) {
            if (v.getType() != null && v.getType().compareTo(type) < 0) {
                result.add(v);
            }
        }
        return result;
    }

    /**
     * Возвращает элемент с максимальной мощностью двигателя.
     *
     * @return максимальный элемент или null, если коллекция пуста
     */
    public Vehicle getMax() {
        if (vehicles.isEmpty()) {
            return null;
        }
        return Collections.max(vehicles);
    }

    /**
     * Проверяет, существует ли элемент с указанным ID.
     *
     * @param id проверяемый идентификатор
     * @return true, если ID существует, иначе false
     */
    public boolean containsId(Long id) {
        return usedIds.contains(id);
    }

    /**
     * Возвращает всю коллекцию транспортных средств.
     *
     * @return ArrayList всех элементов коллекции
     */
    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }
}
