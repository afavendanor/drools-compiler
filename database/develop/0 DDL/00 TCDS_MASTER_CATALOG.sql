--------------------------------------------------------
--  SECUENCES for Table TCDS_MASTER_CATALOG           --
--------------------------------------------------------
CREATE SEQUENCE DLLCDS.SEQ_CDS_MASTER_CATALOG  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE NOCYCLE;

--------------------------------------------------------
--  DDL for Table TCDS_MASTER_CATALOG                 --
--------------------------------------------------------
CREATE TABLE DLLCDS.TCDS_MASTER_CATALOG
(
  NMID NUMBER (10,0) NOT NULL,
  DSMASTER VARCHAR2 (255) DEFAULT ('ND') NOT NULL,
  FECREATED TIMESTAMP NOT NULL
);

COMMENT ON TABLE DLLCDS.TCDS_MASTER_CATALOG IS 'TABLA CATALOGO DE MAESTRAS';
COMMENT ON COLUMN DLLCDS.TCDS_MASTER_CATALOG.NMID IS 'IDENTIFICADOR DE CADA MAESTRA';
COMMENT ON COLUMN DLLCDS.TCDS_MASTER_CATALOG.DSMASTER IS 'DESCRIPCION DE CADA MAESTRA';
COMMENT ON COLUMN DLLCDS.TCDS_MASTER_CATALOG.FECREATED IS 'FECHA DE CREACION DEL REGISTRO';

ALTER TABLE DLLCDS.TCDS_MASTER_CATALOG ADD CONSTRAINT TCDS_MASTER_CATALOG_PK PRIMARY KEY (NMID);
ALTER TABLE DLLCDS.TCDS_MASTER_CATALOG MODIFY FECREATED DEFAULT SYSDATE;

CREATE OR REPLACE PUBLIC SYNONYM TCDS_MASTER_CATALOG FOR DLLCDS.TCDS_MASTER_CATALOG;

--------------------------------------------------------
--  DCL for Table TCDS_MASTER_CATALOG          --
--------------------------------------------------------