INSERT INTO restaurante (id, cep, complemento, nome) VALUES
(1L, '0000001', 'Loja 001', 'Loja Pizzas'),
(2L, '0000002', 'Loja 002', 'Loja Pastel'),
(3L, '0000003', 'Loja 003', 'Loja Bebidas');

INSERT INTO cliente (id, cep, complemento, nome) VALUES
(1L, '1000001', 'Apto 01', 'Cliente 1'),
(2L, '1000002', 'Apto 02', 'Cliente 2'),
(3L, '1000003', 'Apto 03', 'Cliente 3');

INSERT INTO produto (id, disponivel, nome, valor_unitario, restaurante_id) VALUES
(1L, true, 'Pizza Portuguesa', 29.0, 1L),
(2L, true, 'Pizza Romeu e Julieta', 21.0, 1L),
(3L, true, 'Pastel de Palmito', 15.0, 2L),
(4L, true, 'Pastel de Queijo', 13.5, 2L),
(5L, true, 'Suco de Laranja', 7.0, 3L),
(6L, true, 'Refrigerante de Uva', 7.0, 3L);

INSERT INTO sacola (id, forma_pagamento, fechada, valor_total, cliente_id) VALUES
(1L, 0, false, 0.0, 1L);