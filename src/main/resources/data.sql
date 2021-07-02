--TRADE
INSERT INTO TRADE (trade_id, counter_party_id, book_id,  maturity_date, expired, created_ts, version) values ('T1', 'CP-1', 'B1', TO_DATE('20/05/2020', 'DD/MM/YYYY'), 'N', CURRENT_TIMESTAMP(), 1);
INSERT INTO  TRADE (trade_id, counter_party_id, book_id,  maturity_date, expired, created_ts, version) values ('T2', 'CP-2', 'B1', TO_DATE('20/05/2021', 'DD/MM/YYYY'), 'N', CURRENT_TIMESTAMP(), 2);
--INSERT INTO  TRADE (trade_id, counter_party_id, book_id,  maturity_date, expired, created_ts, version) values ('T2', 'CP-1', 'B1', TO_DATE('20/05/2021', 'DD/MM/YYYY'), 'N', CURRENT_TIMESTAMP(), 1);
INSERT INTO  TRADE (trade_id, counter_party_id, book_id,  maturity_date, expired, created_ts, version) values ('T3', 'CP-3', 'B2', TO_DATE('20/05/2014', 'DD/MM/YYYY'), 'N', CURRENT_TIMESTAMP(), 3);

--USER
insert into USERS (username, password, isActive) VALUES ('admin', '{bcrypt}$2a$10$.fQghOljCLOwsrCRCR.9buH/HSdWh3mo8aS79rtpJcgSS4cIy3Dlu', true);
insert into USERS (username, password, isActive) VALUES ('user', '{bcrypt}$2a$10$NGp83VuMrZNkZOz3N9HgjeogOLSwdseGUhbBlJAjs2VcZE7WOG31O', true);
insert into USERS (username, password, isActive) VALUES ('swagger', '{bcrypt}$2a$10$eFV8zorIVHEYDCiPCYHQM.PCaiFLZWyMECq8lUMY7LAtkwWgcXM4C', true);

insert into ROLES (username, role) VALUES ('admin', 'admin');
insert into ROLES (username, role) VALUES ('user', 'user');
insert into ROLES (username, role) VALUES ('swagger', 'swagger');