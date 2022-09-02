package com.inside.repository;

import java.util.List;
import com.inside.entity.Message;
import com.inside.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {

    List<Message> findByUserId(long userId);
    @Query(nativeQuery = true, value = "SELECT * FROM message m WHERE m.user_id = :userId LIMIT :paramLimit")
    List<Message> findOrderedUserByLimit(@Param("userId") long userId, @Param("paramLimit") int paramLimit);
}
