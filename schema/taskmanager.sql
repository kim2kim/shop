create database taskmanager;
use taskmanager;

SET SESSION sql_mode='';

create table task_list(task_id int not null auto_increment, task_name varchar(100) not null, task_description text,task_priority varchar(20),task_status varchar(20),task_start_time datetime default 0,task_end_time datetime not null default 0,task_archived bool default false,primary key(task_id));

insert into task_list values(1,'Gathering Requirement','Requirement Gathering','MEDIUM','ACTIVE',NOW(),NOW() + INTERVAL 3 HOUR,0);
insert into task_list values(2,'Application Designing','Application Designing','MEDIUM','ACTIVE',NOW(),NOW() + INTERVAL 2 HOUR,0);
insert into task_list values(3,'Implementation','Implementation','MEDIUM','ACTIVE',NOW(),NOW() + INTERVAL 3 HOUR,0);
insert into task_list values(4,'Unit Testing','Unit Testing','LOW','ACTIVE',NOW(),NOW() + INTERVAL 4 HOUR,0);
insert into task_list values(5,'Maintanence','Maintanence','LOW','ACTIVE',NOW(),NOW() + INTERVAL 5 HOUR,0);

select * from task_list;
