# DBConnectionPool
Prototype to demonstrate database connection pooling.

Setup
1. Spin up a postgres container using docker.
2. Download & install any database client compatible with postgres.
3. Create a new database, schema and table in postgres.
4. Download jdbc driver for postgres.
5. Update classpath to include JDBC driver.
6. Create classes for DB connection, connection pooling using blocking queue and multi-threading to simulate concurrent access to database.
   
