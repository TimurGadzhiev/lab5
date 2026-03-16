package collection;

import model.Vehicle;
import model.VehicleType;

import java.util.*;


public class CollectionManager {
    private ArrayList<Vehicle> vehicles;
    private Set<Long> usedIds;
    private Date initializationDate;

    public CollectionManager() {
        this.vehicles = new ArrayList<>();
        this.usedIds = new HashSet<>();
        this.initializationDate = new Date();
    }

    public Long generateId() {
        long id = 1;
        while (usedIds.contains(id)) {
            id++;
        }
        usedIds.add(id);
        return id;
    }

    public int size() {
        return vehicles.size();
    }

    private void sort() {
        Collections.sort(vehicles);
    }


    public String getInfo() {
        return "Тип коллекции: " + vehicles.getClass().getName() +"\n" + "Дата инициализации: " + initializationDate + "\n" + "Количество элементов: " + vehicles.size();
    }

    public void add(Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle не может быть null");
        }
        vehicle.setId(generateId());
        vehicles.add(vehicle);
        sort();
    }

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

    public void clear() {
        vehicles.clear();
        usedIds.clear();
    }

    public void shuffle() {
        Collections.shuffle(vehicles);
    }

    public void reorder() {
        Collections.reverse(vehicles);
    }

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

    public List<Vehicle> filterLessThanType(VehicleType type) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle v : vehicles) {
            if (v.getType() != null && v.getType().compareTo(type) < 0) {
                result.add(v);
            }
        }
        return result;
    }

    public Vehicle getMax() {
        if (vehicles.isEmpty()) {
            return null;
        }
        return Collections.max(vehicles);
    }


    public boolean containsId(Long id) {
        return usedIds.contains(id);
    }
    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }
}
