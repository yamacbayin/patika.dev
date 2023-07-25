/*
*
* CREATE THE TABLES
*
*/

CREATE TABLE users (
	user_id SERIAL PRIMARY KEY,
	username VARCHAR(30) UNIQUE NOT NULL
    CHECK (LENGTH(username) > 3),
	email VARCHAR(70) UNIQUE NOT NULL
    CHECK (LENGTH(email) > 3),
	creation_date TIMESTAMP WITH TIME ZONE NOT NULL
	DEFAULT(NOW()),
	is_active BOOLEAN
);

CREATE TABLE categories(
	category_id SERIAL PRIMARY KEY,
	name VARCHAR(40) UNIQUE NOT NULL,
	creation_date TIMESTAMP WITH TIME ZONE NOT NULL
	DEFAULT(NOW())
);

CREATE TABLE posts (
	post_id SERIAL PRIMARY KEY,
	user_id INTEGER NOT NULL,
	CONSTRAINT fk_user_id 
		FOREIGN KEY (user_id) 
		REFERENCES users(user_id),
	category_id INTEGER NOT NULL,
	CONSTRAINT fk_category_id
		FOREIGN KEY (category_id)
		REFERENCES categories(category_id),
	title VARCHAR(50) NOT NULL
	CHECK (LENGTH(title) < 51
		  AND LENGTH(title) > 0),
	content TEXT NOT NULL
	CHECK (LENGTH(content) > 0),
	view_count INTEGER DEFAULT 0,
	creation_date TIMESTAMP WITH TIME ZONE NOT NULL
	DEFAULT(NOW()),
	is_published BOOLEAN
);

CREATE TABLE comments(
	comment_id SERIAL PRIMARY KEY,
	post_id INTEGER NOT NULL,
	FOREIGN KEY (post_id) REFERENCES posts(post_id),
	user_id INTEGER,
	FOREIGN KEY (user_id) REFERENCES users(user_id),
	comment TEXT NOT NULL
	CHECK (LENGTH(comment) > 0),
	creation_date TIMESTAMP WITH TIME ZONE NOT NULL
	DEFAULT(NOW()),
	is_confirmed BOOLEAN
);

/*
*
* INSERT THE MOCKAROO DATA
*
*/

-- Insert users (30)
insert into users (username, email, creation_date, is_active) values ('cbockman0', 'ltumielli0@illinois.edu', '2021-06-20 23:39:32', false);
insert into users (username, email, creation_date, is_active) values ('sburnie1', 'jroskams1@samsung.com', '2013-10-09 21:18:33', true);
insert into users (username, email, creation_date, is_active) values ('jcoase2', 'vhawker2@fema.gov', '2022-02-16 23:00:37', true);
insert into users (username, email, creation_date, is_active) values ('greely3', 'dholby3@sina.com.cn', '2018-07-14 11:54:22', true);
insert into users (username, email, creation_date, is_active) values ('clamperd4', 'fforth4@mediafire.com', '2019-05-10 17:08:37', false);
insert into users (username, email, creation_date, is_active) values ('phugenin5', 'fandrusov5@nymag.com', '2011-11-04 17:51:05', false);
insert into users (username, email, creation_date, is_active) values ('ltumilson6', 'bcorrington6@smh.com.au', '2014-11-23 17:04:23', true);
insert into users (username, email, creation_date, is_active) values ('tmurby7', 'hpoleye7@sitemeter.com', '2019-01-26 15:03:37', true);
insert into users (username, email, creation_date, is_active) values ('mryott8', 'mboys8@google.ca', '2014-01-19 16:49:58', true);
insert into users (username, email, creation_date, is_active) values ('phabgood9', 'ogreiswood9@indiegogo.com', '2019-02-27 02:08:25', false);
insert into users (username, email, creation_date, is_active) values ('dpetowa', 'hbonetta@bluehost.com', '2012-09-24 06:15:58', false);
insert into users (username, email, creation_date, is_active) values ('lpavlovskyb', 'vkennellyb@uiuc.edu', '2022-12-06 05:41:26', false);
insert into users (username, email, creation_date, is_active) values ('yanningc', 'pbykc@admin.ch', '2020-01-11 17:49:45', true);
insert into users (username, email, creation_date, is_active) values ('pyouteadd', 'fsarverd@google.it', '2021-12-10 18:41:11', false);
insert into users (username, email, creation_date, is_active) values ('odransfielde', 'jgarleee@goo.gl', '2011-12-13 15:00:21', false);
insert into users (username, email, creation_date, is_active) values ('ddelunaf', 'dpetitf@state.gov', '2014-05-25 17:54:02', false);
insert into users (username, email, creation_date, is_active) values ('tkniftong', 'fbwyg@godaddy.com', '2013-04-04 00:26:22', false);
insert into users (username, email, creation_date, is_active) values ('pliverh', 'tbrennanh@stanford.edu', '2012-11-28 21:11:53', true);
insert into users (username, email, creation_date, is_active) values ('klabrumi', 'cjacmari@123-reg.co.uk', '2022-03-13 19:15:42', false);
insert into users (username, email, creation_date, is_active) values ('mwalshamj', 'mjerransj@vkontakte.ru', '2012-11-02 18:35:42', true);
insert into users (username, email, creation_date, is_active) values ('sgalegok', 'btorryk@addthis.com', '2011-08-04 07:52:48', false);
insert into users (username, email, creation_date, is_active) values ('jyanceyl', 'akellartl@blinklist.com', '2021-03-12 12:20:50', true);
insert into users (username, email, creation_date, is_active) values ('jshureym', 'eglaysherm@moonfruit.com', '2023-01-01 07:06:34', true);
insert into users (username, email, creation_date, is_active) values ('ralann', 'vhouseleen@redcross.org', '2023-05-23 04:15:55', true);
insert into users (username, email, creation_date, is_active) values ('leliasseno', 'jnaultyo@weibo.com', '2017-05-24 00:36:07', false);
insert into users (username, email, creation_date, is_active) values ('lwalshp', 'imulvyp@barnesandnoble.com', '2011-04-21 19:29:11', true);
insert into users (username, email, creation_date, is_active) values ('fwasbeyq', 'jspurriorq@mapquest.com', '2013-03-07 23:10:39', true);
insert into users (username, email, creation_date, is_active) values ('emcilvaneyr', 'amaccrossonr@sourceforge.net', '2016-09-25 21:59:47', false);
insert into users (username, email, creation_date, is_active) values ('ctrebles', 'baverays@blogs.com', '2016-02-22 20:28:49', false);
insert into users (username, email, creation_date, is_active) values ('dhelleckast', 'tbamborought@discovery.com', '2018-11-07 20:58:10', true);


-- Insert categories (9)
insert into categories (name, creation_date) values ('Marlite Panels (FED)', '2023-04-13 21:48:29');
insert into categories (name, creation_date) values ('Framing (Wood)', '2014-10-10 07:35:39');
insert into categories (name, creation_date) values ('Site Furnishings', '2013-10-27 20:38:51');
insert into categories (name, creation_date) values ('Construction Clean and Final Clean', '2012-08-12 20:47:26');
insert into categories (name, creation_date) values ('Sitework & Site Utilities', '2017-04-30 00:23:57');
insert into categories (name, creation_date) values ('Masonry & Precast', '2015-12-24 18:03:36');
insert into categories (name, creation_date) values ('Glass & Glazing', '2011-04-20 01:15:49');
insert into categories (name, creation_date) values ('Structural and Misc Steel (Fabrication)', '2012-11-13 22:58:15');
insert into categories (name, creation_date) values ('Electrical and Fire Alarm', '2022-06-25 02:28:58');

-- Insert posts(50)
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (3, 2, 'Morbi porttitor lorem id ligula.', 'Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat.', 28665, '2018-02-20 14:36:25', true);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (21, 7, 'Quisque porta volutpat erat.', 'Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo. Morbi ut odio.', 48876, '2013-04-18 18:59:36', false);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (17, 3, 'Aliquam quis turpis eget elit sodales scelerisque.', 'Cras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit. Vivamus vel nulla eget eros elementum pellentesque.', 4553, '2016-07-27 16:49:54', false);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (16, 6, 'Morbi quis tortor id nulla ultrices aliquet.', 'Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', 17507, '2020-05-08 06:26:47', true);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (23, 1, 'Morbi quis tortor id nulla ultrices aliquet.', 'Curabitur gravida nisi at nibh. In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem.', 44523, '2012-09-10 10:34:28', false);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (28, 4, 'Maecenas tristique, est et tempus semper, est quam', 'Curabitur gravida nisi at nibh. In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem.', 30291, '2018-03-26 03:45:16', false);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (5, 6, 'Sed sagittis. Nam congue, risus semper porta volut', 'Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat.', 42653, '2020-04-12 21:20:53', true);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (12, 4, 'Nam ultrices, libero non mattis pulvinar, nulla pe', 'Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat.', 45025, '2020-01-19 15:18:09', true);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (22, 3, 'Vivamus vel nulla eget eros elementum pellentesque', 'Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis.', 48342, '2019-04-26 08:30:37', false);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (6, 3, 'Nulla ut erat id mauris vulputate elementum.', 'Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat.', 21466, '2017-08-04 11:39:12', true);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (3, 2, 'Praesent blandit lacinia erat.', 'Duis consequat dui nec nisi volutpat eleifend. Donec ut dolor. Morbi vel lectus in quam fringilla rhoncus.', 4632, '2012-05-09 07:45:10', false);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (25, 7, 'Suspendisse potenti. Cras in purus eu magna vulput', 'Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi.', 91, '2023-06-01 23:06:11', true);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (21, 1, 'In quis justo. Maecenas rhoncus aliquam lacus.', 'Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros. Suspendisse accumsan tortor quis turpis.', 13653, '2022-11-10 03:21:41', false);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (4, 7, 'Donec ut mauris eget massa tempor convallis. Nulla', 'Duis bibendum. Morbi non quam nec dui luctus rutrum. Nulla tellus.', 39745, '2011-01-15 12:14:30', true);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (12, 9, 'In congue.', 'Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui.', 16460, '2014-10-31 04:00:42', true);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (27, 5, 'Vestibulum ante ipsum primis in faucibus orci luct', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin risus. Praesent lectus.', 879, '2013-03-12 08:47:48', false);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (1, 7, 'Fusce lacus purus, aliquet at, feugiat non, pretiu', 'Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui.', 21304, '2011-07-08 09:16:27', false);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (18, 7, 'Vestibulum ac est lacinia nisi venenatis tristique', 'Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui.', 3742, '2012-07-18 00:23:39', false);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (13, 7, 'Proin eu mi. Nulla ac enim.', 'Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque.', 29298, '2020-10-23 12:12:03', false);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (16, 4, 'Duis consequat dui nec nisi volutpat eleifend.', 'In congue. Etiam justo. Etiam pretium iaculis justo.', 15624, '2019-08-11 15:57:44', false);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (4, 6, 'Donec diam neque, vestibulum eget, vulputate ut, u', 'Duis consequat dui nec nisi volutpat eleifend. Donec ut dolor. Morbi vel lectus in quam fringilla rhoncus.', 15344, '2011-07-17 03:07:51', true);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (12, 7, 'Fusce consequat.', 'Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat.', 13157, '2020-08-02 17:02:22', false);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (12, 6, 'Fusce lacus purus, aliquet at, feugiat non, pretiu', 'Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.', 1616, '2016-08-25 10:06:53', false);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (20, 8, 'Mauris sit amet eros.', 'Cras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit. Vivamus vel nulla eget eros elementum pellentesque.', 5751, '2016-03-09 21:33:10', false);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (12, 1, 'In tempor, turpis nec euismod scelerisque, quam tu', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin risus. Praesent lectus.', 33700, '2012-04-04 14:23:41', true);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (21, 2, 'Aliquam non mauris. Morbi non lectus.', 'Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum. Aliquam non mauris.', 22432, '2021-04-02 21:40:45', false);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (11, 9, 'Fusce congue, diam id ornare imperdiet, sapien urn', 'Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi.', 13474, '2012-11-18 04:38:35', false);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (25, 7, 'Morbi odio odio, elementum eu, interdum eu, tincid', 'Sed sagittis. Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci. Nullam molestie nibh in lectus.', 47502, '2019-04-06 16:38:11', true);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (5, 3, 'Mauris ullamcorper purus sit amet nulla. Quisque a', 'Proin eu mi. Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.', 36545, '2015-05-10 01:34:09', true);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (4, 2, 'Proin eu mi. Nulla ac enim.', 'Quisque porta volutpat erat. Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus.', 17923, '2016-08-21 22:35:32', false);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (9, 1, 'Duis at velit eu est congue elementum.', 'Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst.', 9982, '2018-02-27 17:21:05', false);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (28, 9, 'Nulla tellus. In sagittis dui vel nisl.', 'Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit.', 39505, '2015-08-26 19:10:30', false);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (14, 5, 'Aliquam sit amet diam in magna bibendum imperdiet.', 'Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', 38325, '2022-01-08 20:31:08', true);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (27, 8, 'Integer non velit. Donec diam neque, vestibulum eg', 'Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi.', 10111, '2021-02-26 14:17:40', false);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (24, 3, 'Ut at dolor quis odio consequat varius. Integer ac', 'Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede.', 39010, '2015-05-27 19:31:33', true);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (21, 7, 'Morbi vestibulum, velit id pretium iaculis, diam e', 'Fusce consequat. Nulla nisl. Nunc nisl.', 30780, '2022-05-31 02:44:08', false);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (23, 4, 'Cum sociis natoque penatibus et magnis dis parturi', 'Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum. Aliquam non mauris.', 39833, '2021-03-29 13:59:31', false);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (20, 2, 'Nam ultrices, libero non mattis pulvinar, nulla pe', 'Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui.', 1941, '2014-02-20 07:37:39', false);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (27, 8, 'Quisque porta volutpat erat. Quisque erat eros, vi', 'Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis.', 30271, '2012-07-12 06:51:19', true);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (12, 5, 'Aliquam augue quam, sollicitudin vitae, consectetu', 'Duis consequat dui nec nisi volutpat eleifend. Donec ut dolor. Morbi vel lectus in quam fringilla rhoncus.', 11090, '2013-04-11 11:56:27', true);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (27, 8, 'Nullam orci pede, venenatis non, sodales sed, tinc', 'Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum. Integer a nibh.', 41876, '2015-04-10 13:01:42', false);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (28, 3, 'Phasellus id sapien in sapien iaculis congue.', 'Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat.', 7602, '2015-08-29 00:49:00', true);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (28, 5, 'Duis bibendum.', 'Fusce consequat. Nulla nisl. Nunc nisl.', 21274, '2015-06-02 17:09:24', false);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (14, 2, 'Integer ac neque. Duis bibendum.', 'Aenean fermentum. Donec ut mauris eget massa tempor convallis. Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh.', 3318, '2015-10-08 06:33:17', true);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (4, 4, 'Morbi vestibulum, velit id pretium iaculis, diam e', 'Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla. Sed vel enim sit amet nunc viverra dapibus. Nulla suscipit ligula in lacus.', 13384, '2016-12-29 18:22:51', false);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (23, 4, 'Curabitur gravida nisi at nibh.', 'Phasellus sit amet erat. Nulla tempus. Vivamus in felis eu sapien cursus vestibulum.', 37580, '2013-08-30 21:43:41', true);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (23, 8, 'Nulla facilisi. Cras non velit nec nisi vulputate ', 'Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat.', 35654, '2018-06-20 13:05:15', false);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (5, 7, 'Vivamus tortor. Duis mattis egestas metus.', 'Curabitur gravida nisi at nibh. In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem.', 17957, '2012-07-25 23:24:18', true);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (5, 9, 'Donec odio justo, sollicitudin ut, suscipit a, feu', 'Etiam vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida sem.', 31509, '2013-12-14 20:57:13', false);
insert into posts (user_id, category_id, title, content, view_count, creation_date, is_published) values (2, 1, 'Aliquam augue quam, sollicitudin vitae, consectetu', 'Duis consequat dui nec nisi volutpat eleifend. Donec ut dolor. Morbi vel lectus in quam fringilla rhoncus.', 43460, '2023-03-12 20:02:40', true);

-- Insert comments (250)
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (47, null, 'Nulla facilisi. Cras non velit nec nisi vulputate nonummy.', '2017-05-27 18:05:15', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (14, null, 'Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat.', '2020-02-24 02:45:52', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (26, 27, 'Morbi porttitor lorem id ligula.', '2015-10-05 02:36:02', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (49, 21, 'Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.', '2014-11-26 23:03:05', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (24, null, 'Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem.', '2013-07-06 02:18:35', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (7, 12, 'Quisque ut erat.', '2016-12-26 14:30:11', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (36, 23, 'Morbi quis tortor id nulla ultrices aliquet. Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo.', '2020-11-20 06:56:25', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (30, 12, 'Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus. Phasellus in felis.', '2019-09-16 06:52:11', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (48, null, 'Donec quis orci eget orci vehicula condimentum. Curabitur in libero ut massa volutpat convallis. Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo.', '2021-06-16 00:52:39', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (26, 9, 'Ut tellus. Nulla ut erat id mauris vulputate elementum. Nullam varius.', '2013-06-24 14:47:35', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (41, 18, 'Pellentesque ultrices mattis odio. Donec vitae nisi. Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla.', '2018-09-30 08:18:40', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (47, 20, 'Suspendisse ornare consequat lectus.', '2018-12-26 21:03:12', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (29, null, 'Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam.', '2017-01-29 08:19:55', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (47, 18, 'Etiam vel augue.', '2020-04-14 05:29:56', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (42, null, 'Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh. Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est.', '2014-09-27 17:37:53', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (7, 5, 'Proin interdum mauris non ligula pellentesque ultrices. Phasellus id sapien in sapien iaculis congue. Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl.', '2023-05-04 11:59:02', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (11, null, 'Cras in purus eu magna vulputate luctus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien.', '2013-12-09 00:45:51', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (20, 11, 'Mauris ullamcorper purus sit amet nulla. Quisque arcu libero, rutrum ac, lobortis vel, dapibus at, diam. Nam tristique tortor eu pede.', '2015-02-24 08:52:27', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (32, 25, 'Sed accumsan felis. Ut at dolor quis odio consequat varius.', '2014-03-08 15:35:45', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (23, 9, 'Pellentesque eget nunc.', '2022-05-19 21:51:00', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (43, 8, 'Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem.', '2022-12-06 10:47:25', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (20, null, 'Donec ut mauris eget massa tempor convallis. Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh.', '2023-02-12 11:43:55', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (49, 8, 'Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui.', '2020-10-29 20:45:13', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (31, 13, 'Suspendisse accumsan tortor quis turpis. Sed ante. Vivamus tortor.', '2014-04-09 10:56:03', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (18, 22, 'In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem.', '2013-11-22 01:03:41', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (46, null, 'Maecenas ut massa quis augue luctus tincidunt.', '2013-11-07 19:03:46', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (33, 12, 'Mauris lacinia sapien quis libero.', '2012-07-31 13:33:37', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (1, 27, 'Aenean auctor gravida sem. Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo.', '2018-05-24 18:51:57', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (20, null, 'Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede.', '2023-04-10 21:59:00', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (38, null, 'Suspendisse potenti. In eleifend quam a odio.', '2022-12-25 08:46:46', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (13, 18, 'Donec ut mauris eget massa tempor convallis.', '2019-12-28 10:41:20', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (12, 10, 'Curabitur gravida nisi at nibh. In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem.', '2015-10-29 01:28:49', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (2, 23, 'Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem.', '2020-02-01 18:07:48', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (14, null, 'Sed ante. Vivamus tortor. Duis mattis egestas metus.', '2019-11-06 12:15:52', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (28, 27, 'In eleifend quam a odio. In hac habitasse platea dictumst. Maecenas ut massa quis augue luctus tincidunt.', '2019-02-18 20:07:12', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (1, 25, 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam. Suspendisse potenti.', '2022-11-05 04:32:36', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (14, 26, 'Aliquam sit amet diam in magna bibendum imperdiet. Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis.', '2022-10-16 16:58:45', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (12, 27, 'Nulla suscipit ligula in lacus. Curabitur at ipsum ac tellus semper interdum. Mauris ullamcorper purus sit amet nulla.', '2015-02-28 13:38:29', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (2, 30, 'Nullam molestie nibh in lectus. Pellentesque at nulla. Suspendisse potenti.', '2022-11-13 23:00:51', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (24, 19, 'Aenean lectus.', '2020-01-25 04:48:20', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (32, 14, 'Donec semper sapien a libero. Nam dui.', '2018-08-22 03:52:02', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (47, null, 'Maecenas rhoncus aliquam lacus.', '2019-12-11 20:15:10', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (2, 12, 'Donec quis orci eget orci vehicula condimentum. Curabitur in libero ut massa volutpat convallis.', '2016-01-24 19:55:41', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (7, 18, 'Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl. Aenean lectus. Pellentesque eget nunc.', '2013-05-29 07:19:46', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (44, 28, 'Morbi quis tortor id nulla ultrices aliquet.', '2018-10-28 04:44:35', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (2, 17, 'Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem. Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat.', '2019-08-08 13:21:44', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (34, 10, 'Fusce consequat. Nulla nisl.', '2022-05-03 23:12:36', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (45, 17, 'Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo.', '2018-05-21 15:11:11', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (24, 11, 'Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus. Duis at velit eu est congue elementum.', '2016-10-17 04:17:28', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (11, 22, 'Curabitur gravida nisi at nibh.', '2023-01-20 23:34:53', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (19, 4, 'Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi.', '2023-03-28 18:53:08', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (1, 30, 'Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh. Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est.', '2014-04-14 08:05:59', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (33, 15, 'Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo.', '2019-06-08 04:03:32', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (5, null, 'Aenean auctor gravida sem. Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo.', '2016-04-20 03:16:00', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (27, 11, 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque. Duis bibendum.', '2012-07-17 10:07:04', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (5, 14, 'Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat.', '2020-12-11 06:48:48', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (47, 30, 'Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo.', '2019-06-18 19:05:06', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (26, null, 'Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet.', '2015-05-03 08:46:58', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (21, 9, 'Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio.', '2017-08-01 08:36:26', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (10, null, 'Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros.', '2021-03-09 00:26:35', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (2, null, 'Pellentesque ultrices mattis odio. Donec vitae nisi. Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla.', '2018-04-30 05:15:47', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (14, null, 'Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl. Aenean lectus. Pellentesque eget nunc.', '2019-11-07 00:37:00', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (27, 29, 'Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus.', '2022-05-01 04:57:24', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (5, 15, 'In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem.', '2020-09-06 13:09:09', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (32, 20, 'Donec vitae nisi.', '2017-09-28 14:32:23', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (35, 4, 'Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat.', '2016-08-31 09:25:27', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (18, 24, 'Aenean sit amet justo.', '2021-07-24 18:51:15', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (40, 5, 'Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', '2012-10-02 18:56:36', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (19, 25, 'Nunc rhoncus dui vel sem. Sed sagittis. Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci.', '2022-01-18 01:02:39', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (32, 4, 'Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien.', '2016-01-30 10:43:31', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (26, 10, 'Proin risus. Praesent lectus. Vestibulum quam sapien, varius ut, blandit non, interdum in, ante.', '2013-05-05 01:48:48', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (5, 18, 'Donec vitae nisi. Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla.', '2021-02-23 13:50:07', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (34, 28, 'Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum. Integer a nibh.', '2014-06-05 11:26:01', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (28, 13, 'In est risus, auctor sed, tristique in, tempus sit amet, sem. Fusce consequat.', '2014-06-28 05:52:20', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (17, null, 'Donec ut dolor. Morbi vel lectus in quam fringilla rhoncus.', '2014-09-04 09:13:18', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (45, 2, 'Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem.', '2013-03-04 14:08:02', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (37, 12, 'Vivamus in felis eu sapien cursus vestibulum.', '2014-06-10 10:39:16', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (27, 24, 'Etiam vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida sem.', '2021-12-22 15:08:49', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (11, 10, 'Nulla mollis molestie lorem.', '2020-09-20 02:49:56', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (2, 26, 'Donec dapibus. Duis at velit eu est congue elementum.', '2014-09-06 13:50:59', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (35, 6, 'Praesent lectus.', '2021-12-05 09:49:46', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (7, null, 'Morbi vel lectus in quam fringilla rhoncus. Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis.', '2016-11-03 22:45:38', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (21, 11, 'Suspendisse potenti.', '2012-10-30 03:44:13', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (10, 4, 'Maecenas pulvinar lobortis est. Phasellus sit amet erat. Nulla tempus.', '2023-05-01 00:57:52', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (7, 28, 'Nulla suscipit ligula in lacus. Curabitur at ipsum ac tellus semper interdum.', '2013-08-11 02:53:23', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (36, null, 'Maecenas pulvinar lobortis est. Phasellus sit amet erat. Nulla tempus.', '2022-02-16 05:10:39', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (47, 18, 'Fusce consequat. Nulla nisl. Nunc nisl.', '2014-08-27 00:43:14', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (22, 18, 'Vestibulum sed magna at nunc commodo placerat. Praesent blandit.', '2022-09-29 14:14:46', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (29, 16, 'Suspendisse accumsan tortor quis turpis. Sed ante.', '2019-01-20 05:13:52', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (5, 9, 'Suspendisse potenti. Cras in purus eu magna vulputate luctus.', '2019-03-13 20:32:23', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (47, 5, 'Nulla facilisi. Cras non velit nec nisi vulputate nonummy.', '2018-12-31 18:26:57', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (42, null, 'Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros. Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue.', '2016-08-22 13:16:56', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (31, 7, 'In quis justo. Maecenas rhoncus aliquam lacus.', '2014-04-20 20:16:08', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (29, null, 'Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo.', '2018-04-25 20:02:48', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (35, 10, 'Proin interdum mauris non ligula pellentesque ultrices. Phasellus id sapien in sapien iaculis congue. Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl.', '2019-11-20 21:51:38', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (40, 9, 'Curabitur in libero ut massa volutpat convallis. Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo.', '2018-12-06 20:22:25', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (14, null, 'Nunc rhoncus dui vel sem. Sed sagittis. Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci.', '2015-03-23 01:05:48', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (15, 26, 'Proin leo odio, porttitor id, consequat in, consequat ut, nulla. Sed accumsan felis.', '2015-04-18 06:50:51', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (6, 18, 'Vivamus tortor.', '2016-02-13 13:15:22', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (15, 19, 'Sed ante. Vivamus tortor.', '2015-01-17 04:27:55', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (44, 15, 'Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat.', '2017-07-28 06:38:25', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (26, 12, 'Aenean sit amet justo.', '2019-04-20 20:46:29', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (38, 24, 'Nulla tellus. In sagittis dui vel nisl.', '2020-06-17 01:20:08', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (19, null, 'Aenean lectus. Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum.', '2017-09-27 05:06:46', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (20, 10, 'Curabitur convallis. Duis consequat dui nec nisi volutpat eleifend. Donec ut dolor.', '2017-07-15 19:28:12', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (44, 15, 'Nulla mollis molestie lorem.', '2022-12-09 14:25:39', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (43, 10, 'Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa.', '2012-07-26 02:44:56', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (45, 25, 'In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin interdum mauris non ligula pellentesque ultrices.', '2015-01-03 14:02:29', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (25, 4, 'Aenean sit amet justo. Morbi ut odio.', '2020-07-12 00:53:28', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (28, 12, 'Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros.', '2019-04-06 18:39:26', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (24, null, 'Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue.', '2021-04-18 09:07:36', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (45, 19, 'Proin interdum mauris non ligula pellentesque ultrices. Phasellus id sapien in sapien iaculis congue.', '2021-09-06 16:36:37', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (13, 8, 'Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum. Curabitur in libero ut massa volutpat convallis.', '2015-12-24 15:06:40', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (12, null, 'Donec ut dolor.', '2022-03-03 16:21:41', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (25, 27, 'Aliquam non mauris. Morbi non lectus. Aliquam sit amet diam in magna bibendum imperdiet.', '2019-06-04 15:39:52', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (37, 25, 'Morbi a ipsum.', '2017-04-13 06:53:58', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (27, 7, 'In congue. Etiam justo.', '2017-02-15 08:28:28', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (37, 2, 'Quisque ut erat.', '2016-10-31 08:55:37', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (3, 14, 'Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis. Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl.', '2015-10-18 12:50:04', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (45, 3, 'Mauris lacinia sapien quis libero.', '2018-03-22 00:37:40', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (41, null, 'Phasellus sit amet erat. Nulla tempus. Vivamus in felis eu sapien cursus vestibulum.', '2019-03-31 23:07:56', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (36, 29, 'Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum.', '2021-12-02 10:02:40', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (39, null, 'In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.', '2013-08-01 06:11:38', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (12, 17, 'Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus.', '2022-01-09 21:33:38', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (5, 9, 'Mauris lacinia sapien quis libero. Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum.', '2023-02-19 23:44:51', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (9, 27, 'Fusce consequat.', '2018-08-05 23:21:42', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (11, 25, 'Nullam varius. Nulla facilisi.', '2014-06-01 18:33:53', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (2, 30, 'Vivamus tortor.', '2020-07-31 14:51:42', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (42, null, 'Nullam molestie nibh in lectus.', '2015-11-21 22:31:13', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (33, 24, 'Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus. Suspendisse potenti.', '2017-06-19 03:40:31', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (19, 18, 'Curabitur gravida nisi at nibh. In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem.', '2012-12-21 22:04:19', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (8, 25, 'Nulla nisl.', '2016-03-10 07:39:35', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (49, 29, 'Etiam pretium iaculis justo. In hac habitasse platea dictumst. Etiam faucibus cursus urna.', '2021-04-14 19:34:05', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (21, 12, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin risus.', '2017-01-23 04:17:04', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (44, 29, 'Nullam molestie nibh in lectus. Pellentesque at nulla. Suspendisse potenti.', '2016-09-06 01:31:17', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (43, 11, 'In congue. Etiam justo. Etiam pretium iaculis justo.', '2012-07-02 14:04:58', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (5, 27, 'Etiam faucibus cursus urna. Ut tellus. Nulla ut erat id mauris vulputate elementum.', '2022-09-08 19:23:15', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (38, 4, 'Proin interdum mauris non ligula pellentesque ultrices. Phasellus id sapien in sapien iaculis congue. Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl.', '2018-05-15 11:53:38', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (16, 25, 'In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin interdum mauris non ligula pellentesque ultrices.', '2013-04-30 22:44:01', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (35, 27, 'Ut tellus.', '2021-05-07 06:47:58', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (4, null, 'Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl.', '2020-08-12 21:58:36', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (12, null, 'Proin risus.', '2021-07-05 03:41:49', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (32, 10, 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis. Duis consequat dui nec nisi volutpat eleifend.', '2020-01-23 23:34:11', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (14, null, 'Vivamus in felis eu sapien cursus vestibulum.', '2021-07-05 02:11:38', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (16, 23, 'Ut tellus. Nulla ut erat id mauris vulputate elementum.', '2023-02-28 12:46:53', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (47, 12, 'Mauris lacinia sapien quis libero. Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum.', '2014-03-26 07:01:46', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (43, 27, 'Phasellus sit amet erat. Nulla tempus.', '2020-02-28 03:48:56', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (25, 12, 'Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat.', '2022-07-28 05:39:01', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (4, 25, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin risus.', '2015-05-09 00:20:27', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (14, 25, 'Integer non velit.', '2014-06-27 05:33:32', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (7, 17, 'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante.', '2020-08-21 03:04:25', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (10, 20, 'In blandit ultrices enim.', '2019-03-29 16:55:54', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (24, 25, 'In sagittis dui vel nisl. Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus.', '2015-09-30 00:10:25', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (8, 14, 'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante.', '2023-03-28 19:32:30', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (18, 5, 'Suspendisse potenti.', '2014-12-27 06:16:31', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (47, 19, 'Duis consequat dui nec nisi volutpat eleifend. Donec ut dolor. Morbi vel lectus in quam fringilla rhoncus.', '2013-10-18 12:18:36', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (23, null, 'Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum.', '2022-08-26 18:57:08', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (28, 10, 'Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum.', '2020-08-25 12:24:44', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (11, 18, 'Etiam vel augue.', '2021-01-12 07:10:57', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (6, null, 'Nunc nisl. Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa.', '2019-01-25 15:11:55', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (8, 27, 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam. Suspendisse potenti.', '2015-04-02 06:01:46', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (14, 8, 'Suspendisse potenti. Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum.', '2017-09-25 23:07:36', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (10, 11, 'In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem. Duis aliquam convallis nunc.', '2013-10-15 05:51:22', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (18, 27, 'Praesent lectus.', '2014-07-25 20:01:21', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (44, null, 'Nam dui. Proin leo odio, porttitor id, consequat in, consequat ut, nulla.', '2017-03-06 11:46:59', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (6, 17, 'Morbi non quam nec dui luctus rutrum.', '2021-12-14 15:37:13', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (21, 9, 'Duis bibendum. Morbi non quam nec dui luctus rutrum.', '2021-10-14 13:03:25', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (26, null, 'Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem.', '2022-09-08 12:13:22', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (34, 17, 'In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem. Duis aliquam convallis nunc.', '2020-06-13 02:52:07', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (10, null, 'In est risus, auctor sed, tristique in, tempus sit amet, sem.', '2020-05-22 14:22:30', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (15, 27, 'In hac habitasse platea dictumst.', '2012-11-02 13:28:06', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (1, 17, 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque. Duis bibendum.', '2021-11-19 14:17:00', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (18, 9, 'Proin interdum mauris non ligula pellentesque ultrices.', '2022-06-09 22:16:59', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (2, null, 'Nullam molestie nibh in lectus.', '2015-08-27 07:01:54', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (1, 23, 'Ut at dolor quis odio consequat varius. Integer ac leo.', '2014-05-18 11:41:36', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (38, null, 'Suspendisse accumsan tortor quis turpis.', '2021-03-26 17:18:02', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (2, 15, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin risus.', '2012-07-29 14:34:56', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (9, 14, 'Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede.', '2022-01-04 09:22:11', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (16, null, 'Pellentesque at nulla. Suspendisse potenti. Cras in purus eu magna vulputate luctus.', '2016-12-07 03:33:57', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (14, null, 'Vestibulum sed magna at nunc commodo placerat.', '2022-10-25 23:42:04', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (31, null, 'Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat.', '2013-02-11 20:30:45', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (41, 11, 'In hac habitasse platea dictumst.', '2014-09-28 11:39:36', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (10, 30, 'Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros. Suspendisse accumsan tortor quis turpis.', '2018-02-07 07:57:56', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (6, 14, 'Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.', '2019-03-05 10:13:06', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (8, 22, 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis. Duis consequat dui nec nisi volutpat eleifend.', '2020-02-28 13:22:30', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (34, null, 'Cras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit. Vivamus vel nulla eget eros elementum pellentesque.', '2016-10-11 03:31:38', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (15, 8, 'Curabitur in libero ut massa volutpat convallis. Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo.', '2013-03-02 16:53:58', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (37, 18, 'In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem.', '2020-11-16 09:51:39', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (32, 2, 'Morbi a ipsum. Integer a nibh.', '2016-07-17 22:53:36', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (17, null, 'Nullam varius. Nulla facilisi. Cras non velit nec nisi vulputate nonummy.', '2017-11-21 11:04:25', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (1, null, 'Cras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit.', '2022-08-02 00:01:26', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (29, 13, 'Nulla facilisi.', '2018-04-12 21:07:08', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (39, 6, 'Nulla facilisi.', '2019-09-04 06:36:51', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (5, null, 'Vivamus vel nulla eget eros elementum pellentesque. Quisque porta volutpat erat. Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla.', '2017-10-14 04:20:20', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (40, 29, 'Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet. Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo.', '2013-04-30 09:13:35', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (14, 23, 'Nam dui. Proin leo odio, porttitor id, consequat in, consequat ut, nulla.', '2020-06-03 12:46:10', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (2, 9, 'Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam.', '2021-02-28 14:07:13', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (30, null, 'Nulla facilisi. Cras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit.', '2015-08-31 11:18:31', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (15, 12, 'Pellentesque eget nunc.', '2021-12-22 08:41:00', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (3, 26, 'Nam dui.', '2014-10-02 03:43:41', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (42, 26, 'Etiam vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida sem.', '2023-04-22 14:33:41', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (27, 25, 'Suspendisse potenti. In eleifend quam a odio.', '2014-01-23 09:44:35', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (44, 10, 'Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh. Quisque id justo sit amet sapien dignissim vestibulum.', '2012-11-03 03:14:32', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (20, 11, 'Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien.', '2021-08-19 22:08:06', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (34, 16, 'Nulla tellus. In sagittis dui vel nisl. Duis ac nibh.', '2013-01-11 02:52:34', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (35, null, 'Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros. Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue.', '2023-03-29 15:09:01', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (11, 20, 'Maecenas ut massa quis augue luctus tincidunt.', '2014-07-25 03:08:23', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (7, 16, 'Integer non velit.', '2012-09-22 02:55:51', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (34, 25, 'Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo.', '2016-11-08 02:25:58', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (18, null, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin risus.', '2019-07-01 17:48:03', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (10, 26, 'In est risus, auctor sed, tristique in, tempus sit amet, sem. Fusce consequat. Nulla nisl.', '2017-02-14 09:57:47', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (19, 24, 'Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede.', '2017-11-21 14:06:59', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (29, 5, 'Morbi quis tortor id nulla ultrices aliquet. Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam.', '2013-05-29 01:34:40', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (41, 5, 'Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede. Morbi porttitor lorem id ligula.', '2022-08-18 01:58:35', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (48, null, 'Nulla ac enim.', '2015-08-02 14:00:31', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (5, 29, 'Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam. Suspendisse potenti.', '2016-04-18 17:29:21', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (41, 4, 'Mauris lacinia sapien quis libero.', '2022-09-03 20:01:16', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (18, 6, 'Mauris ullamcorper purus sit amet nulla. Quisque arcu libero, rutrum ac, lobortis vel, dapibus at, diam. Nam tristique tortor eu pede.', '2012-12-20 17:59:58', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (40, 12, 'Pellentesque ultrices mattis odio. Donec vitae nisi. Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla.', '2013-07-20 05:41:11', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (39, 22, 'Nunc nisl. Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa.', '2015-12-01 17:25:12', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (23, 15, 'Maecenas rhoncus aliquam lacus.', '2014-02-09 16:25:07', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (14, 20, 'Aenean sit amet justo.', '2016-03-06 16:24:11', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (7, 23, 'Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy.', '2015-05-07 13:36:47', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (4, 7, 'Mauris ullamcorper purus sit amet nulla.', '2018-11-20 19:32:39', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (34, 6, 'Morbi ut odio. Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim.', '2014-02-24 13:59:11', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (3, 20, 'Nulla tellus. In sagittis dui vel nisl. Duis ac nibh.', '2014-09-17 11:03:37', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (27, null, 'Nulla nisl.', '2020-03-20 19:38:42', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (22, null, 'Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum.', '2019-11-22 03:26:03', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (17, 15, 'Nulla nisl. Nunc nisl. Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa.', '2018-06-19 12:56:20', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (14, null, 'Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi.', '2013-08-20 12:44:22', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (28, 4, 'Curabitur at ipsum ac tellus semper interdum. Mauris ullamcorper purus sit amet nulla.', '2022-02-21 14:43:09', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (1, 2, 'Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet. Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo.', '2022-04-12 05:57:35', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (20, 21, 'Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem.', '2012-10-02 03:21:09', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (49, 16, 'Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh.', '2020-10-13 01:01:41', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (35, 22, 'Etiam pretium iaculis justo. In hac habitasse platea dictumst.', '2019-11-29 23:04:09', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (36, 16, 'Mauris lacinia sapien quis libero. Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum.', '2014-05-25 07:50:00', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (5, null, 'Morbi non quam nec dui luctus rutrum. Nulla tellus. In sagittis dui vel nisl.', '2021-08-01 03:35:11', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (31, 15, 'Donec vitae nisi.', '2020-11-12 10:10:24', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (23, 29, 'Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum.', '2013-06-09 14:50:53', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (44, 11, 'Proin at turpis a pede posuere nonummy. Integer non velit. Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue.', '2021-02-05 04:04:36', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (41, 15, 'In hac habitasse platea dictumst.', '2016-09-16 01:07:01', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (45, 4, 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam. Suspendisse potenti. Nullam porttitor lacus at turpis.', '2015-07-01 17:35:11', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (41, null, 'Maecenas rhoncus aliquam lacus.', '2020-04-18 15:49:13', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (29, null, 'Vivamus vestibulum sagittis sapien.', '2012-10-20 13:15:54', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (12, 27, 'Suspendisse potenti.', '2013-07-29 05:10:16', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (27, 17, 'Vivamus in felis eu sapien cursus vestibulum.', '2015-10-04 09:46:29', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (10, 18, 'Nulla tellus. In sagittis dui vel nisl.', '2016-11-05 02:00:24', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (29, 25, 'Nulla justo. Aliquam quis turpis eget elit sodales scelerisque.', '2018-03-10 12:21:00', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (9, 21, 'Suspendisse accumsan tortor quis turpis.', '2018-09-22 07:19:27', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (11, 9, 'Nulla tempus. Vivamus in felis eu sapien cursus vestibulum. Proin eu mi.', '2016-05-20 19:44:36', false);


/*
*
* QUERIES
*
*/

-- 1. Tüm blog yazılarını başlıkları, yazarları ve kategorileriyle birlikte getirin.
SELECT posts.title, users.username AS author, categories.name AS category
FROM posts
JOIN users ON posts.user_id = users.user_id
JOIN categories ON posts.category_id = categories.category_id;

-- 2. En son yayınlanan 5 blog yazısını başlıkları, yazarları ve yayın tarihleriyle birlikte alın.
SELECT posts.title, users.username, posts.creation_date
FROM posts
JOIN users ON posts.user_id = users.user_id
WHERE posts.is_published = true
ORDER BY creation_date DESC
LIMIT 5;

-- 3. Her blog yazısı için yorum sayısını gösterin
-- Using GROUP BY
-- There were repeating titles in the database, so I had to use post_id as well.
SELECT posts.post_id, posts.title, COUNT(comments.*) FROM posts
LEFT JOIN comments ON posts.post_id = comments.post_id
GROUP BY posts.post_id, posts.title
ORDER BY COUNT DESC;
-- Using subquery
SELECT title,
	(SELECT COUNT(comment_id)
	 FROM comments
	 WHERE posts.post_id = comments.post_id)
	as comment_count
FROM posts
ORDER BY comment_count DESC;

-- 4. Tüm kayıtlı kullanıcıların kullanıcı adlarını ve e-posta adreslerini gösterin
SELECT username, email FROM users;

-- 5. En son 10 yorumu, ilgili gönderi başlıklarıyla birlikte alın.
SELECT posts.title, comments.comment, comments.creation_date FROM comments
JOIN posts ON comments.post_id = posts.post_id
ORDER BY creation_date DESC
LIMIT 10;
-- Using subquery
SELECT
	(SELECT title
	FROM posts
	WHERE posts.post_id = comments.post_id),
	comment,
	creation_date
FROM comments
ORDER BY creation_date DESC
LIMIT 10;

-- 6. Belirli bir kullanıcı tarafından yazılan tüm blog yazılarını bulun.
SELECT * FROM posts
WHERE user_id = 12;
-- It felt really easy to write this query.
-- So here is another one including the username.
SELECT 
	(SELECT username
	FROM users
	WHERE users.user_id = posts.user_id),
	*
FROM posts
WHERE user_id = 12;

-- 7. Her kullanıcının yazdığı toplam gönderi sayısını alın.
SELECT users.username,
	(SELECT COUNT (*)
	FROM posts
	WHERE users.user_id = posts.user_id)
	AS post_count,
	(SELECT COUNT(*)
	FROM comments
	WHERE users.user_id = comments.user_id)
	as comment_count
FROM users
ORDER BY post_count DESC, comment_count DESC;

-- 8. Her kategoriyi, kategorideki gönderi sayısıyla birlikte gösterin.
SELECT categories.name, COUNT(posts.*) as post_count
FROM categories
LEFT JOIN posts ON categories.category_id = posts.category_id
GROUP BY categories.name
ORDER BY post_count DESC;

-- 9.Gönderi sayısına göre en popüler kategoriyi bulun.
SELECT categories.name, COUNT(posts.*) as post_count
FROM categories
JOIN posts ON categories.category_id = posts.category_id
GROUP BY categories.name
ORDER BY post_count DESC
LIMIT 1;

-- 10. Gönderilerindeki toplam görüntülenme sayısına göre en popüler kategoriyi bulun.
SELECT categories.name, 
	(SELECT SUM(view_count)
	 FROM POSTS
	 WHERE categories.category_id = posts.category_id)
	 AS total_views
FROM categories
ORDER BY total_views DESC
LIMIT 1;

-- 11. En fazla yoruma sahip gönderiyi alın.
SELECT posts.title,
	(SELECT COUNT(comments.comment_id)
	FROM comments
	WHERE posts.post_id = comments.post_id)
	AS comment_count
FROM posts
ORDER BY comment_count DESC
LIMIT 1;
-- Using GROUP BY
SELECT posts.post_id, posts.title, COUNT(comments.comment_id) as comment_count
FROM posts
LEFT JOIN comments ON posts.post_id = comments.post_id
GROUP BY posts.post_id, posts.title
ORDER BY comment_count DESC
LIMIT 1;

-- 12. Belirli bir gönderinin yazarının kullanıcı adını ve e-posta adresini gösterin.
SELECT posts.title,
	users.username AS author,
	users.email
FROM posts
JOIN users ON posts.user_id = users.user_id
WHERE post_id = 1;
-- OR
SELECT 
	(SELECT username FROM users
	 WHERE posts.user_id = users.user_id)
	 AS author,
	(SELECT email FROM users
	 WHERE posts.user_id = users.user_id)
	 AS authors_email
FROM posts
WHERE post_id = 1

-- 13. Başlık veya içeriklerinde belirli bir anahtar kelime bulunan tüm gönderileri bulun.
SELECT * FROM posts
WHERE title ILIKE '%integer%'
OR content ILIKE '%integer%';

-- 14. Belirli bir kullanıcının en son yorumunu gösterin.
SELECT users.username, comments.comment, comments.creation_date 
FROM comments
JOIN users ON comments.user_id = users.user_id
WHERE users.username = 'ctrebles'
ORDER BY creation_date DESC
LIMIT 1;

-- 15. Gönderi başına ortalama yorum sayısını bulun.
SELECT (
	(SELECT COUNT(*) FROM comments)
	/
	(SELECT COUNT(*) FROM posts))
    AS average_comments_per_post;

-- 16. Son 30 günde yayınlanan gönderileri gösterin.
SELECT * FROM posts
WHERE creation_date > (CURRENT_DATE - INTERVAL '30' DAY)
AND is_published = true;

-- 17. Belirli bir kullanıcının yaptığı yorumları alın.
SELECT users.user_id, users.username, 
	comments.comment, comments.creation_date 
FROM users
JOIN comments ON comments.user_id = users.user_id
WHERE users.username = 'ctrebles';

-- 18. Belirli bir kategoriye ait tüm gönderileri bulun.
SELECT categories.name, posts.title
FROM posts
JOIN categories ON categories.category_id = posts.category_id
WHERE categories.name = 'Masonry & Precast'

-- 19. 5'ten az yazıya sahip kategorileri bulun.
SELECT categories.name, COUNT(posts.*) as post_count
FROM categories
JOIN posts ON categories.category_id = posts.category_id
GROUP BY categories.name
HAVING COUNT(posts.*) < 5;

-- 20. Hem bir yazı hem de bir yoruma sahip olan kullanıcıları gösterin.
SELECT users.username,
	(SELECT COUNT (*)
	FROM posts
	WHERE users.user_id = posts.user_id)
	AS post_count,
	(SELECT COUNT(*)
	FROM comments
	WHERE users.user_id = comments.user_id)
	as comment_count
FROM users
WHERE 
	(SELECT COUNT (*)
		FROM posts
		WHERE users.user_id = posts.user_id) > 0
	AND
	(SELECT COUNT(*)
		FROM comments
		WHERE users.user_id = comments.user_id) > 0
ORDER BY post_count DESC, comment_count DESC;

-- 21. En az 2 farklı yazıya yorum yapmış kullanıcıları alın.
SELECT users.username FROM users
WHERE (SELECT COUNT(DISTINCT post_id) 
	   FROM comments 
	   WHERE users.user_id = comments.user_id) >= 2;
-- OR
SELECT users.username, COUNT(DISTINCT comments.post_id)
FROM comments
JOIN users ON comments.user_id = users.user_id
GROUP BY users.username
HAVING COUNT(DISTINCT comments.post_id) >= 2
ORDER BY COUNT DESC;

-- 22. En az 3 yazıya sahip kategorileri görüntüleyin.
SELECT categories.name, COUNT(posts.*) as post_count
FROM categories
JOIN posts ON categories.category_id = posts.category_id
GROUP BY categories.name
HAVING COUNT(posts.*) > 3
ORDER BY post_count ASC;

-- 23. 5'ten fazla blog yazısı yazan yazarları bulun
SELECT users.username,
	(SELECT COUNT(*) FROM posts 
	 WHERE users.user_id = posts.user_id)
	 AS blog_posts
FROM users
WHERE (SELECT COUNT(*) FROM posts 
	 WHERE users.user_id = posts.user_id) > 5

-- 24. Bir blog yazısı yazmış veya bir yorum yapmış kullanıcıların e-posta adreslerini görüntüleyin. (UNION kullanarak)
-- Only 1 post or 1 comment
SELECT users.email FROM users
WHERE (SELECT COUNT(posts.post_id)
	   FROM posts
	   WHERE posts.user_id = users.user_id) = 1
UNION
SELECT users.email FROM users
WHERE (SELECT COUNT(comments.comment_id)
	   FROM comments
	   WHERE comments.user_id = users.user_id) = 1;
-- 1 or more posts/comments
SELECT users.email FROM users
JOIN posts
ON users.user_id = posts.user_id
UNION
SELECT users.email FROM users
JOIN comments
ON users.user_id = comments.user_id

-- 25. Bir blog yazısı yazmış ancak hiç yorum yapmamış yazarları bulun.
SELECT users.email FROM users
WHERE (SELECT COUNT(*) FROM posts WHERE users.user_id = posts.user_id) > 0
AND
(SELECT COUNT(*) FROM comments WHERE users.user_id = comments.user_id) = 0