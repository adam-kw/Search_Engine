package com.adamkwiecinski;

public class Main {
    public static void main(String[] args) {
        String filePath = args[1];
        UI ui = new UI(filePath);
        ui.run();
    }
}

