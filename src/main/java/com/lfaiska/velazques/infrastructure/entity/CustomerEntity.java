package com.lfaiska.velazques.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerEntity {

    @JsonProperty("id")
    private int id;
    @JsonProperty("nome")
    private String name;
    @JsonProperty("cpf")
    private String document;

    public CustomerEntity() {
    }

    public CustomerEntity(int id, String name, String document) {
        this.id = id;
        this.name = name;
        this.document = document;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", document='" + document + '\'' +
                '}';
    }
}
