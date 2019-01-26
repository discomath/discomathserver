/**
 * Author:  vapurrmaid
 * Created: 25-Jan-2019
 */

INSERT INTO Topics (topic_name) VALUES
   ('number theory');

INSERT INTO Sub_Topics (sub_topic_name, topic_id) VALUES
    ('divisibility', (SELECT topic_id FROM Topics WHERE topic_name = 'number theory')),
    ('prime and composite numbers', (SELECT topic_id FROM Topics WHERE topic_name = 'number theory')),
    ('modular arithmetic', (SELECT topic_id FROM Topics WHERE topic_name = 'number theory'));
