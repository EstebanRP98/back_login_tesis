package com.marcos.cuadros.repository;

import com.marcos.cuadros.model.entity.PostEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends PagingAndSortingRepository<PostEntity,Long> {

    List<PostEntity> getByUserIdOrderByCreatedAtDesc(Long userId);

    @Query(value = "select * " +
            "from posts p " +
            "where p.exposure_id =:exposure " +
            "and p.expires_at>:now order by created_at desc limit 20",nativeQuery = true)
    List<PostEntity> getLastPublicPosts(@Param("exposure") long exposureId, @Param("now") Date now);

    PostEntity findByPostId(String postId);


}
