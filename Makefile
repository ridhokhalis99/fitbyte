dev-up:
	docker compose --env-file .env.dev up -d --build

dev-down:
	docker compose --env-file .env.dev down

logs:
	docker compose --env-file .env.dev logs -f app db
