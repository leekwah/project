package com.project.greenbook.dao;

import com.project.greenbook.dto.MemberDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository // 현재 클래스를 dao bean으로 등록
public class MemberDAOImpl implements MemberDAO {
    @Autowired
    private SqlSession sqlSession;

    @Override
    public String loginCheck(MemberDTO dto) {
        return sqlSession.selectOne("member.loginCheck", dto);
    }
}
