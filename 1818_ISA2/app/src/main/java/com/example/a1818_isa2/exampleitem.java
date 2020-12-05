package com.example.a1818_isa2;

public class exampleitem {
    private String name;
    private String nickname;
    private String appearance;
    private String portrayed;
    private String img;
  //  private String edit;

    public exampleitem(String text,String text2,String text3, String text4,String text5)
    {
        name=text;
        nickname=text2;
        appearance=text3;
        portrayed=text4;
        img=text5;
      //  edit=editt;



    }

//    public String getEdit() {
//        return edit;
//    }

    public String getImg() {
        return img;
    }

    public String getAppearance() {
        return appearance;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPortrayed() {
        return portrayed;
    }
}
