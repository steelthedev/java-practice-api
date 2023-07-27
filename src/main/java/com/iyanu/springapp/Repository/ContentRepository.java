package com.iyanu.springapp.Repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import com.iyanu.springapp.model.Content;
import com.iyanu.springapp.model.Status;



public interface ContentRepository extends ListCrudRepository<Content,Integer> {
    List<Content> findAllByTitleContains(String keyword);


    @Query(
        """
            SELECT * FROM Content
            Where status = :status
        """
    )

    List<Content> listByStatus(@Param("status") Status status);

}
