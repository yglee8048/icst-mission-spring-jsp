DROP TABLE HANGMA_EMPLOYEE;
DROP TABLE HANGMA_MENU;
DROP TABLE HANGMA_ORDER;

-- ---------------------------------------------------- --
--  DDL for Table HANGMA_EMPLOYEE
-- ---------------------------------------------------- --
CREATE TABLE HANGMA_EMPLOYEE
(
    EMP_NO   NUMBER(5, 0),
    EMP_NM   VARCHAR2(30),
    EMP_RANK VARCHAR2(6),
    PRIMARY KEY (EMP_NO)
);
-- ---------------------------------------------------- --
--  DDL for Table HANGMA_MENU
-- ---------------------------------------------------- --
CREATE TABLE HANGMA_MENU
(
    MENU_ID     NUMBER,
    CATEGORY    VARCHAR2(20),
    MENU_NM     VARCHAR2(30),
    PRICE       NUMBER,
    IMG_FILE_NM VARCHAR2(30),
    PRIMARY KEY (MENU_ID)
);
-- ---------------------------------------------------- --
--  DDL for Table HANGMA_ORDER
-- ---------------------------------------------------- --
CREATE TABLE HANGMA_ORDER
(
    ORDER_ID       NUMBER,
    EMP_NO         NUMBER(5, 0),
    PRICE          NUMBER,
    DISCOUNT_PRICE NUMBER,
    ORDER_DT       DATE,
    PRIMARY KEY (ORDER_ID)
);

INSERT INTO HANGMA_EMPLOYEE (EMP_NO, EMP_NM, EMP_RANK)
VALUES (88999, '홍길동', 'VIP');

INSERT INTO HANGMA_MENU (MENU_ID, CATEGORY, MENU_NM, PRICE, IMG_FILE_NM)
VALUES ('1', 'COFFEE_HOT', '아메리카노', 1000, 'americano.jpg');
INSERT INTO HANGMA_MENU (MENU_ID, CATEGORY, MENU_NM, PRICE, IMG_FILE_NM)
VALUES ('2', 'COFFEE_HOT', '카푸치노', 1500, 'capuccino.jpg');
INSERT INTO HANGMA_MENU (MENU_ID, CATEGORY, MENU_NM, PRICE, IMG_FILE_NM)
VALUES ('3', 'COFFEE_HOT', '카페라떼', 1500, 'cafelatte.jpg');
INSERT INTO HANGMA_MENU (MENU_ID, CATEGORY, MENU_NM, PRICE, IMG_FILE_NM)
VALUES ('4', 'COFFEE_HOT', '카페모카', 2000, 'cafemoka.jpg');
INSERT INTO HANGMA_MENU (MENU_ID, CATEGORY, MENU_NM, PRICE, IMG_FILE_NM)
VALUES ('5', 'COFFEE_ICE', '아메리카노(ICE)', 1200, 'iceamericano.jpg');
INSERT INTO HANGMA_MENU (MENU_ID, CATEGORY, MENU_NM, PRICE, IMG_FILE_NM)
VALUES ('6', 'COFFEE_ICE', '카푸치노(ICE)', 1700, 'icecapuccino.jpg');
INSERT INTO HANGMA_MENU (MENU_ID, CATEGORY, MENU_NM, PRICE, IMG_FILE_NM)
VALUES ('7', 'COFFEE_ICE', '카페라떼(ICE)', 1700, 'icelatte.jpg');
INSERT INTO HANGMA_MENU (MENU_ID, CATEGORY, MENU_NM, PRICE, IMG_FILE_NM)
VALUES ('8', 'COFFEE_ICE', '카페모카(ICE)', 2200, 'icecafemoka.jpg');
INSERT INTO HANGMA_MENU (MENU_ID, CATEGORY, MENU_NM, PRICE, IMG_FILE_NM)
VALUES ('9', 'TEA', '밀크티', 1500, 'milktea.jpg');
INSERT INTO HANGMA_MENU (MENU_ID, CATEGORY, MENU_NM, PRICE, IMG_FILE_NM)
VALUES ('10', 'JUICE', '딸기복숭아', 2500, 'peachstrawberry.jpg');
INSERT INTO HANGMA_MENU (MENU_ID, CATEGORY, MENU_NM, PRICE, IMG_FILE_NM)
VALUES ('11', 'BAKERY', '베이글', 2000, 'bagle.jpg');

commit;