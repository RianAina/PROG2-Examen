CREATE DATABASE gestion_notes_bacc ;

\c gestion_notes_bacc

CREATE TABLE eleves (
    id INT PRIMARY KEY,
    first_name VARCHAR (150) NOT NULL,
    last_name VARCHAR (150) NOT NULL,
    serie CHAR (3),
    CONSTRAINT Serie CHECK (serie IN ('A1','A2','C', 'D','S','L','OSE'))
);

CREATE TABLE matiere (
    id INT PRIMARY KEY,
    name VARCHAR (150) NOT NULL
);


CREATE TABLE inscription_matiere(
    id SERIAL PRIMARY KEY,
    id_eleves INT,
    id_matiere INT,
    note INT NOT NULL,
    FOREIGN KEY (id_eleves) REFERENCES eleves (id),
    FOREIGN KEY (id_matiere) REFERENCES matiere (id)
);