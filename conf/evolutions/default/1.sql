# --- !Ups
CREATE TABLE "BOARD_POSTS" (
  "ID" IDENTITY PRIMARY KEY,
  "NAME" VARCHAR(255),
  "MESSAGE" VARCHAR(255),
  "IP_ADDRESS" VARCHAR(50),
  "CREATED_AT" TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

# --- !Downs
DROP TABLE "BOARD_POSTS";
