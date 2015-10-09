CREATE TABLE recording_group (
	group_name	VARCHAR(30) NOT NULL,
	lead_singer	VARCHAR(30),
	year_formed	VARCHAR(4),
	genre		VARCHAR(30),
	CONSTRAINT recording_group_pk
	PRIMARY KEY (group_name));

CREATE TABLE recording_studio (
	studio_name 	VARCHAR(30) NOT NULL,
	studio_address	VARCHAR(30),
	studio_owner	VARCHAR(30),
	studio_phone	VARCHAR(30),
	CONSTRAINT recording_studio_pk
	PRIMARY KEY (studio_name));

CREATE TABLE album (
	album_title	VARCHAR(30) NOT NULL,
	group_name	VARCHAR(30) NOT NULL,
	studio_name	VARCHAR(30) NOT NULL,
	date_recorded	DATE,
	length		VARCHAR(10),
	number_of_songs	INTEGER,
	CONSTRAINT album_pk
	PRIMARY KEY (album_title, group_name),
	CONSTRAINT album_recording_group_fk
	FOREIGN KEY (group_name) REFERENCES recording_group(group_name),
	CONSTRAINT album_recording_studio_fk
	FOREIGN KEY (studio_name) REFERENCES recording_studio(studio_name));



INSERT INTO recording_group
VALUES ('Queen', 'Freddie Mercury', '1970', 'Rock');

INSERT INTO recording_group
VALUES ('Taylor Swift', 'Taylor Swift', '2004', 'Pop');

INSERT INTO recording_group
VALUES ('Perfume', 'Ayaka Nishikawa', '2000', 'J-pop');

INSERT INTO recording_group
VALUES ('Taeyeon', 'Taeyeon', '2007', 'K-pop');

INSERT INTO recording_studio
VALUES ('Musicland Studios', 'Munich, Germany', 'Giorgo Moroder', '555-888-4444');

INSERT INTO recording_studio
VALUES ('Jungle City Studios', 'New York City, New York', 'Ann Mincieli', '222-333-4444');

INSERT INTO recording_studio
VALUES ('S.M. Entertainment', 'Seoul, South Korea', 'Lee Soo-Man', '123-456-7890');

INSERT INTO recording_studio
VALUES ('Tokuma Japan Communications', 'Tokyo, Japan', 'Tokuma Yasuyoshi', '999-KIM-OCHI');

INSERT INTO album
VALUES ('The Game', 'Queen', 'Musicland Studios', '1980-06-30', '35:39', 10);

INSERT INTO album
VALUES ('1989', 'Taylor Swift', 'Jungle City Studios', '2014-10-27', '48:41', 13);

INSERT INTO album
VALUES ('JPN', 'Perfume', 'Tokuma Japan Communications', '2011-11-30', '55:10', 14);

INSERT INTO album
VALUES ('I', 'Taeyeon', 'S.M. Entertainment', '2015-10-07', '20:00', 6); 
