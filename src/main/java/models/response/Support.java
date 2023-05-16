
package models.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "url",
    "text"
})

public class Support implements Serializable
{
    @JsonProperty("url")
    private String url;
    @JsonProperty("text")
    private String text;

    private final static long serialVersionUID = 2709566143696207042L;

}
