INSERT INTO user (username, password, email, created_at) VALUES
                                                            ('user1', 'password1', 'user1@example.com', '2023-01-01 00:00:00'),
                                                            ('user2', 'password2', 'user2@example.com', '2023-01-02 00:00:00');
INSERT INTO root (title, description, user) VALUES
                                                   ('Root 1', 'Description of Root 1', 1),
                                                   ('Root 2', 'Description of Root 2', 1),
                                                   ('Root 3', 'Description of Root 3', 2);
INSERT INTO node (title, depth, position, root_id, parent_node_id, content) VALUES
                                                                     ('Node 1', 1, 1, 1, NULL, '내용1'),
                                                                     ('Node 2', 1, 2, 1, NULL, '내용2'),
                                                                     ('Node 3', 2, 1, 1, 1, '내용3'), -- Node 3의 부모 노드는 Node 1입니다.
                                                                     ('Node 4', 1, 1, 2, NULL, '내용4');
