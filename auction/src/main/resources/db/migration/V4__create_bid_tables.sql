CREATE TABLE bid (
	bid_id SERIAL PRIMARY KEY,
	public_id UUID NOT NULL,
	bidder_id UUID NOT NULL,
	auction_id UUID NOT NULL,
	value NUMERIC NOT NULL,
	timestamp DATE NOT NULL,
	success boolean NOT NULL DEFAULT FALSE
);