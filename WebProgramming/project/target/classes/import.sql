INSERT INTO user(username, password) VALUES ('user', '$2y$12$8ERMZqggZr2KxC02GScYwObu5EAr8UJZ6UZhuaQMX20.6RNvZj.qi'), ('admin', '$2y$12$vMHXocawOUdUhGQCEOBcB.hXd7NQCT9kV1/gvavlLzIlGwJidiW4q');
										
INSERT INTO authorization(name) VALUES ('ADMIN'), ('COMUM');

INSERT INTO user_authorizations(users_id, authorizations_id) VALUES ('1', '2'), ('2', '1');

INSERT INTO product(name, description, stock_quantity, price, release_date, image_path) VALUES ('Object', 'Nondescript', '10', '2.5', DATE('2010-08-05'), 'images/zwei.png');