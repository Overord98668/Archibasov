-- Создание тестовых данных
INSERT INTO user (username, email) VALUES 
('john_doe', 'john@example.com'),
('jane_smith', 'jane@example.com'),
('bob_wilson', 'bob@example.com');

INSERT INTO categories (categories_name) VALUES 
('Food'),
('Transportation'),
('Entertainment'),
('Utilities'),
('Healthcare'),
('Shopping');

INSERT INTO expenses (user_id, categories_id, amount, data) VALUES 
(1, 1, 25.50, '2024-01-15'),
(1, 2, 45.00, '2024-01-16'),
(1, 3, 30.00, '2024-01-17'),
(2, 1, 18.75, '2024-01-15'),
(2, 4, 120.00, '2024-01-18'),
(3, 2, 35.25, '2024-01-19'),
(3, 5, 85.00, '2024-01-20');
