package com.project.greenbook.service;

import com.project.greenbook.dto.MemDTO;

import java.util.ArrayList;
import java.util.HashMap;

public interface MemService {
    public ArrayList<MemDTO> list();
    public ArrayList<MemDTO> loginYn (HashMap<String, String> param);
    public void register (HashMap<String, String> param);
}
