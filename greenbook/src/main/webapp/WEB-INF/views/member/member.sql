create table member (
                        member_id varchar(20),
                        member_pwd varchar(40),
                        member_name varchar(16),
                        member_phone varchar(16),
                        member_email varchar(50),
                        member_postcode int(5),
                        member_address varchar(100),
                        member_extraAddress varchar(100),
                        member_detailAddress varchar(100)
);

CREATE TABLE user (
                      `user_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '사용자번호',
                      `user_id` varchar(256) NOT NULL COMMENT '아이디',
                      `user_pw` varchar(256) DEFAULT NULL COMMENT '비밀번호',
                      `user_name` varchar(256) NOT NULL COMMENT '사용자명',
                      `user_auth` varchar(256) NOT NULL COMMENT '권한',
                      `append_date` datetime DEFAULT NULL COMMENT '추가날짜',
                      `update_date` datetime DEFAULT NULL COMMENT '수정날짜',
                      PRIMARY KEY (`user_no`)
);
