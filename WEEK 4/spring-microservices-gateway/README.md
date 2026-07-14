# Spring Boot 3 Microservices with API Gateway

This project contains three independent applications:

| Application | Port | Purpose |
|---|---:|---|
| `account-service` | 8081 | Serves account details |
| `loan-service` | 8082 | Serves loans for an account |
| `api-gateway` | 8080 | Routes public requests to both services |

## Run

Requirement: Java 17+. Maven does not need to be installed globally: `mvnw.cmd`
downloads it into the project the first time it runs (internet required once).

In VS Code, use **Ctrl+Shift+P** → **Java: Configure Java Runtime**, then select
your installed Java 17 runtime. Next use **Java: Clean Java Language Server Workspace**
and reload VS Code. The services use Java records, which Java 8 cannot compile.

Open three PowerShell windows at the project root and run:

```powershell
.\mvnw.cmd -pl account-service spring-boot:run
.\mvnw.cmd -pl loan-service spring-boot:run
.\mvnw.cmd -pl api-gateway spring-boot:run
```

## Test through the gateway

```powershell
Invoke-RestMethod http://localhost:8080/accounts/ACC-1001
Invoke-RestMethod http://localhost:8080/loans/account/ACC-1001
```

The gateway exposes the same `/accounts/**` and `/loans/**` paths while keeping the service ports private to callers.
