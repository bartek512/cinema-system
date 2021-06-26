INSERT INTO CINEMA (id, cinema_adress, cinema_name)
VALUES (1, 'Kazimierza Wielkiego', 'Nowe Horyzonty');

INSERT INTO CINEMA (id, cinema_adress, cinema_name)
VALUES (2, 'Kazimierza Wielkiego', 'Nowe Horyzonty');

INSERT INTO CINEMA (id, cinema_adress, cinema_name)
VALUES (3, 'Zczekladowa', 'Bielany aleja');

INSERT INTO AUDITORIUM (id, auditorium_number, auditorium_type, cinema_id)
VALUES (1, 1, 'TYPE_2D', 1);

INSERT INTO AUDITORIUM (id, auditorium_number, auditorium_type, cinema_id)
VALUES (2, 5, 'TYPE_2D', 1);

INSERT INTO AUDITORIUM (id, auditorium_number, auditorium_type, cinema_id)
VALUES (5, 5, 'TYPE_2D', 1);

INSERT INTO SEAT (id, seat_number, seat_row, seat_type, auditorium_id)
VALUES (1, 1, 'a', 'COMMON_SEAT', 1);
INSERT INTO SEAT (id, seat_number, seat_row, seat_type, auditorium_id)
VALUES (2, 2, 'a', 'COMMON_SEAT', 1);
INSERT INTO SEAT (id, seat_number, seat_row, seat_type, auditorium_id)
VALUES (3, 1, 'b', 'COMMON_SEAT', 1);
INSERT INTO SEAT (id, seat_number, seat_row, seat_type, auditorium_id)
VALUES (4, 2, 'b', 'COMMON_SEAT', 1);
INSERT INTO SEAT (id, seat_number, seat_row, seat_type, auditorium_id)
VALUES (5, 3, 'c', 'COMMON_SEAT', 1);



INSERT INTO MOVIE(id, age_category, available_from, available_until, movie_category, title, year)
VALUES (1, 'ADULT', '2021-06-10', '2021-06-25', 'HORROR', 'straszny film', 2015);

INSERT INTO MOVIE(id, age_category, available_from, available_until, movie_category, title, year)
VALUES (2, 'ADULT', '2021-05-10', '2021-05-25', 'COMEDY', 'American Pie', 2012);

INSERT INTO MOVIE(id, age_category, available_from, available_until, movie_category, title, year)
VALUES (3, 'CHILDREN', '2021-05-10', '2021-05-25', 'COMEDY', 'Toy Story', 2012);

INSERT INTO MOVIE(id, age_category, available_from, available_until, movie_category, title, year)
VALUES (4, 'ADULT', '2021-06-10', '2021-06-25', 'HORROR', 'smieszny film', 2015);

INSERT INTO MOVIE(id, age_category, available_from, available_until, movie_category, title, year)
VALUES (5, 'ADULT', '2021-06-10', '2021-06-25', 'HORROR', 'smieszny film', 2015);

INSERT INTO SCREENING (id, screening_date, auditorium_id, movie_id)
VALUES (1, '2021-06-15', 1, 1);

INSERT INTO SCREENING (id, screening_date, auditorium_id, movie_id)
VALUES (2, '2021-05-15', 1, 2);

INSERT INTO SCREENING (id, screening_date, auditorium_id, movie_id)
VALUES (3, '2021-05-15', 1, 3);

INSERT INTO SCREENING (id, screening_date, auditorium_id, movie_id)
VALUES (4, '2021-05-15', 1, 3);

INSERT INTO SCREENING (id, screening_date, auditorium_id, movie_id)
VALUES (5, '2021-05-15', 1, 4);

INSERT INTO SCREENING (id, screening_date, auditorium_id, movie_id)
VALUES (6, '2021-05-15', 1, 5);

INSERT INTO CUSTOMER(id, email, first_name, last_name, phone_number)
VALUES (1, 'andrzej@onet.pl', 'Andrzej', 'Nowak', '123456778');

INSERT INTO CUSTOMER(id, email, first_name, last_name, phone_number)
VALUES (2, 'blazej@onet.pl', 'Blazej', 'Nowak', '434343434');

INSERT INTO CUSTOMER(id, email, first_name, last_name, phone_number)
VALUES (3, 'tomek@onet.pl', 'Tomek', 'Nowak', '546545645');

INSERT INTO CUSTOMER(id, email, first_name, last_name, phone_number)
VALUES (4, 'michal@onet.pl', 'Michal', 'Michalski', '131343444');

INSERT INTO CUSTOMER(id, email, first_name, last_name, phone_number)
VALUES (5, 'mateusz@onet.pl', 'Mateusz', 'Nowak', '78867567');



INSERT INTO RESERVATION(id, booking_type, created_date, price, reservation_status, auditorium_id, customer_id,
                        screening_id)
VALUES (1, 'ONLINE', '2021-05-15', 25, 'CANCELLED', 1, 1, 1);
INSERT INTO RESERVATION(id, booking_type, created_date, price, reservation_status, auditorium_id, customer_id,
                        screening_id)
VALUES (65, 'ONLINE', '2021-04-10', 25, 'PAYED', 1, 1, 1);

INSERT INTO RESERVATION(id, booking_type, created_date, price, reservation_status, auditorium_id, customer_id,
                        screening_id)
VALUES (2, 'ONLINE', '2021-05-12', 33, 'CANCELLED', 1, 2, 2);

INSERT INTO RESERVATION(id, booking_type, created_date, price, reservation_status, auditorium_id, customer_id,
                        screening_id)
VALUES (3, 'ONLINE', '2021-05-13', 33, 'CANCELLED', 1, 3, 2);

INSERT INTO RESERVATION(id, booking_type, created_date, price, reservation_status, auditorium_id, customer_id,
                        screening_id)
VALUES (4, 'ONLINE', '2021-05-15', 32, 'CANCELLED', 1, 4, 2);

INSERT INTO RESERVATION(id, booking_type, created_date, price, reservation_status, auditorium_id, customer_id,
                        screening_id)
VALUES (5, 'ONLINE', '2021-05-15', 22, 'CANCELLED', 1, 5, 2);

INSERT INTO RESERVATION(id, booking_type, created_date, price, reservation_status, auditorium_id, customer_id,
                        screening_id)
VALUES (6, 'ONLINE', '2021-05-11', 32, 'CANCELLED', 1, 1, 2);

INSERT INTO RESERVATION(id, booking_type, created_date, price, reservation_status, auditorium_id, customer_id,
                        screening_id)
VALUES (7, 'ONLINE', '2021-05-17', 34, 'CANCELLED', 1, 2, 2);

INSERT INTO RESERVATION(id, booking_type, created_date, price, reservation_status, auditorium_id, customer_id,
                        screening_id)
VALUES (8, 'STATIONARY', '2021-05-12', 35, 'CANCELLED', 1, 3, 2);

INSERT INTO RESERVATION(id, booking_type, created_date, price, reservation_status, auditorium_id, customer_id,
                        screening_id)
VALUES (9, 'ONLINE', '2021-05-15', 33, 'CANCELLED', 1, 4, 2);

INSERT INTO RESERVATION(id, booking_type, created_date, price, reservation_status, auditorium_id, customer_id,
                        screening_id)
VALUES (10, 'ONLINE', '2021-05-19', 31, 'CANCELLED', 1, 5, 2);

INSERT INTO RESERVATION(id, booking_type, created_date, price, reservation_status, auditorium_id, customer_id,
                        screening_id)
VALUES (11, 'ONLINE', '2021-05-11', 27, 'CANCELLED', 1, 1, 2);

INSERT INTO RESERVATION(id, booking_type, created_date, price, reservation_status, auditorium_id, customer_id,
                        screening_id)
VALUES (12, 'STATIONARY', '2021-05-15', 22, 'CANCELLED', 1, 2, 2);

INSERT INTO RESERVATION(id, booking_type, created_date, price, reservation_status, auditorium_id, customer_id,
                        screening_id)
VALUES (13, 'STATIONARY', '2021-05-15', 15, 'CANCELLED', 1, 3, 2);

INSERT INTO RESERVATION(id, booking_type, created_date, price, reservation_status, auditorium_id, customer_id,
                        screening_id)
VALUES (14, 'ONLINE', '2021-05-15', 25, 'CANCELLED', 1, 1, 3);

INSERT INTO RESERVATION(id, booking_type, created_date, price, reservation_status, auditorium_id, customer_id,
                        screening_id)
VALUES (15, 'ONLINE', '2021-05-11', 33, 'CANCELLED', 1, 2, 3);

INSERT INTO RESERVATION(id, booking_type, created_date, price, reservation_status, auditorium_id, customer_id,
                        screening_id)
VALUES (16, 'ONLINE', '2021-05-15', 33, 'CANCELLED', 1, 3, 3);

INSERT INTO RESERVATION(id, booking_type, created_date, price, reservation_status, auditorium_id, customer_id,
                        screening_id)
VALUES (17, 'STATIONARY', '2021-05-15', 32, 'CANCELLED', 1, 4, 3);

INSERT INTO RESERVATION(id, booking_type, created_date, price, reservation_status, auditorium_id, customer_id,
                        screening_id)
VALUES (25, 'ONLINE', '2021-05-15', 22, 'CANCELLED', 1, 5, 3);

INSERT INTO RESERVATION(id, booking_type, created_date, price, reservation_status, auditorium_id, customer_id,
                        screening_id)
VALUES (26, 'ONLINE', '2021-05-13', 32, 'CANCELLED', 1, 1, 3);

INSERT INTO RESERVATION(id, booking_type, created_date, price, reservation_status, auditorium_id, customer_id,
                        screening_id)
VALUES (27, 'ONLINE', '2021-05-15', 34, 'CANCELLED', 1, 2, 3);

INSERT INTO RESERVATION(id, booking_type, created_date, price, reservation_status, auditorium_id, customer_id,
                        screening_id)
VALUES (28, 'STATIONARY', '2021-05-15', 35, 'CANCELLED', 1, 3, 3);

INSERT INTO RESERVATION(id, booking_type, created_date, price, reservation_status, auditorium_id, customer_id,
                        screening_id)
VALUES (29, 'ONLINE', '2021-05-14', 33, 'CANCELLED', 1, 4, 3);

INSERT INTO RESERVATION(id, booking_type, created_date, price, reservation_status, auditorium_id, customer_id,
                        screening_id)
VALUES (30, 'STATIONARY', '2021-05-14', 33, 'CANCELLED', 1, 4, 3);

INSERT INTO RESERVATION(id, booking_type, created_date, price, reservation_status, auditorium_id, customer_id,
                        screening_id)
VALUES (210, 'ONLINE', '2021-05-15', 31, 'CANCELLED', 1, 5, 3);

INSERT INTO RESERVATION(id, booking_type, created_date, price, reservation_status, auditorium_id, customer_id,
                        screening_id)
VALUES (211, 'ONLINE', '2021-05-16', 27, 'CANCELLED', 1, 1, 3);

INSERT INTO RESERVATION(id, booking_type, created_date, price, reservation_status, auditorium_id, customer_id,
                        screening_id)
VALUES (212, 'ONLINE', '2021-05-15', 22, 'CANCELLED', 1, 2, 3);

INSERT INTO RESERVATION(id, booking_type, created_date, price, reservation_status, auditorium_id, customer_id,
                        screening_id)
VALUES (123, 'ONLINE', '2021-05-17', 15, 'CANCELLED', 1, 3, 3);

INSERT INTO RESERVATION(id, booking_type, created_date, price, reservation_status, auditorium_id, customer_id,
                        screening_id)
VALUES (43, 'ONLINE', '2021-06-17', 15, 'PAYED', 1, 3, 2);

INSERT INTO RESERVATION(id, booking_type, created_date, price, reservation_status, auditorium_id, customer_id,
                        screening_id)
VALUES (55, 'ONLINE', '2021-06-18', 15, 'CANCELLED', 1, 3, 1);

INSERT INTO RESERVATION(id, booking_type, created_date, price, reservation_status, auditorium_id, customer_id,
                        screening_id)
VALUES (76, 'ONLINE', '2021-06-16', 15, 'PAYED', 1, 3, 3);

INSERT INTO RESERVATION(id, booking_type, created_date, price, reservation_status, auditorium_id, customer_id,
                        screening_id)
VALUES (88, 'ONLINE', '2021-06-10', 15, 'PAYED', 1, 3, 2);

INSERT INTO RESERVATION(id, booking_type, created_date, price, reservation_status, auditorium_id, customer_id,
                        screening_id)
VALUES (89, 'ONLINE', '2021-06-13', 15, 'CANCELLED', 1, 3, 1);

INSERT INTO RESERVATION(id, booking_type, created_date, price, reservation_status, auditorium_id, customer_id,
                        screening_id)
VALUES (90, 'ONLINE', '2021-06-12', 15, 'PAYED', 1, 3, 3);



INSERT INTO SEAT_TO_RESERVATION(reservation_id, seat_id)
VALUES (88, 1);
INSERT INTO SEAT_TO_RESERVATION(reservation_id, seat_id)
VALUES (89, 1);
INSERT INTO SEAT_TO_RESERVATION(reservation_id, seat_id)
VALUES (90, 1);


INSERT INTO SEAT_TO_RESERVATION(reservation_id, seat_id)
VALUES (1, 1);
INSERT INTO SEAT_TO_RESERVATION(reservation_id, seat_id)
VALUES (43, 1);
INSERT INTO SEAT_TO_RESERVATION(reservation_id, seat_id)
VALUES (55, 1);
INSERT INTO SEAT_TO_RESERVATION(reservation_id, seat_id)
VALUES (76, 1);

INSERT INTO SEAT_TO_RESERVATION(reservation_id, seat_id)
VALUES (2, 3);

INSERT INTO SEAT_TO_RESERVATION(reservation_id, seat_id)
VALUES (17, 3);
INSERT INTO SEAT_TO_RESERVATION(reservation_id, seat_id)
VALUES (16, 3);
INSERT INTO SEAT_TO_RESERVATION(reservation_id, seat_id)
VALUES (15, 3);
INSERT INTO SEAT_TO_RESERVATION(reservation_id, seat_id)
VALUES (14, 3);
INSERT INTO SEAT_TO_RESERVATION(reservation_id, seat_id)
VALUES (13, 3);
INSERT INTO SEAT_TO_RESERVATION(reservation_id, seat_id)
VALUES (12, 3);
INSERT INTO SEAT_TO_RESERVATION(reservation_id, seat_id)
VALUES (11, 3);
INSERT INTO SEAT_TO_RESERVATION(reservation_id, seat_id)
VALUES (10, 3);
INSERT INTO SEAT_TO_RESERVATION(reservation_id, seat_id)
VALUES (9, 3);
INSERT INTO SEAT_TO_RESERVATION(reservation_id, seat_id)
VALUES (8, 3);
INSERT INTO SEAT_TO_RESERVATION(reservation_id, seat_id)
VALUES (7, 3);
INSERT INTO SEAT_TO_RESERVATION(reservation_id, seat_id)
VALUES (6, 3);
INSERT INTO SEAT_TO_RESERVATION(reservation_id, seat_id)
VALUES (5, 3);
INSERT INTO SEAT_TO_RESERVATION(reservation_id, seat_id)
VALUES (4, 3);
INSERT INTO SEAT_TO_RESERVATION(reservation_id, seat_id)
VALUES (3, 3);
INSERT INTO SEAT_TO_RESERVATION(reservation_id, seat_id)
VALUES (65, 5);
