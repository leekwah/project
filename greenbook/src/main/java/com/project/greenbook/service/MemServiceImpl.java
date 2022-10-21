package com.project.greenbook.service;

import com.project.greenbook.dao.MemDAO;
import com.project.greenbook.dto.MemDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class MemServiceImpl implements MemService {
    @Autowired
    private SqlSession sqlSession;

    @Override
    public ArrayList<MemDTO> list() {
        MemDAO dao = sqlSession.getMapper(MemDAO.class);
        ArrayList<MemDTO> dto = dao.list();
        return dto;
    }

    @Override
    public ArrayList<MemDTO> loginYn(HashMap<String, String> param) {

        MemDAO dao = sqlSession.getMapper(MemDAO.class);
        ArrayList<MemDTO> dto = dao.loginYn(param);

        return dto;
    }

    @Override
    public void register(HashMap<String, String> param) {
        MemDAO dao = sqlSession.getMapper(MemDAO.class);
        dao.register(param);
    }
}
