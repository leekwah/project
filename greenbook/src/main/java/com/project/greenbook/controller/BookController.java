package com.project.greenbook.controller;

import com.project.greenbook.dto.BookImgDTO;
import com.project.greenbook.dto.BookInfoDTO;
import com.project.greenbook.dto.MemberDTO;
import com.project.greenbook.dto.Paging;
import com.project.greenbook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService service;

    @RequestMapping("/")
    public String index(Model model){

        /* Main View */
        List<String> bookId1 = service.bookId1();
        List<String> bookId2 = service.bookId2();
        List<String> bookId3 = service.bookId3();
        List<String> bookId4 = service.bookId4();
        List<String> bookId5 = service.bookId5();
        HashMap<String,String> bookView1 = new HashMap();
        HashMap<String,String> bookView2 = new HashMap();
        HashMap<String,String> bookView3 = new HashMap();
        HashMap<String,String> bookView4 = new HashMap();
        HashMap<String,String> bookView5 = new HashMap();
        for (int i=0; i<4; i++){
            BookInfoDTO infoDTO = service.contentInfo(bookId1.get(i));
            BookImgDTO imgDTO = service.contentImg(bookId1.get(i));
            bookView1.put("bookId"+i, String.valueOf(infoDTO.getBookId()));
            bookView1.put("price"+i, String.valueOf(infoDTO.getBookPrice()));
            bookView1.put("title"+i, infoDTO.getBookTitle());
            bookView1.put("thumbnail"+i, imgDTO.getStoredThumbnail());
        }
        for (int i=0; i<4; i++){
            BookInfoDTO infoDTO = service.contentInfo(bookId2.get(i));
            BookImgDTO imgDTO = service.contentImg(bookId2.get(i));
            bookView2.put("bookId"+i, String.valueOf(infoDTO.getBookId()));
            bookView2.put("price"+i, String.valueOf(infoDTO.getBookPrice()));
            bookView2.put("title"+i, infoDTO.getBookTitle());
            bookView2.put("thumbnail"+i, imgDTO.getStoredThumbnail());
        }
        for (int i=0; i<4; i++){
            BookInfoDTO infoDTO = service.contentInfo(bookId3.get(i));
            BookImgDTO imgDTO = service.contentImg(bookId3.get(i));
            bookView3.put("bookId"+i, String.valueOf(infoDTO.getBookId()));
            bookView3.put("price"+i, String.valueOf(infoDTO.getBookPrice()));
            bookView3.put("title"+i, infoDTO.getBookTitle());
            bookView3.put("thumbnail"+i, imgDTO.getStoredThumbnail());
        }
        for (int i=0; i<4; i++){
            BookInfoDTO infoDTO = service.contentInfo(bookId4.get(i));
            BookImgDTO imgDTO = service.contentImg(bookId4.get(i));
            bookView4.put("bookId"+i, String.valueOf(infoDTO.getBookId()));
            bookView4.put("price"+i, String.valueOf(infoDTO.getBookPrice()));
            bookView4.put("title"+i, infoDTO.getBookTitle());
            bookView4.put("thumbnail"+i, imgDTO.getStoredThumbnail());
        }
        for (int i=0; i<4; i++){
            BookInfoDTO infoDTO = service.contentInfo(bookId5.get(i));
            BookImgDTO imgDTO = service.contentImg(bookId5.get(i));
            bookView5.put("bookId"+i, String.valueOf(infoDTO.getBookId()));
            bookView5.put("price"+i, String.valueOf(infoDTO.getBookPrice()));
            bookView5.put("title"+i, infoDTO.getBookTitle());
            bookView5.put("thumbnail"+i, imgDTO.getStoredThumbnail());
        }
        model.addAttribute("bookView1",bookView1);
        model.addAttribute("bookView2",bookView2);
        model.addAttribute("bookView3",bookView3);
        model.addAttribute("bookView4",bookView4);
        model.addAttribute("bookView5",bookView5);

        /* todayBook */
        int count = service.countBookInfo();
        int todayBook[] = new int[2];
        for(int i=0;i<2;i++) {
            todayBook[i] = (int)(Math.random() * count) + 1;
            for(int j=0;j<i;j++) {
                if(todayBook[i]==todayBook[j]) {
                    i--;
                }
            }
        }
        BookInfoDTO todayInfo1 = service.contentInfo(String.valueOf(todayBook[0]));
        BookInfoDTO todayInfo2 = service.contentInfo(String.valueOf(todayBook[1]));
        BookImgDTO todayImg1 = service.contentImg(String.valueOf(todayBook[0]));
        BookImgDTO todayImg2 = service.contentImg(String.valueOf(todayBook[1]));

        model.addAttribute("todayInfo1", todayInfo1);
        model.addAttribute("todayInfo2", todayInfo2);
        model.addAttribute("todayImg1", todayImg1);
        model.addAttribute("todayImg2", todayImg2);

        /* bestSeller */
        /* List bestSeller = service.bestSeller();*/
        /* list에서 book_id만 뽑아서 contentInfo랑 Img에 넣어서 출력 */
        return "index";
    }
    @RequestMapping("/book_list")
    public String bookList(Model model,@RequestParam HashMap<String,String> param){

        /* 목록 개수*/
        int count = service.bookCount(param);
        /* 한 페이지에 출력할 게시물의 개수 */
        int postNum = 10;
        /* 페이징 번호 [총 개수 / 한 페이지에 출력할 개수] */
        int pageNum = (int)Math.ceil((double)count/postNum);
        /* 출력할 게시물 */
        int page;
        if(param.get("page") == null){
            page = 1;
        } else {
            page = Integer.parseInt(param.get("page"));
        }
        int displayPost = (page - 1) * postNum;

        /* 데이터를 파라미터로 넘기기 위해 해시맵 사용 */
        HashMap<String, String> parameter = new HashMap();
        parameter.put("displayPost", String.valueOf(displayPost));
        parameter.put("postNum",String.valueOf(postNum));
        parameter.put("largeCategory",param.get("largeCategory"));

        if(param.containsKey("smallCategory")) {
            parameter.put("smallCategory",param.get("smallCategory"));
        }
        if(param.containsKey("searchType")){
            parameter.put("searchType",param.get("searchType"));
            parameter.put("searchName",param.get("searchName"));
        }
        if(param.containsKey("title")){
            parameter.put("title",param.get("title"));
            parameter.put("author",param.get("author"));
            model.addAttribute("title",param.get("title"));
            model.addAttribute("author",param.get("author"));
        }

        List list = service.bookList(parameter);
        List bookIdList = service.bookIdList(parameter);
        HashMap<String, String> imgList = new HashMap<>();
        for (int i=0; i<bookIdList.size(); i++){
            BookImgDTO imgDTO = service.contentImg((String) bookIdList.get(i));
            imgList.put("thumbnail"+i, imgDTO.getStoredThumbnail());
            System.out.println(imgList);
        }
        model.addAttribute("list",list);
        model.addAttribute("imgList",imgList);
        model.addAttribute("pageNum",pageNum);
        model.addAttribute("page",page);
        model.addAttribute("largeCategory",param.get("largeCategory"));
        model.addAttribute("smallCategory",param.get("smallCategory"));
        model.addAttribute("searchType",param.get("searchType"));
        model.addAttribute("searchName",param.get("searchName"));

        return "book_list";
    }
    @RequestMapping("/chat")
    public String chat(){return "chat";}

    @RequestMapping("/new_book_list")
    public String newBookList(){

        return "new_book/new_book_list";
    }

    @RequestMapping("/product")
    public String product(@RequestParam HashMap<String,String>  param,Model model, @RequestParam(defaultValue = "1") int currentPage){

        ArrayList<BookInfoDTO> bookInfoList = service.bookInfoList(param);
        int total = service.countBookInfo();
        System.out.println(total);
        model.addAttribute("bookInfoList",bookInfoList);
        model.addAttribute("list",new Paging(total,currentPage, 10, 5));
        model.addAttribute("searchOption",param.get("searchOption"));
        model.addAttribute("searchText",param.get("searchText").replace("%",""));

        return "product/product";
    }

    @RequestMapping("/product_manager")
    public String productManager(@RequestParam HashMap<String,String> param, Model model, @RequestParam(defaultValue = "1") int currentPage){

        ArrayList<BookInfoDTO> bookInfoList = service.bookInfoList(param);
        ArrayList<BookImgDTO> bookImgDTOS = service.bookImgList(param);
        int total = service.countBookInfo();
        System.out.println(total);
        model.addAttribute("bookInfoList",bookInfoList);
        model.addAttribute("bookImgList", bookImgDTOS);
        model.addAttribute("list",new Paging(total,currentPage, 10, 5));
        model.addAttribute("searchOption",param.get("searchOption"));
        model.addAttribute("searchText",param.get("searchText").replace("%",""));

        if(param.get("bookId")!=null){
            System.out.println("bookId = " + param.get("bookId"));
            BookInfoDTO bookInfoDTO = service.contentInfo(param.get("bookId"));
            BookImgDTO bookImgDTO = service.contentImg(param.get("bookId"));

            model.addAttribute("bookInfo2",bookInfoDTO);
            model.addAttribute("bookImg2", bookImgDTO);
            System.out.println("bookId2 = "+bookInfoDTO.getBookId());
        }

        return "product/product_manager";
    }

    @RequestMapping("/product_test")
    public String productTest(){

        return "product/product_testUpload";
    }

    /*
     * 이름 : 이민하
     * 작업 : 2022.10.25  책정보, 이미지, 섬네일 업로드 컨트롤러
     * */
    @RequestMapping("/uploadOk")
    public String upload(@RequestParam("imgfile") MultipartFile uploadFile, HttpServletRequest request, @RequestParam HashMap<String, String> param){

        service.register(uploadFile ,request, param);

        return "redirect:product";
    }

    /*
     * 이름 : 이민하
     * 작업 : 2022.10.25  책정보, 이미지, 섬네일 업로드 컨트롤러
     * */
    @RequestMapping("/updateOk")
    public String updateOk(@RequestParam("imgfile")MultipartFile uploadFile, HttpServletRequest request,@RequestParam HashMap<String, String> param){
        System.out.println("@@@### BookController.upload() start");

        if(uploadFile == null){

        }else{
            service.register(uploadFile ,request, param);
        }

        System.out.println("@@@### BookController.upload() end");
        return "redirect:product";
    }

    @RequestMapping("product_upload")
    public String productUpload(){
        return "product/product_upload";
    }
}
