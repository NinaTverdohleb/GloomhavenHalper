# round_corners.py
from PIL import Image, ImageDraw
from pathlib import Path

INPUT_DIR = Path("input")
OUTPUT_DIR = Path("output")
RADIUS = 40
PREFIX = "ic_deck_"

OUTPUT_DIR.mkdir(exist_ok=True)

for path in INPUT_DIR.glob("*.jpg"):
    img = Image.open(path).convert("RGBA")
    w, h = img.size

    mask = Image.new("L", (w, h), 0)
    draw = ImageDraw.Draw(mask)
    draw.rounded_rectangle([(0, 0), (w - 1, h - 1)], radius=RADIUS, fill=255)
    img.putalpha(mask)

    stem = path.stem.replace("-", "_")
    output_name = f"{PREFIX}{stem}.webp"
    img.save(OUTPUT_DIR / output_name, format="WEBP", lossless=True)
    print(f"✓ {path.name} → {output_name}")