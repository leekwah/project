package com.project.greenbook.controller;

import com.project.greenbook.dto.BookDTO;
import com.project.greenbook.dto.BookImgDTO;
import com.project.greenbook.dto.BookInfoDTO;
import com.project.greenbook.dto.Paging;
import com.project.greenbook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService service;

    @RequestMapping("/")
    public String index(Model model){
        System.out.println("BookController.index() start");

        /* Main View */
        ArrayList<BookDTO> bookView = service.list();
        model.addAttribute("bookView", bookView);
        /* todayBook */
        model.addAttribute("todayBook", bookView);
        /* bestSeller */
        ArrayList<BookDTO> bestSeller = service.bestSeller();
        model.addAttribute("bestSeller", bestSeller);

        System.out.println("BookController.index() end");
        return "index";
    }
    @RequestMapping("/book_list")
    public String bookList(Model model,@RequestParam HashMap<String,String> param){
        System.out.println("BookController.bookList() start");

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
        model.addAttribute("list",list);
        model.addAttribute("pageNum",pageNum);
        model.addAttribute("page",page);
        model.addAttribute("largeCategory",param.get("largeCategory"));
        model.addAttribute("smallCategory",param.get("smallCategory"));
        model.addAttribute("searchType",param.get("searchType"));
        model.addAttribute("searchName",param.get("searchName"));

        System.out.println("BookController.bookList() end");
        return "book_list";
    }

    @RequestMapping("/new_book_list")
    public String newBookList(){

        return "new_book/new_book_list";
    }

    @RequestMapping("/product")
    public String product(@RequestParam HashMap<String,String>  param,Model model, @RequestParam(defaultValue = "1") int currentPage){
        System.out.println("@@@### BookController.productManager() start");

        ArrayList<BookInfoDTO> bookInfoList = service.bookInfoList(param);
        int total = service.countBookInfo();
        System.out.println(total);
        model.addAttribute("bookInfoList",bookInfoList);
        model.addAttribute("list",new Paging(total,currentPage, 10, 5));
        model.addAttribute("searchOption",param.get("searchOption"));
        model.addAttribute("searchText",param.get("searchText").replace("%",""));

        System.out.println("@@@### BookController.productManager() end");
        return "product/product";
    }

    @RequestMapping("/product_manager")
    public String productManager(@RequestParam HashMap<String,String> param, Model model, @RequestParam(defaultValue = "1") int currentPage){
        System.out.println("@@@### BookController.productManager() start");

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

        System.out.println("@@@### BookController.productManager() end");
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
        System.out.println("@@@### BookController.upload() start");

        service.register(uploadFile ,request, param);

        System.out.println("@@@### BookController.upload() end");
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
