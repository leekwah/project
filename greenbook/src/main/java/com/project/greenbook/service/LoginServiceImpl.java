package com.project.greenbook.service;

import com.project.greenbook.dao.LoginDAO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private SqlSession sqlSession;


    @Override
    public void register(HashMap<String, String> param) {
        LoginDAO dao = sqlSession.getMapper(LoginDAO.class);
        dao.register(param);
    }
}
