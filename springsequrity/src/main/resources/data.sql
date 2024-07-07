CREATE TABLE IF NOT EXISTS MyUsers(
            id           bigint not null primary key,
            username   varchar(255),
            password   varchar(255)
            );

CREATE TABLE IF NOT EXISTS MyRoles(
            id           bigint not null primary key,
            role   varchar(255)
            );

CREATE TABLE IF NOT EXISTS MyUser_Roles(
            id           bigint not null primary key,
            user_id      bigint not null,
            role_id      bigint not null
            );

INSERT INTO MyUsers VALUES (1, 'Admin', 'Admin');
INSERT INTO MyUsers VALUES (2, 'User', 'User');
INSERT INTO MyRoles VALUES (1, 'Admin');
INSERT INTO MyRoles VALUES (2, 'User');
INSERT INTO MyUser_Roles VALUES (1, 1, 1);
INSERT INTO MyUser_Roles VALUES (2, 2, 2);