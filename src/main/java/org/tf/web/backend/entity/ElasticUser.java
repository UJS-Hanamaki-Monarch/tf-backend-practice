package org.tf.web.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "user")
public class ElasticUser {
    @Id
    private String id;
    @Field(type = FieldType.Text)
    private String account;
    @Field(type = FieldType.Text)
    private String password;
    @Field(type = FieldType.Auto)
    private Profile profile;
    @Field(type = FieldType.Date)
    private Date createAt;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Profile{
    @Field(type = FieldType.Text)
    private String nickName;
    @Field(type = FieldType.Text)
    private String sex;
}
