package ai.openfabric.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
public class ContainerPort {


    @Getter
    @Setter
    @JsonProperty("IP")
    private String ip;

    @Getter
    @Setter
    @JsonProperty("PrivatePort")
    private String privatePort;

    @Getter
    @Setter
    @JsonProperty("PublicPort")
    private String publicPort;

    @Getter
    @Setter
    @JsonProperty("Type")
    private String type;


}
