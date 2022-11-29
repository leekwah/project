package com.project.onstagram.dao;

import com.project.onstagram.domain.PostVO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PostDAO {
    public String getTime() {
        String now = null;

        try(Connection connection = ConnectionUtil.INSTANCE.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select now()");
            ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            resultSet.next();

            now = resultSet.getString(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    public String getTime2() throws Exception {
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement("select now()");
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();

        String now = resultSet.getString(1);

        return now;
    }

    // 삽입 기능
    public void insert(PostVO vo) throws Exception {
        String sql = "insert into post (title, dueDate, finished) values (?, ?, ?)";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, vo.getTitle());
        preparedStatement.setString(2, String.valueOf(vo.getDueDate()));
        preparedStatement.setBoolean(3, vo.isFinished());

        preparedStatement.executeUpdate();

    }

    // 게시글 전체 보는 기능
    public List<PostVO> selectAll() throws Exception {
        String sql = "select * from post";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        List<PostVO> list = new ArrayList<>();

        while (resultSet.next()) {
            PostVO vo = PostVO.builder()
                    .pno(resultSet.getLong("pno"))
                    .title(resultSet.getString("title"))
                    .dueDate(resultSet.getDate("dueDate").toLocalDate())
                    .finished(resultSet.getBoolean("finished"))
                    .build();

            list.add(vo);
        }
        return list;
    }

    // 게시글 하나만 보는 기능
    public PostVO selectOne(Long pno) throws  Exception {
        String sql = "select * from post where pno = ?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setLong(1, pno);

        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();
        PostVO vo = PostVO.builder()
                .pno(resultSet.getLong("pno"))
                .title(resultSet.getString("title"))
                .dueDate(resultSet.getDate("dueDate").toLocalDate())
                .finished(resultSet.getBoolean("finished"))
                .build();

        return vo;
    }

    // 삭제 기능
    public void deleteOne(Long pno) throws Exception {
        String sql = "delete from post where tno = ?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setLong(1, pno);
        preparedStatement.executeUpdate();
    }

    // 업데이트 기능
    public void updateOne(PostVO postVO) throws Exception {
        String sql = "update post set title = ?, dueDate = ?, finished = ? where pno = ?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, postVO.getTitle());
        preparedStatement.setDate(2, Date.valueOf(postVO.getDueDate()));
        preparedStatement.setBoolean(3, postVO.isFinished());
        preparedStatement.setLong(4, postVO.getPno());

        preparedStatement.executeUpdate();

    }
}
