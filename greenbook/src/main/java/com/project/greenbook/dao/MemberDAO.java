package com.project.greenbook.dao;

import com.project.greenbook.dto.MemberDTO;

import java.util.ArrayList;
import java.util.HashMap;

public interface MemberDAO {
    public ArrayList<MemberDTO> loginCheck(HashMap<String, String> param);
    public void signUp(HashMap<String, String> param);
    public void signIn(HashMap<String, String> param);

}
