package sda.testing;

public class Zadanie2 {

    // Sprawdź, wykorzystując metody assertEquals i assertNotEquals z klasy org.junit.Assert :
    // 1. Czy użytkownik (Adam, 22 lata) i (Adam, 22 lata) są sobie "równi"
    // 2. Czy użytkownik (Adam, 23 lata) i (Adam, 22 lata) są sobie nie "równi"

    private class User {
        String name;
        int age;

        User(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

}