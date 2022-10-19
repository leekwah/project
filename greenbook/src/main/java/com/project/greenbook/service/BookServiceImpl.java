package com.project.greenbook.service;

import com.project.greenbook.dao.BookDAO;
import com.project.greenbook.dto.BookDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private SqlSession sqlSession;

    @Override
    public ArrayList<BookDTO> list() {
        System.out.println("BookServiceImpl.list() start");

        BookDAO dao = sqlSession.getMapper(BookDAO.class); // getMapper() 메서드를 사용해서, 호출한 뒤에, 값을 dao에 대입
        ArrayList<BookDTO> dto = dao.list();

        System.out.println("BookServiceImpl.list() end");
        return dto;
    }

    @Override
    public void write(HashMap <String, String> param) {
        System.out.println("BookServiceImpl.write() start");

        BookDAO dao = sqlSession.getMapper(BookDAO.class);
        dao.write(param);

        System.out.println("BookServiceImpl.write() end");
    }
}
