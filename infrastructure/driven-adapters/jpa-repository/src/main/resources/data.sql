CREATE TABLE `USERS` (
      id UUID NOT NULL,
      `name` VARCHAR(100) NOT NULL,
      email VARCHAR(100) NOT NULL,
      password VARCHAR(100) NOT NULL,
      last_Login timestamp NOT NULL,
      token VARCHAR(1000) NOT NULL,
      is_active BOOLEAN NOT NULL,
      created timestamp NOT NULL,
      modified timestamp NOT NULL,
      CONSTRAINT pk_user PRIMARY KEY (id)
);

CREATE TABLE `PHONES` (
      id UUID NOT NULL,
      user_id UUID NOT NULL,
      `number` VARCHAR(100) NOT NULL,
      city_code VARCHAR(50) NOT NULL,
      country_code VARCHAR(50) NOT NULL,
      created timestamp NOT NULL,
      modified timestamp NOT NULL,
      CONSTRAINT pk_phone PRIMARY KEY (id)
);


INSERT INTO `USERS` (id, `name`,  email, password, last_login, is_active, created, modified, token) VALUES 
 ('af54892a-5936-4d12-9e81-3e3c4890b374', 'Juan Rodriguez', 'juan@rodriguez.org', 'Hunter12345@', '2023-12-20T12:15:48.733206', 1, '2023-12-20T12:15:48.733206', '2023-12-20T12:15:48.733206', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJKdWFuIFJvZHJpZ3VleiIsImF1dGgiOiIiLCJkZXRhaWxzIjp7Im5hbWUiOiJKdWFuIFJvZHJpZ3VleiIsImlkIjoiYWY1NDg5MmEtNTkzNi00ZDEyLTllODEtM2UzYzQ4OTBiMzc0IiwiZW1haWwiOiJqdWFueHoxMTJAcm9kcmlndWV6Lm9yZyJ9LCJleHAiOjE3MDMwOTI1NDh9._IwQVBPFPHgnKOJc5k8tO1-BVSM9tAni50dW3G-vWBloOEEcdwkegzHbk41dVRnOsurm6ipEXOUu54MrTWMg4Q');


INSERT INTO `PHONES` (id, user_id, `number`, city_code, country_code, created, modified) VALUES
('7d32fa5c-9e91-4f24-953f-f1dca8e5c089','af54892a-5936-4d12-9e81-3e3c4890b374','123456789','1','57', '2023-12-20T12:15:48.733206', '2023-12-20T12:15:48.733206');                                                                                  
