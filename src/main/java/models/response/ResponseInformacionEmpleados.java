
package models.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "data",
    "support"
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseInformacionEmpleados implements Serializable {
  @JsonProperty("data")
  private Datum data ;
  @JsonProperty("support")
  private Support support;
  private final static long serialVersionUID = -9112121849417225541L;

}
