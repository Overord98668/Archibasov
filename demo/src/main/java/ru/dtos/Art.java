package ru.ssau.art.dtos;
public class Art{
    private  Long id;
    private String title;
    private boolean completed;

    public Long getId(){
        return id;
    }
    public void setId(){
        this.id=id;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(){
        this.title=title;
    }
    public boolean getcompleted(){
        return completed;
    }
    public void setCompleted(){
        this.completed=completed;
    }
}