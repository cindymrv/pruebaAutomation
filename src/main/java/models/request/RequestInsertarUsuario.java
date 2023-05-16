package models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@JsonPropertyOrder({
        "name",
        "job"
})

@Data
@AllArgsConstructor
@Builder
public class RequestInsertarUsuario implements Serializable {

    @JsonProperty("name")
    private String name;
    @JsonProperty("job")
    private String job;
    private static final long serialVersionUID = 6551030489768543544L;


}
