Insert into ranks(rank_name) value("관리자");
Insert into ranks(rank_name) value("일반회원");
Insert into ranks(rank_name) value("정회원");
Insert into ranks(rank_name) value("트레이너");
Insert into fboard_ranks(fbrank_name) value("일반");
Insert into fboard_ranks(fbrank_name) value("공지");

update ranks set rank_name = '관리자' where rank_no = 0;

alter table fms_test add fms_date datetime not null
alter table members modify member_tel varchar(50) not null;

insert into members(member_name, member_email, member_tel,member_pwd, member_gender, rank_no, join_date)
values('제작자','a@a.com','010-123-4567', password(1), '남성', 1, now());

update members set member_gender = '남성' where member_no = 1;