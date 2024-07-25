FROM python:3.9-slim

# Install dependencies
RUN apt-get update && apt-get install -y wget unzip \
    && rm -rf /var/lib/apt/lists/*    

# Create directory for Java installation
RUN mkdir -p /opt/java

# For x86 systems
# # Download and install Temurin (AdoptOpenJDK) 11
# RUN wget -qO- https://api.adoptopenjdk.net/v3/binary/latest/21/ga/linux/x64/jdk/hotspot/normal/adoptopenjdk | tar xvz -C /opt && \
#     ln -s /opt/jdk-21.* /opt/java/openjdk


# For ARM systems
# Download and install Temurin (AdoptOpenJDK) 11
RUN wget -qO- https://api.adoptopenjdk.net/v3/binary/latest/21/ga/linux/aarch64/jdk/hotspot/normal/adoptopenjdk | tar xvz -C /opt && \
    ln -s /opt/jdk-21.* /opt/java/openjdk

# Set up environment variables for Java
ENV JAVA_HOME=/opt/java/openjdk
ENV PATH=$JAVA_HOME/bin:$PATH    


# Install jadx
RUN wget https://github.com/skylot/jadx/releases/download/v1.5.0/jadx-1.5.0.zip \
    && unzip jadx-1.5.0.zip -d /opt/jadx \
    && ln -s /opt/jadx/bin/jadx /usr/bin/jadx \
    && ln -s /opt/jadx/bin/jadx-gui /usr/bin/jadx-gui \
    && rm jadx-1.5.0.zip


# Set the working directory
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY script.py .

# Run script.py when the container launches
ENTRYPOINT ["python", "script.py"]

# docker run -v ./uploads:/app/uploads -v ./output:/app/output jadx-decompile test.apk
