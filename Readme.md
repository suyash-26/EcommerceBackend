## 🚀 Features

### 🌍 Environment Configuration

* Implemented **multiple environment setups** using Spring Profiles
* Separate configurations for:

    * **Local (`application-local.properties`)** → for development
    * **Production (`application-prod.properties`)** → for deployment
* Ensures **clean separation of concerns** between environments
* Uses **environment variables** in production for secure credential handling
* Avoids hardcoding sensitive data in the codebase

👉 This allows the same codebase to run seamlessly across local and deployed environments.
