#!/bin/bash

# Limpar o cache do Docker
docker-compose down --rmi all

# Iniciar os containers usando o Docker Compose
docker-compose up -d

# Verificar se os containers foram iniciados corretamente
docker-compose ps

echo "Containers iniciados com sucesso!"
