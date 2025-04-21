CREATE TABLE pigs (
    pig_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    weight DOUBLE PRECISION NOT NULL,
    age INTEGER NOT NULL,
    breed VARCHAR(255) NOT NULL
);

CREATE TABLE auction (
    auction_id SERIAL PRIMARY KEY,
    expiration_date DATE NOT NULL,
    highest_bid NUMERIC NOT NULL,
    is_finished BOOLEAN NOT NULL,
    public_id UUID NOT NULL,
    starting_price NUMERIC NOT NULL,
    pig_id BIGINT NOT NULL,
    highest_bidder_id UUID,

    CONSTRAINT fk_pigs
        FOREIGN KEY (pig_id)
        REFERENCES pigs(pig_id)
        ON DELETE CASCADE
);
