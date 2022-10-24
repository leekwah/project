package com.project.greenbook.service;

import com.project.greenbook.dao.MemberDAO;
import com.project.greenbook.dto.MemberDTO;
import lombok.extern.log4j.Log4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
@Service
@Log4j
public class MemberServiceImpl implements MemberService {
    @Autowired
    private SqlSession sqlSession;
    @Override
    public ArrayList<MemberDTO> list() {
        log.info("MemberServiceImpl.list() start");
        MemberDAO dao = sqlSession.getMapper(MemberDAO.class);
        ArrayList<MemberDTO> dtos = dao.list();

        log.info("MemberServiceImpl.list() end");
        return dtos;
    }

    @Override
    public void register(HashMap<String, String> param) {
        log.info("MemberServiceImpl.register() start");

        MemberDAO dao = sqlSession.getMapper(MemberDAO.class);
        dao.register(param);

        log.info("MemberServiceImpl.register() end");
    }
}
