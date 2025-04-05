
# 🚀 Project with Gradle + OkHttp

This project demonstrates how to set up and use **Gradle via CLI** and make **HTTP connections using OkHttp** in Java.

---

## ✅ Getting Started

### Step 1: Prerequisites

Make sure the following are installed:

- ✅ Java JDK 17+
- ✅ Gradle
- ✅ Git

> Verify installations:
```
java -version
gradle -v
```
# ⚙️ Step 2: Create a Gradle Project
To generate a Java application using CLI:

bash
```
gradle init

```

Choose:
Type: application
Language: Java
Build script DSL: Groovy
Test framework: JUnit
Project name: your choice
Package: your domain

📂 Step 3: Directory Structure (after init)

.
├── build.gradle
├── settings.gradle
├── gradlew
├── gradlew.bat
└── src
    ├── main
    │   └── java
    │       └── your.package.name.App.java
    └── test
        └── java
            └── your.package.name.AppTest.java

BEFORE DOING THIS MAKE SURE YOU ARE DONE WITH GRADLE PROJECT IN YOUR SYSTEM 

💻 Step 4: Add OkHttp Dependency
Open build.gradle and add inside dependencies {} block:

```
implementation 'com.squareup.okhttp3:okhttp:4.12.0'
```
Optional: If you're using Java 8 or want logging:
```
implementation 'com.squareup.okhttp3:logging-interceptor:4.12.0'
```
Then run:
```
./gradlew build
```

🌐 Step 5: Use OkHttp in Your Java File
Example code (App.java):

```
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class App {
    public static void main(String[] args) throws Exception {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
            .url("https://jsonplaceholder.typicode.com/posts/1")
            .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                System.out.println(response.body().string());
            } else {
                System.out.println("Request failed: " + response.code());
            }
        }
    }
}

```
🧪 Step 6: Run the Application
```
./gradlew run
```

🧼 Optional: Clean Build
```
./gradlew clean
```

IF YOU WANT TO RUN THE JAVA JAR THEN YOU CAN FOLLOW THESE STEPS 

🔨 Step 1: Add Manifest Configuration in build.gradle
In your build.gradle, add the following jar block at the bottom:
```
jar {
    manifest {
        attributes(
                'Main-Class': application.mainClass.get()
        )
    }

  duplicatesStrategy = DuplicatesStrategy.EXCLUDE // Prevent META-INF duplicates
}
```

💡 This ensures that the Main-Class entry is written into the .jar so it can be run with java -jar.

⚙️ Step 2: Build the JAR
```
./gradlew clean build
```

If everything is fine, the JAR will be located at:
```
app/build/libs/OkHttpCLIDemo.jar
```

🚀 Step 3: Run the JAR
Now run your CLI app using:
```
java -jar app/build/libs/OkHttpCLIDemo.jar
```


🚀 Push to GitHub
```
git init
git add .
git commit -m "Initial commit with OkHttp"
git branch -M master
git remote add origin https://github.com/yourusername/your-repo.git
git push -u origin master

```
📌 Notes
✅ OkHttp is a powerful HTTP client library for Java and Android.
✅ Prefer ./gradlew over system-installed Gradle for consistent builds.
✅ Always commit your build.gradle and gradlew wrapper scripts.

📎 References
Gradle Documentation
OkHttp GitHub
OkHttp Recipes


