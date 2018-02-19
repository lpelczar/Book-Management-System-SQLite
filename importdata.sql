CREATE TEMP TABLE booksTEMP (
  ISBN,
  author,
  title,
  publisher,
  publication_year,
  price,
  type
);

CREATE TEMP TABLE authorsTEMP (
  author_id,
  name,
  surname,
  birth_year,
  city,
  country
);

CREATE TEMP TABLE publishersTEMP (
  publisher_id,
  name,
  city,
  country
);

CREATE TEMP TABLE type_booksTEMP (
  type_id,
  type
);

.mode csv
.import Books.csv booksTEMP
.import Authors.csv authorsTEMP
.import Publishers.csv publishersTEMP
.import TypeBooks.csv type_booksTEMP

INSERT INTO books (
  ISBN,
  author,
  title,
  publisher,
  publication_year,
  price,
  type
) SELECT * FROM booksTEMP WHERE ROWID != 1;

INSERT INTO authors (
  author_id,
  name,
  surname,
  birth_year,
  city,
  country
) SELECT * FROM authorsTEMP WHERE ROWID != 1;

INSERT INTO publishers (
  publisher_id,
  name,
  city,
  country
) SELECT * FROM publishersTEMP WHERE ROWID != 1;

INSERT INTO type_books (
  type_id,
  type
) SELECT * FROM type_booksTEMP WHERE ROWID != 1;