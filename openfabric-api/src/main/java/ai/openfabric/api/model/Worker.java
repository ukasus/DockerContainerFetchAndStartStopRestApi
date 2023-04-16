package ai.openfabric.api.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.Nullable;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity()
@Table(name = "Worker")
public class Worker extends Datable implements Serializable {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "of-uuid")
//    @GenericGenerator(name = "of-uuid", strategy = "ai.openfabric.api.model.IDGenerator")
    @Getter
    @Setter
    @JsonProperty("Id")
   @Column(length = 2048)
    public String id;

    @Getter
    @Setter
    @Column(length = 2048)
    public String name;

    @Getter
    @Setter
    @JsonProperty("Command")
    @Column(length = 2048)
    private String command;

    @Getter
    @Setter
    @JsonProperty("Image")
    @Column(length = 2048)
    private String image;

    @Getter
    @Setter
    @Column(length = 2048)
    @JsonProperty("ImageID")
    private String imageId;

    @Getter
    @Setter
    @Nullable
    @JsonProperty("Ports")
    @ElementCollection
    @CollectionTable(name = "container_ports",joinColumns = @JoinColumn(name = "worker_id"))
    public List<ContainerPort> ports;


    @Getter
    @Setter
    @JsonProperty("Status")
    private String status;

    @Getter
    @Setter
    @JsonProperty("State")
    private String state;


}
