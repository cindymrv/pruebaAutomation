package models.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "job",
    "updatedAt"
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseActualizarUsuario implements Serializable
{

  @JsonProperty("name")
  private String name;
  @JsonProperty("job")
  private String job;
  @JsonProperty("updatedAt")
  private String updatedAt;
  private final static long serialVersionUID = 3641578637710884741L;

}