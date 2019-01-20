// Complete the compareTriplets function below.
function compareTriplets(a, b) {
    let a_pts = 0;
    let b_pts = 0;
    const arrlen = a.length;
    for (let i = 0; i < arrlen; i++) {
        console.log(i);
        if (a[i] == b[i]) continue;
        (a[i] > b[i]) ? a_pts++ : b_pts++;
    }

    return [a_pts, b_pts];
}