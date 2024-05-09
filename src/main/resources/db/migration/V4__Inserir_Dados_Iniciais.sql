-- Inserir dados iniciais para a tabela 'category'
INSERT INTO category (id ,name, image, created_at, updated_at) VALUES
(1,'Eletrônicos', 'https://i.ibb.co/1QzkGf7/Electronica.png', current_timestamp, current_timestamp),
(2,'Moda', 'https://i.ibb.co/Chjv3k8/Moda.png', current_timestamp, current_timestamp),
(3,'Alimentação', 'https://i.ibb.co/hLpVpZX/Alimentaci-n.png', current_timestamp, current_timestamp),
(4,'Casa e Jardim', 'https://i.ibb.co/s2GpH7J/Hogar-y-jardin.png', current_timestamp, current_timestamp),
(5,'Saúde e Beleza', 'https://i.ibb.co/ZSsFGNL/Salud-y-belleza.png', current_timestamp, current_timestamp)
ON CONFLICT DO NOTHING;


-- Inserir dados iniciais para a tabela 'product'
INSERT INTO product (id, title, price, description, category_id, created_at, updated_at,image) VALUES
(1,'Jaqueta de Couro Estilo Motociclista', 299.99, 'Jaqueta de couro com estilo motociclista.', 2, current_timestamp, current_timestamp, 'https://i.ibb.co/0hXWpfn/Chaqueta-de-Cuero-Estilo-Motociclista.png'),
(2,'Tênis Adidas Ultraboost', 199.99, 'Tênis esportivo da marca Adidas, modelo Ultraboost.', 2, current_timestamp, current_timestamp, 'https://i.ibb.co/7jKp0rs/Zapatillas-Adidas-Ultraboost.png'),
(3,'Calça Jeans Levi''s 501 Original', 149.99, 'Calça jeans clássica da marca Levi''s, modelo 501 Original.', 2, current_timestamp, current_timestamp, 'https://i.ibb.co/yn9tWB2/Jeans-Levi-s-501-Original.png'),
(4,'Vestido Elegante de Noite', 129.99, 'Vestido elegante para eventos noturnos.', 2, current_timestamp, current_timestamp, 'https://i.ibb.co/WVY7wyD/Vestido-Elegante-de-Noche.png'),
(5,'Camiseta Nike Dri-FIT', 39.99, 'Camiseta esportiva da marca Nike, tecnologia Dri-FIT para absorção de suor.', 2, current_timestamp, current_timestamp, 'https://i.ibb.co/Hpv1gLk/Camiseta-Nike-Dri-FIT.png'),
(6,'Fones de Ouvido sem Fio Bose Quiet Comfort 35', 349.99, 'Fones de ouvido sem fio da marca Bose, modelo Quiet Comfort 35.', 1, current_timestamp, current_timestamp, 'https://i.ibb.co/YTb1Ybv/Auriculares-Inal-mbricos-Bose-Quiet-Comfort-35.png'),
(7,'Console Play Station 5', 4499.99, 'Console de videogame da Sony, modelo Play Station 5.', 1, current_timestamp, current_timestamp, 'https://i.ibb.co/BcqzzgF/Consola-Play-Station-5.png'),
(8,'Câmera Sony Alpha A7 III', 1299.99, 'Câmera fotográfica da Sony, modelo Alpha A7 III.', 1, current_timestamp, current_timestamp, 'https://i.ibb.co/ZHT2r1s/C-mara-Sony-Alpha-A7-III.png'),
(9,'Smartphone Samsung Galaxy S21', 1799.99, 'Smartphone da Samsung, modelo Galaxy S21.', 1, current_timestamp, current_timestamp, 'https://i.ibb.co/mXkVjdS/Smartphone-Samsung-Galaxy-S21.png'),
(10,'Apple Mac Book Pro', 8999.99, 'Notebook da Apple, modelo Mac Book Pro.', 1, current_timestamp, current_timestamp, 'https://i.ibb.co/cDj3dpX/Apple-Mac-Book-Pro.png'),
(11,'La Roche-Posay Effaclar Sérum Ultra Concentrado', 174.72, 'Eficácia clinicamente comprovada com resultados visíveis: -45% Espinhas; -49% Marcas de Acne;', 5, current_timestamp, current_timestamp, 'https://m.media-amazon.com/images/I/51za6kC9k1L._AC_SX679_.jpg'),
(12,'Vichy Mineral 89 Sérum Concentrado Hidratante', 139.90, 'Hidrata e fortalece a pele com ácido hialurônico de origem natural e Água Termal Mineralizante de Vichy. Ideal para todos os tipos de pele, inclusive as sensíveis.', 5, current_timestamp, current_timestamp, 'https://m.media-amazon.com/images/I/51uM+yRQcJL._AC_SX342_SY445_.jpg'),
(13,'Cetaphil Gentle Skin Cleanser', 59.90, 'Limpador facial suave e não comedogênico, ideal para peles sensíveis e secas. Remove impurezas sem agredir a pele.', 5, current_timestamp, current_timestamp, 'https://m.media-amazon.com/images/I/71xY1eaDeKL._SX466_.jpg'),
(14,'Nivea Creme', 34.90, 'Creme hidratante clássico para o rosto e corpo. Hidrata profundamente e protege a pele por até 24 horas.', 5, current_timestamp, current_timestamp, 'https://m.media-amazon.com/images/I/51U+ULwABqL._AC_SY300_SX300_.jpg'),
(15,'Bepantol Derma Pomada', 29.90, 'Pomada reparadora para peles secas, rachadas e irritadas. Promove a cicatrização e hidrata profundamente.', 5, current_timestamp, current_timestamp, 'https://m.media-amazon.com/images/I/41AKkxml0kL._AC_SX679_.jpg'),
(16,'Eucerin Hyaluron-Filler Creme para Olhos', 119.90, 'Creme anti-rugas para a área dos olhos com ácido hialurônico e vitamina B5. Preenche rugas, reduz olheiras e bolsas.', 5, current_timestamp, current_timestamp, 'https://m.media-amazon.com/images/I/71iDL2frZYL._AC_SX679_.jpg'),
(17,'Leite Integral', 5.99, 'Leite integral pasteurizado.', 3, current_timestamp, current_timestamp, 'https://img.freepik.com/fotos-premium/leite-de-aveia-na-garrafa-de-vidro-na-madeira-rustica_271740-2553.jpg?w=740'),
(18,'Pão de Forma Integral', 3.49, 'Pão de forma integral com 8 grãos.', 3, current_timestamp, current_timestamp, 'https://img.freepik.com/fotos-premium/fatias-de-pao-na-placa-de-madeira_23-2148359137.jpg?w=1380'),
(19,'Granola com Castanhas e Frutas Secas', 12.99, 'Granola crocante com castanhas e frutas secas.', 3, current_timestamp, current_timestamp, 'https://img.freepik.com/fotos-gratis/sortido-de-comida-infantil-saboroso-alto-angulo_23-2149627800.jpg?t=st=1715186244~exp=1715189844~hmac=a4cff449d412a033beee8ce52e492fbfdf99f9dc452d50ba1a768127c750cf51&w=740'),
(20,'Maçã Fuji', 2.99, 'Maçã Fuji fresca e crocante.', 3, current_timestamp, current_timestamp, 'https://img.freepik.com/fotos-gratis/maca-vermelha-com-a-folha-verde-no-fundo-branco_1232-3290.jpg?t=st=1715186301~exp=1715189901~hmac=6104a113f8b88f15749bbffe04ce771247b85c60d243511477da6f5816d84b67&w=1380'),
(21,'Iogurte Natural Integral', 4.50, 'Iogurte natural integral sem adição de açúcares.', 3, current_timestamp, current_timestamp, 'https://img.freepik.com/fotos-premium/delicioso-iogurte-com-mirtilos-e-morangos-close-up_122799-127.jpg?w=740'),
(22,'Jogo de Cama Queen Size', 199.99, 'Jogo de cama Queen Size em algodão 100%.', 4, current_timestamp, current_timestamp, 'https://img.freepik.com/fotos-gratis/arranjo-de-cama-aconchegante-de-alto-angulo_23-2150326152.jpg?t=st=1715186398~exp=1715189998~hmac=bf28ac0d9ca9fb025b5193062d2d90d497df0e0bc0f53c631d714bbcfaebef55&w=740'),
(23,'Conjunto de Sofá e Poltrona', 1299.99, 'Conjunto de sofá e poltrona em couro sintético.', 4, current_timestamp, current_timestamp, 'https://img.freepik.com/fotos-gratis/travesseiro-no-interior-da-decoracao-do-sofa-da-sala-de-estar_74190-12625.jpg?t=st=1715186465~exp=1715190065~hmac=dd58bf4800dc211ee7e10aca9c8a956e1b5142bbc804af9c81b8f02806639dbb&w=1380'),
(24,'Churrasqueira Elétrica', 249.99, 'Churrasqueira elétrica portátil com grelha antiaderente.', 4, current_timestamp, current_timestamp, 'https://img.freepik.com/fotos-gratis/homem-grelhando-carne-linguicas-ao-ar-livre_53876-63336.jpg?t=st=1715186714~exp=1715190314~hmac=c1a36dc6fa4b80d1f27923ab1853e19d27cacf5eb2596820cfd90f31bcb0e37f&w=1060'),
(25,'Kit de Ferramentas para Jardim', 99.99, 'Kit de ferramentas para jardinagem com 10 peças.', 4, current_timestamp, current_timestamp, 'https://img.freepik.com/fotos-premium/vista-de-alto-angulo-de-varias-flores-na-mesa_1048944-9273677.jpg?w=1380'),
(26 ,'Luminária de Mesa Decorativa', 59.99, 'Luminária de mesa decorativa com abajur de tecido.', 4, current_timestamp, current_timestamp, 'https://img.freepik.com/fotos-premium/lampada-elegante-na-mesa-contra-um-fundo-claro_917213-38000.jpg?w=826')
ON CONFLICT DO NOTHING;