-- Insertar roles
INSERT IGNORE INTO roles (name) VALUES ('ROLE_USER');
INSERT IGNORE INTO roles (name) VALUES ('ROLE_ADMIN');

-- Insertar usuario admin (password: admin123)
INSERT IGNORE INTO users (username, email, password) VALUES 
('admin', 'admin@taskmanager.com', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVwUi.');

-- Insertar usuario normal (password: user123)
INSERT IGNORE INTO users (username, email, password) VALUES 
('user', 'user@taskmanager.com', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVwUi.');

-- Asignar roles
INSERT IGNORE INTO user_roles (user_id, role_id) 
SELECT u.id, r.id FROM users u, roles r 
WHERE u.username = 'admin' AND r.name = 'ROLE_ADMIN';

INSERT IGNORE INTO user_roles (user_id, role_id) 
SELECT u.id, r.id FROM users u, roles r 
WHERE u.username = 'user' AND r.name = 'ROLE_USER';