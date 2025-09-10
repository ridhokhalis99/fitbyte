CREATE TABLE activity_types (
  code         VARCHAR(50) PRIMARY KEY,
  rate_per_min NUMERIC(8,2) NOT NULL DEFAULT 0
);

INSERT INTO activity_types(code, rate_per_min) VALUES
    ('Walking', 4),
    ('Yoga', 4),
    ('Stretching', 4),
    ('Cycling', 8),
    ('Swimming', 8),
    ('Dancing', 8),
    ('Hiking', 10),
    ('Running', 10),
    ('HIIT', 10),
    ('JumpRope', 10);