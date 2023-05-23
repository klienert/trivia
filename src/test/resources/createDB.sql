DROP TABLE IF EXISTS TriviaApp.attempt;
DROP TABLE IF EXISTS TriviaApp.quiz;
DROP TABLE IF EXISTS TriviaApp.category;
DROP TABLE IF EXISTS TriviaApp.difficulty;
DROP TABLE IF EXISTS TriviaApp.user;
    -- tables
-- Table: Attempt
CREATE TABLE TriviaApp.attempt (id int  NOT NULL AUTO_INCREMENT, attempt_date datetime NULL, score int  NULL DEFAULT 0, User_id int   NULL, Quiz_id int   NULL, started_at datetime  NULL, completed_at datetime  NULL, CONSTRAINT Attempt_pk PRIMARY KEY (id));
-- Table: Category
CREATE TABLE TriviaApp.category ( id int  NOT NULL, topic varchar(100)  NOT NULL, CONSTRAINT Category_pk PRIMARY KEY (id));
-- Table: Difficulty
CREATE TABLE TriviaApp.difficulty ( id int  NOT NULL AUTO_INCREMENT, difficulty varchar(15)  NOT NULL, CONSTRAINT Difficulty_pk PRIMARY KEY (id));
-- Table: Quiz
CREATE TABLE TriviaApp.quiz (id int  NOT NULL AUTO_INCREMENT, description varchar(255) NULL, Category_id int  NULL, Difficulty_id int   NULL, User_id int NULL, score int NULL, created_at datetime  NULL, updated_at datetime  NULL, CONSTRAINT Quiz_pk PRIMARY KEY (id));
-- Table: User
CREATE TABLE TriviaApp.user (id int  NOT NULL AUTO_INCREMENT, first_name varchar(50)  NOT NULL, last_name varchar(50)  NOT NULL, user_name varchar(25)  NOT NULL, email varchar(50)  NULL, created_at datetime  NULL, updated_at datetime  NULL, CONSTRAINT User_pk PRIMARY KEY (id) );
-- foreign keys
-- Reference: Attempt_Quiz (table: Attempt)
ALTER TABLE TriviaApp.attempt ADD CONSTRAINT Attempt_Quiz FOREIGN KEY Attempt_Quiz (Quiz_id) REFERENCES Quiz (id);
-- Reference: Attempt_User (table: Attempt)
ALTER TABLE TriviaApp.attempt ADD CONSTRAINT Attempt_User FOREIGN KEY Attempt_User (User_id) REFERENCES User (id);
-- Reference: Quiz_Category (table: Quiz)
ALTER TABLE TriviaApp.quiz ADD CONSTRAINT Quiz_Category FOREIGN KEY Quiz_Category (Category_id)     REFERENCES Category (id);
-- Reference: Quiz_Difficulty (table: Quiz)
ALTER TABLE TriviaApp.quiz ADD CONSTRAINT Quiz_Difficulty FOREIGN KEY Quiz_Difficulty (Difficulty_id)    REFERENCES Difficulty (id);
-- Reference: Quiz_User (table: Quiz)
ALTER TABLE TriviaApp.quiz ADD CONSTRAINT Quiz_User FOREIGN KEY Quiz_User (User_id)    REFERENCES User (id);
-- Insert
--  Insert: Difficulty
INSERT INTO TriviaApp.difficulty (difficulty) VALUES ('easy'), ('medium'), ('hard');
--  Insert: Category
INSERT INTO TriviaApp.category (id, topic) VALUES
                                             (9 ,'General Knowledge'),
                                             (10 ,'Entertainment: Books'),
                                             (11 ,'Entertainment: Film'),
                                             (12 ,'Entertainment: Music'),
                                             (13 ,'Entertainment: Musicals & Theatres'),
                                             (14 ,'Entertainment: Television'),
                                             (15 ,'Entertainment: Video Games'),
                                             (16 ,'Entertainment: Board Games'),
                                             (17 ,'Science & Nature'),
                                             (18 ,'Science: Computers'),
                                             (19 ,'Science: Mathematics'),
                                             (20 ,'Mythology'),
                                             (21 ,'Sports'),
                                             (22 ,'Geography'),
                                             (23 ,'History'),
                                             (24 ,'Politics'),
                                             (25 ,'Art'),
                                             (26 ,'Celebrities'),
                                             (27 ,'Animals'),
                                             (28 ,'Vehicles'),
                                             (29 ,'Entertainment: Comics'),
                                             (30 ,'Science: Gadgets'),
                                             (31 ,'Entertainment: Japanese Anime & Manga'),
                                             (32 ,'Entertainment: Cartoon & Animations')
;