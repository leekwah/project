package com.project.greenbook.dao;

import com.project.greenbook.dto.MemDTO;

import java.util.ArrayList;
import java.util.HashMap;

public interface MemDAO {
    public ArrayList<MemDTO> list();
    public ArrayList<MemDTO> loginYn (HashMap<String, String> param);
    public void register (HashMap<String, String> param);
}
