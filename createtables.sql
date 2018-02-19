CREATE TABLE publishers (
  publisher_id TEXT PRIMARY KEY ,
  name TEXT,
  city TEXT,
  country TEXT
);

CREATE TABLE authors (
  author_id INTEGER PRIMARY KEY ,
  name TEXT,
  surname TEXT,
  birth_year INTEGER,
  city TEXT,
  country TEXT
);

CREATE TABLE type_books (
  type_id INTEGER PRIMARY KEY ,
  type TEXT
);

CREATE TABLE books (
  ISBN INTEGER PRIMARY KEY,
  author INTEGER,
  title TEXT,
  publisher TEXT,
  publication_year INTEGER,
  price REAL,
  type INTEGER,
  FOREIGN KEY (publisher) REFERENCES publishers(publisher_id) ON DELETE CASCADE,
  FOREIGN KEY (author) REFERENCES authors(author_id) ON DELETE CASCADE,
  FOREIGN KEY (type) REFERENCES type_books(type_id) ON DELETE CASCADE
);