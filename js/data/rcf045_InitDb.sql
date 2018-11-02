create table if not exists questions(
  question VARCHAR(240) NOT NULL,
  answer_a VARCHAR(240) NOT NULL,
  answer_b VARCHAR(240) NOT NULL,
  answer_c VARCHAR(240),
  answer_d VARCHAR(240),
  success_rate INT );
