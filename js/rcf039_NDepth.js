function depthInPx(maxgap, depth) {
    const b = 2.00; // Inverse of speed of gap -> maxgap.
    return Math.floor(maxgap * (depth / (depth + b)));
}

// To test. Max indentation set to 30px.
for (let i = 0; i < 20; i++) {
    console.log(depthInPx(30, i));
}
