--------------------------------------------------------
--  SECUENCES for Table TCDS_MASTER_ITEMS           --
--------------------------------------------------------
CREATE SEQUENCE DLLCDS.SEQ_CDS_MASTER_ITEMS  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE NOCYCLE;

--------------------------------------------------------
--  DDL for Table TCDS_MASTER_ITEMS                 --
--------------------------------------------------------
CREATE TABLE DLLCDS.TCDS_MASTER_ITEMS
(
  NMID NUMBER (10,0) NOT NULL,
  DSITEM VARCHAR2 (20) DEFAULT ('ND') NOT NULL,
  NMMASTER_CATALOG NUMBER (10,0) DEFAULT (0) NOT NULL,
  FECREATED TIMESTAMP NOT NULL
);

COMMENT ON TABLE DLLCDS.TCDS_MASTER_ITEMS IS 'TABLA QUE CONTIENE LOS ITEMS DE LAS MAESTRAS';
COMMENT ON COLUMN DLLCDS.TCDS_MASTER_ITEMS.NMID IS 'IDENTIFICADOR DE CADA ITEM';
COMMENT ON COLUMN DLLCDS.TCDS_MASTER_ITEMS.DSITEM IS 'DESCRIPCIÓN DE CADA ITEM';
COMMENT ON COLUMN DLLCDS.TCDS_MASTER_ITEMS.NMMASTER_CATALOG IS 'IDENTIFICADOR DE LA MAESTRA A LA QUE PERTENECE EL ITEM';
COMMENT ON COLUMN DLLCDS.TCDS_MASTER_ITEMS.FECREATED IS 'FECHA DE CREACION DEL REGISTRO';

ALTER TABLE DLLCDS.TCDS_MASTER_ITEMS MODIFY FECREATED DEFAULT SYSDATE;
ALTER TABLE DLLCDS.TCDS_MASTER_ITEMS ADD CONSTRAINT TCDS_MASTER_ITEMS_PK PRIMARY KEY (NMID);
ALTER TABLE DLLCDS.TCDS_MASTER_ITEMS ADD CONSTRAINT TCDS_MASTER_ITEMS_FK01 FOREIGN KEY(NMMASTER_CATALOG) 
	REFERENCES DLLCDS.TCDS_MASTER_CATALOG(NMID);

CREATE OR REPLACE PUBLIC SYNONYM TCDS_MASTER_ITEMS FOR DLLCDS.TCDS_MASTER_ITEMS;


--------------------------------------------------------
--  DCL for Table TCDS_MASTER_ITEMS          --
--------------------------------------------------------
