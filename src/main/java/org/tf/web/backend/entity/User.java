package org.tf.web.backend.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;


@Entity
@Data
public class User {
    @Id
    private String id;
}
