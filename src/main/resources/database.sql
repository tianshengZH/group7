-- Active: 1700205471188@@benfordapp.clpldhgabcmu.us-east-2.rds.amazonaws.com@3306
use demo1;
Create table users
(
    userid int not null AUTO_INCREMENT,
    email varchar(128) Not NULL,
    username VARCHAR(128) Not null,
    passwords VARCHAR(128) NOT null,
    PRIMARY KEY(userid)

);
ALTER TABLE users AUTO_INCREMENT = 80001;

create table accounts
(
    acid int not null AUTO_INCREMENT,
    userid int not null,
    accountnumber varchar(128),
    actype int, -- 0 rmb,1 dollar
    PRIMARY key(acid),
    Foreign Key (userid) REFERENCES users(userid)
);

alter table accounts add COLUMN RMBIncome float;
alter table accounts add COLUMN DollarIncome float;
ALTER TABLE accounts AUTO_INCREMENT = 50001;
create table sellers(
                        pid int not null AUTO_INCREMENT,
                        userid int not null,
                        pname varchar(128),
                        status int, -- 0 有效, 1 被删除
                        PRIMARY KEY(pid),
                        Foreign Key (userid) REFERENCES users(userid)
);
ALTER TABLE sellers AUTO_INCREMENT = 30001;
create table bills(
                      bid int not null AUTO_INCREMENT,
                      pid int not null,
                      dollarIncome FLOAT,
                      billstatus int, -- 0 未提现，1 已提现
                      PRIMARY KEY(bid),
                      Foreign Key (pid) REFERENCES sellers(pid)
);
ALTER TABLE bills AUTO_INCREMENT = 10001;