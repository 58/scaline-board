SHELL := /bin/bash

# ------------------------------------------------------------------
# 開発用
# ------------------------------------------------------------------

## 開発用イメージビルド
dev-build:
	docker compose -f compose.yaml -f compose.dev.yaml build

## 開発用コンテナ起動 (バックグラウンド)
dev-up:
	docker compose -f compose.yaml -f compose.dev.yaml up -d

## 開発用コンテナ停止＆コンテナ削除
dev-down:
	docker compose -f compose.yaml -f compose.dev.yaml down

## 開発用ログをフォロー
dev-logs:
	docker compose -f compose.yaml -f compose.dev.yaml logs -f

# ------------------------------------------------------------------
# 本番用
# ------------------------------------------------------------------

## 本番用イメージビルド
prod-build:
	docker compose -f compose.yaml -f compose.prod.yaml build

## 本番用コンテナ起動 (バックグラウンド)
prod-up:
	docker compose -f compose.yaml -f compose.prod.yaml up -d

## 本番用コンテナ停止＆コンテナ削除
prod-down:
	docker compose -f compose.yaml -f compose.prod.yaml down

## 本番用ログをフォロー
prod-logs:
	docker compose -f compose.yaml -f compose.prod.yaml logs -f


# ------------------------------------------------------------------
# ヘルプ
# ------------------------------------------------------------------
help:
	@echo "Usage: make [target]"
	@echo ""
	@echo "開発用:"
	@echo "  dev-build    : Dockerイメージをビルド（開発）"
	@echo "  dev-up       : コンテナ起動（開発）"
	@echo "  dev-down     : コンテナ停止（開発）"
	@echo "  dev-logs     : コンテナログ表示（開発）"
	@echo ""
	@echo "本番用:"
	@echo "  prod-build   : Dockerイメージをビルド（本番）"
	@echo "  prod-up      : コンテナ起動（本番）"
	@echo "  prod-down    : コンテナ停止（本番）"
	@echo "  prod-logs    : コンテナログ表示（本番）"
