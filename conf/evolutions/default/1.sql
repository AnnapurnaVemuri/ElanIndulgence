# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table user_info (
  id                        integer not null,
  username                  varchar(255),
  email                     varchar(255),
  password                  varchar(255),
  constraint pk_user_info primary key (id))
;

create sequence user_info_seq;




# --- !Downs

drop table if exists user_info cascade;

drop sequence if exists user_info_seq;

