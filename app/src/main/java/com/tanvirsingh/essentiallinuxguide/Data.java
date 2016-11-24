package com.tanvirsingh.essentiallinuxguide;

import java.util.ArrayList;

/**
 * Created by kalol on 14/11/16.
 */
public class Data {

    public static ArrayList<information> getData(){

        ArrayList<information> data = new ArrayList<>();

        String[] titleString = {"What is Linux anyways?", "Why should I Linux?","OK! How do I get started?","Show me the cool stuff"};

        for(int i =0; i < titleString.length; i++){
            information current = new information();

            current.title = titleString[i];

            data.add(current);
        }
        return data;
    }


}





