-- �고�몃���
DROP SCHEMA IF EXISTS zipcode;

-- �고�몃���
CREATE SCHEMA zipcode;

-- zipcode
CREATE TABLE zipcode (
	zipcode   CHAR(5)     NULL, -- �고�몃���
	sido      VARCHAR(20) NULL, -- ����
	sigungu   VARCHAR(20) NULL, -- ��援곌뎄
	doro      VARCHAR(80) NULL, -- ��濡�
	building1 INT(5)      NULL, -- 嫄대Ъ踰���1
	building2 INT(5)      NULL
	-- 嫄대Ъ踰���2
)DEFAULT CHARSET=euckr;
drop TABLE zipcode;
use zipcode;
SELECT * from zipcode.zipcode; 
-- /Users/KyungA/Desktop/수업/zipcode_DB/20161207_도로명주소 지역별 전체
LOAD data LOCAL INFILE '/Users/KyungA/Downloads/zipcode_DB/20161207_도로명주소 지역별 전체/충청북도.txt' INTO table zipcode
character set 'euckr' fields TERMINATED by '|' IGNORE 1 lines
(@zipcode, @sido, @d, @sigungu , @d, @d, @d, @d, @doro, @d, @d, @building1, @building2, @d, @d, @d, @d, @d, @d ,@d, @d, @d, @d, @d, @d, @d) set zipcode=@zipcode, sido=@sido, sigungu=@sigungu, doro=@doro, building1=@building1, building2=@building2

;
set names euckr;
SELECT DISTINCT sido from zipcode;
DESC zipcode;
SELECT zipcode,sido,sigungu,doro,building1,building2 from zipcode.zipcode;
SELECT zipcode,sido,sigungu,doro,building1,building2 from zipcode where zipcode=?;
SELECT DISTINCT doro from zipcode;




