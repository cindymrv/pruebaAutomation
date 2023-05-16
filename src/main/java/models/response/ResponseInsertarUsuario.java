package models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.io.Serializable;

@JsonPropertyOrder({
        "name",
        "job",
        "id",
        "createdAt"
})

@Data
public class ResponseInsertarUsuario implements Serializable{
    @JsonProperty("name")
    private String name;
    @JsonProperty("job")
    private String job;
    @JsonProperty("id")
    private String id;
    @JsonProperty("createdAt")
    private String createdAt;
    private static final long serialVersionUID = 3535212383231657931L;
}
