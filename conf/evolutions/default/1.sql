# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table merchant (
  merchant_id               integer not null,
  name                      varchar(255),
  username                  varchar(255),
  email                     varchar(255),
  password                  varchar(255),
  is_designer               boolean,
  constraint pk_merchant primary key (merchant_id))
;

create table user_info (
  id                        integer not null,
  username                  varchar(255),
  email                     varchar(255),
  password                  varchar(255),
  constraint pk_user_info primary key (id))
;

create sequence merchant_seq;

create sequence user_info_seq;




# --- !Downs

drop table if exists merchant cascade;

drop table if exists user_info cascade;

drop sequence if exists merchant_seq;

drop sequence if exists user_info_seq;

