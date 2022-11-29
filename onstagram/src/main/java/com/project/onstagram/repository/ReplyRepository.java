package com.project.onstagram.repository;

import com.project.onstagram.domain.Reply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    @Query("select r from Reply r where r.post.pno = :pno")
    Page<Reply> listOfPost(Long pno, Pageable pageable);
}
