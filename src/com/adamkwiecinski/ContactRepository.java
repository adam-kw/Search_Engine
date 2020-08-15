package com.adamkwiecinski;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContactRepository {

    private final List<String> contactRepository = new ArrayList<>();

    public ContactRepository(String fileName) {
        try{
            initializeContactRepository(fileName);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public List<String> getContactRepository() {
        return new ArrayList<>(contactRepository);
    }

    private boolean addContact(String line){
        if(line != null && !line.equals("")){
            contactRepository.add(line);
        }
        return false;
    }

    private void initializeContactRepository(String path) throws IOException {
        File file = new File(path);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        /*while(bufferedReader.readLine() != null){
            addContact(bufferedReader.readLine());
        }*/

        for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
            addContact(line);
        }
        bufferedReader.close();
    }
}
