package com.project.greenbook.service;

import com.project.greenbook.dto.BookDTO;

import java.util.ArrayList;
import java.util.HashMap;

public interface BookService {
    public ArrayList<BookDTO> list();
    public void write (HashMap <String, String> param);
}
