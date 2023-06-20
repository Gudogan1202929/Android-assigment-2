package com.example.assigment_2;

public class Lesson {

    private String title ;
    private String description;
    private int image_id;

    private boolean flag = false;

    public Lesson(String title, String description, int image_id) {
        this.title = title;
        this.description = description;
        this.image_id = image_id;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    @Override
    public String toString() {
        return "title=" + title +"\n" + "description='" + description +"\n" ;
    }
}

