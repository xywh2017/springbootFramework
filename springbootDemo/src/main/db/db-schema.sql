DROP DATABASE IF EXISTS sfc;
DROP USER IF exists sfc;
create user sfc encrypted password '123456';
CREATE DATABASE sfc with owner sfc;
CREATE EXTENSION postgis with owner sfc;
CREATE EXTENSION hstore with owner sfc;
CREATE SCHEMA AUTHORIZATION sfc;

DROP TABLE IF EXISTS "sys_user";
DROP TABLE IF EXISTS "sys_organization";
DROP TABLE IF EXISTS "sys_resource";
DROP TABLE IF EXISTS "sys_role";
DROP TABLE IF EXISTS "sys_news";

drop sequence IF EXISTS "sys_user_seq";
drop table IF EXISTS "sys_user";

create sequence "sys_user_seq"
    start with 1
    increment by 1
    no minvalue
    no maxvalue
    cache 1;
ALTER TABLE sys_user_seq OWNER TO sfc;
create table "sys_user" (
  "id" int4 default nextval('sys_user_seq'::regclass),
  "organization_id" int4,
  "username" varchar(100),
  "password" varchar(100),
  "salt" varchar(100),
  "role_id" int4,
  "realname" varchar(100),
  "phone" varchar(100),
  "email" varchar(100),
  locked boolean default false,
  "token" varchar(100),
  constraint pk_sys_user primary key(id)
)WITH (
  OIDS=FALSE
);
ALTER TABLE sys_user OWNER TO sfc;
alter table "sys_user" alter column "id" set default nextval('sys_user_seq');

drop sequence IF EXISTS "sys_organization_seq";
drop table IF EXISTS "sys_organization";

create sequence "sys_organization_seq"
    start with 1
    increment by 1
    no minvalue
    no maxvalue
    cache 1;
ALTER TABLE sys_organization_seq OWNER TO sfc;
    -- ----------------------------
-- Table structure for sys_organization
-- ----------------------------
create table "sys_organization" (
  "id" int4 default nextval('sys_organization_seq'::regclass),
  "name" varchar(100),
  "shortname" varchar(100),
  "linkman" varchar(100),
  "linkman_phone" varchar(100),
  "linkman_email" varchar(100),
  "city" varchar(100),
  "address" varchar(100),
  "introduction" varchar(255),
  "parent_id" int4,
  "parent_ids" varchar(255),
  "status" varchar(100),
  "comments" varchar(255),
  "is_valid" boolean default true,
  constraint pk_sys_organization primary key(id)
)WITH (
  OIDS=FALSE
);
ALTER TABLE sys_organization OWNER TO sfc;
alter table "sys_organization" alter column "id" set default nextval('sys_organization_seq');

drop sequence IF EXISTS "sys_resource_seq";
drop table IF EXISTS "sys_resource";

create sequence "sys_resource_seq"
    start with 1
    increment by 1
    no minvalue
    no maxvalue
    cache 1;
ALTER TABLE sys_resource_seq OWNER TO sfc;

create table "sys_resource" (
  id int4 default nextval('sys_resource_seq'::regclass),
  name varchar(100),
  type varchar(50),
  url varchar(200),
  parent_id int4,
  parent_ids varchar(100),
  permission varchar(200),
  available boolean default false,
  description  varchar(200),
  constraint pk_sys_resource primary key(id)
)WITH (
  OIDS=FALSE
);
ALTER TABLE sys_resource OWNER TO sfc;
alter table "sys_resource" alter column "id" set default nextval('sys_resource_seq');

drop sequence IF EXISTS "sys_role_seq";
drop table IF EXISTS "sys_role";

create sequence "sys_role_seq"
    start with 1
    increment by 1
    no minvalue
    no maxvalue
    cache 1;
ALTER TABLE sys_role_seq OWNER TO sfc;

create table "sys_role" (
  id int4 default nextval('sys_role_seq'::regclass),
  template_id int4,
  organization_id int4,
  role varchar(100),
  description varchar(100),
  resource_ids varchar(2000),
  available boolean default false,
  constraint pk_sys_role primary key(id)
)WITH (
  OIDS=FALSE
);
ALTER TABLE sys_role OWNER TO sfc;
alter table "sys_role" alter column "id" set default nextval('sys_role_seq');

drop sequence IF EXISTS "sys_news_seq";
drop table IF EXISTS "sys_news";

create sequence "sys_news_seq"
    start with 1
    increment by 1
    no minvalue
    no maxvalue
    cache 1;
ALTER TABLE sys_news_seq OWNER TO sfc;

create table "sys_news" (
  id int4 default nextval('sys_news_seq'::regclass),
  title varchar(100),
  author varchar(100),
  release_time timestamp without time zone,	
  news_type smallint,
  content varchar(2000),
  img varchar(100),
  available boolean default false,
  constraint pk_sys_news primary key(id)
)WITH (
  OIDS=FALSE
);
ALTER TABLE sys_news OWNER TO sfc;
alter table "sys_news" alter column "id" set default nextval('sys_news_seq');