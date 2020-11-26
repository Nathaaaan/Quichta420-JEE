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
INSERT INTO ASSIGN(tutor_id,intern_id,internShip_Year) VALUES(1,2,2019);
INSERT INTO ASSIGN(tutor_id,intern_id,internShip_Year) VALUES(1,3,2020);
INSERT INTO ASSIGN(tutor_id,intern_id,internShip_Year) VALUES(1,4,2020);
INSERT INTO ASSIGN(tutor_id,intern_id,internShip_Year) VALUES(1,5,2020);
INSERT INTO ASSIGN(tutor_id,intern_id,internShip_Year) VALUES(2,6,2020);
INSERT INTO ASSIGN(tutor_id,intern_id,internShip_Year) VALUES(2,7,2019);
INSERT INTO ASSIGN(tutor_id,intern_id,internShip_Year) VALUES(2,8,2020);


INSERT INTO EXCEL(internship_id,cdc,fiche_visite,fiche_eval_entr,sondage_web,rapport_rendu,sout,planif,faite)
 VALUES(1,'false','false','false','false','false','false','false','false');
INSERT INTO EXCEL(internship_id,cdc,fiche_visite,fiche_eval_entr,sondage_web,rapport_rendu,sout,planif,faite)
 VALUES(2,'false','false','false','false','false','false','false','false');
INSERT INTO EXCEL(internship_id,cdc,fiche_visite,fiche_eval_entr,sondage_web,rapport_rendu,sout,planif,faite)
 VALUES(3,'false','false','false','false','false','false','false','false');
INSERT INTO EXCEL(internship_id,cdc,fiche_visite,fiche_eval_entr,sondage_web,rapport_rendu,sout,planif,faite)
 VALUES(4,'false','false','false','false','false','false','false','false');
 INSERT INTO EXCEL(internship_id,cdc,fiche_visite,fiche_eval_entr,sondage_web,rapport_rendu,sout,planif,faite)
 VALUES(5,'false','false','false','false','false','false','false','false');
INSERT INTO EXCEL(internship_id,cdc,fiche_visite,fiche_eval_entr,sondage_web,rapport_rendu,sout,planif,faite)
 VALUES(6,'false','false','false','false','false','false','false','false');
 INSERT INTO EXCEL(internship_id,cdc,fiche_visite,fiche_eval_entr,sondage_web,rapport_rendu,sout,planif,faite)
 VALUES(7,'false','false','false','false','false','false','false','false');
INSERT INTO EXCEL(internship_id,cdc,fiche_visite,fiche_eval_entr,sondage_web,rapport_rendu,sout,planif,faite)
 VALUES(8,'false','false','false','false','false','false','false','false');


INSERT INTO COMPANY(company_name,company_adress) VALUES('Google','1 avenue de la rue');
INSERT INTO COMPANY(company_name,company_adress) VALUES('Amazon','1 rue de l''avenue');
INSERT INTO COMPANY(company_name,company_adress) VALUES('Apple','1 boulevard de la rue');
INSERT INTO COMPANY(company_name,company_adress) VALUES('Facebook','1 avenue du boulevard');
INSERT INTO COMPANY(company_name,company_adress) VALUES('Quichta420','420 rue de la quichta');


INSERT INTO INTERNSHIPINFO(internship_id,company_id,master,start_date,end_date,description,meeting_info)
 VALUES (1,1,'Maes','2020-05-02','2020-08-20','description','meeting info');
INSERT INTO INTERNSHIPINFO(internship_id,company_id,master,start_date,end_date,description,meeting_info)
 VALUES (2,2,'Ninho','2020-04-05','2020-08-20','description','meeting info');
INSERT INTO INTERNSHIPINFO(internship_id,company_id,master,start_date,end_date,description,meeting_info)
 VALUES (3,1,'Booba','2020-03-01','2020-08-20','description','meeting info');
INSERT INTO INTERNSHIPINFO(internship_id,company_id,master,start_date,end_date,description,meeting_info)
 VALUES (4,3,'Karis','2020-05-02','2020-10-20','description','meeting info');
INSERT INTO INTERNSHIPINFO(internship_id,company_id,master,start_date,end_date,description,meeting_info)
 VALUES (5,1,'Sadek','2020-05-02','2020-08-05','description','meeting info');
INSERT INTO INTERNSHIPINFO(internship_id,company_id,master,start_date,end_date,description,meeting_info)
 VALUES (6,3,'PLK','2020-05-02','2020-08-20','description','meeting info');
INSERT INTO INTERNSHIPINFO(internship_id,company_id,master,start_date,end_date,description,meeting_info)
 VALUES (7,2,'Bosh','2020-05-02','2020-08-20','description','meeting info');
INSERT INTO INTERNSHIPINFO(internship_id,company_id,master,start_date,end_date,description,meeting_info)
 VALUES (8,1,'Oboy','2020-05-02','2020-08-20','description','meeting info');


INSERT INTO KeyWord(key_word) VALUES('cle1');
INSERT INTO KeyWord(key_word) VALUES('cle2');


INSERT INTO IsKeyWord(key_word, internship_id) VALUES('cle1',1);
INSERT INTO IsKeyWord(key_word, internship_id) VALUES('cle1',2);
INSERT INTO IsKeyWord(key_word, internship_id) VALUES('cle1',3);
INSERT INTO IsKeyWord(key_word, internship_id) VALUES('cle2',1);
INSERT INTO IsKeyWord(key_word, internship_id) VALUES('cle2',4);