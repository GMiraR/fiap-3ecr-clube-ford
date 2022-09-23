create table customers (
       uuid varchar(255) not null,
        document varchar(255),
        email varchar(255),
        first_name varchar(255),
        last_name varchar(255),
        status varchar(255),
        points_wallet int8,
        created_at timestamp,
        updated_at timestamp,
        primary key (uuid)
);

create table customers_rewards (
   customer_uuid varchar(255) not null,
    rewards_uuid varchar(255) not null
);

create table images (
   uuid varchar(255) not null,
    url text not null,
    primary key (uuid)
);


create table partners (
   uuid varchar(255) not null,
    created_at timestamp,
    description varchar(255),
    name varchar(255),
    updated_at timestamp,
    primary key (uuid)
);

create table reward_categories (
   uuid varchar(255) not null,
    description varchar(255),
    name varchar(255),
    created_at timestamp,
    updated_at timestamp,
    primary key (uuid)
);

create table rewards (
   uuid varchar(255) not null,
    created_at timestamp,
    description varchar(255),
    destination JSON,
    details JSON,
    images JSON,
    name varchar(255),
    points int8,
    status varchar(255),
    expire_at timestamp,
    updated_at timestamp,
    category_uuid varchar(255),
    partner_uuid varchar(255),
    primary key (uuid)
);

alter table customers 
   add constraint UK_it18e80awkffujkd8vnr5v1u5 unique (document);

alter table customers 
   add constraint UK_rfbvkrffamfql7cjmen8v976v unique (email);

alter table customers_rewards 
   add constraint UK_g6dcx0rm99ne9wfres0jctnko unique (rewards_uuid);
   
alter table reward_categories 
   add constraint UK_sftirmuv9f4pak2rvrcdwfcvh unique (name);
 

alter table rewards 
   add constraint UK_d3oq2ns8emieay4b9upqnb9a8 unique (name);
 

alter table customers_rewards 
   add constraint FK7pf2mlus6knlpovgde8kxx52f 
   foreign key (rewards_uuid) 
   references rewards;
 

alter table customers_rewards 
   add constraint FKc8q1am98y1pqd0io5ybus42tj 
   foreign key (customer_uuid) 
   references customers;
 

alter table rewards 
   add constraint FKl4lhj90fagcaqwtsjbyh863gy 
   foreign key (category_uuid) 
   references reward_categories;
 

alter table rewards 
   add constraint FKlqiwtdpgdq5y55vsb4ho6konl 
   foreign key (partner_uuid) 
   references partners;