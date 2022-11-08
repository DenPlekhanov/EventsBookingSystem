INSERT INTO Event (id, "event_name", "event_description", "event_capacity") VALUES
    (0, 'Vacant Event Slot' , 'This Event Slot Is Vacant' ,0),
    (1, 'Event1' , 'Event1_Description' ,201),
    (2, 'Event2' , 'Event2_Description' ,202),
    (3, 'Event3' , 'Event3_Description' ,203),
    (4, 'Event4' , 'Event4_Description' ,204),
    (5, 'Event5' , 'Event5_Description' ,205),
    (6, 'Event6' , 'Event6_Description' ,206);

INSERT INTO place (id, name, description, "type_of_events", "default_event_capacity") VALUES
    (1, 'Place1','Place1_Description','Dancing',100),
    (2, 'Place2','Place2_Description','Dancing',100),
    (3, 'Place3','Place3_Description','Dancing',100),
    (4, 'Place4','Place4_Description','Dancing',100),
    (5, 'Place5','Place5_Description','Dancing',100),
    (6, 'Place6','Place6_Description','Dancing',100);

-- INSERT INTO TimeSlot (id, "event_id" ,  "start_date" , "finish_date" , "place_id") VALUES
--     (1, 1, '2022-07-19','2022-07-20',1),
--     (2, 2, '2022-07-19','2022-07-21',2),
--     (3, 3, '2022-07-19','2022-07-22',3),
--     (4, 4, '2022-07-19','2022-07-23',4),
--     (5, 5, '2022-07-19','2022-07-24',5),
--     (6, 6, '2022-07-19','2022-07-25',6);

INSERT INTO TimeSlot ("event_id" ,  "start_date" , "finish_date" , "place_id") VALUES
    (1, '2022-07-19','2022-07-20',1),
    (2, '2022-07-19','2022-07-21',2),
    (3, '2022-07-19','2022-07-22',3),
    (4, '2022-07-19','2022-07-23',4),
    (5, '2022-07-19','2022-07-24',5),
    (6, '2022-07-19','2022-07-25',6);

-- INSERT INTO t_role(id, name)
-- VALUES (1, 'ROLE_USER'), (2, 'ROLE_ADMIN');
--
-- INSERT INTO t_role(id, name)
-- VALUES (3, 'ROLE_MANAGER');
