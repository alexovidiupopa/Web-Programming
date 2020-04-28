DROP TABLE LogReport
DROP TABLE Loggers

CREATE TABLE Loggers(
    id int primary key auto_increment,
    username varchar(50),
    password varchar(20)
);

CREATE TABLE LogReport(
    id int primary key auto_increment,
    user_id int foreign key references Loggers(id),
    message varchar(255),
    type varchar(25),
    severity varchar(25),
    posted_on varchar(16)
);