# ÖDEV 8
1. test veritabanınızda employee isimli sütun bilgileri id(INTEGER), name VARCHAR(50), birthday DATE, email VARCHAR(100) olan bir tablo oluşturalım.
```
CREATE TABLE employee(
	id SERIAL PRIMARY KEY,
	name VARCHAR(50),
	birthday DATE,
	email VARCHAR(100)
);
```
2. Oluşturduğumuz employee tablosuna 'Mockaroo' servisini kullanarak 50 adet veri ekleyelim.
```
insert into employee (name, birthday, email) values ('Melinda Genny', '1990/07/18', 'mgenny0@state.tx.us');
insert into employee (name, birthday, email) values ('Frankie McPhilip', '1967/01/11', 'fmcphilip1@gmpg.org');
insert into employee (name, birthday, email) values ('Christoph Pitcher', '1952/10/19', 'cpitcher2@4shared.com');
insert into employee (name, birthday, email) values ('Clemmie Coxwell', '1990/04/02', 'ccoxwell3@youtu.be');
insert into employee (name, birthday, email) values ('Carita Guerry', '1937/01/29', 'cguerry4@slate.com');
insert into employee (name, birthday, email) values ('Kippie McCree', '1999/03/04', 'kmccree5@rediff.com');
insert into employee (name, birthday, email) values ('Ashlie Anthony', '1996/10/21', 'aanthony6@utexas.edu');
insert into employee (name, birthday, email) values ('Codi Spohrmann', '1942/11/22', 'cspohrmann7@hhs.gov');
insert into employee (name, birthday, email) values ('Allison Kassidy', '1920/09/02', 'akassidy8@java.com');
insert into employee (name, birthday, email) values ('Ewell Hadenton', '1969/11/08', 'ehadenton9@foxnews.com');
insert into employee (name, birthday, email) values ('Bobine Postles', '1963/01/11', 'bpostlesa@over-blog.com');
insert into employee (name, birthday, email) values ('Humfrey Grent', '1996/10/14', 'hgrentb@noaa.gov');
insert into employee (name, birthday, email) values ('Jeff Polley', '1935/04/10', 'jpolleyc@booking.com');
insert into employee (name, birthday, email) values ('Nigel McLinden', '1929/07/23', 'nmclindend@wp.com');
insert into employee (name, birthday, email) values ('Valentine Itscovitz', '1955/07/23', 'vitscovitze@imageshack.us');
insert into employee (name, birthday, email) values ('Burtie Izaks', '1990/01/05', 'bizaksf@netlog.com');
insert into employee (name, birthday, email) values ('Holt Havesides', '1992/06/03', 'hhavesidesg@wisc.edu');
insert into employee (name, birthday, email) values ('Jim Chattey', '1970/04/05', 'jchatteyh@gizmodo.com');
insert into employee (name, birthday, email) values ('Almira Shilito', '1996/12/24', 'ashilitoi@usgs.gov');
insert into employee (name, birthday, email) values ('Cass Brittlebank', '1970/09/07', 'cbrittlebankj@google.com.br');
insert into employee (name, birthday, email) values ('Jana Horlick', '2004/01/30', 'jhorlickk@imgur.com');
insert into employee (name, birthday, email) values ('Steffie Zammett', '1961/11/18', 'szammettl@merriam-webster.com');
insert into employee (name, birthday, email) values ('Booth Rubinek', '1977/05/30', 'brubinekm@archive.org');
insert into employee (name, birthday, email) values ('Sunshine Heggison', '1925/05/08', 'sheggisonn@photobucket.com');
insert into employee (name, birthday, email) values ('Veronika Zannolli', '2009/11/30', 'vzannollio@youku.com');
insert into employee (name, birthday, email) values ('Karisa Terbruggen', '1972/09/12', 'kterbruggenp@skyrock.com');
insert into employee (name, birthday, email) values ('Rodrick Follet', '1949/05/03', 'rfolletq@home.pl');
insert into employee (name, birthday, email) values ('Sukey Dunbavin', '1949/08/26', 'sdunbavinr@nasa.gov');
insert into employee (name, birthday, email) values ('Hope De Meyer', '1932/03/23', 'hdes@mapy.cz');
insert into employee (name, birthday, email) values ('Ezra Sans', '1922/02/19', 'esanst@pcworld.com');
insert into employee (name, birthday, email) values ('Cort Hasnney', '1970/07/06', 'chasnneyu@wufoo.com');
insert into employee (name, birthday, email) values ('Nichol Gather', '1935/09/12', 'ngatherv@msn.com');
insert into employee (name, birthday, email) values ('Mannie Ebden', '1950/08/31', 'mebdenw@utexas.edu');
insert into employee (name, birthday, email) values ('Brad Reymers', '1960/09/28', 'breymersx@blogspot.com');
insert into employee (name, birthday, email) values ('Earl Fretwell', '1953/07/26', 'efretwelly@discuz.net');
insert into employee (name, birthday, email) values ('Scotty Lahiff', '1981/02/11', 'slahiffz@imageshack.us');
insert into employee (name, birthday, email) values ('Doralia Calvert', '1922/11/08', 'dcalvert10@cyberchimps.com');
insert into employee (name, birthday, email) values ('Saunderson Daldry', '1975/03/12', 'sdaldry11@hostgator.com');
insert into employee (name, birthday, email) values ('Hartley Bidwell', '2005/06/02', 'hbidwell12@e-recht24.de');
insert into employee (name, birthday, email) values ('Tiffy Chester', '1980/01/16', 'tchester13@fda.gov');
insert into employee (name, birthday, email) values ('Deerdre Lenard', '1964/08/17', 'dlenard14@earthlink.net');
insert into employee (name, birthday, email) values ('Eduard Rubica', '1971/02/05', 'erubica15@posterous.com');
insert into employee (name, birthday, email) values ('Briant Cunniffe', '1920/10/18', 'bcunniffe16@nydailynews.com');
insert into employee (name, birthday, email) values ('Leon Sneezum', '2005/07/17', 'lsneezum17@google.com.au');
insert into employee (name, birthday, email) values ('Jillie Dufall', '1976/02/16', 'jdufall18@paginegialle.it');
insert into employee (name, birthday, email) values ('Alfy Durrett', '1931/12/04', 'adurrett19@oaic.gov.au');
insert into employee (name, birthday, email) values ('Cesar Shory', '1995/03/12', 'cshory1a@youtu.be');
insert into employee (name, birthday, email) values ('Corbin Hounsome', '1976/08/09', 'chounsome1b@prweb.com');
insert into employee (name, birthday, email) values ('Theobald Warlowe', '1953/03/24', 'twarlowe1c@sfgate.com');
insert into employee (name, birthday, email) values ('Harper Colt', '2009/04/24', 'hcolt1d@reference.com');
```
3. Sütunların her birine göre diğer sütunları güncelleyecek 5 adet UPDATE işlemi yapalım.
```
UPDATE employee
SET 
name = 'First Update',
birthday = '1999-01-01',
email = '1@update.com'
WHERE id = 1;

UPDATE employee
SET 
name = 'Second Update',
birthday = '1999-01-02',
email = '2@update.com'
WHERE name = 'Frankie McPhilip';

UPDATE employee
SET 
name = 'Third Update',
birthday = '1999-01-03',
email = '3@update.com'
WHERE birthday = '1952-10-19';

UPDATE employee
SET 
name = 'Fourth Update',
birthday = '1999-01-04',
email = '4@update.com'
WHERE email = 'ccoxwell3@youtu.be';

UPDATE employee
SET 
name = 'Fifth Update',
birthday = '1999-01-05',
email = '5@update.com'
WHERE id = 5;
```
4. Sütunların her birine göre ilgili satırı silecek 5 adet DELETE işlemi yapalım.
```
DELETE FROM employee
WHERE id = 6;

DELETE FROM employee
WHERE name = 'Ashlie Anthony';

DELETE FROM employee
WHERE birthday = '1942-11-22';

DELETE FROM employee
WHERE email = 'akassidy8@java.com';

DELETE FROM employee
WHERE id = 10;
```