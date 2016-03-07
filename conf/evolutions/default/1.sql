# --- Created by Ebean DD
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table baked_goods (
  id                        bigserial not null,
  title                     varchar(255),
  time_to_bake              varchar(255),
  constraint pk_baked_goods primary key (id))
;




# --- !Downs

drop table if exists baked_goods cascade;

