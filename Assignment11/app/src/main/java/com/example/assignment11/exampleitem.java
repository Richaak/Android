package com.example.assignment11;

public class exampleitem {
    private String mtextview;
    private String mbutton;

    public exampleitem(String text, String button)
    {
        mtextview=text;
        mbutton=button;
    }

    public String getMbutton(){
        return mbutton;
    }

    public String getMtextview(){
        return mtextview;
    }
}

