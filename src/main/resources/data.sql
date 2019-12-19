INSERT INTO Author(a_name) VALUES ('Me');
INSERT INTO Author(a_name) VALUES ('You');

INSERT INTO Genre(g_name) VALUES ('Children');

INSERT INTO Book(name, genre_g_id, author,age,owner_a_id) VALUES ('Book',1,'Me','1-4',1);
INSERT INTO Book(name, genre_g_id, author,age,owner_a_id) VALUES ('Book2',1,'Me','1-4',2);
INSERT INTO Book(name, genre_g_id, author,age,owner_a_id) VALUES ('Book3',1,'Me','1-4',2);


COMMIT;