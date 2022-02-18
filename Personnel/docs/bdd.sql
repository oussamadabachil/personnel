CREATE TABLE EMPLOYE (
  idEmploye INT AUTO_INCREMENT,
  nomEmploye VARCHAR(42),
  prenomEmploye VARCHAR(42),
  mailEmploye VARCHAR(42),
  mdpEmploye VARCHAR(42),
  dateArrivee DATE,
  dateDepart DATE,
  typeEmploye TINYINT,
  idLigue INT,
  PRIMARY KEY (idEmploye)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE LIGUE (
  idLigue INT AUTO_INCREMENT,
  nomLigue VARCHAR(42),
  PRIMARY KEY (idLigue)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE EMPLOYE ADD FOREIGN KEY (idLigue) REFERENCES LIGUE (idLigue);