CREATE TABLE TRADE (
    TRADE_ID VARCHAR(50) PRIMARY KEY,
    COUNTER_PARTY_ID VARCHAR(255),
    BOOK_ID VARCHAR(255),
    EXPIRED VARCHAR(255),
    MATURITY_DATE DATE,
    CREATED_TS TIMESTAMP NOT NULL,
    VERSION INT(2) NOT NULL
);

create table USERS(
    username varchar_ignorecase(50) not null primary key,
    password varchar(255)           not null,
    isactive  boolean                not null
);
create table roles
(
    username  varchar_ignorecase(50) not null,
    role      varchar_ignorecase(50) not null,
    constraint fk_roles_user foreign key (username) references USERS (username)
);