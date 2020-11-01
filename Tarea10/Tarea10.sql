CREATE DATABASE registro;
USE registro;

CREATE TABLE carrera (
    idCarrera INT PRIMARY KEY,
    nombre VARCHAR(50)
);

CREATE TABLE estudiante (
    cta INT,
    nombre VARCHAR(50),
    idcarrera INT,
    FOREIGN KEY (idcarrera)
        REFERENCES carrera (idcarrera)
);

INSERT INTO carrera values(100,'ing en sistemas');
INSERT INTO carrera values(101,'ing civil');
INSERT INTO carrera values(102,'ing quimica');
INSERT INTO carrera values(103,'ing mecanica');
INSERT INTO carrera values(104,'ing electrica');
INSERT INTO carrera values(105,'ing industrial');
INSERT INTO carrera values(106,'ing agroindustrial');
INSERT INTO carrera values(107,'ing en alimentos');
INSERT INTO carrera values(108,'ing en software');
INSERT INTO carrera values(109,'ing informatica');

INSERT INTO estudiante values(10000, 'pedro lopez', 100);
INSERT INTO estudiante values(10001, 'luis lopez', 101);
INSERT INTO estudiante values(10002, 'juan lopez', 102);
INSERT INTO estudiante values(10003, 'porfirio lopez', 103);
INSERT INTO estudiante values(10004, 'mario lopez', 104);
INSERT INTO estudiante values(10005, 'jose lopez', 105);
INSERT INTO estudiante values(10006, 'oscar lopez', 106);
INSERT INTO estudiante values(10007, 'sebastian lopez', 107);
INSERT INTO estudiante values(10008, 'walter lopez', 108);
INSERT INTO estudiante values(10009, 'fredy lopez', 109);

SELECT * FROM estudiante;
SELECT * FROM estudiante WHERE cta = 10000;

DELETE FROM estudiante WHERE cta = 10000;
SELECT * FROM estudiante;

DELETE FROM estudiante;
SELECT * FROM estudiante;

