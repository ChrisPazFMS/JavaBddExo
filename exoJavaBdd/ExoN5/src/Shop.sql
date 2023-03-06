 -- - Reconstruction de la base de donnée - --
 
 
 DROP DATABASE IF EXISTS Shop;
 CREATE DATABASE Shop; 
 USE Shop;
 
-- - Constrution de la tables utilisateurs - --
 
 CREATE TABLE T_Users (
IdUser int(4) PRIMARY KEY AUTO_INCREMENT,
Login varchar(20) NOT NULL,
Password varchar(20) NOT NULL
) ENGINE = InnoDB;

INSERT INTO T_Users ( Login, Password ) VALUE ( 'WilliamShakespeare','W123');
INSERT INTO T_Users ( Login, Password ) VALUE ( 'SamiraLachhab','S123');
INSERT INTO T_Users ( Login, Password ) VALUE ( 'MohamedSijelmassi','M123');
INSERT INTO T_Users ( Login, Password ) VALUE ( 'OctaviaButler','O123');
INSERT INTO T_Users ( Login, Password ) VALUE ( 'MariamaBa','M123');
INSERT INTO T_Users ( Login, Password ) VALUE ( 'NatsumeSoseki','N123');


 
-- - Constrution de la tables des articles en vente - --
 
 
 CREATE TABLE T_Articles (
 IdArticle     int(4)   PRIMARY KEY AUTO_INCREMENT,
 Description   varchar(30) NOT NULL,
 Brand         varchar(30) NOT NULL,
 UnitaryPrice     float(8) NOT NULL
 ) ENGINE = InnoDB;
 
 INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'Souris'         , 'Logitoch', 65 );
 INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'Clavier'        , 'Microhard', 49.5 );
 INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'Systeme d''exploitation', 'Fenetre Vistouille', 150 );
 INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'Tapis souris'   , 'Chapeau Bleu', 5 );
 INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'Cle USB 8 to'   , 'Syno', 5 );
 INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'Laptop'         , 'PH', 1199 );
 INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'CD x 500'       , 'CETME', 250 );
 INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'DVD-R x 100'    , 'CETME', 99 );
 INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'DVD+R x 100'    , 'CETME', 105 );
 INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'Batterie Laptop', 'PH', 80 );
 INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'Casque Audio'   , 'PH', 80 );
 INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'Telephone portable', 'Nokia 8210', 26 );
 INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'WebCam'         , 'Logitoch', 755 );
 INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'Telephone portable', 'Samsung galaxy s23 ultra', 32 );
 
 SELECT * FROM T_Articles;
 show tables;
 SELECT Description from T_Articles;
 INSERT INTO T_Articles (Description, Brand, UnitaryPrice ) VALUES ('Macbook', 'Apple', '2000');
 DESCRIBE T_Articles;
 UPDATE T_Articles SET Brand='Logithec', UnitaryPrice=85 WHERE IdArticle = 1;
 DELETE FROM  T_Articles WHERE IdArticle=2;
 
 INSERT INTO T_Articles (idarticle, Description, Brand, UnitaryPrice) VALUE ('2', 'Clavier', 'Microhard', 49.5);
 SELECT * FROM T_Articles;
 SELECT * FROM T_Articles WHERE UnitaryPrice > 100;
 SELECT * FROM T_Articles WHERE UnitaryPrice >= 50 && UnitaryPrice <= 150;
 SELECT * FROM T_Articles;
 SELECT * FROM t_Articles ORDER BY UnitaryPrice;
 SELECT Description FROM T_Articles;
 SELECT * FROM T_Articles WHERE SOUNDEX(description) = SOUNDEX('shouryse'); #Choisissez une requête particulièrement intéressante à présenter
 
 #exo 1.12 
 
 CREATE TABLE T_Categories (IdCategory int(4) PRIMARY KEY AUTO_INCREMENT, CatName VARCHAR(30) NOT NULL, Description VARCHAR(100) NOT NULL);
 INSERT INTO T_Categories (CatName, Description) VALUES ('PC', 'Ordinateur portable ou pas');
 INSERT INTO T_Categories (CatName, Description) VALUES ('Smartphone', 'Telephone de derniere generation avec ecran tactile + applis');
 INSERT INTO T_Categories (CatName, Description) VALUES ('Materiel informatique', 'Tout materiel informatique physique en lien avec un ordinateur');
 INSERT INTO T_Categories (CatName, Description) VALUES ('logiciel informatique', 'Logiciel informatique tout systeme d''exploitation');
 
 ALTER TABLE T_Articles ADD FOREIGN KEY(IdCategory) REFERENCES T_Categories(IdCategory);
 ALTER TABLE T_Articles ADD COLUMN IdCategory int(4);
 
 UPDATE T_Articles SET IdCategory = 3 WHERE IdArticle IN(1,2,4,5,6,7,8,9,10,11,12,13);
 UPDATE T_Articles SET IdCategory = 2 WHERE IdArticle IN(12,14);
 UPDATE T_Articles SET IdCategory = 1 WHERE IdArticle IN(3,15);
 
  
 INSERT INTO T_Articles (Description, Brand, UnitaryPrice, IdCategory) VALUES ('Pavillon', 'HP', 1500, 1);
 INSERT INTO T_Articles (Description, Brand, UnitaryPrice, IdCategory) VALUES ('Dolisim', 'logiciels de facturation', 655, 4);
 INSERT INTO T_Articles (Description, Brand, UnitaryPrice, IdCategory) VALUES ('Openflex', 'logiciel de caisse certifie', 975, 4);
 
 
 SELECT * FROM T_Articles;
 SELECT * FROM T_Categories;
 
 #exo 1.13
 SELECT IdArticle, T_Articles.Description, Brand, UnitaryPrice, CatName FROM T_Articles INNER JOIN T_Categories WHERE T_Articles.IdCategory = T_Categories.IdCategory and IdArticle IN(11,12,13,14,15) ORDER BY UnitaryPrice;
 
 
 
 
 