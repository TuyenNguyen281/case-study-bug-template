package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "producers")
public class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long producerId;

    @NotEmpty
    private String producerName;

    public Producer() {
    }

    public Producer(Long producerId, @NotEmpty String producerName) {
        this.producerId = producerId;
        this.producerName = producerName;
    }

    public Long getProducerId() {
        return producerId;
    }

    public void setProducerId(Long producerId) {
        this.producerId = producerId;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

}
