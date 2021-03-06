package org.tf.web.backend.dto;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.Hibernate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author tuzi
 * @date 2022年03月22日 14:19
 */

@Entity(name = "bucket")
public class BucketCallbackDTO {
    @Id
    @GeneratedValue(generator = "UUIDHexGenerator")
    @GenericGenerator(name="UUIDHexGenerator", strategy="uuid")
    @Column(length = 32)
    private String id;
    private String hash;
    @Column(name = "image_key")
    private String key;
    private String name;
    private String fsize;

    public BucketCallbackDTO() {
    }

    public BucketCallbackDTO(String id, String hash, String key, String name, String fsize) {
        this.id = id;
        this.hash = hash;
        this.key = key;
        this.name = name;
        this.fsize = fsize;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFsize() {
        return fsize;
    }

    public void setFsize(String fsize) {
        this.fsize = fsize;
    }

    @Override
    public String toString() {
        return "BucketCallbackDTO{" +
                "id='" + id + '\'' +
                ", hash='" + hash + '\'' +
                ", key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", fsize='" + fsize + '\'' +
                '}';
    }
}
