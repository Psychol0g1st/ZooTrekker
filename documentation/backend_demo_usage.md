# Backend használata
Mindenek előtt szükségünk lesz egy Postman nevű applikációra, amit az alábbi linken lehet letölteni:
https://www.postman.com/downloads/
Futtatni a backendet az IntelliJ-n belül a legkönnyebb. Megnyitva a projektet jobb fent van egy `m` betű amin belül lesz egy `backend`, azt lenyitjuk, azon belül a `Plugins`-t, majd a `spring-boot`-ot azon belül végül dupla-klikk a `spring-boot:run`-ra. 
FONTOS: az adatbáziskezelp rendszerben (MariaDB) kell lennie egy `betyardb` nevű adatbázisnak, ezt nem generálja ki a kód. 
Ha már fut a backend és az adatbázisunk, jelen esetben MariaDB egy Apache webszerver mögött, akkor tudunk mindenféle kéréseket küldeni az alábbi linkre:
## `http://localhost:8082/*`

##Entitás:
A demo entitás a Betyar entitás, amit 3 attribútummal reprezentálok:
nev, strong, orr
Különösebb értelmük az attribútumoknak nincsen, de kipróbálni a rendszert tökéletes volt.
A nev az egy String, a strong az egy boolean és az orr egy float (0,1) intervallumban.

###C - Create:
Hozzáadni az adatbázishoz úgy tudunk, hogy a csillag helyére az `add` szócskát írjuk a link mögé és a kérés módját `POST`-ra állítjuk, valamint a csomagnak a body részébe kell leírnunk az entitás attribútumait JSON formátumban. FONTOS: állítsuk át az üzenet formáját raw-ra és a kék legördülő menünél válasszük ki a JSON formátumot, csak így fogja elfogadni, különben kivételt kapunk.
###R - Retrieve:
Lekérni az összes adatot a ab-ból úgy tudunk, hogy a csillag helyére a `getall` szócskát írjuk és a kérés módját `GET`-re állítjuk. Ilyenkor kimenetként megkapjuk az entitásainkat JSON formájában.
###U - Update:
Frissíteni egy létező entitást úgy tudunk, hogy a csillag helyére a `update/{id}` szöveget írjuk és a kérés módját `PUT`-ra állítjuk. Az `id` helyére kerül annak a rekordnak az id-je, amit módosítani szeretnénk kapcsos zárójelek nélkül. Hasonlóan a létrehozásnál, JSON formátumban kell megadni a frissítendő adatokat. FONTOS: állítsuk át az üzenet formáját raw-ra és a kék legördülő menünél válasszük ki a JSON formátumot, csak így fogja elfogadni, különben kivételt kapunk.
###D - Delete:
Törölni egy létező entitást úgy tudunk, hogy a csillag helyére a `delete/{id}` szöveget írjuk és a kérés módját `DELETE`-re állítjuk. Az `id` helyére kerül annak a rekordnak az id-je, amit módosítani szeretnénk kapcsos zárójelek nélkül.