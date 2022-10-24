package com.project.greenbook.service;

import com.project.greenbook.dto.MemberDTO;

import java.util.ArrayList;
import java.util.HashMap;

public interface MemberService {
    public ArrayList<MemberDTO> list();
    public void register(HashMap<String, String> param);
}
