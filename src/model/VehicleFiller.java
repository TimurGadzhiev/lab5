package model;

import java.util.Scanner;

/**
 * Класс для заполнения объекта Vehicle данными из консоли.
 * Обеспечивает интерактивный ввод с валидацией всех полей.
 */
public class VehicleFiller {
    /** Сканер для чтения ввода пользователя */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Заполняет переданный объект Vehicle данными, введенными пользователем.
     * Для каждого поля выполняется циклический ввод до получения корректного значения.
     *
     * @param vehicle объект Vehicle, который нужно заполнить
     */
    public void fill(Vehicle vehicle) {
        String name;
        while (true) {
            System.out.println("Введите название транспортного средства: ");
            name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Имя не может быть пустым");
            } else {
                break;
            }
        }
        vehicle.setName(name);


        int x;
        while (true) {
            try {
                System.out.println("Введите координату x(значение меньше 98): ");
                x = Integer.parseInt(scanner.nextLine().trim());
                if (x > 98) {
                    System.out.println("Значение x не должно превосходить 98");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ошибка! Введите число");
            }
        }


        Integer y;
        while (true) {
            try {
                System.out.println("Введите координату y(значение больше -112): ");
                y = Integer.parseInt(scanner.nextLine().trim());
                if (y <= -112) {
                    System.out.println("Значение y должно быть больше -112");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ошибка! Введите число");
            }
        }
        Coordinates coordinates = new Coordinates(x, y);
        vehicle.setCoordinates(coordinates);


        Float enginePower;
        while (true) {
            try {
                System.out.println("Введите мощность двигателя(значение больше 0): ");
                enginePower = Float.parseFloat(scanner.nextLine().trim());
                if (enginePower <= 0) {
                    System.out.println("Значение enginePower должно быть больше 0");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ошибка! Введите число");
            }
        }
        vehicle.setEnginePower(enginePower);


        Float capacity;
        while (true) {
            System.out.println("Введите объём двигателя(значение больше 0): ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                capacity = null;
                break;
            }
            try {
                capacity = Float.parseFloat(input);
                if (capacity <= 0) {
                    System.out.println("Значение capacity должно быть больше 0");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ошибка! Введите число");
            }
        }
        vehicle.setCapacity(capacity);


        Integer fuelConsumption;
        while (true) {
            try {
                System.out.println("Введите потребление топлива(значение больше 0): ");
                fuelConsumption = Integer.parseInt(scanner.nextLine().trim());
                if (fuelConsumption <= 0 ) {
                    System.out.println("Значение fuelConsumption должно быть больше 0");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ошибка! Введите число");
            }
        }
        vehicle.setFuelConsumption(fuelConsumption);


        VehicleType vehicleType = null;
        while (true) {
            System.out.println("Введите тип вашего транспортного средства");
            System.out.println("1 - CAR,\n2 - PLANE,\n3 - SHIP,\n4 - BICYCLE\n5 - CHOPPER\n6 - Ничего(null)");
            try {
                int typeChoice = Integer.parseInt(scanner.nextLine().trim());
                if (typeChoice < 1 || typeChoice > 6){
                    System.out.println("Вы указали неправильный номер! Проверьте и введите еще раз");
                }else{
                    switch (typeChoice){
                        case 1:
                            vehicleType = VehicleType.CAR;
                            break;
                        case 2:
                            vehicleType = VehicleType.PLANE;
                            break;
                        case 3:
                            vehicleType = VehicleType.SHIP;
                            break;
                        case 4:
                            vehicleType = VehicleType.BICYCLE;
                            break;
                        case 5:
                            vehicleType = VehicleType.CHOPPER;
                            break;
                        case 6:
                            vehicleType = null;
                            break;
                    }
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ошибка! Введите число");
            }
        }
        vehicle.setType(vehicleType);

        vehicle.setCreationDate(new java.util.Date());
        System.out.println("Транспортное средство успешно создано!");
    }

    /**
     * Закрывает сканер, освобождая связанные с ним ресурсы.
     * Должен вызываться при завершении программы.
     */
    public void close() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
