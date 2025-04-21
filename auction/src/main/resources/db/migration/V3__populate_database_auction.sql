INSERT INTO auction (
    expiration_date, highest_bid, is_finished, public_id, starting_price, pig_id, highest_bidder_id
) VALUES
('2030-05-01', 1500.00, false, gen_random_uuid(), 1000.00, 1, NULL),
('2030-05-15', 1250.00, false, gen_random_uuid(), 900.00, 2, NULL),
('2030-06-01', 1800.00, false, gen_random_uuid(), 1200.00, 3, NULL);
