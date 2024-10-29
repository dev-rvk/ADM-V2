## Websocketify

Source: [Websockify-js](https://github.com/novnc/websockify-js)

Source: [How to connect](https://github.com/yume-chan/ya-webadb/discussions/245)

## Connecting Android Emulators

### Finding port number for emulator
Emulators run on port = {number}+1 where is emulator-{number}

Example:
```plaintext
    adb devices
    List of devices attached
    emulator-5554	device
```
so the emulator is running on port `5555`

### Establish Web Socket connection to the port

1. Install required packages `npm install`
2. Run Websockify
   ```plaintext
    $ node websockify.js <web-socket-port> localhost:<emulator-port>
   ```
   ```plaintext
    $ node websockify.js 15555 localhost:5555
    WebSocket settings:
        - proxying from :15555 to localhost:5555
        - Running in unencrypted HTTP (ws://) mode
   ```