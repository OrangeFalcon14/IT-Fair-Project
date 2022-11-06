PGDMP     /    :            
    z            postgres %   10.22 (Ubuntu 10.22-0ubuntu0.18.04.1) %   10.22 (Ubuntu 10.22-0ubuntu0.18.04.1)     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            �           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    3            �            1259    16384    gk_test_info    TABLE       CREATE TABLE public.gk_test_info (
    id bigint NOT NULL,
    answer character varying(255),
    option_a character varying(255),
    option_b character varying(255),
    option_c character varying(255),
    option_d character varying(255),
    question character varying(255)
);
     DROP TABLE public.gk_test_info;
       public         postgres    false    3            �            1259    16392    gk_test_scores    TABLE     �   CREATE TABLE public.gk_test_scores (
    id bigint NOT NULL,
    correct_answers bigint,
    total_marks bigint,
    user_name character varying(255),
    wrong_answers bigint
);
 "   DROP TABLE public.gk_test_scores;
       public         postgres    false    3            �            1259    16431    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public       postgres    false    3            �            1259    16397    iq_test    TABLE       CREATE TABLE public.iq_test (
    id bigint NOT NULL,
    answer character varying(255),
    option_a character varying(255),
    option_b character varying(255),
    option_c character varying(255),
    option_d character varying(255),
    question character varying(255)
);
    DROP TABLE public.iq_test;
       public         postgres    false    3            �            1259    16405    iq_test_score    TABLE     �   CREATE TABLE public.iq_test_score (
    id bigint NOT NULL,
    correct_answers bigint,
    total_marks bigint,
    user_name character varying(255),
    wrong_answers bigint
);
 !   DROP TABLE public.iq_test_score;
       public         postgres    false    3            �            1259    16410    it_fair_game_project    TABLE       CREATE TABLE public.it_fair_game_project (
    id bigint NOT NULL,
    gk_test_scores bigint,
    iq_test_scores bigint,
    optical_illusion_scores bigint,
    total_points bigint,
    typing_test_scores bigint,
    user_name character varying(255),
    user_rank bigint
);
 (   DROP TABLE public.it_fair_game_project;
       public         postgres    false    3            �            1259    16415    optical_illusion_test    TABLE     B  CREATE TABLE public.optical_illusion_test (
    id bigint NOT NULL,
    answer character varying(255),
    img_url character varying(255),
    optiona character varying(255),
    optionb character varying(255),
    optionc character varying(255),
    optiond character varying(255),
    question character varying(255)
);
 )   DROP TABLE public.optical_illusion_test;
       public         postgres    false    3            �            1259    16423    typing_test_info    TABLE     �   CREATE TABLE public.typing_test_info (
    id bigint NOT NULL,
    user_name character varying(255),
    user_score bigint,
    user_typed character varying(255),
    user_typing_speed bigint
);
 $   DROP TABLE public.typing_test_info;
       public         postgres    false    3            �          0    16384    gk_test_info 
   TABLE DATA               d   COPY public.gk_test_info (id, answer, option_a, option_b, option_c, option_d, question) FROM stdin;
    public       postgres    false    196            �          0    16392    gk_test_scores 
   TABLE DATA               d   COPY public.gk_test_scores (id, correct_answers, total_marks, user_name, wrong_answers) FROM stdin;
    public       postgres    false    197            �          0    16397    iq_test 
   TABLE DATA               _   COPY public.iq_test (id, answer, option_a, option_b, option_c, option_d, question) FROM stdin;
    public       postgres    false    198            �          0    16405    iq_test_score 
   TABLE DATA               c   COPY public.iq_test_score (id, correct_answers, total_marks, user_name, wrong_answers) FROM stdin;
    public       postgres    false    199            �          0    16410    it_fair_game_project 
   TABLE DATA               �   COPY public.it_fair_game_project (id, gk_test_scores, iq_test_scores, optical_illusion_scores, total_points, typing_test_scores, user_name, user_rank) FROM stdin;
    public       postgres    false    200            �          0    16415    optical_illusion_test 
   TABLE DATA               r   COPY public.optical_illusion_test (id, answer, img_url, optiona, optionb, optionc, optiond, question) FROM stdin;
    public       postgres    false    201            �          0    16423    typing_test_info 
   TABLE DATA               d   COPY public.typing_test_info (id, user_name, user_score, user_typed, user_typing_speed) FROM stdin;
    public       postgres    false    202            �           0    0    hibernate_sequence    SEQUENCE SET     A   SELECT pg_catalog.setval('public.hibernate_sequence', 18, true);
            public       postgres    false    203            �
           2606    16391    gk_test_info gk_test_info_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.gk_test_info
    ADD CONSTRAINT gk_test_info_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.gk_test_info DROP CONSTRAINT gk_test_info_pkey;
       public         postgres    false    196            �
           2606    16396 "   gk_test_scores gk_test_scores_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.gk_test_scores
    ADD CONSTRAINT gk_test_scores_pkey PRIMARY KEY (id);
 L   ALTER TABLE ONLY public.gk_test_scores DROP CONSTRAINT gk_test_scores_pkey;
       public         postgres    false    197                       2606    16404    iq_test iq_test_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.iq_test
    ADD CONSTRAINT iq_test_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.iq_test DROP CONSTRAINT iq_test_pkey;
       public         postgres    false    198                       2606    16409     iq_test_score iq_test_score_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.iq_test_score
    ADD CONSTRAINT iq_test_score_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.iq_test_score DROP CONSTRAINT iq_test_score_pkey;
       public         postgres    false    199                       2606    16414 .   it_fair_game_project it_fair_game_project_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public.it_fair_game_project
    ADD CONSTRAINT it_fair_game_project_pkey PRIMARY KEY (id);
 X   ALTER TABLE ONLY public.it_fair_game_project DROP CONSTRAINT it_fair_game_project_pkey;
       public         postgres    false    200                       2606    16422 0   optical_illusion_test optical_illusion_test_pkey 
   CONSTRAINT     n   ALTER TABLE ONLY public.optical_illusion_test
    ADD CONSTRAINT optical_illusion_test_pkey PRIMARY KEY (id);
 Z   ALTER TABLE ONLY public.optical_illusion_test DROP CONSTRAINT optical_illusion_test_pkey;
       public         postgres    false    201            	           2606    16430 &   typing_test_info typing_test_info_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.typing_test_info
    ADD CONSTRAINT typing_test_info_pkey PRIMARY KEY (id);
 P   ALTER TABLE ONLY public.typing_test_info DROP CONSTRAINT typing_test_info_pkey;
       public         postgres    false    202            �   �  x��SMo�0=˿B�`[����I��"(:���b�ID:Y���؉�n����#�<3K�Z�}6�	.Gg�]+lMqG	�Xj�65
;�-v^�bj�����fe�\�_��d� {�C��s�LM��=Bp�sə�dkooS�.Yc��ڻ>��rv�!�l�Z�7��6��E ����:@6+̍2at�<��u�Ȕ�1�-J[���wP#��`�fM)�f��92�`�z���-����ǀ.��{�{�����6��(G>���L��2ςE��/�+mf�v�/"�{B��	��$G�Ta��j�7�L�t�OEPۧ�
�w�Tn�Eum���pY|9={{�]D������2.���Y��x5%�G\�\]X�H?i�\Z�B.og�R<�ժeh�q��@zUCm;�f�Rc_�8��_���[}T,�`����9�����t���� �RH���
�v�q -+���h{7V���N�Ƃ����7UU�J�n�      �      x������ � �      �   �  x�mRMo�0=ӿ�!g���8�k�X1,	��.����)�ed�����a0(J�����9}!Y��H�V�k���O{�0�v����a�_����g�vf�>����H�i�&b�y�eTъ��̑���s�t�x炿��7��b�U�!�O�ݢ�H$tO�X�+6����Ǌ�����v��~m����m(�Z�5�s�u�Z!�������wC��u�2�(��dF9C*c��8s��"ʨ�_o*�Y` ��,�5�z��8��n��nێ�}cy��^#wXBS"�����t}(��!��D��Ȃ��i�+ԝ�{�9��c]�!ܔ�#��Wr'ْiI���������pE~*�M`���;���_pE)(�%e�����3�$�mX�~��ߒ��g9���<S�4F��HH��Y$��jɲ������Y~���\�r�Fmj
3�@)�E��
�a4K�1�,�uE��J�      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �     