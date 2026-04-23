# 🌍 Environment Configuration in Spring Boot

This project demonstrates **multiple ways to manage environments (local, production, etc.)** in a clean, secure, and scalable way using Spring Boot.

---

# 🧠 Why Environment Configuration Matters

In real-world applications:

* Local setup ≠ Production setup
* Credentials must **never be hardcoded**
* Same code should run in different environments

👉 Goal:

> One codebase → multiple environments → zero secrets in GitHub

---

# ⚙️ Common Approaches to Environment Configuration

## 1️⃣ Using Environment Variables (Recommended)

### ✅ How it works

Spring Boot reads variables like:

```properties
spring.datasource.url=${DB_URL}
```

### 🔧 Set variables

#### Mac/Linux

```bash
export DB_URL=jdbc:mysql://localhost:3306/db
export DB_USERNAME=root
export DB_PASSWORD=1234
```

#### Windows

```cmd
set DB_URL=jdbc:mysql://localhost:3306/db
```

### ✅ Pros

* Secure (no secrets in code)
* Works everywhere (local, server, Docker, cloud)
* Industry standard

### ❌ Cons

* Manual setup required locally

---

## 2️⃣ Using `.env` File

### ✅ How it works

Store variables in a file:

```env
DB_URL=jdbc:mysql://localhost:3306/db
DB_USERNAME=root
DB_PASSWORD=1234
```

Then load them manually or via library.

### ✅ Pros

* Cleaner than typing exports repeatedly
* Easy for teams

### ❌ Cons

* Not natively supported by Spring Boot
* Needs extra setup
* Not recommended for production

---

## 3️⃣ Using Spring Profiles (Best Practice)

Spring Boot supports environment-specific files:

```text
application.properties
application-local.properties
application-prod.properties
```

### 🔁 How it works

```text
Active Profile → Loads matching config file
```

Example:

```bash
-Dspring.profiles.active=local
```

### ✅ Pros

* Clean separation of environments
* Easy to manage different configs

### ❌ Cons

* Needs proper structuring

---

## 4️⃣ Using IDE Configuration (Alternative to terminal)

Instead of setting variables manually:

### IntelliJ / VS Code:

* Add Environment Variables in Run Configuration
* Set:

```
SPRING_PROFILES_ACTIVE=local
DB_URL=...
```

### ✅ Pros

* No terminal usage
* Easy local setup

### ❌ Cons

* IDE-specific (not portable)

---

## 5️⃣ Using Docker

```bash
docker run -e DB_URL=... your-image
```

### ✅ Pros

* Clean and reproducible
* Industry standard for deployment

---

## 6️⃣ Using Cloud Platforms

Platforms like:

* Render
* Railway

Provide UI to set variables:

```
DB_URL=...
DB_USERNAME=...
DB_PASSWORD=...
SPRING_PROFILES_ACTIVE=prod
```

### ✅ Pros

* No manual server setup
* Secure storage of secrets

---

# 🏗️ Final Approach Used in This Project

We use a combination of:

### ✅ Spring Profiles + Environment Variables

---

## 📄 File Structure

```text
src/main/resources/
  application.properties
  application-local.properties   (ignored)
  application-prod.properties
```

---

## 📄 application.properties (base)

```properties
spring.application.name=EcommerceBackend
spring.profiles.active=local
```

---

## 📄 application-local.properties (local only)

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/eCommerce
spring.datasource.username=root
spring.datasource.password=yourpassword
```

⚠️ Not committed to Git

---

## 📄 application-prod.properties (production)

```properties
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=false
```

---

# 🔒 Security Rules (Very Important)

* ❌ Never commit:

    * `application-local.properties`
    * `.env`
* ❌ Never hardcode credentials
* ❌ Never use `ddl-auto=update` in production

---

# 🚀 Deployment Checklist

Before deploying to any server (Render / Railway / AWS):

### ✅ Set environment variables:

```
SPRING_PROFILES_ACTIVE=prod
DB_URL=...
DB_USERNAME=...
DB_PASSWORD=...
```

---

### ✅ Ensure:

* No local configs are committed
* Production profile is active
* Database is accessible from server

---

# ⚠️ Common Mistakes

* Mixing local & production configs ❌
* Using localhost DB in production ❌
* Forgetting to set profile ❌
* Committing secrets ❌

---

# 🧠 Final Mental Model

```text
Code → asks for config (${DB_URL})
        ↓
Environment provides value
        ↓
Spring Boot injects it
```

---

# 🔥 Key Takeaways

* Profiles = environment separation
* Environment variables = secure secrets
* `.env` = optional convenience
* Cloud platforms = manage env variables for you

---

# 📌 Conclusion

This setup ensures:

* Clean architecture
* Secure configuration
* Easy deployment
* Scalable system design

---

If you're extending this project:

* Add Docker support
* Use Flyway/Liquibase for DB migrations
* Integrate secret managers for production

---

👉 This approach reflects real-world backend practices used in production systems.
