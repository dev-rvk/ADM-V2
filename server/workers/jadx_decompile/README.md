## JADX DECOMPILE
A docker image workflow to decompile android apk files.
> [!NOTE]  
> The dockerfile has been created to support arm64 systems by installing temurin for arm64 (aarch64). Before setting up the image check if your system is arm64, else change the url to install temurin for x86_64 (amd64).


> [!IMPORTANT]  
> Do the steps below for x86_64 (amd64) systems only.
> Uncomment the part 

```plaintext
    # For x86 systems
    # # Download and install Temurin (AdoptOpenJDK) 11
    # RUN wget -qO- https://api.adoptopenjdk.net/v3/binary/latest/21/ga/linux/x64/jdk/hotspot/normal/adoptopenjdk | tar xvz -C /opt && \
    #     ln -s /opt/jdk-21.* /opt/java/openjdk
```
> Comment the part
```plaintext
    # For ARM systems
    # Download and install Temurin (AdoptOpenJDK) 11
    RUN wget -qO- https://api.adoptopenjdk.net/v3/binary/latest/21/ga/linux/aarch64/jdk/hotspot/normal/adoptopenjdk | tar xvz -C /opt && \
        ln -s /opt/jdk-21.* /opt/java/openjdk
```

## Setup and Usage

1. Clone the repository
    ```plaintext
    git clone https://github.com/dev-rvk/jadx_decompile.git
    ```
2. Check with your system and follow the Important Notes section above.
3. Build the image
   ```plaintext
   docker build -t jadx_decompile .
   ```
4. Run the image (Make sure you have the apk file in the uploads directory)
   ```plaintext
    docker run -v ./uploads:/app/uploads -v ./output:/app/output jadx-decompile <name-of-apk>.apk

   ```
   Example usage for test apk file
   ```plaintext
    docker run -v ./uploads:/app/uploads -v ./output:/app/output jadx-decompile test.apk

   ```
5. The output apk file will be decompiled in the output/<name-of-apk> directory.
