package com.example.chatapplication;
import java.util.ArrayList;


//to get and set the message
public class Message {
    static ArrayList<String> msgs = new ArrayList<String>();
    static ArrayList<String> namess = new ArrayList<String>();
    static String currentname;
    public Message() {
    }

    public static void setName(String name) {
        namess.add(name);
    }

    public static void setMsgs(String msg) {
        msgs.add(msg);
    }

    public static ArrayList<String> getMsgs() {
        return msgs;
    }

    public static String getCurrentname() {
        return currentname;
    }

    public static void setCurrname(String currname) {
        Message.currentname = currname;
    }

    public static ArrayList<String> getName() {
        return namess;
    }






}
