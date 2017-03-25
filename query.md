Insert into ranks(rank_name) value("관리자");
Insert into ranks(rank_name) value("일반회원");
Insert into ranks(rank_name) value("정회원");
Insert into ranks(rank_name) value("트레이너");

insert into members(member_name, member_email, member_nick,
member_tel,member_pwd, member_gender, rank_no, join_date)
values('제작자','a@a.com', 'wackos_Rtwo',
'010-123-4567', password(1), '남성', 1, now());

insert into members(member_name, member_email, member_tel,member_pwd, member_gender, rank_no, join_date)
values('제작자','a@ab.com','010-122-4567', password(1), '남성', 1, now());
insert into members(member_name, member_email, member_tel,member_pwd, member_gender, rank_no, join_date)
values('trainer2','ab@a.com','010-122-4442', password(1), '남성', 4, now());

update members set trainer_no = 1 where member_no=2;

insert into trainers(trainer_name, member_no) value((select member_name from members where member_no=3),3);

select mbs.member_email, mbs.member_name, mrk.rank_name,
mbs.member_Tel,mbs.member_Gender,mbs.join_Date,trs.trainer_no,
trs.trainer_name
from members mbs
left join ranks mrk on mrk.rank_no = mbs.rank_no
left join trainers trs on mbs.trainer_no = trs.trainer_no
where mbs.member_email = "a@ab.com";