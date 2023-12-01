/**
 * @author:Satish Bharatiya
 * @date: 11/29/2023
 */
package com.ssb.crudmongdb.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Data
@Document(collection = "Book")
public class Book {
    @Id
    private int id;
    private  String bookName;
    private String authorName;

}
