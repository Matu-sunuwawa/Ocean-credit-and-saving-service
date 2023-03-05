show databases;
use advproject;
show tables;
create table Admins(accnoa int, pinnoa int, uname int, upass varchar(50));
select * from Admins;
insert into Admins(accnoa,pinnoa,uname,upass) values(12121,1234,23232,"Admin");
drop table Admins;