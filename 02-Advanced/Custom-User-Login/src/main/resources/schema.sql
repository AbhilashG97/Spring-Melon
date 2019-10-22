DROP TABLE if EXISTS users;

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `fullname` varchar(100) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name_UNIQUE` (`username`),
  UNIQUE KEY `user_id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

