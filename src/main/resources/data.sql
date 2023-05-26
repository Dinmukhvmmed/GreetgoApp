CREATE TABLE IF NOT EXISTS student (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    age INT NOT NULL,
    average_grade DECIMAL(2,1) NOT NULL
);

INSERT INTO student (name, surname, age, average_grade)
VALUES ('Вася', 'Пупкин', 15, 1.8);

INSERT INTO student (name, surname, age, average_grade)
VALUES ('Иван', 'Сидоров', 13, 4.0);

INSERT INTO student (name, surname, age, average_grade)
VALUES ('Вольфганг', 'Моцарт', 10, 5.0);

INSERT INTO student (name, surname, age, average_grade)
VALUES ('Лев', 'Толстой', 7, 4.6);

INSERT INTO student (name, surname, age, average_grade)
VALUES ('Чарльз', 'Дарвин', 8, 4.4);