create table if not exists promotions (
    id bigint primary key auto_increment,
    title VARCHAR(255) NOT NULL,
    start_time DATE NOT NULL,
    end_time DATE NOT NULL,
    discount DECIMAL(5,2) NOT NULL,
    details TEXT
);