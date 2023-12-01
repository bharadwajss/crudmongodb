/**
 * @author:Satish Bharatiya
 * @date: 11/29/2023
 */
package com.ssb.crudmongdb.repository;

import com.ssb.crudmongdb.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book, Integer> {
}
