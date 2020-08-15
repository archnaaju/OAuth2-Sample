--
-- PostgreSQL database dump
--

-- Dumped from database version 11.7
-- Dumped by pg_dump version 11.7

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

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: Customers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.customers (
    id uuid NOT NULL,
    title character varying(255),
    is_deleted boolean,
    created_at timestamp without time zone,
    modified_at timestamp without time zone
);


ALTER TABLE public.customers OWNER TO postgres;

--
-- Name: Products; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.products (
    id uuid,
    customer_id uuid,
    title character varying(255),
    description character varying(1024),
    is_deleted boolean,
    price numeric(10,2),
    created_at timestamp,
    modified_at timestamp
)
INHERITS (public.customers);


ALTER TABLE public.products OWNER TO postgres;

--
-- Data for Name: Customers; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.customers (id, title, is_deleted, created_at, modified_at) FROM stdin;
\.


--
-- Data for Name: Products; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.products (id, title, is_deleted, created_at, modified_at, customer_id, description, price) FROM stdin;
\.


--
-- Name: Customers Customers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customers
    ADD CONSTRAINT "Customers_pkey" PRIMARY KEY (id);


--
-- Name: Products FK_CUSTOMER_ID; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT "FK_CUSTOMER_ID" FOREIGN KEY (customer_id) REFERENCES public.customers(id);


--
-- PostgreSQL database dump complete
--

