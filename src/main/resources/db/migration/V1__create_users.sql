CREATE TABLE users (
  id            BIGSERIAL PRIMARY KEY,
  email         VARCHAR(255) NOT NULL UNIQUE,
  password_hash VARCHAR(255) NOT NULL,
  name          VARCHAR(60),
  image_uri     TEXT,
  preference    VARCHAR(20),
  weight_unit   VARCHAR(10),
  height_unit   VARCHAR(10),
  weight        NUMERIC(6,2),
  height        NUMERIC(6,2),
  created_at    TIMESTAMPTZ NOT NULL DEFAULT NOW(),
  updated_at    TIMESTAMPTZ NOT NULL DEFAULT NOW()
);
CREATE INDEX idx_users_email ON users(email);