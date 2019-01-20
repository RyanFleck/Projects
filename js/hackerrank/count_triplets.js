// Second attempt, using maps.

function countTriplets(arr, r) {
    const map2 = {};
    const map3 = {};
    const arr_len = arr.length;
    let count = 0;

    for (let x = 0; x < arr_len; x++) {
        const val = arr[x];
        const val_n = val * r;

        if (val in map3) {
            count += map3[val];
        }

        if (val in map2) {
            val_n in map3 ? map3[val_n] += map2[val] : map3[val_n] = map2[val];
        }

        val_n in map2 ? map2[val_n] += 1 : map2[val_n] = 1;
    }

    return count;
}

// First attempt, timed out on most problems:
/*
// Complete the countTriplets function below.
function countTriplets(arr, r) {
    const arr_len = arr.length;
    let count = 0;

    // console.log(`Given:\nArr: ${arr}\nr: ${r}`);

    for (let x = 0; x < arr_len - 2; x++) {
        // console.log(`Given ${arr[x]}, sweeping for ${arr[x] * r} and ${arr[x] * r * r}`);
        let b_match = arr[x] * r;
        for (let y = x+1; y < arr_len - 1; y++) {
            if (arr[y] == b_match) {
                let c_match = b_match * r;
                for (let z = y + 1; z < arr_len; z++) {
                    if (arr[z] == c_match) {
                        // console.log(`Match found at ${x},${y},${z} => ${arr[x]},${b_match},${c_match}.`);
                        count++;
                    }
                }
            }
        }
    }

    return count;
} */
