package com.project.greenbook.dao;

import com.project.greenbook.dto.BookDTO;

import java.util.ArrayList;
import java.util.HashMap;

public interface BookDAO {
    public ArrayList<BookDTO> list();
    public void write (HashMap<String, String> param); // 매개변수의 타입을 HashMap으로 사용한다.
    public BookDTO contentView(HashMap<String, String> param);
}
