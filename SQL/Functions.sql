
-- Functions
/* Indicates whether more books should be ordered based on the remaining quantity */ 
CREATE OR REPLACE FUNCTION order_more_books(searchISBN numeric(13,0))
    RETURNS BOOLEAN AS $$						-- Boolean function that returns true if more books should be ordered (i.e. stock < 10), false otherwise. 
BEGIN                                                                   -- NOTE: We understand the project mentioned to create the functionality as a tirgger but we made it as a function
    RETURN 10 > (
        SELECT stock
        FROM project.book
        WHERE isbn = searchISBN
    );
END;									-- This function will print to the console saying that an email will be sent to the publisher to get more books based  on the 
									-- amount sold last month.
$$ 	LANGUAGE plpgsql;

