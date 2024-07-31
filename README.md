# ADM V2

Android Device Manager, a tool to perform Android Reverse Engineering & Malware Analysis

## Table of Contents

- [ADM V2](#adm-v2)
  - [Table of Contents](#table-of-contents)
  - [About the Project](#about-the-project)
  - [Features](#features)
  - [Built with](#built-with)

## About the Project

ADM or Android Device Manager is a open source tool developed for Android cybersecurity experts to get a remote on the cloud setup for analysis for performing analysis of Android Apps across various Android versions.

## Features

1. Perform Static Analysis using jadx like interface (WIP)
2. Decompile so files using a variety of compilers (`Ghidra` & `Angr` suppourt has been added).
3. Contains a repository of shellcodes for various architectures (arm and arm64)
4. Create a Android Emulator of a specific android version. (WIP)
5. Select an Android Emulator of a specific android version get access to it's file system, adb shell, Screen with touch screen support. (Uses `Scrcpy` with `TangoADB`)
6. Perform a Dynamic analysis of the apk on the Android Emulator using `Frida`. (WIP)
7. Setup a home server to connect multiple physical devices to the server and access them on the webapp. (WIP)

## Built with

- React.js
- Express
- Docker
- Android Studio Emulator
- Jadx
- Ghidra
- Angr
- Frida
- Tango ADB