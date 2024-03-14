-- soccer JPA 버전

SELECT * FROM stadium;
DROP TABLE stadium;

SELECT * FROM schedule;
DROP TABLE schedule;

SELECT * FROM team;
DROP TABLE team;

SELECT * FROM player;
DROP TABLE player;


CREATE TABLE stadium(
id INT NOT NULL AUTO_INCREMENT,
statium_name VARCHAR(40),
hometeam VARCHAR(10),
seat_count INTEGER,
address VARCHAR(60),
ddd VARCHAR(10),
tel VARCHAR(10),
PRIMARY KEY(id)
);

CREATE TABLE schedule(
id INT NOT NULL AUTO_INCREMENT,
gubun VARCHAR(10),
hometeam_id VARCHAR(10),
awayteam_id VARCHAR(10),
home_score INTEGER,
away_score INTEGER,
sta_id INT,
PRIMARY KEY(id),
FOREIGN KEY(sta_id) REFERENCES stadium(id)
);

CREATE TABLE team(
id INT NOT NULL AUTO_INCREMENT,
region_name VARCHAR(10),
team_name VARCHAR(10),
e_team_name VARCHAR(40),
orig_yyyy VARCHAR(10),
zip_code1 VARCHAR(10),
zip_code2 VARCHAR(10),
address VARCHAR(80),
ddd VARCHAR(10),
tel VARCHAR(10),
fax VARCHAR(10),
homepage VARCHAR(50),
owner VARCHAR(10),
sta_id INT,
PRIMARY KEY(id),
FOREIGN KEY(sta_id) REFERENCES stadium(id)
);

CREATE TABLE player(
id INT NOT NULL AUTO_INCREMENT,
player_name VARCHAR(10),
e_player_name VARCHAR(40),
nickname VARCHAR(30),
join_yyyy VARCHAR(10),
position VARCHAR(10),
back_no INTEGER,
nation VARCHAR(20),
birth_date DATE,
solar VARCHAR(10),
height INTEGER,
weight INTEGER,
team_id int,
PRIMARY KEY (id),
FOREIGN KEY(team_id) REFERENCES team(id)
);