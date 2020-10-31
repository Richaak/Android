package com.example.assignment11;

public class exampleitem {
    private String mtextview;
    private String mbutton1;
    private String mbutton;
    private String mtextview1;

    public exampleitem(String text, String button,String button1,String textview1)
    {
        mtextview=text;
        mbutton=button;
        mbutton1=button1;
        mtextview1=textview1;
    }


    public String getMbutton1() {
        return mbutton1;
    }

    public String getMtextview1() {
        return mtextview1;
    }

    public String getMbutton(){
        return mbutton;
    }

    public String getMtextview(){
        return mtextview;
    }
}

