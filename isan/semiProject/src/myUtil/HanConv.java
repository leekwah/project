package myUtil;

public class HanConv
{
 public static String toKor(String str)
 {
  //영문->한글
  String r="";
 
  if(str.equals("") || str==null || str.equals("null"))
  {
  r=str;
  return r;
  } 
 
  try{
  r= new String(str.getBytes("8859_1"),"euc-kr" );
  }catch(Exception e)
  {};
 
  return r; 
 }
 
 public static String toEng(String str)
 {
  //한글->영문
  String r="";
 
  if(str.equals("")||str==null||str.equals("null"))
  {
  r=str;
  return r;
  } 
 
  try{
  r= new String(str.getBytes("euc-kr"),"8859_1" );
  }catch(Exception e)
  {};
 
  return r; 
 }
}


