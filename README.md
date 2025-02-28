# DBConnectionPool

A lightweight, thread-safe **Database Connection Pool** implementation in Java. This prototype efficiently manages database connections, reusing them to reduce overhead and improve performance.

## 🚀 Features
- Connection pooling for efficient database access
- Thread-safe implementation to handle concurrent requests
- Configurable pool size and connection timeout
- Automatic connection reuse and cleanup

## 🏗️ Installation
Clone the repository and build the project:
```sh
git clone https://github.com/saurabhs13/DBConnectionPool.git
cd DBConnectionPool
mvn clean install
```

## 🔧 Usage
### 1. Initialize the Connection Pool
```java
DBConnectionPool pool = new DBConnectionPool("jdbc:mysql://localhost:3306/mydb", "user", "password", 10);
```

### 2. Get a Connection
```java
Connection connection = pool.getConnection();
```

### 3. Use the Connection
```java
Statement stmt = connection.createStatement();
ResultSet rs = stmt.executeQuery("SELECT * FROM users");
```

### 4. Release the Connection
```java
pool.releaseConnection(connection);
```

### 5. Shut Down the Pool (when done)
```java
pool.shutdown();
```

## ⚙️ Configuration
You can customize the connection pool by adjusting:
- **Pool size**: Number of active connections
- **Timeout**: Maximum wait time for a connection
- **Idle connection cleanup**: Automatically closes unused connections

## 📌 TODO / Future Enhancements
- Support for connection validation
- Advanced connection lifecycle management
- Performance optimizations

## 🛠️ Contributing
Feel free to fork this repository, improve the implementation, and submit a pull request!

## 📜 License
This project is licensed under the MIT License.

