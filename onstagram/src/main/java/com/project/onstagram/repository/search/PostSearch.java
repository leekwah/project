package com.project.onstagram.repository.search;

import com.project.onstagram.domain.Post;
import com.project.onstagram.dto.PostListReplyCountDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostSearch {
    Page<Post> search1(Pageable pageable);
    Page<Post> searchAll(String[] types, String keyword, Pageable pageable);

    Page<PostListReplyCountDTO> searchWithReplyCount(String[] types, String keyword, Pageable pageable);
}
