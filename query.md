Insert into ranks(rank_name) value("관리자");
Insert into ranks(rank_name) value("일반회원");
Insert into ranks(rank_name) value("정회원");
Insert into ranks(rank_name) value("트레이너");
Insert into fboard_ranks(fbrank_name) value("일반");
Insert into fboard_ranks(fbrank_name) value("공지");
insert into members(member_name, member_email, member_tel,member_pwd, member_gender, rank_no, join_date)
values('제작자','a@a.com','010-123-4567', password(1), '남성', 1, now());
insert into members(member_name, member_email, member_tel,member_pwd, member_gender, rank_no, join_date)
values('제작자','a@ab.com','010-122-4567', password(1), '남성', 1, now());
