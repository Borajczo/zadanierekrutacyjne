package pl.piotr.zadanieapp;

import com.google.gson.JsonObject;
import org.json.JSONObject;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UserMapper {

    SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");

    public JsonObject convertToUserDTO(GitHubUser gitHubUser) throws ParseException {

        JsonObject json = new JsonObject();
        json.addProperty("id", gitHubUser.getId());
        json.addProperty("login", gitHubUser.getLogin());
        json.addProperty("name", gitHubUser.getName());
        json.addProperty("type", gitHubUser.getType());
        json.addProperty("avatarUrl", gitHubUser.getAvatarUrl());
        json.addProperty("createdAt", gitHubUser.getCreatedAt());

        json.addProperty("calculations", calculations(gitHubUser.getFollowers(), gitHubUser.getPublicRepos()));

        return json;
    }

    public Integer calculations(Integer fallowerNumber, Integer reposNumber) {
        Integer result = null;
        try{
            result = 6 / fallowerNumber * (2 + reposNumber);
        } catch (ArithmeticException e) {
            System.out.println ("Can't be divided by Zero"+e);
        }

        return result;
    }

}
