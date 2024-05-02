CREATE TABLE Author (
    id VARCHAR(36)  PRIMARY KEY NOT NULL,
    email VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    created_at DATETIME NOT NULL,
    description MEDIUMTEXT NOT NULL
);

CREATE TABLE Category (
    id VARCHAR(36)  PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    created_at DATETIME NOT NULL
);

CREATE TABLE Book (
    id VARCHAR(36)  PRIMARY KEY NOT NULL,
    title VARCHAR(255) NOT NULL,
    resume MEDIUMTEXT,
    summary LONGTEXT,
    price DECIMAL,
    number_page INT,
    isbn VARCHAR(255),
    date_publication DATETIME,
    category_id VARCHAR(255) NOT NULL,
    author_id VARCHAR(255) NOT NULL,
    created_at DATETIME NOT NULL,

    CONSTRAINT fk_category_book FOREIGN KEY (category_id) REFERENCES Category(id),
    CONSTRAINT fk_author_book FOREIGN KEY (author_id) REFERENCES Author(id)
);