package kwah.solo.first;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class BookDAO {
    @Autowired
    SqlSessionTemplate sqlSessionTemplate;
    public int insert(Map<String, Object> map) {
        return this.sqlSessionTemplate.insert("book.insert", map);
    }
}
