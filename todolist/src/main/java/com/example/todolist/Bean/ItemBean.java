package com.example.todolist.Bean;

public class ItemBean {

    private int ID;
    private String status;
    private String content;
    private String created;
    private String updated;


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String isStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreated() {
        return created;
    }

    public String getStatus(){
        return String.valueOf(this.status);
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public ItemBean(int ID,  String content, String created, String  updated,String status) {
        this.ID = ID;

        this.content = content;
        this.created = created;
        this.updated = updated;
        this.status=status;
    }


    public ItemBean(int ID) {
        this.ID = ID;
    }
}
