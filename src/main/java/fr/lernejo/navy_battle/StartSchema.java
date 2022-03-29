package fr.lernejo.navy_battle;

import java.util.Objects;

public class StartSchema {
    private String id;
    private String url;
    private String message;

    public StartSchema(){
        this.id = null;
        this.url = null;
        this.message = null;
    }

    public String getId() {
        return id;
    }
    public String getMessage() {
        return this.message;
    }
    public String getUrl() {
        return this.url;
    }
    public boolean isValid(){
        return (!Objects.isNull(this.message) &&
                !Objects.isNull(this.id) && !Objects.isNull(this.url) &&
                !this.message.isEmpty() && !this.id.isEmpty() && !this.url.isEmpty());
    }
    public String toString() {
        return ("{\"id\": \"" + this.id + "\", \"url\": \"" + this.url + "\", \"message\": \"" + this.message + "\"}");
    }
    public void setUrl(String url) {
        this.url = url;
    }
}
