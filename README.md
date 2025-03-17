# SkeletonHexa App

Este proyecto es una aplicación basada en **Java** con **arquitectura hexagonal**, diseñada para una ferretería.

## 🚀 Tecnologías Utilizadas

- **Java**: Lenguaje de programación principal.
- **Maven**: Para la gestión de dependencias.
- **Arquitectura Hexagonal**: Separación de capas en dominio, aplicación y adaptadores.

## 📂 Estructura del Proyecto

```
skeletonhexa-app-master/
│── pom.xml                                  # Configuración de Maven
│── .vscode/settings.json                     # Configuración de VSCode
│── src/main/java/com/ferreteriapp/          # Código fuente principal
│   │── Main.java                             # Punto de entrada de la aplicación
│   │── adapter/                              # Adaptadores de infraestructura
│   │── application/usecase/                  # Casos de uso
│   │── config/                               # Configuración de la aplicación
│   │── domain/                               # Lógica de dominio
```

## 📌 Instalación y Uso

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tuusuario/tu-repo.git
   ```
2. Accede al directorio del proyecto:
   ```bash
   cd skeletonhexa-app-master
   ```
3. Compila y ejecuta con Maven:
   ```bash
   mvn clean install
   mvn exec:java -Dexec.mainClass="com.ferreteriapp.Main"
   ```

## ✨ Arquitectura Hexagonal

El proyecto sigue una **arquitectura hexagonal**, dividiendo la aplicación en:

- **Dominio**: Lógica de negocio pura.
- **Aplicación**: Casos de uso.
- **Adaptadores**: Infraestructura y conexiones externas.

## 📜 Hecho por:

Stivenco12

