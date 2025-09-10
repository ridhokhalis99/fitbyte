CREATE TABLE activities (
  id                BIGSERIAL PRIMARY KEY,
  user_id           BIGINT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
  activity_type     VARCHAR(50) NOT NULL REFERENCES activity_types(code),
  done_at           TIMESTAMPTZ NOT NULL,
  duration_minutes  INT NOT NULL CHECK (duration_minutes >= 1),
  calories_burned   INT NOT NULL DEFAULT 0,
  created_at        TIMESTAMPTZ NOT NULL DEFAULT NOW(),
  updated_at        TIMESTAMPTZ NOT NULL DEFAULT NOW()
);
CREATE INDEX idx_activities_user_doneat ON activities(user_id, done_at DESC);
CREATE INDEX idx_activities_user_type   ON activities(user_id, activity_type);