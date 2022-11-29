package com.project.onstagram.repository;

import com.project.onstagram.domain.Post;
import com.project.onstagram.repository.search.PostSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Long>, PostSearch {

    Page<Post> findByTitleContainingOrderByBnoDesc (String keyword, Pageable pageable);
    @Query("select b from Post b where b.title like concat('%', :keyword, '%') ")
    Page<Post> findKeyword(String keyword, Pageable pageable);

    @Query(value = "select now()", nativeQuery = true)
    String getTime();

}
