// Complete the encryption function below.
function encryption(s) {
    console.log(s);
    const s_len = s.length;
    const arr_pivot = Math.sqrt(s_len);
    let arr_cols;
    let arr_rows;

    if (arr_pivot == Math.floor(arr_pivot)) {
        arr_cols = arr_rows = arr_pivot;
    } else {
        arr_rows = Math.floor(arr_pivot);
        arr_cols = arr_rows + 1;
    }

    const ans = new Array(arr_cols);
    for (let x = 0; x < arr_cols; x++) {
        ans[x] = new Array(arr_rows);
        let index = 0;
        for (let a = x; a < s_len; a += arr_cols) {
            ans[x][index] = s[a];
            index++;
        }
    }

    const ans2 = new Array(arr_cols);
    for (let x = 0; x < arr_cols; x++) ans2[x] = ans[x].join('');

    return ans2.join(' ');
}