INSERT INTO Author(a_name) VALUES ('Yuval Noah Harari');
INSERT INTO Author(a_name) VALUES ('‎Rudyard Kipling');
INSERT INTO Author(a_name) VALUES ('Neil deGrasse Tyson');

INSERT INTO Genre(g_name) VALUES ('Children');
INSERT INTO Genre(g_name) VALUES ('Science');


INSERT INTO Book(name, genre_g_id,owner_a_id) VALUES ('Astrophysics for People in a Hurry',2,3);
INSERT INTO Book(name, genre_g_id,owner_a_id) VALUES ('Sapiens: A Brief History of Humankind',2,1);
INSERT INTO Book(name, genre_g_id,owner_a_id) VALUES ('Jungle book',1,2);

COMMIT;