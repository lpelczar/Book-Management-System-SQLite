CREATE TABLE books (
  ISBN INTEGER PRIMARY KEY,
  author INTEGER,
  title TEXT,
  publisher TEXT,
  publication_year INTEGER,
  price REAL,
  type INTEGER
);

CREATE TABLE publishers (
  publisher_id TEXT,
  name TEXT,
  city TEXT,
  country TEXT,
  PRIMARY KEY (publisher_id),
  FOREIGN KEY (publisher_id) REFERENCES books(publisher)
);

CREATE TABLE authors (
  author_id INTEGER,
  name TEXT,
  surname TEXT,
  birth_year INTEGER,
  city TEXT,
  country TEXT,
  PRIMARY KEY (author_id),
  FOREIGN KEY (author_id) REFERENCES books(author)
);

CREATE TABLE type_books (
  type_id INTEGER,
  type TEXT,
  PRIMARY KEY (type_id),
  FOREIGN KEY (type_id) REFERENCES books(type)
);