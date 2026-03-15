CREATE TABLE IF NOT EXISTS posts(
    id UUID PRIMARY KEY,
    categoryId UUID NOT NULL,
    title VARCHAR(255) NOT NULL,
    subTitle VARCHAR(255) NOT NULL,
    bodyPost TEXT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,

    CONSTRAINTS fk_post_category
        FOREIGN KEY (categoryId)
        REFERENCES categories(id)
)