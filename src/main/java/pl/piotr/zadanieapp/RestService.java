package pl.piotr.zadanieapp;

import com.google.gson.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.ParseException;


@RestController
@RequestMapping(path ="/api/users", produces=MediaType.APPLICATION_JSON_VALUE)
public class RestService {

    @GetMapping("/{login}")
    public String getByUserName(@PathVariable String login) throws IOException {

        Gson gson = new Gson();
        UserMapper userMapper = new UserMapper();
        JsonObject json = new JsonObject();
        try{

            URL url = new URL("https://api.github.com/users/" + login);
            InputStreamReader reader = new InputStreamReader(url.openStream());
            GitHubUser gitHubUser = gson.fromJson(reader, GitHubUser.class);
            json = userMapper.convertToUserDTO(gitHubUser);
            reader.close();

        }catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return json.toString();
    }


}
