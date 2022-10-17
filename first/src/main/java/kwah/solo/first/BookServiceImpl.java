package kwah.solo.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookDAO bookDAO;

    @Override
    public String create(Map<String, Object> map) {
        int affectRowCount = this.bookDAO.insert(map);
        if (affectRowCount == 1) { // insert 구문이 성공하면 1, 실패하면 0을 리턴한다.
            return map.get("book_id").toString();
        }
        return null; // 실패한 경우 null 리턴
    }
}
