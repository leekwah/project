package com.project.greenbook.dao;

import com.project.greenbook.dto.MemberDTO;

import java.util.ArrayList;
import java.util.HashMap;

public interface MemberDAO {
    public ArrayList<MemberDTO> loginCheck(HashMap<String, String> param);
    public void signUp(HashMap<String, String> param);
    public int idCheck(String member_id) throws Exception;
    public int emailCheck(String member_email) throws Exception;
}
