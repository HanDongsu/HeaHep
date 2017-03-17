insert into honey_membs(EMAIL, MB_NICK, MB_NM, TEL, PWD)
value ('r@r.com','철한찡','배철한','010-2222-3333',password(1));
insert into honey_membs(EMAIL, MB_NICK, MB_NM, TEL, PWD)
value ('s@e.com','쏭썽','송성은','010-3333-4444',password(1));
insert into honey_membs(EMAIL, MB_NICK, MB_NM, TEL, PWD)
value ('q@q.com','예쁜걸로해주세요','손덕현','010-4444-5555',password(1));
insert into honey_membs(EMAIL, MB_NICK, MB_NM, TEL, PWD)
value ('a@a.com','똥수','한동수','010-1234-5678',password(1));

insert into honey_membs_photos(mb_no) values (1);
insert into honey_membs_photos(mb_no) values (2);
insert into honey_membs_photos(mb_no) values (3);
insert into honey_membs_photos(mb_no) values (4);
    
Insert into ranks(rank_name) value("관리자");
Insert into ranks(rank_name) value("일반회원");
Insert into ranks(rank_name) value("정회원");
Insert into ranks(rank_name) value("트레이너");

update ranks set rank_name = '관리자' where rank_no = 0;

alter table fms_test add fms_date datetime not null
alter table members modify member_tel varchar(50) not null;

insert into members(member_name, member_email, member_tel,member_pwd, member_gender, rank_no)
values('개발자','a@a.com','010-123-4567', password(1),1,1);

update members set member_gender = '남성' where member_no = 1;