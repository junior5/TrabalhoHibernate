-- Database: bancotrabalhohibernate

-- DROP DATABASE bancotrabalhohibernate;

CREATE DATABASE bancotrabalhohibernate
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Portuguese_Brazil.1252'
       LC_CTYPE = 'Portuguese_Brazil.1252'
       CONNECTION LIMIT = -1;

-- Table: public.cliente

\c bancotrabalhohibernate

-- DROP TABLE cliente;

CREATE TABLE cliente
(
  id integer NOT NULL DEFAULT nextval('cliente_id_seq'::regclass),
  nome character varying(60),
  sobrenome character varying(60),
  idade integer,
  sexo character varying(60)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE cliente
  OWNER TO postgres;
