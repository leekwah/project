package com.project.onstagram.service;

import com.project.onstagram.dao.PostDAO;
import com.project.onstagram.domain.PostVO;
import com.project.onstagram.dto.PostDTO;
import com.project.onstagram.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

@Log4j2
public enum PostService {
    INSTANCE;

    private PostDAO dao;
    private ModelMapper modelMapper;

    PostService() {
        dao = new PostDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    public void register(PostDTO postDTO) throws Exception {
        PostVO postVO = modelMapper.map(postDTO, PostVO.class);
        log.info(postVO);

        dao.insert(postVO); // int를 반환하므로 이를 이용해서 예외처리도 가능
    }
}