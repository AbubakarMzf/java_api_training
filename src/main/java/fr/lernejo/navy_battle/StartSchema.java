package fr.lernejo.navy_battle;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class StartSchema {
    @NotNull
    private final String id;
    @NotNull
    private  String url;
    @NotNull
    private final String message;

    public StartSchema(@JsonProperty("id") String id, @JsonProperty("url") String url, @JsonProperty("message") String message){
        this.id = id;
        this.url = url;
        this.message = message;
    }
    public boolean isValid(){
        System.out.println(this.message);
        System.out.println(this.id);
        System.out.println(this.url);
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
