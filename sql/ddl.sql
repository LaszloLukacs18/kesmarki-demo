use demodb
go

create sequence dbo.address_seq
    start with 1
    increment by 50
go

create sequence dbo.contact_seq
    start with 1
    increment by 50
go

create sequence dbo.person_seq
    start with 1
    increment by 50
go

create table dbo.person
(
    id                    int not null
        primary key,
    first_name            varchar(255),
    last_name             varchar(255),
    primary_contact_email varchar(255)
)
go

create table dbo.address
(
    id           int      not null
        primary key,
    address_type smallint not null
        check ([address_type] >= 0 AND [address_type] <= 1),
    city         varchar(255),
    house_number int      not null,
    postal_code  varchar(255),
    street       varchar(255),
    person_id    int
        constraint FK81ihijcn1kdfwffke0c0sjqeb
            references dbo.person
)
go

create table dbo.contact
(
    id           int      not null
        primary key,
    contact_type smallint not null
        check ([contact_type] >= 0 AND [contact_type] <= 1),
    value        varchar(255),
    address_id   int
        constraint FKl0sju2uai8cgdtic18wy5hlfr
            references dbo.address
)
go

create unique index UK_8tgtjwyhvpi16na7pw1lguypu
    on dbo.person (primary_contact_email)
    where [primary_contact_email] IS NOT NULL
go

