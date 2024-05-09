-- Inserir dados iniciais para a tabela 'category'
INSERT INTO category (name, image, created_at, updated_at) VALUES
('Eletrônicos', 'https://i.ibb.co/1QzkGf7/Electronica.png', current_timestamp, current_timestamp),
('Moda', 'https://i.ibb.co/Chjv3k8/Moda.png', current_timestamp, current_timestamp),
('Alimentação', 'https://i.ibb.co/hLpVpZX/Alimentaci-n.png', current_timestamp, current_timestamp),
('Casa e Jardim', 'https://i.ibb.co/s2GpH7J/Hogar-y-jardin.png', current_timestamp, current_timestamp),
('Saúde e Beleza', 'https://i.ibb.co/ZSsFGNL/Salud-y-belleza.png', current_timestamp, current_timestamp)
ON CONFLICT DO NOTHING;


-- Inserir dados iniciais para a tabela 'product'
INSERT INTO product (title, price, description, category_id, created_at, updated_at) VALUES
('Jaqueta de Couro Estilo Motociclista', 299.99, 'Jaqueta de couro com estilo motociclista.', 2, current_timestamp, current_timestamp),
('Tênis Adidas Ultraboost', 199.99, 'Tênis esportivo da marca Adidas, modelo Ultraboost.', 2, current_timestamp, current_timestamp),
('Calça Jeans Levi''s 501 Original', 149.99, 'Calça jeans clássica da marca Levi''s, modelo 501 Original.', 2, current_timestamp, current_timestamp),
('Vestido Elegante de Noite', 129.99, 'Vestido elegante para eventos noturnos.', 2, current_timestamp, current_timestamp),
('Camiseta Nike Dri-FIT', 39.99, 'Camiseta esportiva da marca Nike, tecnologia Dri-FIT para absorção de suor.', 2, current_timestamp, current_timestamp),
('Fones de Ouvido sem Fio Bose Quiet Comfort 35', 349.99, 'Fones de ouvido sem fio da marca Bose, modelo Quiet Comfort 35.', 1, current_timestamp, current_timestamp),
('Console Play Station 5', 4499.99, 'Console de videogame da Sony, modelo Play Station 5.', 1, current_timestamp, current_timestamp),
('Câmera Sony Alpha A7 III', 1299.99, 'Câmera fotográfica da Sony, modelo Alpha A7 III.', 1, current_timestamp, current_timestamp),
('Smartphone Samsung Galaxy S21', 1799.99, 'Smartphone da Samsung, modelo Galaxy S21.', 1, current_timestamp, current_timestamp),
('Apple Mac Book Pro', 8999.99, 'Notebook da Apple, modelo Mac Book Pro.', 1, current_timestamp, current_timestamp),
('La Roche-Posay Effaclar Sérum Ultra Concentrado', 174.72, 'Eficácia clinicamente comprovada com resultados visíveis: -45% Espinhas; -49% Marcas de Acne;', 5, current_timestamp, current_timestamp),
('Vichy Mineral 89 Sérum Concentrado Hidratante', 139.90, 'Hidrata e fortalece a pele com ácido hialurônico de origem natural e Água Termal Mineralizante de Vichy. Ideal para todos os tipos de pele, inclusive as sensíveis.', 5, current_timestamp, current_timestamp),
('Cetaphil Gentle Skin Cleanser', 59.90, 'Limpador facial suave e não comedogênico, ideal para peles sensíveis e secas. Remove impurezas sem agredir a pele.', 5, current_timestamp, current_timestamp),
('Nivea Creme', 34.90, 'Creme hidratante clássico para o rosto e corpo. Hidrata profundamente e protege a pele por até 24 horas.', 5, current_timestamp, current_timestamp),
('Bepantol Derma Pomada', 29.90, 'Pomada reparadora para peles secas, rachadas e irritadas. Promove a cicatrização e hidrata profundamente.', 5, current_timestamp, current_timestamp),
('Eucerin Hyaluron-Filler Creme para Olhos', 119.90, 'Creme anti-rugas para a área dos olhos com ácido hialurônico e vitamina B5. Preenche rugas, reduz olheiras e bolsas.', 5, current_timestamp, current_timestamp),
('Leite Integral', 5.99, 'Leite integral pasteurizado.', 3, current_timestamp, current_timestamp),
('Pão de Forma Integral', 3.49, 'Pão de forma integral com 8 grãos.', 3, current_timestamp, current_timestamp),
('Granola com Castanhas e Frutas Secas', 12.99, 'Granola crocante com castanhas e frutas secas.', 3, current_timestamp, current_timestamp),
('Maçã Fuji', 2.99, 'Maçã Fuji fresca e crocante.', 3, current_timestamp, current_timestamp),
('Iogurte Natural Integral', 4.50, 'Iogurte natural integral sem adição de açúcares.', 3, current_timestamp, current_timestamp),
('Jogo de Cama Queen Size', 199.99, 'Jogo de cama Queen Size em algodão 100%.', 4, current_timestamp, current_timestamp),
('Conjunto de Sofá e Poltrona', 1299.99, 'Conjunto de sofá e poltrona em couro sintético.', 4, current_timestamp, current_timestamp),
('Churrasqueira Elétrica', 249.99, 'Churrasqueira elétrica portátil com grelha antiaderente.', 4, current_timestamp, current_timestamp),
('Kit de Ferramentas para Jardim', 99.99, 'Kit de ferramentas para jardinagem com 10 peças.', 4, current_timestamp, current_timestamp),
('Luminária de Mesa Decorativa', 59.99, 'Luminária de mesa decorativa com abajur de tecido.', 4, current_timestamp, current_timestamp)
ON CONFLICT DO NOTHING;