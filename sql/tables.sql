CREATE OR UPDATE TABLE usuario (
	id SERIAL PRIMARY KEY NOT NULL,
	name TEXT NOT NULL,
	email TEXT NOT NULL,
	password TEXT NOT NULL,
	dateofbirth TEXT NOT NULL,
	avatar TEXT NOT NULL,
	username TEXT NOT NULL
);

CREATE TABLE posts (
	id SERIAL PRIMARY KEY NOT NULL,
	usuario INTEGER REFERENCES usuario (id),
	message TEXT NOT NULL,
	likes INTEGER DEFAULT 0,
	createdat VARCHAR(255) NOT NULL -- unix timestamp
);

CREATE TABLE likes (
  usuario INTEGER REFERENCES usuario (id),
  post INTEGER REFERENCES posts (id)
);