package com.project.onstagram.service;

import com.project.onstagram.domain.Post;
import com.project.onstagram.dto.PageRequestDTO;
import com.project.onstagram.dto.PageResponseDTO;
import com.project.onstagram.dto.PostDTO;
import com.project.onstagram.dto.PostListReplyCountDTO;
import com.project.onstagram.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class PostServiceImpl implements PostService {
    private final ModelMapper modelMapper;
    private final PostRepository postRepository;

    @Override
    public Long register(PostDTO postDTO) {

        Post post = modelMapper.map(postDTO, Post.class);
        Long pno = postRepository.save(post).getPno();

        return pno;
    }

    @Override
    public PostDTO readOne(Long pno) {

        Optional<Post> result = postRepository.findById(pno);

        Post post = result.orElseThrow();

        PostDTO postDTO = modelMapper.map(post, PostDTO.class);

        return postDTO;
    }

    @Override
    public void modify(PostDTO postDTO) {
        Optional<Post> result = postRepository.findById(postDTO.getPno());

        Post post = result.orElseThrow();

        post.change(postDTO.getTitle(), postDTO.getContent());

        postRepository.save(post);
    }

    @Override
    public void remove(Long pno) {
        postRepository.deleteById(pno);
    }

    @Override
    public PageResponseDTO<PostDTO> list(PageRequestDTO pageRequestDTO) {
        String[] types = pageRequestDTO.getTypes();
        String keyword = pageRequestDTO.getKeyword();
        Pageable pageable = pageRequestDTO.getPageable("pno");

        Page<Post> result = postRepository.searchAll(types, keyword, pageable);

        List<PostDTO> dtoList = result.getContent().stream()
                .map(post -> modelMapper.map(post, PostDTO.class))
                .collect(Collectors.toList());


        return PageResponseDTO.<PostDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total((int)result.getTotalElements())
                .build();
    }

    @Override
    public PageResponseDTO<PostListReplyCountDTO> listWithReplyCount(PageRequestDTO pageRequestDTO) {

        String[] types = pageRequestDTO.getTypes();
        String keyword = pageRequestDTO.getKeyword();
        Pageable pageable = pageRequestDTO.getPageable("pno");

        Page<PostListReplyCountDTO> result = postRepository.searchWithReplyCount(types, keyword, pageable);

        return PageResponseDTO.<PostListReplyCountDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(result.getContent())
                .total((int)result.getTotalElements())
                .build();
    }
}