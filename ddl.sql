create sequence hibernate_sequence start with 1 increment by 1;
create table passphrase
(
    passphrase_id bigint      not null,
    created       timestamp   not null,
    passkey       varchar(20) not null,
    primary key (passphrase_id)
);
create table word
(
    word_id       bigint       not null,
    word          varchar(255) not null,
    passphrase_id bigint       not null,
    primary key (word_id)
);
alter table passphrase
    add constraint UK_a3pb2f6tt93aer89b7ndn2e31 unique (passkey);
alter table word
    add constraint FKpsougjtl2ab3j1new78wig2rv foreign key (passphrase_id) references passphrase;
create sequence hibernate_sequence start with 1 increment by 1;
create table passphrase
(
    passphrase_id bigint      not null,
    created       timestamp   not null,
    passkey       varchar(20) not null,
    primary key (passphrase_id)
);
create table word
(
    word_id       bigint       not null,
    word          varchar(255) not null,
    passphrase_id bigint       not null,
    primary key (word_id)
);
alter table passphrase
    add constraint UK_a3pb2f6tt93aer89b7ndn2e31 unique (passkey);
alter table word
    add constraint FKpsougjtl2ab3j1new78wig2rv foreign key (passphrase_id) references passphrase;
