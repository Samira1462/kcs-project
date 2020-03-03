insert into BRANCH (code,firstIp,lastIp,name) values ('00019','127.0.0.1','127.0.0.1','مركزی');
insert into ROLES (name) values ('ROLE_ADMIN');
insert into ROLES (name) values ('ROLE_USER');
insert into MATCHERS (id,pagename,role) values (1,'/system/**','ROLE_ADMIN');
insert into MATCHERS (id,pagename,role) values (2,'/leader/**','ROLE_ADMIN,ROLE_USER');
insert into MATCHERS (id,pagename,role) values (3,'/','ROLE_ADMIN,ROLE_USER');
insert into USERS (USERNAME,CREATE_ON,UPDATE_ON,ENABLED,FIRSTLOGIN,PASSWORD,ROLE,Branch) values ('admin',getdate(),getdate(),1,1,'$2a$10$hbxecwitQQ.dDT4JOFzQAulNySFwEpaFLw38jda6Td.Y/cOiRzDFu','ROLE_ADMIN','00019');
insert into USERS (USERNAME,CREATE_ON,UPDATE_ON,ENABLED,FIRSTLOGIN,PASSWORD,ROLE,Branch) values ('admin2',getdate(),getdate(),1,1,'$2a$10$hbxecwitQQ.dDT4JOFzQAulNySFwEpaFLw38jda6Td.Y/cOiRzDFu','ROLE_ADMIN','00019');

