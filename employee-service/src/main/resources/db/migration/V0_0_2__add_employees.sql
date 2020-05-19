-- noinspection SqlNoDataSourceInspectionForFile

alter table employee modify column id int auto_increment;
insert into employee (name, email) values
("Charles Xavier", "profx@xmen.com")
,("Erik Lensherr", "magneto@brotherhood.com")
,("James Howlett", "wolverine@xmen.com")
,("Scott Summers", "cyclops@xmen.com")
,("Ororo Munroe", "storm@xmen.com")
,("Jean Grey", "profx@xmen.com")
,("Pietro Maximoff", "quicksilver@brotherhood.com")
,("Wanda Maximoff", "scarletwitch@brotherhood.com")
,("Mortimer Toynbee", "toad@brotherhood.com")
,("John Allerdyce", "pyro@brotherhood.com");
