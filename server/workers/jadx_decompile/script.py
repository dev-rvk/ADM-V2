import os
import subprocess
import sys

def decompile_apk(apk_filename, input_dir, output_dir):
    apk_path = os.path.join(input_dir, apk_filename)
    output_path = os.path.join(output_dir, apk_filename[:-4])
    subprocess.run(["jadx", "-d", output_path, apk_path])

if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Usage: python script.py <apk_filename>")
        sys.exit(1)
    apk_filename = sys.argv[1]
    input_dir = "/app/uploads"
    output_dir = "/app/output"
    os.makedirs(output_dir, exist_ok=True)
    decompile_apk(apk_filename, input_dir, output_dir)
