/**********************************/
/* Table Name: 키워드 */
/**********************************/
DROP TABLE keyword;
CREATE TABLE keyword(
        keywordno                           NUMBER(10)       NOT NULL        PRIMARY KEY,
        reviewno                            NUMBER(10)       NOT NULL,
        keylistno                            NUMBER(2)        NOT NULL,
  FOREIGN KEY (reviewno) REFERENCES review (reviewno),
  FOREIGN KEY (keylistno) REFERENCES keylist(keylistno)
);

COMMENT ON TABLE keyword is '키워드';
COMMENT ON COLUMN keyword.keywordno is '키워드 번호';
COMMENT ON COLUMN keyword.reviewno is '리뷰 번호';
COMMENT ON COLUMN keyword.keylistno is '키워드';

DROP SEQUENCE keyword_seq;
CREATE SEQUENCE keyword_seq
  START WITH 1                -- 시작 번호
  INCREMENT BY 1            -- 증가값
  MAXVALUE 9999999999    -- 최대값: 9999999999 --> NUMBER(10) 대응
  CACHE 2                       -- 2번은 메모리에서만 계산
  NOCYCLE;                      -- 다시 1부터 생성되는 것을 방지
    

    

insert into keyword(keywordno, reviewno,keylistno)
values(keyword_seq.nextval, 6, '1');

--조회--
    SELECT  keywordno, reviewno, keylistno
    FROM keyword
    WHERE reviewno = '6';

--수정--
  UPDATE keyword
  SET keylistno='2'
  WHERE keywordno = '3' and reviewno = '6';

commit;




select count(*)
from keyword
where reviewno = '94' and keylistno='1'

select count(*)
from keyword
where reviewno = '95' and keylistno='1'

select name
from cate
where cateno in(
select cateno
from catejoin
where storeno = '3')

