INSERT INTO reward_categories (uuid, name, description, created_at, updated_at) VALUES ('faa0784d-ad27-48d9-b075-eb52c0c39328','Gift Card', 'Cartão presente.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO reward_categories (uuid, name, description, created_at, updated_at) VALUES ('3b4654bc-f25b-4412-ade3-a7c096d6f51b','Aluguel Veicular', 'Alugue veículos Ford.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO reward_categories (uuid, name, description, created_at, updated_at) VALUES ('1d786a5d-7134-42c0-87fa-ff804ad29c72','Assinaturas', 'Assine veículos Ford.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO reward_categories (uuid, name, description, created_at, updated_at) VALUES ('4b6b1298-29ad-4ece-a502-f1899bbcdf00','Combustível', 'Descontos em combustível.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO reward_categories (uuid, name, description, created_at, updated_at) VALUES ('kdl240d-34dg-42ce-b232-f3429b3cdf11','Serviço Veicular', 'Serviços para veículos.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO reward_categories (uuid, name, description, created_at, updated_at) VALUES ('3lsmot4-kj02-14dd-l5n2-g8239b3cdff4','Viagem', 'Serviços de viagem.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO customers (uuid, first_name, last_name, email, document, status, points_wallet, created_at, updated_at)
    VALUES ('85958','Guilherme', 'de Mira', 'gui_demira@gmail.com', '32985407060', 'ACTIVE', 1000000, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO customers (uuid, first_name, last_name, email, document, status, points_wallet, created_at, updated_at)
    VALUES ('85706','Noah', 'Bergamo', 'noah_bergamo@gmail.com', '22134146028', 'ACTIVE', 10000, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO customers (uuid, first_name, last_name, email, document, status, points_wallet, created_at, updated_at)
    VALUES ('84233','Gianluca', 'Striatto', 'gian_striatto@gmail.com', '50005096090', 'ACTIVE', 12000, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO customers (uuid, first_name, last_name, email, document, status, points_wallet, created_at, updated_at)
    VALUES ('84863','Wilker', 'Santos', 'wilker_santos@gmail.com', '93472962011', 'ACTIVE', 9000, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO customers (uuid, first_name, last_name, email, document, status, points_wallet, created_at, updated_at)
    VALUES ('84386','Samuel', 'Souza', 'samuel_souza@gmail.com', '57623239007', 'ACTIVE', 9000, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO customers (uuid, first_name, last_name, email, document, status, points_wallet, created_at, updated_at)
    VALUES ('81868','Sttela', 'Bastos', 'sttela_bastos@gmail.com', '37951760005', 'ACTIVE', 11000, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO partners (uuid, name, description, created_at, updated_at)
    VALUES ('ford-1', 'Ford', 'Ford é o parceiro padrão.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO partners (uuid, name, description, created_at, updated_at)
    VALUES ('lincoln-1', 'Lincoln', 'Lincoln é a linha de carros de luxo da Ford.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);


