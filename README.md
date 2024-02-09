# Readme

Az alkalmazás futtatásához először a következő parancsot kell kiadni a 
főkönyvtárban:

docker-compose up

Ez elindítja az mssql adatbázist és generál egy demodb nevű adatbázist.

Ezután a spring boot alkalmazást kell elindítani a következő parancsal:

mvn spring-boot:run

Az alkalmazás legenerálja a sémát.

A tesztek futtatásához az adatbázisnak futnia kell. Az inmemory adatbázis
konfigurálása sok időt elvitt volna így nem foglalkoztam vele.

Az alkalmazással rest API -n keresztül lehet kommunikálni Postman -el vagy 
valami más alkalmazás segítségével.

A json mappában vannak a példa objektumok. Az adatok beviteléhez a következő
endpoint -ot kell használni:

POST http://localhost:8080/person

A request body -nak a json mappában található json objektumokat kell megadni.

Az sql mappában találhatók a DDL -ek illetve az SQL insertek. IntelliJ -ben 
expportáltam ki, remélem működik.