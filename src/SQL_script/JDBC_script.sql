CREATE TABLE recording_groups (
	group_name	VARCHAR(30) NOT NULL,
	lead_singer	VARCHAR(30),
	year_formed	VARCHAR(4),
	genre		VARCHAR(30),
	CONSTRAINT recording_groups_pk
	PRIMARY KEY (group_name));

CREATE TABLE recording_studios(
	studio_name 	VARCHAR(30) NOT NULL,
	studio_address	VARCHAR(30),
	studio_owner	VARCHAR(30),
	studio_phone	VARCHAR(30),
	CONSTRAINT recording_studios_pk
	PRIMARY KEY (studio_name));

CREATE TABLE albums (
	album_title	VARCHAR(30) NOT NULL,
	group_name	VARCHAR(30) NOT NULL,
	studio_name	VARCHAR(30) NOT NULL,
	date_recorded	DATE,
	length		VARCHAR(10),
	number_of_songs	INTEGER,
	CONSTRAINT albums_pk
	PRIMARY KEY (album_title, group_name),
	CONSTRAINT albums_recording_groups_fk
	FOREIGN KEY (group_name) REFERENCES recording_groups(group_name),
	CONSTRAINT albums_recording_studios_fk
	FOREIGN KEY (studio_name) REFERENCES recording_studios(studio_name));



INSERT INTO recording_groups
VALUES ('Queen', 'Freddie Mercury', '1970', 'Rock');

INSERT INTO recording_groups
VALUES ('Taylor Swift', 'Taylor Swift', '2004', 'Pop');

INSERT INTO recording_groups
VALUES ('Ariana Grande', 'Ariana Grande', '2008', 'Pop');

INSERT INTO recording_groups
VALUES ('Taeyeon', 'Taeyeon', '2007', 'K-pop');

INSERT INTO recording_studios
VALUES ('Musicland Studios', 'Munich, Germany', 'Giorgo Moroder', '555-888-4444');

INSERT INTO recording_studios
VALUES ('Jungle City Studios', 'New York City, New York', 'Ann Mincieli', '222-333-4444');

INSERT INTO recording_studios
VALUES ('S.M. Entertainment', 'Seoul, South Korea', 'Lee Soo-Man', '123-456-7890');

INSERT INTO recording_studios
VALUES ('Republic Records', 'New York City, New York', 'Monte Lipman', '212-841-5100');

INSERT INTO albums
VALUES ('The Game', 'Queen', 'Musicland Studios', '1980-06-30', '35:39', 10);

INSERT INTO albums
VALUES ('1989', 'Taylor Swift', 'Jungle City Studios', '2014-10-27', '48:41', 13);

INSERT INTO albums
VALUES ('My Everything', 'Ariana Grande', 'Republic Records', '2014-08-22', '40:31', 16);

INSERT INTO albums
VALUES ('I', 'Taeyeon', 'S.M. Entertainment', '2015-10-07', '20:00', 6);
