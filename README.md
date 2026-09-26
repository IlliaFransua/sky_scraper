# sky_scraper

### Installation

```bash
git clone https://github.com/IlliaFransua/sky_scraper
cd sky_scraper
```

### Build and Tests

```bash
mvn package && java -cp target/backtracking-1.0-SNAPSHOT.jar com.mycompany.app.App 4 3 2 1 1 2 2 2 4 3 2 1 1 2 2 2
```

Expected:

```bash
1 2 3 4
2 3 4 1
3 4 1 2
4 1 2 3

```

---

Run:

```bash
mvn package && java -cp target/backtracking-1.0-SNAPSHOT.jar com.mycompany.app.App 4 2 2 1 1 2 3 3 4 2 2 1 1 2 3 3
```

Expected:

```bash
1 2 3 4
2 1 4 3
3 4 2 1
4 3 1 2

```

---

Run:

```bash
mvn package && java -cp target/backtracking-1.0-SNAPSHOT.jar com.mycompany.app.App 3 2 1 2 2 3 3 1 3 2 1 2 2 3 3 1
```

Expected:

```bash
1 2 4 3
2 4 3 1
4 3 1 2
3 1 2 4

```

---

Run:

```bash
mvn package && java -cp target/backtracking-1.0-SNAPSHOT.jar com.mycompany.app.App 2 2 3 1 3 2 1 2 3 1 2 2 1 3 2 2
```

Expected:

```bash
1 3 2 4
4 2 3 1
3 4 1 2
2 1 4 3

```

---

Run:

```bash
mvn package && java -cp target/backtracking-1.0-SNAPSHOT.jar com.mycompany.app.App 1 2 2 2 1 2 2 2 2 2 2 2 2 2 2 2
```

Expected:

```bash
Error

```

---

Run:

```bash
mvn package && java -cp target/backtracking-1.0-SNAPSHOT.jar com.mycompany.app.App 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
```

Expected:

```bash
Error

```

---

Run:

```bash
mvn package && java -cp target/backtracking-1.0-SNAPSHOT.jar com.mycompany.app.App 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2
```

Expected:

```bash
Error
```
