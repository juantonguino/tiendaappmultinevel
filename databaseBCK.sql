--
-- PostgreSQL database dump
--

-- Dumped from database version 12.13 (Debian 12.13-1.pgdg110+1)
-- Dumped by pg_dump version 15.1

-- Started on 2023-06-26 20:34:33

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 6 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: sonartest
--

-- *not* creating schema, since initdb creates it


ALTER SCHEMA public OWNER TO sonartest;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 205 (class 1259 OID 74682)
-- Name: categorias; Type: TABLE; Schema: public; Owner: tiendaelectronicauser
--

CREATE TABLE public.categorias (
    id integer NOT NULL,
    nombre character varying(10) NOT NULL,
    descripcion character varying(255)
);


ALTER TABLE public.categorias OWNER TO tiendaelectronicauser;

--
-- TOC entry 204 (class 1259 OID 74680)
-- Name: categorias_id_seq; Type: SEQUENCE; Schema: public; Owner: tiendaelectronicauser
--

CREATE SEQUENCE public.categorias_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.categorias_id_seq OWNER TO tiendaelectronicauser;

--
-- TOC entry 3036 (class 0 OID 0)
-- Dependencies: 204
-- Name: categorias_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: tiendaelectronicauser
--

ALTER SEQUENCE public.categorias_id_seq OWNED BY public.categorias.id;


--
-- TOC entry 211 (class 1259 OID 74711)
-- Name: clientes; Type: TABLE; Schema: public; Owner: tiendaelectronicauser
--

CREATE TABLE public.clientes (
    id integer NOT NULL,
    tipo_id integer NOT NULL,
    nombres character varying(50) NOT NULL,
    apellidos character varying(50) NOT NULL,
    documento character varying(50) NOT NULL,
    estado character varying(1) NOT NULL
);


ALTER TABLE public.clientes OWNER TO tiendaelectronicauser;

--
-- TOC entry 210 (class 1259 OID 74709)
-- Name: clientes_id_seq; Type: SEQUENCE; Schema: public; Owner: tiendaelectronicauser
--

CREATE SEQUENCE public.clientes_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.clientes_id_seq OWNER TO tiendaelectronicauser;

--
-- TOC entry 3037 (class 0 OID 0)
-- Dependencies: 210
-- Name: clientes_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: tiendaelectronicauser
--

ALTER SEQUENCE public.clientes_id_seq OWNED BY public.clientes.id;


--
-- TOC entry 215 (class 1259 OID 74742)
-- Name: detallepedido; Type: TABLE; Schema: public; Owner: tiendaelectronicauser
--

CREATE TABLE public.detallepedido (
    id integer NOT NULL,
    pedi_id integer NOT NULL,
    prod_id integer NOT NULL,
    cantidad numeric(19,2) NOT NULL,
    valor numeric(19,2) NOT NULL
);


ALTER TABLE public.detallepedido OWNER TO tiendaelectronicauser;

--
-- TOC entry 214 (class 1259 OID 74740)
-- Name: detallepedido_id_seq; Type: SEQUENCE; Schema: public; Owner: tiendaelectronicauser
--

CREATE SEQUENCE public.detallepedido_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.detallepedido_id_seq OWNER TO tiendaelectronicauser;

--
-- TOC entry 3038 (class 0 OID 0)
-- Dependencies: 214
-- Name: detallepedido_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: tiendaelectronicauser
--

ALTER SEQUENCE public.detallepedido_id_seq OWNED BY public.detallepedido.id;


--
-- TOC entry 203 (class 1259 OID 74674)
-- Name: estadospedido; Type: TABLE; Schema: public; Owner: tiendaelectronicauser
--

CREATE TABLE public.estadospedido (
    id integer NOT NULL,
    descripcion character varying(10) NOT NULL
);


ALTER TABLE public.estadospedido OWNER TO tiendaelectronicauser;

--
-- TOC entry 202 (class 1259 OID 74672)
-- Name: estadospedido_id_seq; Type: SEQUENCE; Schema: public; Owner: tiendaelectronicauser
--

CREATE SEQUENCE public.estadospedido_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.estadospedido_id_seq OWNER TO tiendaelectronicauser;

--
-- TOC entry 3039 (class 0 OID 0)
-- Dependencies: 202
-- Name: estadospedido_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: tiendaelectronicauser
--

ALTER SEQUENCE public.estadospedido_id_seq OWNED BY public.estadospedido.id;


--
-- TOC entry 213 (class 1259 OID 74724)
-- Name: pedidos; Type: TABLE; Schema: public; Owner: tiendaelectronicauser
--

CREATE TABLE public.pedidos (
    id integer NOT NULL,
    clie_id integer NOT NULL,
    espe_id integer NOT NULL,
    fecha timestamp without time zone NOT NULL,
    total numeric(19,2) NOT NULL
);


ALTER TABLE public.pedidos OWNER TO tiendaelectronicauser;

--
-- TOC entry 212 (class 1259 OID 74722)
-- Name: pedidos_id_seq; Type: SEQUENCE; Schema: public; Owner: tiendaelectronicauser
--

CREATE SEQUENCE public.pedidos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pedidos_id_seq OWNER TO tiendaelectronicauser;

--
-- TOC entry 3040 (class 0 OID 0)
-- Dependencies: 212
-- Name: pedidos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: tiendaelectronicauser
--

ALTER SEQUENCE public.pedidos_id_seq OWNED BY public.pedidos.id;


--
-- TOC entry 209 (class 1259 OID 74698)
-- Name: productos; Type: TABLE; Schema: public; Owner: tiendaelectronicauser
--

CREATE TABLE public.productos (
    id integer NOT NULL,
    cate_id integer NOT NULL,
    referencia character varying(10) NOT NULL,
    nombre character varying(50) NOT NULL,
    descripcion character varying(255),
    precio_unitario numeric(19,2),
    unidades_disponibles numeric(19,2)
);


ALTER TABLE public.productos OWNER TO tiendaelectronicauser;

--
-- TOC entry 208 (class 1259 OID 74696)
-- Name: productos_id_seq; Type: SEQUENCE; Schema: public; Owner: tiendaelectronicauser
--

CREATE SEQUENCE public.productos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.productos_id_seq OWNER TO tiendaelectronicauser;

--
-- TOC entry 3041 (class 0 OID 0)
-- Dependencies: 208
-- Name: productos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: tiendaelectronicauser
--

ALTER SEQUENCE public.productos_id_seq OWNED BY public.productos.id;


--
-- TOC entry 207 (class 1259 OID 74690)
-- Name: tipodocumento; Type: TABLE; Schema: public; Owner: tiendaelectronicauser
--

CREATE TABLE public.tipodocumento (
    id integer NOT NULL,
    descripcion character varying(10) NOT NULL
);


ALTER TABLE public.tipodocumento OWNER TO tiendaelectronicauser;

--
-- TOC entry 206 (class 1259 OID 74688)
-- Name: tipodocumento_id_seq; Type: SEQUENCE; Schema: public; Owner: tiendaelectronicauser
--

CREATE SEQUENCE public.tipodocumento_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipodocumento_id_seq OWNER TO tiendaelectronicauser;

--
-- TOC entry 3042 (class 0 OID 0)
-- Dependencies: 206
-- Name: tipodocumento_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: tiendaelectronicauser
--

ALTER SEQUENCE public.tipodocumento_id_seq OWNED BY public.tipodocumento.id;


--
-- TOC entry 2864 (class 2604 OID 74685)
-- Name: categorias id; Type: DEFAULT; Schema: public; Owner: tiendaelectronicauser
--

ALTER TABLE ONLY public.categorias ALTER COLUMN id SET DEFAULT nextval('public.categorias_id_seq'::regclass);


--
-- TOC entry 2867 (class 2604 OID 74714)
-- Name: clientes id; Type: DEFAULT; Schema: public; Owner: tiendaelectronicauser
--

ALTER TABLE ONLY public.clientes ALTER COLUMN id SET DEFAULT nextval('public.clientes_id_seq'::regclass);


--
-- TOC entry 2869 (class 2604 OID 74745)
-- Name: detallepedido id; Type: DEFAULT; Schema: public; Owner: tiendaelectronicauser
--

ALTER TABLE ONLY public.detallepedido ALTER COLUMN id SET DEFAULT nextval('public.detallepedido_id_seq'::regclass);


--
-- TOC entry 2863 (class 2604 OID 74677)
-- Name: estadospedido id; Type: DEFAULT; Schema: public; Owner: tiendaelectronicauser
--

ALTER TABLE ONLY public.estadospedido ALTER COLUMN id SET DEFAULT nextval('public.estadospedido_id_seq'::regclass);


--
-- TOC entry 2868 (class 2604 OID 74727)
-- Name: pedidos id; Type: DEFAULT; Schema: public; Owner: tiendaelectronicauser
--

ALTER TABLE ONLY public.pedidos ALTER COLUMN id SET DEFAULT nextval('public.pedidos_id_seq'::regclass);


--
-- TOC entry 2866 (class 2604 OID 74701)
-- Name: productos id; Type: DEFAULT; Schema: public; Owner: tiendaelectronicauser
--

ALTER TABLE ONLY public.productos ALTER COLUMN id SET DEFAULT nextval('public.productos_id_seq'::regclass);


--
-- TOC entry 2865 (class 2604 OID 74693)
-- Name: tipodocumento id; Type: DEFAULT; Schema: public; Owner: tiendaelectronicauser
--

ALTER TABLE ONLY public.tipodocumento ALTER COLUMN id SET DEFAULT nextval('public.tipodocumento_id_seq'::regclass);


--
-- TOC entry 3019 (class 0 OID 74682)
-- Dependencies: 205
-- Data for Name: categorias; Type: TABLE DATA; Schema: public; Owner: tiendaelectronicauser
--

COPY public.categorias (id, nombre, descripcion) FROM stdin;
1	accesorios	categoria de accesorios
2	accesorios	categoria de accesorios
3	accesorios	categoria de accesorios
5	cat	catDesc
6	accesorios	categoria de accesorios
7	accetest	categoriatest
4	accestest	categoria test
8	juguetes	Categoria de juguetes
9	hogar	Categoria para el hogar
\.


--
-- TOC entry 3025 (class 0 OID 74711)
-- Dependencies: 211
-- Data for Name: clientes; Type: TABLE DATA; Schema: public; Owner: tiendaelectronicauser
--

COPY public.clientes (id, tipo_id, nombres, apellidos, documento, estado) FROM stdin;
1	1	Juan	Tonguino	1085309823	1
\.


--
-- TOC entry 3029 (class 0 OID 74742)
-- Dependencies: 215
-- Data for Name: detallepedido; Type: TABLE DATA; Schema: public; Owner: tiendaelectronicauser
--

COPY public.detallepedido (id, pedi_id, prod_id, cantidad, valor) FROM stdin;
1	1	1	3.00	30000.00
\.


--
-- TOC entry 3017 (class 0 OID 74674)
-- Dependencies: 203
-- Data for Name: estadospedido; Type: TABLE DATA; Schema: public; Owner: tiendaelectronicauser
--

COPY public.estadospedido (id, descripcion) FROM stdin;
1	Solicitado
2	En Curso
3	Pagado
4	Entregado
\.


--
-- TOC entry 3027 (class 0 OID 74724)
-- Dependencies: 213
-- Data for Name: pedidos; Type: TABLE DATA; Schema: public; Owner: tiendaelectronicauser
--

COPY public.pedidos (id, clie_id, espe_id, fecha, total) FROM stdin;
1	1	1	2023-06-26 20:03:56.999	20000.00
\.


--
-- TOC entry 3023 (class 0 OID 74698)
-- Dependencies: 209
-- Data for Name: productos; Type: TABLE DATA; Schema: public; Owner: tiendaelectronicauser
--

COPY public.productos (id, cate_id, referencia, nombre, descripcion, precio_unitario, unidades_disponibles) FROM stdin;
1	1	Trap123U	Trapero hogar update	Trapero para el hogar	10000.00	10.00
\.


--
-- TOC entry 3021 (class 0 OID 74690)
-- Dependencies: 207
-- Data for Name: tipodocumento; Type: TABLE DATA; Schema: public; Owner: tiendaelectronicauser
--

COPY public.tipodocumento (id, descripcion) FROM stdin;
1	Cedula
2	TI
3	Pasaporte
\.


--
-- TOC entry 3043 (class 0 OID 0)
-- Dependencies: 204
-- Name: categorias_id_seq; Type: SEQUENCE SET; Schema: public; Owner: tiendaelectronicauser
--

SELECT pg_catalog.setval('public.categorias_id_seq', 9, true);


--
-- TOC entry 3044 (class 0 OID 0)
-- Dependencies: 210
-- Name: clientes_id_seq; Type: SEQUENCE SET; Schema: public; Owner: tiendaelectronicauser
--

SELECT pg_catalog.setval('public.clientes_id_seq', 1, true);


--
-- TOC entry 3045 (class 0 OID 0)
-- Dependencies: 214
-- Name: detallepedido_id_seq; Type: SEQUENCE SET; Schema: public; Owner: tiendaelectronicauser
--

SELECT pg_catalog.setval('public.detallepedido_id_seq', 1, true);


--
-- TOC entry 3046 (class 0 OID 0)
-- Dependencies: 202
-- Name: estadospedido_id_seq; Type: SEQUENCE SET; Schema: public; Owner: tiendaelectronicauser
--

SELECT pg_catalog.setval('public.estadospedido_id_seq', 4, true);


--
-- TOC entry 3047 (class 0 OID 0)
-- Dependencies: 212
-- Name: pedidos_id_seq; Type: SEQUENCE SET; Schema: public; Owner: tiendaelectronicauser
--

SELECT pg_catalog.setval('public.pedidos_id_seq', 1, true);


--
-- TOC entry 3048 (class 0 OID 0)
-- Dependencies: 208
-- Name: productos_id_seq; Type: SEQUENCE SET; Schema: public; Owner: tiendaelectronicauser
--

SELECT pg_catalog.setval('public.productos_id_seq', 1, true);


--
-- TOC entry 3049 (class 0 OID 0)
-- Dependencies: 206
-- Name: tipodocumento_id_seq; Type: SEQUENCE SET; Schema: public; Owner: tiendaelectronicauser
--

SELECT pg_catalog.setval('public.tipodocumento_id_seq', 3, true);


--
-- TOC entry 2873 (class 2606 OID 74687)
-- Name: categorias categorias_pkey; Type: CONSTRAINT; Schema: public; Owner: tiendaelectronicauser
--

ALTER TABLE ONLY public.categorias
    ADD CONSTRAINT categorias_pkey PRIMARY KEY (id);


--
-- TOC entry 2879 (class 2606 OID 74716)
-- Name: clientes clientes_pkey; Type: CONSTRAINT; Schema: public; Owner: tiendaelectronicauser
--

ALTER TABLE ONLY public.clientes
    ADD CONSTRAINT clientes_pkey PRIMARY KEY (id);


--
-- TOC entry 2883 (class 2606 OID 74747)
-- Name: detallepedido detallepedido_pkey; Type: CONSTRAINT; Schema: public; Owner: tiendaelectronicauser
--

ALTER TABLE ONLY public.detallepedido
    ADD CONSTRAINT detallepedido_pkey PRIMARY KEY (id);


--
-- TOC entry 2871 (class 2606 OID 74679)
-- Name: estadospedido estadospedido_pkey; Type: CONSTRAINT; Schema: public; Owner: tiendaelectronicauser
--

ALTER TABLE ONLY public.estadospedido
    ADD CONSTRAINT estadospedido_pkey PRIMARY KEY (id);


--
-- TOC entry 2881 (class 2606 OID 74729)
-- Name: pedidos pedidos_pkey; Type: CONSTRAINT; Schema: public; Owner: tiendaelectronicauser
--

ALTER TABLE ONLY public.pedidos
    ADD CONSTRAINT pedidos_pkey PRIMARY KEY (id);


--
-- TOC entry 2877 (class 2606 OID 74703)
-- Name: productos productos_pkey; Type: CONSTRAINT; Schema: public; Owner: tiendaelectronicauser
--

ALTER TABLE ONLY public.productos
    ADD CONSTRAINT productos_pkey PRIMARY KEY (id);


--
-- TOC entry 2875 (class 2606 OID 74695)
-- Name: tipodocumento tipodocumento_pkey; Type: CONSTRAINT; Schema: public; Owner: tiendaelectronicauser
--

ALTER TABLE ONLY public.tipodocumento
    ADD CONSTRAINT tipodocumento_pkey PRIMARY KEY (id);


--
-- TOC entry 2885 (class 2606 OID 74717)
-- Name: clientes clientes_tido_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: tiendaelectronicauser
--

ALTER TABLE ONLY public.clientes
    ADD CONSTRAINT clientes_tido_id_fkey FOREIGN KEY (tipo_id) REFERENCES public.tipodocumento(id);


--
-- TOC entry 2888 (class 2606 OID 74748)
-- Name: detallepedido detallepedido_pedi_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: tiendaelectronicauser
--

ALTER TABLE ONLY public.detallepedido
    ADD CONSTRAINT detallepedido_pedi_id_fkey FOREIGN KEY (pedi_id) REFERENCES public.pedidos(id);


--
-- TOC entry 2889 (class 2606 OID 74753)
-- Name: detallepedido detallepedido_prod_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: tiendaelectronicauser
--

ALTER TABLE ONLY public.detallepedido
    ADD CONSTRAINT detallepedido_prod_id_fkey FOREIGN KEY (prod_id) REFERENCES public.productos(id);


--
-- TOC entry 2886 (class 2606 OID 74730)
-- Name: pedidos pedidos_clie_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: tiendaelectronicauser
--

ALTER TABLE ONLY public.pedidos
    ADD CONSTRAINT pedidos_clie_id_fkey FOREIGN KEY (clie_id) REFERENCES public.clientes(id);


--
-- TOC entry 2887 (class 2606 OID 74735)
-- Name: pedidos pedidos_espe_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: tiendaelectronicauser
--

ALTER TABLE ONLY public.pedidos
    ADD CONSTRAINT pedidos_espe_id_fkey FOREIGN KEY (espe_id) REFERENCES public.estadospedido(id);


--
-- TOC entry 2884 (class 2606 OID 74704)
-- Name: productos productos_cate_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: tiendaelectronicauser
--

ALTER TABLE ONLY public.productos
    ADD CONSTRAINT productos_cate_id_fkey FOREIGN KEY (cate_id) REFERENCES public.categorias(id);


--
-- TOC entry 3035 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: sonartest
--

REVOKE USAGE ON SCHEMA public FROM PUBLIC;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2023-06-26 20:34:35

--
-- PostgreSQL database dump complete
--

