<%--
  Created by IntelliJ IDEA.
  User: kwah
  Date: 2022/09/08
  Time: 5:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.cos.upload.File" %>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.jspmart.upload.SmartUpload" %>
<%
  Cos
  SmartUpload upload = new SmartUpload();
  upload.initialize(pageContext);
  upload.upload();

  int last = upload.getFiles().getCount(); //개수를 나타냄
  int count = 0;
  for(int i = 0 ; i<last ; i++){
    File file = upload.getFiles().getFile(i);// 0~last까지 파일을 받음.

    if(!file.isMissing()){ // 업로드할 파일이 있다면,
      file.saveAs("/upload/"+file.getFileName());
      //메소드를 통해 upload디렉토리에 파일 이름을 저장
      out.println("폼 태그 필드 이름 :" + file.getFieldName() + "<br>");
      //필드 네임을 출력 filesel01~05
      out.println("파일 이름 :" + file.getFileName() + "<br>");
      out.println("파일 크기 :" + file.getSize() + "<br>");
      out.println("파일 확장자 :" + file.getFileExt() + "<br>");
      out.println("파일 경로 :" + file.getFilePathName() + "<br>");
      out.println("<br>---------------------------------<br>");
      count++;
    }
  }
  out.println("파일 "+count + "개를 업로드 했습니다.");
%>