# --- !Ups
CREATE TABLE board_posts (
  id IDENTITY PRIMARY KEY,
  name VARCHAR(255),
  message VARCHAR(255),
  ip_address VARCHAR(50),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

# --- !Downs
DROP TABLE board_posts;
