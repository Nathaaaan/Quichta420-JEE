/*-- DROP --*/

DROP TABLE IsKeyWord;
DROP TABLE KeyWord;
DROP TABLE InternshipInfo;
DROP TABLE Excel;
DROP TABLE Company;
DROP TABLE Assign;
DROP TABLE Intern;
DROP TABLE SchoolGroup;
DROP TABLE Tutor;

/*-- CREATE --*/

CREATE TABLE Tutor(
	tutor_id INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	first_name VARCHAR(40),
	last_name VARCHAR(40),
	login VARCHAR(40),
	password VARCHAR(40),

	PRIMARY KEY(tutor_id)
);

CREATE TABLE SchoolGroup(
	SchoolGroup_name VARCHAR(10) PRIMARY KEY
);

CREATE TABLE Intern(
	intern_id INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	first_name VARCHAR(40),
	last_name VARCHAR(40),
	SchoolGroup_name VARCHAR(10),

	PRIMARY KEY(intern_id),
	FOREIGN KEY(SchoolGroup_name) REFERENCES SchoolGroup(SchoolGroup_name)
);

CREATE TABLE Assign(
	internship_id INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	tutor_id INT,
	intern_id INT,
	internship_year INT,

	PRIMARY KEY(internship_id),
	FOREIGN KEY(tutor_id) REFERENCES Tutor(tutor_id),
	FOREIGN KEY(intern_id) REFERENCES Intern(intern_id)
);

CREATE TABLE Excel(
	excel_id INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	cdc boolean,
	fiche_visite boolean,
	fiche_eval_entr boolean,
	sondage_web boolean,
	rapport_rendu boolean,
	sout boolean,
	planif boolean,
	faite boolean,
	note_tech INT,
	note_com INT,

	PRIMARY KEY(excel_id)
);

CREATE TABLE Company(
	company_id INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	company_name VARCHAR(30),
	company_adress VARCHAR(80),

	PRIMARY KEY(company_id)
);

CREATE TABLE InternshipInfo(
	internship_id INT,
	company_id INT,
	master VARCHAR(60),
	start_date DATE,
	end_date DATE,
	description VARCHAR(200),
	meeting_info VARCHAR(100),
	intern_comment VARCHAR(200),
	tutor_comment VARCHAR(200),
	linkedin_profile VARCHAR(60),
	excel_id INT,

	PRIMARY KEY(internship_id),
	FOREIGN KEY(internship_id) REFERENCES Assign(internship_id),
	FOREIGN KEY(excel_id) REFERENCES Excel(excel_id),
	FOREIGN KEY(company_id) REFERENCES Company(company_id)
);

CREATE TABLE KeyWord(
	key_word VARCHAR(30),

	PRIMARY KEY(key_word)
);

CREATE TABLE IsKeyWord(
	key_word VARCHAR(30),
	internship_id INT,

	PRIMARY KEY(key_word,internship_id),
	FOREIGN KEY(key_word) REFERENCES KeyWord(key_word),
	FOREIGN KEY(internship_id) REFERENCES InternshipInfo(internship_id)
);

/*-- INSERT --*/

/* IF DATABASE ALREADY CREATED YOU MUST DROP ALL TABLE AND RECREATE IT BEFORE EXECUTE THIS SCRIPT */

INSERT INTO TUTOR(first_name,last_name,login,password) VALUES('Jean','Yves','jy','jy');
INSERT INTO TUTOR(first_name,last_name,login,password) VALUES('Jean','Soma','js','js');
INSERT INTO TUTOR(first_name,last_name,login,password) VALUES('Frederique','Meunier','fredo','8000euros');


INSERT INTO SCHOOLGROUP(SchoolGroup_name) VALUES('L1');
INSERT INTO SCHOOLGROUP(SchoolGroup_name) VALUES('L2');
INSERT INTO SCHOOLGROUP(SchoolGroup_name) VALUES('L3');
INSERT INTO SCHOOLGROUP(SchoolGroup_name) VALUES('M1');
INSERT INTO SCHOOLGROUP(SchoolGroup_name) VALUES('M2');


INSERT INTO INTERN(first_name,last_name,SchoolGroup_name) VALUES('Antoine','Banniel','M1');
INSERT INTO INTERN(first_name,last_name,SchoolGroup_name) VALUES('Ryan','Viehweger','M1');
INSERT INTO INTERN(first_name,last_name,SchoolGroup_name) VALUES('Seedy','Jobe','M1');
INSERT INTO INTERN(first_name,last_name,SchoolGroup_name) VALUES('Andriatiana','Rakotondranoro','M1');
INSERT INTO INTERN(first_name,last_name,SchoolGroup_name) VALUES('Nathan','Picchiottino','M1');
INSERT INTO INTERN(first_name,last_name,SchoolGroup_name) VALUES('Hugo','Mignotte','M1');
INSERT INTO INTERN(first_name,last_name,SchoolGroup_name) VALUES('Kouba','LaD','L1');
INSERT INTO INTERN(first_name,last_name,SchoolGroup_name) VALUES('Jul','LeS','L3');


INSERT INTO ASSIGN(tutor_id,intern_id,internShip_Year) VALUES(1,1,2020);
INSERT INTO ASSIGN(tutor_id,intern_id,internShip_Year) VALUES(1,2,2020);
INSERT INTO ASSIGN(tutor_id,intern_id,internShip_Year) VALUES(1,3,2020);
INSERT INTO ASSIGN(tutor_id,intern_id,internShip_Year) VALUES(1,4,2020);
INSERT INTO ASSIGN(tutor_id,intern_id,internShip_Year) VALUES(1,5,2020);
INSERT INTO ASSIGN(tutor_id,intern_id,internShip_Year) VALUES(2,6,2020);
INSERT INTO ASSIGN(tutor_id,intern_id,internShip_Year) VALUES(2,7,2020);
INSERT INTO ASSIGN(tutor_id,intern_id,internShip_Year) VALUES(2,8,2020);


INSERT INTO EXCEL(cdc,fiche_visite,fiche_eval_entr,sondage_web,rapport_rendu,sout,planif,faite)
 VALUES('true','true','false','false','false','false','false','false');
INSERT INTO EXCEL(cdc,fiche_visite,fiche_eval_entr,sondage_web,rapport_rendu,sout,planif,faite)
 VALUES('false','false','false','false','false','false','false','false');
INSERT INTO EXCEL(cdc,fiche_visite,fiche_eval_entr,sondage_web,rapport_rendu,sout,planif,faite)
 VALUES('false','true','false','false','false','false','false','false');
INSERT INTO EXCEL(cdc,fiche_visite,fiche_eval_entr,sondage_web,rapport_rendu,sout,planif,faite)
 VALUES('true','false','true','false','false','false','false','false');
INSERT INTO EXCEL(cdc,fiche_visite,fiche_eval_entr,sondage_web,rapport_rendu,sout,planif,faite)
 VALUES('false','false','false','false','false','false','false','false');
INSERT INTO EXCEL(cdc,fiche_visite,fiche_eval_entr,sondage_web,rapport_rendu,sout,planif,faite)
 VALUES('false','false','true','false','false','false','false','false');
INSERT INTO EXCEL(cdc,fiche_visite,fiche_eval_entr,sondage_web,rapport_rendu,sout,planif,faite)
 VALUES('false','false','false','false','false','false','false','true');
INSERT INTO EXCEL(cdc,fiche_visite,fiche_eval_entr,sondage_web,rapport_rendu,sout,planif,faite)
 VALUES('false','false','false','false','true','false','false','false');


INSERT INTO COMPANY(company_name,company_adress) VALUES('Google','1 avenue de la rue');
INSERT INTO COMPANY(company_name,company_adress) VALUES('Amazon','1 rue de l''avenue');
INSERT INTO COMPANY(company_name,company_adress) VALUES('Apple','1 boulevard de la rue');
INSERT INTO COMPANY(company_name,company_adress) VALUES('Facebook','1 avenue du boulevard');
INSERT INTO COMPANY(company_name,company_adress) VALUES('Quichta420','420 rue de la quichta');


INSERT INTO INTERNSHIPINFO(internship_id,excel_id,company_id,master,start_date,end_date,description,meeting_info)
 VALUES (1,1,1,'Maes','2020-05-02','2020-08-20','description','meeting info');
INSERT INTO INTERNSHIPINFO(internship_id,excel_id,company_id,master,start_date,end_date,description,meeting_info)
 VALUES (2,2,2,'Ninho','2020-04-05','2020-08-20','description','meeting info');
INSERT INTO INTERNSHIPINFO(internship_id,excel_id,company_id,master,start_date,end_date,description,meeting_info)
 VALUES (3,3,1,'Booba','2020-03-01','2020-08-20','description','meeting info');
INSERT INTO INTERNSHIPINFO(internship_id,excel_id,company_id,master,start_date,end_date,description,meeting_info)
 VALUES (4,4,3,'Karis','2020-05-02','2020-10-20','description','meeting info');
INSERT INTO INTERNSHIPINFO(internship_id,excel_id,company_id,master,start_date,end_date,description,meeting_info)
 VALUES (5,5,1,'Sadek','2020-05-02','2020-08-05','description','meeting info');
INSERT INTO INTERNSHIPINFO(internship_id,excel_id,company_id,master,start_date,end_date,description,meeting_info)
 VALUES (6,6,3,'PLK','2020-05-02','2020-08-20','description','meeting info');
INSERT INTO INTERNSHIPINFO(internship_id,excel_id,company_id,master,start_date,end_date,description,meeting_info)
 VALUES (7,7,2,'Bosh','2020-05-02','2020-08-20','description','meeting info');
INSERT INTO INTERNSHIPINFO(internship_id,excel_id,company_id,master,start_date,end_date,description,meeting_info)
 VALUES (8,8,1,'Oboy','2020-05-02','2020-08-20','description','meeting info');