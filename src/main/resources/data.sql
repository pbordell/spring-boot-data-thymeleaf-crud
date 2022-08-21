drop table MOVIE;

CREATE TABLE MOVIE
(
    ID        NUMBER(8,0) NOT NULL,
    NAME      VARCHAR(50) NOT NULL,
    YEAR 	  NUMBER(4,0) NOT NULL,
    DIRECTOR  VARCHAR(50) NOT NULL,
    COVER     BLOB,
    CONSTRAINT SCHEDULER_JOB_INFO_PK PRIMARY KEY (ID)
);

drop SEQUENCE SEQ_ID_MOVIE;
CREATE SEQUENCE SEQ_ID_MOVIE START WITH 1 INCREMENT BY 1;

INSERT INTO MOVIE (ID,NAME,YEAR,DIRECTOR,COVER) VALUES(1, 'El cabo del miedo',1991,'Martin Scorsese',null);
INSERT INTO MOVIE (ID,NAME,YEAR,DIRECTOR,COVER) VALUES(2, 'Antes del amanecer',1995,'Richard Linklater',null);
INSERT INTO MOVIE (ID,NAME,YEAR,DIRECTOR,COVER) VALUES(3, 'Matrix',1999,'Wachowski',null);
INSERT INTO MOVIE (ID,NAME,YEAR,DIRECTOR,COVER) VALUES(4, 'Seven',1995,'David Fincher',null);
INSERT INTO MOVIE (ID,NAME,YEAR,DIRECTOR,COVER) VALUES(5, 'Reservoir dogs',1992,'Quentin Tarantino',null); 
INSERT INTO MOVIE (ID,NAME,YEAR,DIRECTOR,COVER) VALUES(6, 'El club de la lucha',1999,'David Fincher',null);
INSERT INTO MOVIE (ID,NAME,YEAR,DIRECTOR,COVER) VALUES(8, 'Terminator 2',1991,'James Cameron',null);
INSERT INTO MOVIE (ID,NAME,YEAR,DIRECTOR,COVER) VALUES(9, 'El gran Lebowsky',1998, 'Coen',null);
INSERT INTO MOVIE (ID,NAME,YEAR,DIRECTOR,COVER) VALUES(10, 'American history X',1999, 'Tony Kaye',null);

COMMIT;