#!make

up:
	docker compose up -d

down:
	docker compose down
.PHONY: build
build:
	docker compose up -d --build

deploy:
	docker network inspect build-and-roll-network >/dev/null 2>&1 || \
		docker network create --driver bridge build-and-roll-network
	make build
	make up


