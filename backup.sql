--
-- PostgreSQL database dump
--

-- Dumped from database version 16.0
-- Dumped by pg_dump version 16.0

-- Started on 2023-10-15 13:43:29

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
-- TOC entry 2 (class 3079 OID 16384)
-- Name: adminpack; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;


--
-- TOC entry 4874 (class 0 OID 0)
-- Dependencies: 2
-- Name: EXTENSION adminpack; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 216 (class 1259 OID 16398)
-- Name: cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cliente (
    cod_cliente integer NOT NULL,
    nome_cliente character varying(20) NOT NULL,
    sobrenome_cliente character varying(40) NOT NULL,
    cpf_cliente character varying(11)
);


ALTER TABLE public.cliente OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 16473)
-- Name: cod_cliente_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cod_cliente_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483647
    CACHE 1;


ALTER SEQUENCE public.cod_cliente_seq OWNER TO postgres;

--
-- TOC entry 4875 (class 0 OID 0)
-- Dependencies: 221
-- Name: cod_cliente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cod_cliente_seq OWNED BY public.cliente.cod_cliente;


--
-- TOC entry 219 (class 1259 OID 16407)
-- Name: produto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.produto (
    cod_produto integer NOT NULL,
    descricao text
);


ALTER TABLE public.produto OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 16493)
-- Name: cod_produto_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cod_produto_seq
    START WITH 6
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 999999
    CACHE 1;


ALTER SEQUENCE public.cod_produto_seq OWNER TO postgres;

--
-- TOC entry 4876 (class 0 OID 0)
-- Dependencies: 222
-- Name: cod_produto_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cod_produto_seq OWNED BY public.produto.cod_produto;


--
-- TOC entry 220 (class 1259 OID 16458)
-- Name: item_do_pedido; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.item_do_pedido (
    cod_pedido integer NOT NULL,
    cod_produto integer NOT NULL,
    qtdade integer
);


ALTER TABLE public.item_do_pedido OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16403)
-- Name: pedido; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pedido (
    cod_pedido integer NOT NULL,
    data timestamp without time zone,
    cod_cliente integer
);


ALTER TABLE public.pedido OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 16406)
-- Name: pedidos_cod_pedido_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pedidos_cod_pedido_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.pedidos_cod_pedido_seq OWNER TO postgres;

--
-- TOC entry 4877 (class 0 OID 0)
-- Dependencies: 218
-- Name: pedidos_cod_pedido_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.pedidos_cod_pedido_seq OWNED BY public.pedido.cod_pedido;


--
-- TOC entry 4703 (class 2604 OID 16475)
-- Name: cliente cod_cliente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente ALTER COLUMN cod_cliente SET DEFAULT nextval('public.cod_cliente_seq'::regclass);


--
-- TOC entry 4704 (class 2604 OID 16418)
-- Name: pedido cod_pedido; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido ALTER COLUMN cod_pedido SET DEFAULT nextval('public.pedidos_cod_pedido_seq'::regclass);


--
-- TOC entry 4705 (class 2604 OID 16494)
-- Name: produto cod_produto; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto ALTER COLUMN cod_produto SET DEFAULT nextval('public.cod_produto_seq'::regclass);


--
-- TOC entry 4862 (class 0 OID 16398)
-- Dependencies: 216
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.cliente (cod_cliente, nome_cliente, sobrenome_cliente, cpf_cliente) VALUES (8, 'jeferson', 'pacheco', '08899971951');
INSERT INTO public.cliente (cod_cliente, nome_cliente, sobrenome_cliente, cpf_cliente) VALUES (5, 'qwer2', 'qwer2', '88999719511');


--
-- TOC entry 4866 (class 0 OID 16458)
-- Dependencies: 220
-- Data for Name: item_do_pedido; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.item_do_pedido (cod_pedido, cod_produto, qtdade) VALUES (4, 3, 10);
INSERT INTO public.item_do_pedido (cod_pedido, cod_produto, qtdade) VALUES (4, 4, 11);
INSERT INTO public.item_do_pedido (cod_pedido, cod_produto, qtdade) VALUES (4, 1, 12);
INSERT INTO public.item_do_pedido (cod_pedido, cod_produto, qtdade) VALUES (5, 2, 13);
INSERT INTO public.item_do_pedido (cod_pedido, cod_produto, qtdade) VALUES (6, 5, 14);
INSERT INTO public.item_do_pedido (cod_pedido, cod_produto, qtdade) VALUES (6, 3, 15);


--
-- TOC entry 4863 (class 0 OID 16403)
-- Dependencies: 217
-- Data for Name: pedido; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.pedido (cod_pedido, data, cod_cliente) VALUES (4, '2023-10-15 00:00:00', 8);
INSERT INTO public.pedido (cod_pedido, data, cod_cliente) VALUES (5, '2023-10-16 00:00:00', 8);
INSERT INTO public.pedido (cod_pedido, data, cod_cliente) VALUES (6, '2023-10-17 00:00:00', 8);


--
-- TOC entry 4865 (class 0 OID 16407)
-- Dependencies: 219
-- Data for Name: produto; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.produto (cod_produto, descricao) VALUES (3, 'Tubo de pasta de dentes 90g');
INSERT INTO public.produto (cod_produto, descricao) VALUES (4, 'Sabonete antibacteriano');
INSERT INTO public.produto (cod_produto, descricao) VALUES (1, 'Garrafa em gel de 3 litros');
INSERT INTO public.produto (cod_produto, descricao) VALUES (5, 'Antisseptico bucal de 600ml');
INSERT INTO public.produto (cod_produto, descricao) VALUES (2, 'Caixa de luvas de latex com 200 unidades');


--
-- TOC entry 4878 (class 0 OID 0)
-- Dependencies: 221
-- Name: cod_cliente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cod_cliente_seq', 19, true);


--
-- TOC entry 4879 (class 0 OID 0)
-- Dependencies: 222
-- Name: cod_produto_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cod_produto_seq', 7, true);


--
-- TOC entry 4880 (class 0 OID 0)
-- Dependencies: 218
-- Name: pedidos_cod_pedido_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pedidos_cod_pedido_seq', 100, true);


--
-- TOC entry 4707 (class 2606 OID 16421)
-- Name: cliente clientes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT clientes_pkey PRIMARY KEY (cod_cliente);


--
-- TOC entry 4715 (class 2606 OID 16462)
-- Name: item_do_pedido item_do_pedido_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item_do_pedido
    ADD CONSTRAINT item_do_pedido_pkey PRIMARY KEY (cod_pedido, cod_produto);


--
-- TOC entry 4711 (class 2606 OID 16423)
-- Name: pedido pedidos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido
    ADD CONSTRAINT pedidos_pkey PRIMARY KEY (cod_pedido);


--
-- TOC entry 4713 (class 2606 OID 16425)
-- Name: produto produtos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto
    ADD CONSTRAINT produtos_pkey PRIMARY KEY (cod_produto);


--
-- TOC entry 4709 (class 2606 OID 16492)
-- Name: cliente u_cpf_cliente; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT u_cpf_cliente UNIQUE (cpf_cliente);


--
-- TOC entry 4717 (class 2606 OID 16463)
-- Name: item_do_pedido item_do_pedido_cod_pedido_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item_do_pedido
    ADD CONSTRAINT item_do_pedido_cod_pedido_fkey FOREIGN KEY (cod_pedido) REFERENCES public.pedido(cod_pedido);


--
-- TOC entry 4718 (class 2606 OID 16468)
-- Name: item_do_pedido item_do_pedido_cod_produtos_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item_do_pedido
    ADD CONSTRAINT item_do_pedido_cod_produtos_fkey FOREIGN KEY (cod_produto) REFERENCES public.produto(cod_produto);


--
-- TOC entry 4716 (class 2606 OID 16486)
-- Name: pedido pedido_cod_cliente_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido
    ADD CONSTRAINT pedido_cod_cliente_fkey FOREIGN KEY (cod_cliente) REFERENCES public.cliente(cod_cliente) ON DELETE RESTRICT NOT VALID;


-- Completed on 2023-10-15 13:43:29

--
-- PostgreSQL database dump complete
--

