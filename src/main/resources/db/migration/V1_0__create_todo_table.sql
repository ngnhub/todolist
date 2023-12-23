CREATE TABLE IF NOT EXISTS todo_item
(
    id             BIGINT PRIMARY KEY,
    title          TEXT      NOT NULL,
    description    TEXT,
    created_at     TIMESTAMP NOT NULL,
    complete_until TIMESTAMP,
    status         TEXT      NOT NULL
);
