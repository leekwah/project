package com.project.greenbook.dao;

import com.project.greenbook.dto.MemberDTO;

import java.util.ArrayList;
import java.util.HashMap;

public interface MemberDAO {
    public ArrayList<MemberDTO> list();
    public void register(HashMap<String, String> param);
    public MemberDTO memberView (HashMap<String, String> param);
}
