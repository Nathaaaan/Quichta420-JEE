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
