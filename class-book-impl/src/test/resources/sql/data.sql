ALTER SEQUENCE credential_generator RESTART;
INSERT INTO credentials (id, creation_date, deleted, modifying_date, password, username)
VALUES (nextval('credential_generator'), current_timestamp, false, current_timestamp, 'uwjwwwefwko', 'steven_venson');
INSERT INTO credentials (id, creation_date, deleted, modifying_date, password, username)
VALUES (nextval('credential_generator'), current_timestamp, false, current_timestamp, 'afdafefsd', 'john_melder');
INSERT INTO credentials (id, creation_date, deleted, modifying_date, password, username)
VALUES (nextval('credential_generator'), current_timestamp, false, current_timestamp, '123fsgsgddd', 'david_vendon');
INSERT INTO credentials (id, creation_date, deleted, modifying_date, password, username)
VALUES (nextval('credential_generator'), current_timestamp, false, current_timestamp, 'sdgsgs134', 'robert_tasert');
INSERT INTO credentials (id, creation_date, deleted, modifying_date, password, username)
VALUES (nextval('credential_generator'), current_timestamp, false, current_timestamp, 'qwssssgr34', 'david_hekson');

ALTER SEQUENCE group_generator RESTART;
INSERT INTO groups (id, creation_date, deleted, modifying_date, group_title)
VALUES (nextval('group_generator'), current_timestamp, false, current_timestamp, '2A');
INSERT INTO groups (id, creation_date, deleted, modifying_date, group_title)
VALUES (nextval('group_generator'), current_timestamp, false, current_timestamp, '3A');
INSERT INTO groups (id, creation_date, deleted, modifying_date, group_title)
VALUES (nextval('group_generator'), current_timestamp, false, current_timestamp, '4A');

ALTER SEQUENCE student_generator RESTART;
INSERT INTO students (id, creation_date, deleted, modifying_date, first_name, last_name, credential, group_id)
VALUES (nextval('student_generator'), current_timestamp, false, current_timestamp, 'Steven','Venson', 1,1);
INSERT INTO students (id, creation_date, deleted, modifying_date, first_name, last_name, credential, group_id)
VALUES (nextval('student_generator'), current_timestamp, false, current_timestamp, 'John','Melder', 2,2);
INSERT INTO students (id, creation_date, deleted, modifying_date, first_name, last_name, credential, group_id)
VALUES (nextval('student_generator'), current_timestamp, false, current_timestamp, 'David','Vendon', 3,3);

ALTER SEQUENCE teacher_generator RESTART;
INSERT INTO teachers (id, creation_date, deleted, modifying_date, first_name, last_name, credential)
VALUES (nextval('teacher_generator'), current_timestamp, false, current_timestamp, 'David', 'Hekston', 4);
INSERT INTO teachers (id, creation_date, deleted, modifying_date, first_name, last_name, credential)
VALUES (nextval('teacher_generator'), current_timestamp, false, current_timestamp, 'Robert', 'Tasert', 5);

ALTER SEQUENCE score_generator RESTART;
INSERT INTO scores (id, creation_date, deleted, modifying_date, score)
VALUES (nextval('score_generator'), current_timestamp, false, current_timestamp, 10);
INSERT INTO scores (id, creation_date, deleted, modifying_date, score)
VALUES (nextval('score_generator'), current_timestamp, false, current_timestamp, 9);
INSERT INTO scores (id, creation_date, deleted, modifying_date, score)
VALUES (nextval('score_generator'), current_timestamp, false, current_timestamp, 8);

ALTER SEQUENCE subject_generator RESTART;
INSERT INTO subjects (id, creation_date, deleted, modifying_date, subject_title)
VALUES (nextval('subject_generator'), current_timestamp, false, current_timestamp, 'MATH');
INSERT INTO subjects (id, creation_date, deleted, modifying_date, subject_title)
VALUES (nextval('subject_generator'), current_timestamp, false, current_timestamp, 'GEOMETRY');
INSERT INTO subjects (id, creation_date, deleted, modifying_date, subject_title)
VALUES (nextval('subject_generator'), current_timestamp, false, current_timestamp, 'ENGLISH');

INSERT INTO group_subject(group_id, subject_id) VALUES (1,1);
INSERT INTO group_subject(group_id, subject_id) VALUES (2,2);
INSERT INTO group_subject(group_id, subject_id) VALUES (3,3);

INSERT INTO group_teacher(group_id, teacher_id) VALUES (1,1);
INSERT INTO group_teacher(group_id, teacher_id) VALUES (2,2);
INSERT INTO group_teacher(group_id, teacher_id) VALUES (3,2);

INSERT INTO score_subject(score_id, subject_id) VALUES (1,1);
INSERT INTO score_subject(score_id, subject_id) VALUES (2,2);
INSERT INTO score_subject(score_id, subject_id) VALUES (3,3);

INSERT INTO student_subject(student_id, subject_id) VALUES (1,1);
INSERT INTO student_subject(student_id, subject_id) VALUES (2,2);
INSERT INTO student_subject(student_id, subject_id) VALUES (3,3);

INSERT INTO student_teacher(student_id, teacher_id) VALUES (1,1);
INSERT INTO student_teacher(student_id, teacher_id) VALUES (2,2);
INSERT INTO student_teacher(student_id, teacher_id) VALUES (3,2);