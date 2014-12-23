# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table custom_order_messages (
  msg_id                    integer not null,
  order_id                  integer,
  message                   varchar(255),
  from_cust                 boolean,
  date_created              timestamp,
  constraint pk_custom_order_messages primary key (msg_id))
;

create table custom_orders (
  id                        integer not null,
  cust_id                   integer,
  merchant_id               integer,
  prod_type_id              integer,
  color_id                  integer,
  qty                       integer,
  date_created              timestamp,
  status                    boolean,
  descr                     varchar(255),
  constraint pk_custom_orders primary key (id))
;

create table customized_orders (
  id                        integer not null,
  custusername              varchar(255),
  merchantname              varchar(255),
  prodtype                  varchar(255),
  budgetrange               varchar(255),
  description               varchar(255),
  colors_list               varchar(255),
  constraint pk_customized_orders primary key (id))
;

create table order_ui (
  id                        integer not null,
  prod_id                   integer,
  merchant_name             varchar(255),
  qty                       integer,
  date_created              timestamp,
  prod_type                 varchar(255),
  constraint pk_order_ui primary key (id))
;

create table orders (
  id                        integer not null,
  cust_id                   integer,
  merchant_id               integer,
  prod_id                   integer,
  qty                       integer,
  date_created              timestamp,
  constraint pk_orders primary key (id))
;

create table random (
  id                        integer not null,
  random_string             varchar(255),
  constraint pk_random primary key (id))
;

create table random3 (
  id                        integer not null,
  constraint pk_random3 primary key (id))
;

create table user_info (
  id                        integer not null,
  username                  varchar(255),
  email                     varchar(255),
  password                  varchar(255),
  constraint pk_user_info primary key (id))
;

create sequence custom_order_messages_seq;

create sequence custom_orders_seq;

create sequence customized_orders_seq;

create sequence order_ui_seq;

create sequence orders_seq;

create sequence random_seq;

create sequence random3_seq;

create sequence user_info_seq;




# --- !Downs

drop table if exists custom_order_messages cascade;

drop table if exists custom_orders cascade;

drop table if exists customized_orders cascade;

drop table if exists order_ui cascade;

drop table if exists orders cascade;

drop table if exists random cascade;

drop table if exists random3 cascade;

drop table if exists user_info cascade;

drop sequence if exists custom_order_messages_seq;

drop sequence if exists custom_orders_seq;

drop sequence if exists customized_orders_seq;

drop sequence if exists order_ui_seq;

drop sequence if exists orders_seq;

drop sequence if exists random_seq;

drop sequence if exists random3_seq;

drop sequence if exists user_info_seq;

