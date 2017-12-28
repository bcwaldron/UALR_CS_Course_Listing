package edu.ualr.cpsc4399.bcwaldronhw2;


import java.util.List;

public class Course {

    private String title;
    private String description;

    public String getTitle(){
        return(title);
    }
    public String getDescription(){
        return(description);
    }
    public void setTitle(String a){
        title = a;
    }
    public void setDescription(String a){
        description = a;
    }
    public void Course(){
        title = "0";
        description = "0";
    }
};
