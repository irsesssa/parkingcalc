package com.parking;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class TestParameterDataProvider {
    @Test(dataProvider = "db.properties")
    public void testConnection(Map<String, String> map) {

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("[Key] : " + entry.getKey()
                    + " [Value] : " + entry.getValue());
        }

    }

    @DataProvider(name = "db.properties")
    public Object[][] provideDbProperties() {
        Map<String, String> map = readDbProperties();
        return new Object[][] { { map } };
    }



    public Map<String, String> readDbProperties() {

        Properties prop = new Properties();
        InputStream input = null;
        Map<String, String> map = new HashMap<String, String>();

        try {
            File initialFile = new File("db.properties");
            input = new FileInputStream(initialFile);
          // getClass().getClassLoader().getResourceAsStream("db.properties");

            prop.load(input);

            map.put("jdbc.ChooseALot", prop.getProperty("jdbc.ChooseALot"));
            map.put("jdbc.ChooseEntryDateAndTime", prop.getProperty("jdbc.ChooseEntryDateAndTime"));
            map.put("jdbc.ChooseLeavingDateAndTime", prop.getProperty("jdbc.ChooseLeavingDateAndTime"));
            map.put("jdbc.COST", prop.getProperty("jdbc.COST"));

            map.put("jdbc1.ChooseALot1", prop.getProperty("jdbc1.ChooseALot1"));
            map.put("jdbc1.ChooseEntryDateAndTime1", prop.getProperty("jdbc1.ChooseEntryDateAndTime1"));
            map.put("jdbc1.ChooseLeavingDateAndTime1", prop.getProperty("jdbc1.ChooseLeavingDateAndTime1"));
            map.put("jdbc1.COST1", prop.getProperty("jdbc1.COST1"));

            map.put("jdbc2.ChooseALot2", prop.getProperty("jdbc2.ChooseALot2"));
            map.put("jdbc2.ChooseEntryDateAndTime2", prop.getProperty("jdbc2.ChooseEntryDateAndTime2"));
            map.put("jdbc2.ChooseLeavingDateAndTime2", prop.getProperty("jdbc2.ChooseLeavingDateAndTime2"));
            map.put("jdbc2.COST2", prop.getProperty("jdbc2.COST2"));

            map.put("jdbc3.ChooseALot3", prop.getProperty("jdbc3.ChooseALot3"));
            map.put("jdbc3.ChooseEntryDateAndTime3", prop.getProperty("jdbc3.ChooseEntryDateAndTime3"));
            map.put("jdbc3.ChooseLeavingDateAndTime3", prop.getProperty("jdbc3.ChooseLeavingDateAndTime3"));
            map.put("jdbc3.COST3", prop.getProperty("jdbc3.COST3"));


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return map;

    }

}